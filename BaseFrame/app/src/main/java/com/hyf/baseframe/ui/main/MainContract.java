package com.hyf.baseframe.ui.main;

import com.hyf.baseframe.beans.MobResult;
import com.hyf.baseframe.entitys.CookResult;
import com.hyf.baseframe.entitys.User;
import com.hyf.baseframe.ui.BaseModel;
import com.hyf.baseframe.ui.BasePresenter;
import com.hyf.baseframe.ui.BaseView;

import io.reactivex.Observable;

/**
 * Created by hyf on 2017/9/29.
 */

interface MainContract {
    interface Model extends BaseModel {
        Observable<MobResult<CookResult>> getCookCategory();
    }

    interface View extends BaseView {
        void getCookCategory(CookResult cookResult);
    }

    interface Presenter extends BasePresenter {
        void getCookCategory();
    }
}
