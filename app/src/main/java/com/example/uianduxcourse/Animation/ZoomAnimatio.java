package com.example.uianduxcourse.Animation;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

public class ZoomAnimatio implements ViewPager.PageTransformer {
    private float ScaleSize = 0.6f;
    private float Alpha = 0.4f;

    @Override
    public void transformPage(@NonNull View view, float v) {
        Log.i("morse", "transformPage: "+v);
        if(v<-1){
            view.setAlpha(0);
        }
        else if(v<=1){
            view.setScaleX(Math.max(ScaleSize, 1-Math.abs(v)));
            view.setScaleY(Math.max(ScaleSize, 1-Math.abs(v)));
            view.setAlpha(Math.max(Alpha,1-Math.abs(v) ));
        }
        else{
            view.setAlpha(0);
        }
    }
}
