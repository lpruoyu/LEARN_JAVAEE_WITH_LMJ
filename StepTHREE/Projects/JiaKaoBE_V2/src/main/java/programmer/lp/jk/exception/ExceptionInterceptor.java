package programmer.lp.jk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import programmer.lp.jk.pojo.result.R;
import programmer.lp.jk.util.Rs;

//@ControllerAdvice
@RestControllerAdvice
public class ExceptionInterceptor {
//    @ExceptionHandler(Throwable.class)
//    public void exceptionHandlerOther(Throwable throwable, HttpServletResponse response) throws Exception {
//        response.setCharacterEncoding("UTF-8");
//        response.setStatus(400);
////        response.getWriter().write(Rs.error(getRealCause(throwable).getMessage()).json());
//        response.getWriter().write(Rs.error(throwable.getMessage()).json());
//    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public R handle(Throwable throwable) {
        return Rs.error(throwable);
    }

//    @ExceptionHandler(Throwable.class)
//    public void handle(Throwable throwable,
//                       HttpServletResponse response) throws Exception {
////        response.setContentType(/*MediaType.APPLICATION_JSON_UTF8_VALUE*//*"application/json; charset=UTF-8"*/);
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
//        response.setStatus(400);
//
////        DEBUGs.run(throwable::printStackTrace);
//
////        response.getWriter().write(Rs.error(getRealCause(throwable)).json());
//        response.getWriter().write(Rs.error(throwable).jsonString());
//    }

    private Throwable getRealCause(Throwable throwable) {
        Throwable cause = throwable.getCause();
        while (cause != null) {
            throwable = cause;
            cause = cause.getCause();
        }
        return throwable;
    }
}
