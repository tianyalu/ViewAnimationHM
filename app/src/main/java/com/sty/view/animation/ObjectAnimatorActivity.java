package com.sty.view.animation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
public class ObjectAnimatorActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnAlpha;
    private Button btnRotate;
    private Button btnScale;
    private Button btnTranslation;
    private Button btnCombination;
    private Button btnPlayXml;
    private ImageView ivPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);

        initViews();
        setListeners();
    }

    private void initViews(){
        btnAlpha = findViewById(R.id.btn_alpha);
        btnRotate = findViewById(R.id.btn_rotate);
        btnScale = findViewById(R.id.btn_scale);
        btnTranslation = findViewById(R.id.btn_translation);
        btnCombination = findViewById(R.id.btn_combination);
        btnPlayXml = findViewById(R.id.btn_play_xml);
        ivPic = findViewById(R.id.iv_pic);
    }

    private void setListeners(){
        btnAlpha.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnTranslation.setOnClickListener(this);
        btnCombination.setOnClickListener(this);
        btnPlayXml.setOnClickListener(this);
        ivPic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_alpha:
                playAlphaAnimator();
                break;
            case R.id.btn_rotate:
                playRotateAnimator();
                break;
            case R.id.btn_scale:
                playScaleAnimator();
                break;
            case R.id.btn_translation:
                playTranslationAnimator();
                break;
            case R.id.btn_combination:
                playCombinationAnimator();
                break;
            case R.id.btn_play_xml:
                playAnimatorFromXml();
                break;
            case R.id.iv_pic:
                Toast.makeText(this, "属性动画效果会改变控件的真实坐标", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    //播放透明动画
    private void playAlphaAnimator(){
        /**
         * target: 执行动画的目标
         * propertyName: 属性的名字
         * float... values: 可变参数
         */
        ObjectAnimator oa = ObjectAnimator.ofFloat(ivPic, "alpha", 0, 0.5f, 0, 1, 0, 1);
        oa.setDuration(2000);

        oa.start(); //开始执行动画
    }

    //播放旋转动画
    private void playRotateAnimator(){
        //ObjectAnimator oa = ObjectAnimator.ofFloat(ivPic, "rotation", 0, 180, 90, 360);
        ObjectAnimator oa = ObjectAnimator.ofFloat(ivPic, "rotationX", 0, 180, 90, 360);
        oa.setDuration(2000);

        oa.start(); //开始执行动画
    }

    //播放缩放动画
    private void playScaleAnimator(){
        ObjectAnimator oa = ObjectAnimator.ofFloat(ivPic, "scaleX", 0.1f, 2, 1, 2);
        //ObjectAnimator oa = ObjectAnimator.ofFloat(ivPic, "scaleY", 0.1f, 2, 1, 2);
        oa.setDuration(2000);

        oa.start(); //开始执行动画
    }

    //播放位移动画
    private void playTranslationAnimator(){
        //ObjectAnimator oa = ObjectAnimator.ofFloat(ivPic, "translationX", 10, 50, 20, 100);
        ObjectAnimator oa = ObjectAnimator.ofFloat(ivPic, "translationY", 10, 50, 20, 100);
        oa.setDuration(2000);

        oa.start();  //开始执行动画
    }

    //播放组合动画
    private void playCombinationAnimator(){
        AnimatorSet as = new AnimatorSet();
        ObjectAnimator oa1 = ObjectAnimator.ofFloat(ivPic, "alpha", 0, 0.5f, 0, 1, 0, 1);
        ObjectAnimator oa2 = ObjectAnimator.ofFloat(ivPic, "rotationX", 0, 180, 90, 360);
        ObjectAnimator oa3 = ObjectAnimator.ofFloat(ivPic, "scaleX", 0.1f, 2, 1, 2);
        ObjectAnimator oa4 = ObjectAnimator.ofFloat(ivPic, "translationY", 10, 50, 20, 100);

        as.setDuration(2000); //执行动画的时长
        as.setTarget(ivPic); //执行动画的控件

        //往集合中添加动画
        as.playSequentially(oa1, oa2, oa3, oa4); //挨个飞
        //as.playTogether(oa1, oa2, oa3, oa4); //一起飞

        as.start();
    }

    //从XML加载播放动画
    private void playAnimatorFromXml(){
        ObjectAnimator oa = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.oanimator);
        oa.setTarget(ivPic);
        oa.start();
    }
}
