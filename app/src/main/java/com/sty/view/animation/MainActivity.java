package com.sty.view.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnViewAnimation;
    private Button btnObjectAnimator;
    private Button btnFrameAnimation;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setListeners();
    }

    private void initViews(){
        btnViewAnimation = findViewById(R.id.btn_view_animation);
        btnObjectAnimator = findViewById(R.id.btn_object_animator);
        btnFrameAnimation = findViewById(R.id.btn_frame_animation);
    }

    private void setListeners(){
        btnViewAnimation.setOnClickListener(this);
        btnObjectAnimator.setOnClickListener(this);
        btnFrameAnimation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_view_animation:
                intent = new Intent(this, ViewAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_object_animator:
                intent = new Intent(this, ObjectAnimatorActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_frame_animation:
                intent = new Intent(this, FrameAnimationActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
