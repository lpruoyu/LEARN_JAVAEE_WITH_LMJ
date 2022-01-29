package programmer.lp.test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class TestReflectParam {

    public void run(String name, Integer age) {
    }

    public static void main(String[] args) throws Exception {
        Method method = TestReflectParam.class.getMethod("run", String.class, Integer.class);
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter.getName());
        }
    }

}
