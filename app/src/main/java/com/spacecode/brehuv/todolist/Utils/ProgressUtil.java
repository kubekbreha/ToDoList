package com.spacecode.brehuv.todolist.Utils;

import android.widget.ProgressBar;


public class ProgressUtil {

    public static void increaseProgress(ProgressBar progressBar, int increment ){
        int value = progressBar.getProgress();
        value += increment;
        if(value > 100) value = 100;
        progressBar.setProgress(value);
    }

    public static void decreaseProgress(ProgressBar progressBar, int decrement ){
        int value = progressBar.getProgress();
        value -= decrement;
        if(value < 0) value = 0;
        progressBar.setProgress(value);
    }


}
