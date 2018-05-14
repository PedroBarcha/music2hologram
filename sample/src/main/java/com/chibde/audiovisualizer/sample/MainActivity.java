/*
* Copyright (C) 2017 Gautam Chibde
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.chibde.audiovisualizer.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.chibde.audiovisualizer.sample.visualizer.BarVisualizerActivity;
import com.chibde.audiovisualizer.sample.visualizer.CircleBarVisualizerActivity;
import com.chibde.audiovisualizer.sample.visualizer.CircleVisualizerActivity;
import com.chibde.audiovisualizer.sample.visualizer.LineBarVisualizerActivity;
import com.chibde.audiovisualizer.sample.visualizer.LineVisualizerActivity;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set bottom toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.action_bar);
        setSupportActionBar(toolbar);

        //screens selectable by the toolbar are fragments, not activities
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                if (item.getItemId() == R.id.hologramItem) {
                    transaction.replace(R.id.content, new HologramFragment()).commit();
                    return true;
                } else if (item.getItemId() == R.id.buildPyramidItem) {
                    transaction.replace(R.id.content, new HowToFragment()).commit();
                    return true;
                } else if (item.getItemId() == R.id.codeItem) {
                    transaction.replace(R.id.content, new CodeFragment()).commit();
                    return true;
                }
                return false;
            }
        });
    }

    //upper menu bar (currently has only share option)
    public boolean onOptionsItemSelected(MenuItem item) {
        //use a switch here if eventually there is more than an option on the action bar

        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String shareSub = "Hologram Music";
        String shareBody = "Welcome to the future\n\nhttps://www.youtube.com/watch?v=ZZ5LpwO-An4";
        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
        myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

        startActivity(Intent.createChooser(myIntent, "Share Our App"));

        return super.onOptionsItemSelected(item);
    }


    //one of these is called when a type of hologram is chosen in the Hologram Fragment
    public void line(View view) {
        startActivity(LineVisualizerActivity.class);
    }

    public void bar(View view) {
        startActivity(BarVisualizerActivity.class);
    }

    public void circle(View view) {
        startActivity(CircleVisualizerActivity.class);
    }

    public void circleBar(View view) {
        startActivity(CircleBarVisualizerActivity.class);
    }

    public void lineBar(View view) {
        startActivity(LineBarVisualizerActivity.class);
    }

    public void startActivity(Class clazz) {
        startActivity(new Intent(this, clazz));
    }

//    @Override
//    public  boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.action_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

}