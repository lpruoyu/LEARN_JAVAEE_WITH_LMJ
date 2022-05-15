package programmer.lp.jk.util;

import org.springframework.dao.DuplicateKeyException;
import programmer.lp.jk.exception.CommonException;
import programmer.lp.jk.pojo.query.PageQuery;
import programmer.lp.jk.pojo.result.CodeMsg;
import programmer.lp.jk.pojo.result.R;

public final class Rs {
    private Rs() {
    }

    public static final String K_COUNT = "count";
    public static final int CODE_SUCCESS = 0;

    private static final int CODE_ERROR_DEFAULT = CodeMsg.BAD_REQUEST.getCode();

    private static R success() {
        return new R().setCode(CODE_SUCCESS);
    }

    public static R success(PageQuery query) {
        return success().setData(query.getData());
    }

    public static R success(String msg) {
        return success().setMsg(msg);
    }

    public static R success(PageQuery query, String msg) {
        return success().setData(query.getData()).setMsg(msg);
    }

    public static R error() {
        return error(CODE_ERROR_DEFAULT);
    }

    public static R error(int code) {
        return new R().setCode(code);
    }

    public static R error(String msg) {
        return error().setMsg(msg);
    }

    public static R error(int code, String msg) {
        return error(code).setMsg(msg);
    }

    public static R error(Throwable e) {
        R r = error(e.getMessage());
        if (e instanceof CommonException) {
            r.setCode(((CommonException) e).getCode());
        }else if (e instanceof DuplicateKeyException) {
            r.setMsg(CodeMsg.SAVE_ERROR.getMsg());
        }
        return r;
    }

    public static R r(boolean success) {
        return new R().setCode(success ? CODE_SUCCESS : CODE_ERROR_DEFAULT);
    }

    public static R r(boolean success, String msg) {
        return r(success).setMsg(msg);
    }

    public static R r(boolean success, Object data) {
        return r(success).setData(data);
    }
}
