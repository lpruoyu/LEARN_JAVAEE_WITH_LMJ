package programmer.lp.jk.foreign.anno;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Repeatable(ForeignFields1.class)
public @interface ForeignField1 {
    /**
     * 被引用的主表类
     */
    Class<?> value() default Object.class;

    /**
     * 被引用的主表类
     */
    Class<?> mainTable() default Object.class;

    /**
     * 被引用的属性名
     */
    String mainField() default "id";

    /**
     * 当前属性在数据库中的字段名
     */
    String column() default "";

    /**
     * 级联类型
     */
    ForeignCascade cascade() default ForeignCascade.DEFAULT;
}
