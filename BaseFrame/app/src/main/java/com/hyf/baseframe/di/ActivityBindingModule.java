package com.hyf.baseframe.di;

import com.hyf.baseframe.ui.main.MainActivity;
import com.hyf.baseframe.ui.main.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by hyf on 2017/9/29.
 */
@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();


}
