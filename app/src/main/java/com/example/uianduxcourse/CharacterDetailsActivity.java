package com.example.uianduxcourse;

import android.animation.Animator;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.uianduxcourse.Adapter.ColorAdapter;
import com.example.uianduxcourse.databinding.ActivityCharacterDetailsBinding;

import java.util.ArrayList;

public class CharacterDetailsActivity extends AppCompatActivity {
    Bundle extras ;
    Context context;
    ActivityCharacterDetailsBinding activityCharacterDetailsBinding;
    BottomSheetBehavior bottomSheetBehavior;
    RecyclerView recyclerView;
    ArrayList<Integer> colors;
    ColorAdapter colorAdapter;
    GridLayoutManager gridLayoutManager;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);
        context =this;
        activityCharacterDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_character_details );
        LinearLayout linearLayout=findViewById(R.id.BottomSheetView);
        bottomSheetBehavior =BottomSheetBehavior.from(linearLayout);
        extras = getIntent().getExtras();
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                if(i == BottomSheetBehavior.STATE_HIDDEN){

                }
                else if  (i ==  BottomSheetBehavior.STATE_EXPANDED){
                 Log.i("ex","Expanded BottomSheet" );
                // initAdapter();
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
        activityCharacterDetailsBinding.CloseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Clicked" ,Toast.LENGTH_LONG ).show();
                Animation animation=AnimationUtils.loadAnimation(v.getContext(), R.anim.translate_then_rotate);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        onBackPressed();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
             activityCharacterDetailsBinding.CloseImageView.startAnimation(animation);
            }
        });
        HandleDraw(extras.getInt("FragmentNumber"));
        Animate();

    }
    @Override
    protected void onStart() {
        super.onStart();
        }
    private void HandleDraw(int fragmentNumber) {
        if(fragmentNumber ==1){
            activityCharacterDetailsBinding.DetailFragmentRoot.setBackgroundResource(R.drawable.kevin_background);
            activityCharacterDetailsBinding.CharacterImageView.setImageResource(R.drawable.kevin_minions);
            activityCharacterDetailsBinding.CharacterNameView.setText("Kevin");
            activityCharacterDetailsBinding.CharacterDefinationView.setText(R.string.kevinDefination);
        }
        else{

            activityCharacterDetailsBinding.DetailFragmentRoot.setBackgroundResource(R.drawable.agnes_background);
            activityCharacterDetailsBinding.CharacterImageView.setImageResource(R.drawable.agnes_gru);
            activityCharacterDetailsBinding.CharacterNameView.setText("Agnes");
            activityCharacterDetailsBinding.CharacterDefinationView.setText(R.string.angesDefination);
        }

    }
    private void Animate() {

        Animation animation1= AnimationUtils.loadAnimation(this,R.anim.from_left_current );
        activityCharacterDetailsBinding.CharacterNameView.startAnimation(animation1);
        Animation animation2=AnimationUtils.loadAnimation(this,R.anim.from_button_current );
        activityCharacterDetailsBinding.CharacterDefinationView.startAnimation(animation2);
        Animation animation3=AnimationUtils.loadAnimation(this,R.anim.translate_then_rotate );
        activityCharacterDetailsBinding.CloseImageView.startAnimation(animation3);
        activityCharacterDetailsBinding.CharacterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View myView = v;
                Animation animation=AnimationUtils.loadAnimation(v.getContext(),R.anim.scale_up );
                animation.setFillEnabled(false);
                animation.setFillAfter(false);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.i("t","aNIMATION sTART cLICKED" );
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                v.startAnimation(animation);
            }
        });

    }

}
