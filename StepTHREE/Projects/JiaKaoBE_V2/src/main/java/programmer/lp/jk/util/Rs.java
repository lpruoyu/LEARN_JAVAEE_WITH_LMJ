package programmer.lp.jk.util;

import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import programmer.lp.jk.exception.CommonException;
import programmer.lp.jk.pojo.query.PageQuery;
import programmer.lp.jk.pojo.result.CodeMsg;
import programmer.lp.jk.pojo.result.R;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

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

    public static R success(Object data) {
        return success().setData(data);
    }

    public static R success(PageQuery query, String msg) {
        return success().setData(query.getData()).setMsg(msg);
    }

    public static R success(CodeMsg codeMsg) {
        return success().setMsg(codeMsg.getMsg());
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
        R r = error(e.getMessage()); // 开发阶段
//        R r = error(); // 项目上线 项目上线了就不要把其它异常信息给用户看了
        if (e instanceof CommonException) {
            r.setCode(((CommonException) e).getCode());
        } else if (e instanceof BindException) {
            final List<String> msgs = ((BindException) e).getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());
//            final List<ObjectError> allErrors = ((BindException) e).getAllErrors();
//            final List<String> msgs = new ArrayList<>();
//            for (ObjectError allError : allErrors) {
//                msgs.add(allError.getDefaultMessage());
//            }
            final String message = StringUtils.collectionToDelimitedString(msgs, ", ");
            r.setMsg(message);
        } else if (e instanceof ConstraintViolationException) {
            final List<String> msgs = ((ConstraintViolationException) e).getConstraintViolations()
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
            final String message = StringUtils.collectionToDelimitedString(msgs, ", ");
            r.setMsg(message);
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

    public static R exception(String msg) {
        throw new CommonException(msg);
    }

    public static R exception(CodeMsg codeMsg) {
        throw new CommonException(codeMsg);
    }
}
