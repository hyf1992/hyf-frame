package com.hyf.baseframe.ui.main;

import com.hyf.baseframe.di.ActivityScoped;
import com.hyf.baseframe.ui.BaseView;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by hyf on 2017/9/29.
 */
@Module
public abstract class MainModule {

    @ActivityScoped
    @Binds
    abstract MainContract.View view(MainActivity mainActivity);

    @ActivityScoped
    @Binds
    abstract MainContract.Presenter presenter(MainPresenter mainPresenter);

    @ActivityScoped
    @Binds
    abstract MainContract.Model model(MainModel mainModel);


}
