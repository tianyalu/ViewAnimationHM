package com.sty.view.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 补间动画效果不会改变控件的真实坐标
 */
public class ViewAnimationActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnAlpha;
    private Button btnRotate;
    private Button btnScale;
    private Button btnTranslation;
    private Button btnCombination;
    private ImageView ivPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        initViews();
        setListeners();
    }

    private void initViews(){
        btnAlpha = findViewById(R.id.btn_alpha);
        btnRotate = findViewById(R.id.btn_rotate);
        btnScale = findViewById(R.id.btn_scale);
        btnTranslation = findViewById(R.id.btn_translation);
        btnCombination = findViewById(R.id.btn_combination);
        ivPic = findViewById(R.id.iv_pic);
    }

    private void setListeners(){
        btnAlpha.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnTranslation.setOnClickListener(this);
        btnCombination.setOnClickListener(this);
        ivPic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_alpha:
                playAlphaAnimation();
                break;
            case R.id.btn_rotate:
                playRotateAnimation();
                break;
            case R.id.btn_scale:
                playScaleAnimation();
                break;
            case R.id.btn_translation:
                playTranslationAnimation();
                break;
            case R.id.btn_combination:
                playCombinationAnimation();
                break;
            case R.id.iv_pic:
                Toast.makeText(this, "补间动画效果不会改变控件的真实坐标", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    //播放透明动画
    private void playAlphaAnimation(){
//        1.0意味着完全不透明  0.0意味着完全透明
//        AlphaAnimation aa = new AlphaAnimation(1.0f, 0.0f);
//        aa.setDuration(2000); //设置动画执行的时间
//        aa.setRepeatCount(1); //设置重复的次数
//        aa.setRepeatMode(Animation.REVERSE); //设置动画执行的模式

        Animation aa = AnimationUtils.loadAnimation(this, R.anim.alpha);
        ivPic.startAnimation(aa); //开始执行动画
    }

    //播放旋转动画
    private void playRotateAnimation(){
        //fromDegrees:开始旋转的角度  toDegrees:结束旋转的角度
        //RotateAnimation ra = new RotateAnimation(0, 360);
//        RotateAnimation ra = new RotateAnimation(0, 360,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        ra.setDuration(2000); //设置动画执行的时间
//        ra.setRepeatCount(1); //设置重复的次数
//        ra.setRepeatMode(Animation.REVERSE); //设置动画执行的模式

        Animation ra = AnimationUtils.loadAnimation(this, R.anim.rotate);
        ivPic.startAnimation(ra); //开始执行动画
    }

    //播放缩放动画
    private void playScaleAnimation(){
//        ScaleAnimation sa = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        sa.setDuration(2000); //设置动画执行的时间
//        sa.setRepeatCount(1); //设置动画重复的次数
//        sa.setRepeatMode(Animation.REVERSE); //设置动画执行的模式

        Animation sa = AnimationUtils.loadAnimation(this, R.anim.scale);
        ivPic.startAnimation(sa); //开始执行动画
    }

    //播放位移动画
    private void playTranslationAnimation(){
//        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0,
//                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
//                Animation.RELATIVE_TO_PARENT, 0.2f);
//        ta.setDuration(2000); //设置动画执行的时间
//        ta.setRepeatCount(1); //设置动画重复的次数
//        ta.setRepeatMode(Animation.REVERSE); //设置动画执行的模式
//        ta.setFillAfter(true); //动画结束后停留在结束位置

        Animation ta = AnimationUtils.loadAnimation(this, R.anim.translate);
        ivPic.startAnimation(ta);  //开始执行动画
    }

    //播放组合动画
    private void playCombinationAnimation(){
//        AnimationSet as = new AnimationSet(true);
//
//        AlphaAnimation aa = new AlphaAnimation(1.0f, 0.0f);
//        aa.setDuration(2000); //设置动画执行的时间
//        aa.setRepeatCount(1); //设置重复的次数
//        aa.setRepeatMode(Animation.REVERSE); //设置动画执行的模式
//
//        RotateAnimation ra = new RotateAnimation(0, 360,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        ra.setDuration(2000); //设置动画执行的时间
//        ra.setRepeatCount(1); //设置重复的次数
//        ra.setRepeatMode(Animation.REVERSE); //设置动画执行的模式
//
//        ScaleAnimation sa = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        sa.setDuration(2000); //设置动画执行的时间
//        sa.setRepeatCount(1); //设置动画重复的次数
//        sa.setRepeatMode(Animation.REVERSE); //设置动画执行的模式
//
//        as.addAnimation(aa);
//        as.addAnimation(ra);
//        as.addAnimation(sa);

        Animation as = AnimationUtils.loadAnimation(this, R.anim.set);
        ivPic.startAnimation(as);
    }
}
