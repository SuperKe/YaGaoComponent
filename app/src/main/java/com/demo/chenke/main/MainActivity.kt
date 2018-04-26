package com.demo.chenke.main

import com.alibaba.android.arouter.facade.annotation.Route
import com.demo.chenke.basiclib.mvpbase.baseImpl.BaseActivity

@Route(path = "/app/main")
class MainActivity : BaseActivity() {


    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }
}
