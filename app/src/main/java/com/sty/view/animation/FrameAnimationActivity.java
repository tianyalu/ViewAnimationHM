package com.sty.view.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 属性动画效果会改变控件的真实坐标
 */
public class FrameAnimationActivity extends AppCompatActivity{
    private ImageView ivPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        ivPic = findViewById(R.id.iv_pic);
        ivPic.setBackgroundResource(R.drawable.my_anim);
        AnimationDrawable ad = (AnimationDrawable) ivPic.getBackground();
        ad.start();
    }

}
