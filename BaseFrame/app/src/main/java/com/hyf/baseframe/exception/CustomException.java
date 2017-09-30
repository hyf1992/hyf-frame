package com.hyf.baseframe.exception;


/**
 * Created by hyf on 2017/9/30.
 */

public class CustomException extends Exception {
    private int errCode;

    public CustomException(int errCode){
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
