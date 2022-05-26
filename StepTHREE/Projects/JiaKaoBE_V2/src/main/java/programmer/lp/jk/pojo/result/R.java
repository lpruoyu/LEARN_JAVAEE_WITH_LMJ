package programmer.lp.jk.pojo.result;

import programmer.lp.jk.enhance.JSONable;

import java.util.HashMap;

public class R extends HashMap<String, Object> implements JSONable {
    public static final int CODE_SUCCESS = 0;

    private static final String K_CODE = "code";
    private static final String K_MSG = "msg";
    private static final String K_DATA = "data";

    public R setCode(int code) {
        return add(K_CODE, code);
    }

    public R setMsg(String msg) {
        return add(K_MSG, msg);
    }

    public R setData(Object data) {
        return add(K_DATA, data);
    }

    public R add(String key, Object data) {
        put(key, data);
        return this;
    }
}
