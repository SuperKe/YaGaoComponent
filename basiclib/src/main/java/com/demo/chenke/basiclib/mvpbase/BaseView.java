package com.demo.chenke.basiclib.mvpbase;

public interface BaseView {

    void showLoadingDialog(String msg);

    void dismissLoadingDialog();

    void showLoading(String msg);

    void showContent();
}
