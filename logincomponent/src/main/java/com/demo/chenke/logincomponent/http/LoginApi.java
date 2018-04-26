package com.demo.chenke.logincomponent.http;

import com.demo.chenke.basiclib.retroft.BaseApiImpl;

/**
 * Created by chenke on 2018/4/25.
 */

public class LoginApi extends BaseApiImpl {
    public static LoginApi api = new LoginApi(LoginRetrofitService.BASE_URL);

    public LoginApi(String baseUrl) {
        super(baseUrl);
    }

    public static LoginRetrofitService getInstance() {
        return api.getRetrofit().create(LoginRetrofitService.class);
    }
}
