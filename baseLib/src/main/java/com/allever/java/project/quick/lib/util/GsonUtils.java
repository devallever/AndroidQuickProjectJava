package com.allever.java.project.quick.lib.util;

import com.google.gson.Gson;

public class GsonUtils {
    private static final Gson sGson = new Gson();

    public static String toJson(Object object) {
        return sGson.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return sGson.fromJson(json, clazz);
    }
}
