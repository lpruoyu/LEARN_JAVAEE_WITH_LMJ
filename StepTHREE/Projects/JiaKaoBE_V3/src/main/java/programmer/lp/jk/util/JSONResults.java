package programmer.lp.jk.util;

import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import programmer.lp.jk.exception.CommonException;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

public final class JSONResults {
    private JSONResults() {
    }

    public static JSONResult success(CodeMsg codeMsg) {
        return new JSONResult(codeMsg);
    }

    public static <T> JSONDataResult<T> success(T data) {
        return new JSONDataResult<>(data);
    }

    public static JSONResult exception(Throwable e) {
        JSONResult r = new JSONResult(CodeMsg.BAD_REQUEST.getCode());
        if (e instanceof CommonException) {
            r.setCode(((CommonException) e).getCode());
            r.setMsg(e.getMessage());
        } else if (e instanceof BindException) {
            final List<String> msgs = ((BindException) e).getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());
            final String message = StringUtils.collectionToDelimitedString(msgs, ", ");
            r.setMsg(message);
        } else if (e instanceof ConstraintViolationException) {
            final List<String> msgs = ((ConstraintViolationException) e).getConstraintViolations()
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
            final String message = StringUtils.collectionToDelimitedString(msgs, ", ");
            r.setMsg(message);
        } else {
            r.setMsg(e.getMessage()); // 项目运行时应该注销这一行，不把异常信息发送给前端
        }
        return r;
    }

    public static void exception(CodeMsg codeMsg) {
        throw new CommonException(codeMsg);
    }
}
