package com.demo.chenke.commonlib;

/**
 * Created by chenke on 2018/4/26.
 * 登录信息存储，实际开发中将登录的model持久化
 */
public class App {
    private static final App single = new App();
    private boolean isLogin;

    public static App getInstance() {
        return AppSingle.mInstance;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    private static class AppSingle {
        private static final App mInstance = new App();
    }
}
