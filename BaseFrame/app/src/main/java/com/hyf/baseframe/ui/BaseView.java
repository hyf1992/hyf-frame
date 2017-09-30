package com.hyf.baseframe.ui;

import com.hyf.baseframe.beans.Meta;

/**
 * Created by hyf on 2017/9/29.
 */

public interface BaseView {
    void showLoading();
    void stopLoading();
    void onError(int errCode);
}
