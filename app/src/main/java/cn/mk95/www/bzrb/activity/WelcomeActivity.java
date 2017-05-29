package cn.mk95.www.bzrb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import cn.mk95.www.bzrb.R;

public class WelcomeActivity extends Activity {

    private ImageView welcomeImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    //初始化
    private void init() {
        findView();
        addAnimation();
    }

    private void addAnimation() {
        AlphaAnimation anima=new AlphaAnimation(0.3f,1.0f);
        // 设置动画显示时间
        anima.setDuration(3000);
        welcomeImg.setAnimation(anima);
        anima.setAnimationListener(new AnimationImpl());
    }

    //寻找控件
    private void findView() {
        welcomeImg=(ImageView) findViewById(R.id.welcome_img);
    }

    private class AnimationImpl implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Intent intent=new Intent(WelcomeActivity.this,IndexActivity.class);
            startActivity(intent);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
