package programmer.lp.error;

// 运行时异常、相当于RuntimeException
public class MyError extends Error {

    public MyError(String message) {
        super(message);
    }

}
