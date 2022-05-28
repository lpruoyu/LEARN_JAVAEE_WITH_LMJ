package programmer.lp.jk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;
import programmer.lp.jk.util.JSONResults;

@RestControllerAdvice
public class ExceptionInterceptor {
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public JSONResult handle(Throwable throwable) {
        System.out.println(throwable);
        return JSONResults.exception(throwable);
    }
}
