package com.hyf.baseframe.ui;

import android.os.Bundle;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by hyf on 2017/9/29.
 */

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initData();
        initView();
    }

    protected abstract int getLayout();
    protected abstract void initData();
    protected abstract void initView();
}
