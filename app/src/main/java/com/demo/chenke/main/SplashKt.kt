package com.demo.chenke.main

import com.alibaba.android.arouter.launcher.ARouter
import com.demo.chenke.basiclib.mvpbase.baseImpl.BaseActivity
import com.demo.chenke.commonlib.App
import com.demo.chenke.commonlib.utils.RxTimerUtli
import kotlinx.android.synthetic.main.splash_kt.*

class SplashKt : BaseActivity() {
    override fun setLayout(): Int {
        return R.layout.splash_kt
    }

    override fun initView() {
        initTimer()
    }

    private fun initTimer() {
        var i = 4
        RxTimerUtli.interval(1.toLong(), {
            i--
            tv_timer.text = i.toString()
            if (i == 0) {
                if (!App.getInstance().isLogin) {
                    showLogin()
                } else {
                    showMain()
                }
                RxTimerUtli.cancel()
                finish()
            }
        })
    }

    private fun showLogin() {
        ARouter.getInstance().build("/login/login").navigation()
    }

    private fun showMain() {
        ARouter.getInstance().build("/app/main").navigation()
    }
}
