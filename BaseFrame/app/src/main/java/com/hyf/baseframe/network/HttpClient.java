package com.hyf.baseframe.network;

import android.util.SparseArray;

import com.hyf.baseframe.app.Constants;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by hyf on 2017/9/30.
 */

public class HttpClient {
    private static final long DEFAULT_CONNECT_TIMEOUT = 10;
    private volatile static HttpClient httpClient;
    private SparseArray<HttpService> retrofitManager;
    private Retrofit.Builder builder;

    private HttpClient() {
        retrofitManager = new SparseArray<>();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new CommonParamsInterceptor())
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .build();
        builder = new Retrofit.Builder().client(okHttpClient)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    }

    public static HttpClient getInstance() {
        if (httpClient == null) {
            synchronized (HttpClient.class) {
                if (httpClient == null) {
                    httpClient = new HttpClient();
                }
            }
        }
        return httpClient;
    }

    /**
     * 获取默认HttpService
     *
     * @return
     */
    public HttpService getHttpService() {
        return this.getHttpService(0);
    }

    /**
     * 根据host类型获取HttpService
     *
     * @param hostType
     * @return
     */
    public HttpService getHttpService(int hostType) {
        HttpService httpService = retrofitManager.get(hostType);
        if (httpService == null) {
            String baseUrl = Constants.getHost(hostType);
            httpService = builder.baseUrl(baseUrl).build().create(HttpService.class);
            retrofitManager.put(hostType, httpService);
        }
        return httpService;
    }

    /**
     *公共参数拦截器
     */
    class CommonParamsInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl httpUrl = request.url().newBuilder().addQueryParameter("key",Constants.MOB_APPKEY).build();
            request = request.newBuilder().url(httpUrl).build();
            return chain.proceed(request);
        }
    }





}
