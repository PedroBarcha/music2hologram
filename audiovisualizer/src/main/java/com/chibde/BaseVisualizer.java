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
package com.chibde;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.media.audiofx.Visualizer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Base class that contains common implementation for all
 * visualizers.
 * Created by gautam chibde on 28/10/17.
 */

abstract public class BaseVisualizer extends View {
    protected byte[] bytes;
    protected Paint paint;
    protected Visualizer visualizer;
    protected int color = Color.BLUE;

    public BaseVisualizer(Context context) {
        super(context);
        init(null);
        init();
    }

    public BaseVisualizer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
        init();
    }

    public BaseVisualizer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
        init();
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (visualizer == null) {
//            return;
//        }
//        visualizer.setEnabled(false);
//        visualizer.release();
//    }

    private void init(AttributeSet attributeSet) {
        paint = new Paint();
    }

    /**
     * Set color to visualizer with color resource id.
     *
     * @param color color resource id.
     */
    public void setColor(int color) {
        this.color = color;
        this.paint.setColor(this.color);
    }

    public void setPlayer() {
        visualizer = new Visualizer(0);
        visualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);

        visualizer.setDataCaptureListener(new Visualizer.OnDataCaptureListener() {
            @Override
            public void onWaveFormDataCapture(Visualizer visualizer, byte[] bytes,
                                              int samplingRate) {
                BaseVisualizer.this.bytes = bytes;
                invalidate();
            }

            @Override
            public void onFftDataCapture(Visualizer visualizer, byte[] bytes,
                                         int samplingRate) {
            }
        }, Visualizer.getMaxCaptureRate() / 2, true, false);

        visualizer.setEnabled(true);
    }

    public Visualizer getVisualizer() {
        return visualizer;
    }

    public void setVisualizer (Visualizer visu) {
        visualizer=visu;
    }

    protected abstract void init();
//
//    protected void onStop() {
//        if (visualizer == null) {
//            return;
//        }
//        visualizer.setEnabled(false);
//        visualizer.release();
//    }
//    protected void onDestroy() {
//        if (visualizer == null) {
//            return;
//        }
//        visualizer.setEnabled(false);
//        visualizer.release();
//    }
//
//    public void release() {
//        if (visualizer == null) {
//            return;
//        }
//        visualizer.setEnabled(false);
//        visualizer.release();
//    }
}