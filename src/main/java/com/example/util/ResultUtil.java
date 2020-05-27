package com.example.util;

import java.util.HashMap;
import java.util.Map;

public class ResultUtil {

    public static Map<String, Object> error() {
        Map<String, Object> result = new HashMap();
        result.put("code", "101");
        result.put("msg", "error");
        return result;
    }

    public static Map<String, Object> loginError() {
        Map<String, Object> result = new HashMap();
        result.put("code", "100");
        result.put("msg", "账户密码错误");
        return result;
    }

    public static Map<String, Object> result(Integer code, String msg) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static Map<String, Object> success() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "success");
        return result;
    }

    public static Map<String, Object> success(Object obj) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "success");
        result.put("data", obj);
        return result;
    }

}
