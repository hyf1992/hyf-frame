package com.hyf.baseframe.network;

import com.hyf.baseframe.beans.HttpResult;
import com.hyf.baseframe.beans.MobResult;
import com.hyf.baseframe.entitys.CookResult;
import com.hyf.baseframe.entitys.User;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hyf on 2017/9/30.
 */

public interface HttpService {
    //根据用户id获取用户
    @GET("v1/cook/category/query")
    Observable<MobResult<CookResult>> getCookCategory();
}
