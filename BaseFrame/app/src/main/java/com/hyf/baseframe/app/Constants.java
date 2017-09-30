package com.hyf.baseframe.app;

/**
 * Created by hyf on 2017/9/30.
 */

public class Constants {
    private static final String DEFAULT_HOST = "http://apicloud.mob.com/";

    public static final String MOB_APPKEY  = "1eb379e570164";

    public static String getHost(int hostType) {
        switch (hostType) {
            case HostType.DEFAULT_HOST:
                return DEFAULT_HOST;
            default:
                return "";
        }
    }
}
