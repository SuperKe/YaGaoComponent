package com.demo.chenke.otherlib.customview;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.chenke.otherlib.R;
import com.demo.chenke.otherlib.utils.ScreenUtils;

/**
 * Created by chenke on 2018/4/26.
 */
public class LoadingDialog extends Dialog implements Animation.AnimationListener {
    private View view;
    private ImageView iv_loading_01, iv_loading_02, iv_loading_03;
    private MyAnimation animation1;
    private MyAnimation animation2;

    public LoadingDialog(@NonNull Context context) {
        this(context, R.style.dialog_round_corner_transparent);
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initUI(context);
    }


    private void initUI(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.loading_dialog, null);
        iv_loading_01 = view.findViewById(R.id.iv_loading_01);
        iv_loading_02 = view.findViewById(R.id.iv_loading_02);
        iv_loading_03 = view.findViewById(R.id.iv_loading_03);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setContentView(view);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();         //使用这种方式更改了dialog的框宽高
        params.width = ScreenUtils.dpToPx(context.getResources(), 120);
        params.height = ScreenUtils.dpToPx(context.getResources(), 120);
        window.setAttributes(params);

    }

    /**
     * 给Dialog设置提示信息
     *
     * @param message
     */
    public void setMessage(CharSequence message) {
        if (message != null && message.length() > 0) {
            TextView txt = view.findViewById(R.id.tv_message);
            txt.setVisibility(View.VISIBLE);
            txt.setText(message);
            txt.invalidate();//刷新textView
        }
    }

    @Override
    public void show() {
        startAnimation();
        super.show();
    }

    private void startAnimation() {
        if (animation1 == null) {
            animation1 = new MyAnimation(1f, 0.5f);
        }
        if (animation2 == null) {
            animation2 = new MyAnimation(0.5f, 1f);
        }
        animation1.setAnimationListener(this);
        animation2.setAnimationListener(this);
        iv_loading_01.startAnimation(animation1);
        iv_loading_03.startAnimation(animation1);
        iv_loading_02.startAnimation(animation2);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animation1) {
            iv_loading_01.startAnimation(animation2);
            iv_loading_03.startAnimation(animation2);
            iv_loading_02.startAnimation(animation1);
        } else if (animation == animation2) {
            iv_loading_01.startAnimation(animation1);
            iv_loading_03.startAnimation(animation1);
            iv_loading_02.startAnimation(animation2);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    class MyAnimation extends AlphaAnimation {

        public MyAnimation(float fromAlpha, float toAlpha) {
            super(fromAlpha, toAlpha);
            this.setDuration(240);
            this.setFillAfter(true);
        }
    }
}
