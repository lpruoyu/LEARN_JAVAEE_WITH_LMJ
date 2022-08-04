package programmer.lp.jk.common.exception;

//@RestControllerAdvice
//@Slf4j
//public class CommonExceptionHandler {
//    @ExceptionHandler(Throwable.class)
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    public JSONResult main(Throwable throwable) {
//        log.error("error", throwable);
//        return exception(getRealCause(throwable));
//    }
//
//    private JSONResult exception(Throwable e) {
//        JSONResult jsonResult = new JSONResult();
//        int code = CodeMsg.BAD_REQUEST.getCode();
//        String message = e.getMessage();
//        if (e instanceof CommonException) {
//            code = ((CommonException) e).getCode();
//        } else if (e instanceof BindException) {
////            final List<String> msgs = ((BindException) e).getAllErrors()
////                    .stream()
////                    .map(ObjectError::getDefaultMessage)
////                    .collect(Collectors.toList());
//            message = StringUtils.collectionToDelimitedString(
//                    Streams.map(((BindException) e).getAllErrors(),
//                            ObjectError::getDefaultMessage), ", ");
//        } else if (e instanceof ConstraintViolationException) {
////            final List<String> msgs = ((ConstraintViolationException) e).getConstraintViolations()
////                    .stream()
////                    .map(ConstraintViolation::getMessage)
////                    .collect(Collectors.toList());
//            message = StringUtils.collectionToDelimitedString(
//                    Streams.map(((ConstraintViolationException) e).getConstraintViolations(),
//                            ConstraintViolation::getMessage), ", ");
//        } else if (e instanceof AuthorizationException) {
//            message = CodeMsg.NO_PERMISSION.getMsg();
//        }
//        jsonResult.setCode(code);
//        jsonResult.setMsg(message); // 项目运行时应该注销这一行，不把异常信息发送给前端
//        return jsonResult;
//    }
//
//    private Throwable getRealCause(Throwable throwable) {
//        Throwable cause = throwable.getCause();
//        while (cause != null) {
//            throwable = cause;
//            cause = cause.getCause();
//        }
//        return throwable;
//    }
//}


import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import programmer.lp.jk.common.enhance.CodeMsg;
import programmer.lp.jk.common.util.JSONResults;
import programmer.lp.jk.common.util.Streams;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public JSONResult handle(Throwable t) {
        log.error("handle", t);

        // 一些可以直接处理的异常
        if (t instanceof CommonException) {
            return handle((CommonException) t);
        } else if (t instanceof BindException) {
            return handle((BindException) t);
        } else if (t instanceof ConstraintViolationException) {
            return handle((ConstraintViolationException) t);
        } else if (t instanceof AuthorizationException) {
            return JSONResults.error(CodeMsg.NO_PERMISSION);
        }

        // 处理cause异常（导致产生t的异常）
        Throwable cause = t.getCause();
        if (cause != null) {
            return handle(cause);
        }

        // 其他异常（没有cause的异常）
        return JSONResults.error();
    }

    private JSONResult handle(CommonException ce) {
        return JSONResults.error(ce.getCode(), ce.getMessage());
    }

    private JSONResult handle(BindException be) {
        List<ObjectError> errors = be.getBindingResult().getAllErrors();
        // 函数式编程的方式：stream
        List<String> defaultMsgs = Streams.map(errors, ObjectError::getDefaultMessage);
        String msg = StringUtils.collectionToDelimitedString(defaultMsgs, ", ");
        return JSONResults.error(msg);
    }

    private JSONResult handle(ConstraintViolationException cve) {
        List<String> msgs = Streams.map(cve.getConstraintViolations(), ConstraintViolation::getMessage);
        String msg = StringUtils.collectionToDelimitedString(msgs, ", ");
        return JSONResults.error(msg);
    }
}