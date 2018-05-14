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
package com.chibde.audiovisualizer.sample.visualizer;

import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;

import com.chibde.audiovisualizer.sample.BaseActivity;
import com.chibde.audiovisualizer.sample.R;
import com.chibde.visualizer.CircleBarVisualizer;

public class CircleBarVisualizerActivity extends BaseActivity {


    @Override
    protected void init() {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //avoid sleeping
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_circle_bar_visualizer);

        CircleBarVisualizer circleBarVisualizer1 = findViewById(R.id.visualizer1);
        circleBarVisualizer1.setColor(ContextCompat.getColor(this, R.color.colorAccent));
//        circleBarVisualizer1.setPlayer();

        CircleBarVisualizer circleBarVisualizer2 = findViewById(R.id.visualizer2);
        circleBarVisualizer2.setColor(ContextCompat.getColor(this, R.color.colorAccent));
        circleBarVisualizer2.setPlayer();
//
////
        CircleBarVisualizer circleBarVisualizer3 = findViewById(R.id.visualizer3);
        circleBarVisualizer3.setColor(ContextCompat.getColor(this, R.color.colorAccent));
////        circleBarVisualizer3.setPlayer();
////
        CircleBarVisualizer circleBarVisualizer4 = findViewById(R.id.visualizer4);
        circleBarVisualizer4.setColor(ContextCompat.getColor(this, R.color.colorAccent));
////        circleBarVisualizer4.setPlayer();
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (circleBarVisualizer.visualizer == null) {
//            return;
//        }
//        circleBarVisualizer.visualizer.setEnabled(false);
//        circleBarVisualizer.visualizer.release();
//    }

//    @Override
//    protected int getLayout() {
//        return R.layout.activity_circle_bar_visualizer;
//    }
}