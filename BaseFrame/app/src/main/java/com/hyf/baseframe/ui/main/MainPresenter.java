package com.hyf.baseframe.ui.main;

import com.hyf.baseframe.beans.MobResult;
import com.hyf.baseframe.entitys.CookResult;
import com.hyf.baseframe.entitys.User;
import com.hyf.baseframe.rxjava.ErrorConsumer;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by hyf on 2017/9/29.
 */

public final class MainPresenter implements MainContract.Presenter {
    private MainContract.Model model;

    private MainContract.View view;

    @Inject
    MainPresenter(MainContract.Model model, MainContract.View view) {
        this.model = model;
        this.view = view;
    }


    @Override
    public void getCookCategory() {
        model.getCookCategory().subscribe(new Consumer<MobResult<CookResult>>() {
            @Override
            public void accept(MobResult<CookResult> cookResultMobResult) throws Exception {
                view.getCookCategory(cookResultMobResult.getResult());
            }
        },new ErrorConsumer(view));
    }
}
