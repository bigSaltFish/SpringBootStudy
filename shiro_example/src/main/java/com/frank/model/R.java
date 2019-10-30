package com.frank.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回给前端的model
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
        put("msg", "操作成功");
    }

    public static R error() {
        return error(1, "操作失败");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R ResponseBo = new R();
        ResponseBo.put("code", code);
        ResponseBo.put("msg", msg);
        return ResponseBo;
    }

    public static R ok(String msg) {
        R ResponseBo = new R();
        ResponseBo.put("msg", msg);
        return ResponseBo;
    }

    public static R ok(Map<String, Object> map) {
        R ResponseBo = new R();
        ResponseBo.putAll(map);
        return ResponseBo;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}