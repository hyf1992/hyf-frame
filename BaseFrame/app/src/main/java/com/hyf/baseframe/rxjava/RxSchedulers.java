package com.hyf.baseframe.rxjava;


import android.app.Activity;
import android.util.Log;

import com.hyf.baseframe.beans.HttpResult;
import com.hyf.baseframe.beans.MobResult;
import com.hyf.baseframe.exception.CustomException;
import com.hyf.baseframe.ui.main.MainActivity;

import javax.inject.Inject;

import cn.nekocode.rxlifecycle.RxLifecycle;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hyf on 2017/9/30.
 */

public final class RxSchedulers {

    /**
     * 统一返回处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> io_main(final Activity activity) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream.compose(RxLifecycle.bind(activity).<T>withObservable())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMap(new Function<T, ObservableSource<T>>() {
                            @Override
                            public ObservableSource<T> apply(@NonNull T t) throws Exception {
                                if (t instanceof HttpResult) {
                                    if (((HttpResult) t).getMeta().isSuccess())
                                        return Observable.just(t);
                                    else
                                        return Observable.error(new CustomException(((HttpResult) t).getMeta().getCode()));
                                } else if (t instanceof MobResult) {
                                    if ("success".equals(((MobResult) t).getMsg())) {
                                        return Observable.just(t);
                                    }else{
                                        return Observable.error(new CustomException(((MobResult) t).getRetCode()));
                                    }
                                } else {
                                    return Observable.empty();
                                }
                            }
                        }).doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {

                            }
                        }).doFinally(new Action() {
                            @Override
                            public void run() throws Exception {

                            }
                        });
            }
        };

    }
}
