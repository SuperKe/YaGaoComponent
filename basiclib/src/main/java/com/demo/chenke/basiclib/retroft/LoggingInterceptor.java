package com.demo.chenke.basiclib.retroft;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chenke on 2018/4/24.
 * retrofit的日志解析器
 */
public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("header", "bb")
                .build();
        Response response = chain.proceed(request);
        return response;
    }
}
