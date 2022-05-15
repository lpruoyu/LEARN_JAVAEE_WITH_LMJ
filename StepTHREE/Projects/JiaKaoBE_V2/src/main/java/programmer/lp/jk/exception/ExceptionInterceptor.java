package programmer.lp.jk.exception;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import programmer.lp.jk.util.Rs;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@ControllerAdvice
public class ExceptionInterceptor {
//    @ExceptionHandler(Throwable.class)
//    public void exceptionHandlerOther(Throwable throwable, HttpServletResponse response) throws Exception {
//        response.setCharacterEncoding("UTF-8");
//        response.setStatus(400);
////        response.getWriter().write(Rs.error(getRealCause(throwable).getMessage()).json());
//        response.getWriter().write(Rs.error(throwable.getMessage()).json());
//    }

    @ExceptionHandler(Throwable.class)
    public void handle(Throwable throwable,
                       HttpServletResponse response) throws Exception {
//        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE/*"application/json; charset=UTF-8"*/);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setStatus(400);
//        response.getWriter().write(Rs.error(getRealCause(throwable)).json());
        response.getWriter().write(Rs.error(throwable).json());
    }

    private Throwable getRealCause(Throwable throwable) {
        Throwable cause = throwable.getCause();
        while (cause != null) {
            throwable = cause;
            cause = cause.getCause();
        }
        return throwable;
    }
}
