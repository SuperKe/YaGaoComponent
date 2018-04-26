package com.demo.chenke.logincomponent.activity

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.demo.chenke.basiclib.mvpbase.baseImpl.MvpActivity
import com.demo.chenke.commonlib.App
import com.demo.chenke.logincomponent.R
import com.demo.chenke.logincomponent.contact.LoginDataContact
import com.demo.chenke.logincomponent.contact.LoginViewContact
import com.demo.chenke.logincomponent.presenter.LoginPresenter
import kotlinx.android.synthetic.main.login_kt.*

@Route(path = "/login/login")
class LoginKt : MvpActivity<LoginDataContact.presenter>(), LoginDataContact.view, LoginViewContact {

    override fun setLayout(): Int {
        return R.layout.login_kt
    }

    override fun initView() {
        btn_login.setOnClickListener {
            presenter.login(edit_username.text.toString(), edit_password.text.toString())
        }
    }

    override fun initPresenter(): LoginDataContact.presenter {
        return LoginPresenter(this, this)
    }


    override fun setData() {
        App.getInstance().isLogin = true
        ARouter.getInstance().build("/app/main").navigation()
        finish()
    }


    override fun usernameError(msg: String?) {
        edit_username.error = msg
    }

    override fun loginPassError(msg: String?) {
        edit_password.error = msg
    }
}
