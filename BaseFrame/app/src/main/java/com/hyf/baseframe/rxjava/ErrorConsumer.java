package com.hyf.baseframe.rxjava;


import com.hyf.baseframe.exception.CustomException;
import com.hyf.baseframe.ui.BaseView;

import io.reactivex.functions.Consumer;

/**
 * Created by hyf on 2017/9/30.
 */

public final class ErrorConsumer implements Consumer<Throwable> {
    private BaseView view;

    public ErrorConsumer(BaseView view) {
        this.view = view;
    }

    @Override
    public void accept(Throwable throwable) throws Exception {
        if(throwable instanceof CustomException){
            view.onError(((CustomException) throwable).getErrCode());
        }else{

        }
    }



}
