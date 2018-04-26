package com.demo.chenke.logincomponent.http;

import com.demo.chenke.logincomponent.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by chenke on 2018/4/25.
 */

public interface LoginRetrofitService {
    String BASE_URL = "https://news-at.zhihu.com/api/4/";

    /**
     * 测试接口
     *
     * @return
     */
    @GET("news/latest")
    Observable<LoginBean> test();
}
