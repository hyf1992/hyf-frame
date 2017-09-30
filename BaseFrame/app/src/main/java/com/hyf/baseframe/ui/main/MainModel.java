package com.hyf.baseframe.ui.main;

import android.app.Activity;

import com.hyf.baseframe.beans.HttpResult;
import com.hyf.baseframe.beans.Meta;
import com.hyf.baseframe.beans.MobResult;
import com.hyf.baseframe.entitys.CookResult;
import com.hyf.baseframe.entitys.User;
import com.hyf.baseframe.network.HttpClient;
import com.hyf.baseframe.rxjava.RxSchedulers;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by hyf on 2017/9/29.
 */

public final class MainModel implements MainContract.Model {

    private MainContract.View view;

    @Inject
    MainModel(MainContract.View view) {
        this.view = view;
    }

    @Override
    public Observable<MobResult<CookResult>> getCookCategory() {
        return HttpClient.getInstance().getHttpService().getCookCategory()
                .compose(RxSchedulers.<MobResult<CookResult>>io_main((Activity) view));
    }
}
