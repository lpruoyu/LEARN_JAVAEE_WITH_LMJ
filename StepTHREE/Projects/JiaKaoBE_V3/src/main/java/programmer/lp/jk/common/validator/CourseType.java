package programmer.lp.jk.common.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = CourseType.SpecialValidator.class)
public @interface CourseType {
    String message() default "只能为0或2或3";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    class SpecialValidator implements ConstraintValidator<CourseType, Short> {
        @Override
        public boolean isValid(Short value, ConstraintValidatorContext context) {
            return value == null || value == 0 || value == 2 || value == 3;
        }
    }
}