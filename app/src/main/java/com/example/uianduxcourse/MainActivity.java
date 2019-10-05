package com.example.uianduxcourse;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.example.uianduxcourse.Adapter.ViewPagerAdapter;
import com.example.uianduxcourse.Animation.ZoomAnimatio;
import com.example.uianduxcourse.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private ViewPagerAdapter viewPagerAdapter;
    private ArrayList<Fragment> fragments;
    private int count=2;
    private int Entered=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.from_left_current,R.anim.current_to_top );
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main );
        fragments = new ArrayList<Fragment>();
        fragments.add(new KevinFragment());
        fragments.add(new AgnesFragment());
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(), fragments,this);
        activityMainBinding.ViewPager.setAdapter(viewPagerAdapter);
        activityMainBinding.ViewPager.setPageTransformer(true,new ZoomAnimatio());
        Animate();
    }

    private void Animate() {
        activityMainBinding.SearchImage.setAnimation(AnimationUtils.loadAnimation(this,R.anim.translate_then_rotate ));
        activityMainBinding.SearchImage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (count % 2 == 0) {
                    activityMainBinding.SearchImage.setImageDrawable(getDrawable(R.drawable.from_search_to_close));
                    Drawable drawable = activityMainBinding.SearchImage.getDrawable();
                    if( drawable instanceof AnimatedVectorDrawable){
                        ((AnimatedVectorDrawable) drawable).start();
                    }
                    activityMainBinding.SearchBar.setVisibility(View.VISIBLE);
                    activityMainBinding.SearchBar.setAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.from_right_current));
                    Entered=1;
                }
                else{
                    activityMainBinding.SearchImage.setImageDrawable(getDrawable(R.drawable.from_close_to_search));
                    Drawable drawable=activityMainBinding.SearchImage.getDrawable();
                    if(drawable instanceof AnimatedVectorDrawable){
                        AnimatedVectorDrawable animatedVectorDrawable=((AnimatedVectorDrawable) drawable);
                      animatedVectorDrawable.start();
                    }
                    activityMainBinding.SearchBar.setAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.from_current_left));
                    activityMainBinding.SearchBar.setVisibility(View.INVISIBLE);
                    Entered=2;
                }
                count++;

            }
        });
        activityMainBinding.PreviousImage.
                setAnimation(AnimationUtils.loadAnimation(this,R.anim.translate_then_rotate ));
        activityMainBinding.DescribeMeText.
                setAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_current ));
        activityMainBinding.CharatersText.
                setAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_current ));
        activityMainBinding.ViewPager.
                setAnimation(AnimationUtils.loadAnimation(this,R.anim.from_button_current));

    }
}
