package com.demo.chenke.logincomponent.presenter;

import android.text.TextUtils;

import com.demo.chenke.basiclib.mvpbase.baseImpl.BasePresenterImpl;
import com.demo.chenke.basiclib.retroft.ExceptionHelper;
import com.demo.chenke.logincomponent.bean.LoginBean;
import com.demo.chenke.logincomponent.contact.LoginDataContact;
import com.demo.chenke.logincomponent.contact.LoginViewContact;
import com.demo.chenke.logincomponent.http.LoginApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenke on 2018/4/25.
 */

public class LoginPresenter extends BasePresenterImpl<LoginDataContact.view> implements LoginDataContact.presenter {
    private LoginViewContact loginView;

    public LoginPresenter(LoginDataContact.view view, LoginViewContact loginView) {
        super(view);
        this.loginView = loginView;
    }

    @Override
    public void login(String username, String pass) {
        if (loginView != null) {
            if (TextUtils.isEmpty(username)) {
                loginView.usernameError("账号有误");
            } else if (TextUtils.isEmpty(pass)) {
                loginView.loginPassError("密码有误");
            } else {
                requestLoginData();
            }
        }
    }

    private void requestLoginData() {
        LoginApi.getInstance().test()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        view.showLoadingDialog("登录中...");
                        addDisposable(disposable);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        view.setData();
                        view.dismissLoadingDialog();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ExceptionHelper.handleException(throwable);
                        view.dismissLoadingDialog();
                    }
                });
    }

}
