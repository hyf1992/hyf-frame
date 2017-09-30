package com.hyf.baseframe.beans;

/**
 * Created by hyf on 2017/9/29.
 */

public final class HttpResult<T> {
    private Meta meta;
    private T data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
