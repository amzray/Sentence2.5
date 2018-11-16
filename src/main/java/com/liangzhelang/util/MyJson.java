package com.liangzhelang.util;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class MyJson {
    private static Gson gson = new Gson();


    public static String obj2Str(Object obj){
        return gson.toJson(obj);
    }

    public static <T> T str2Obj(String str, Class<T> cla){
        return gson.fromJson(str, cla);

    }
}
