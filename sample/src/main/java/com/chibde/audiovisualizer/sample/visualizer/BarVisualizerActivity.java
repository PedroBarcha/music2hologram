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
import android.view.View;
import android.widget.ImageButton;

import com.chibde.audiovisualizer.sample.BaseActivity;
import com.chibde.audiovisualizer.sample.R;
import com.chibde.visualizer.BarVisualizer;

public class BarVisualizerActivity extends BaseActivity {

    @Override
    protected void init() {
        BarVisualizer barVisualizer = findViewById(R.id.visualizer);

        // set custom color to the line.
        barVisualizer.setColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        // define custom number of bars you want in the visualizer between (10 - 256).
        barVisualizer.setDensity(70);

        // Set your media player to the visualizer.
        barVisualizer.setPlayer();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_bar_visualizer;
    }
}
