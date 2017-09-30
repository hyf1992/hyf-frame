package com.hyf.baseframe.di;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * Created by hyf on 2017/9/29.
 */
@Component(modules = {ActivityBindingModule.class, AndroidSupportInjectionModule.class})
interface AppComponent extends AndroidInjector<DaggerApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<DaggerApplication> {
    }

}
