package com.demo.chenke.logincomponent.contact;

import com.demo.chenke.basiclib.mvpbase.BasePresenter;
import com.demo.chenke.basiclib.mvpbase.BaseView;

/**
 * Created by chenke on 2018/4/25.
 * 数据的view和视图的view
 */
public interface LoginDataContact {
    /**
     * 请求数据
     */
    interface presenter extends BasePresenter {
        void login(String username, String pass);
    }

    /**
     * 回填数据
     */
    interface view extends BaseView {
        void setData();
    }
}
