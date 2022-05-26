package programmer.lp.jk.foreign.anno;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ForeignFields1 {
    ForeignField1[] value() default {};
}
