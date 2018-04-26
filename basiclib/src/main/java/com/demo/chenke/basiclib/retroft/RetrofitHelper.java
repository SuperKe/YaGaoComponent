package com.demo.chenke.basiclib.retroft;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chenke on 2018/4/25.
 */

public class RetrofitHelper {

    private static OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
    private static Retrofit.Builder mRetrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpBuilder
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS).build());

    public static <T> T create(String api, Class<T> cls) {
        Retrofit retrofit = mRetrofit.baseUrl(api).build();
        return retrofit.create(cls);
    }

}
