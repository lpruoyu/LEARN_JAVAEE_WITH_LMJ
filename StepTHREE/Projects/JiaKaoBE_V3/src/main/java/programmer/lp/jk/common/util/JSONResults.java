package programmer.lp.jk.common.util;

import programmer.lp.jk.common.enhance.CodeMsg;
import programmer.lp.jk.common.exception.CommonException;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;

public final class JSONResults {
    private JSONResults() {
    }

    public static JSONResult ok(CodeMsg codeMsg) {
        return new JSONResult(codeMsg);
    }

    public static <T> JSONDataResult<T> ok(T data) {
        return new JSONDataResult<>(data);
    }

    public static <T> T exception(CodeMsg codeMsg) {
        throw new CommonException(codeMsg);
    }

    public static JSONResult error() {
        return new JSONResult(CodeMsg.BAD_REQUEST.getCode());
    }

    public static JSONResult error(String msg) {
        return new JSONResult(CodeMsg.BAD_REQUEST.getCode(), msg);
    }

    public static JSONResult error(int code, String msg) {
        return new JSONResult(code, msg);
    }

    public static JSONResult error(CodeMsg codeMsg) {
        return new JSONResult(codeMsg);
    }
}
