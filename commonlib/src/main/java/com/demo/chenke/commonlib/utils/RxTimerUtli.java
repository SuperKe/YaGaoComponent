package com.demo.chenke.commonlib.utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


/**
 * Created by chenke on 2018/4/10.
 */

public class RxTimerUtli {
    private static Disposable mDisposable;

    /**
     * 每隔milliseconds秒后接口回调
     *
     * @param milliseconds 间隔多少时间
     * @param next         每次间隔回调
     */
    public static void interval(long milliseconds, final IRxNext next) {
        mDisposable = Observable.interval(milliseconds, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        next.doNext(aLong);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mDisposable.dispose();
                    }
                })
        ;
    }

    public static void cancel() {
        if (mDisposable != null && mDisposable.isDisposed()) {
            mDisposable.dispose();
            mDisposable = null;
        }
    }

    public interface IRxNext {
        void doNext(long number);
    }
}
