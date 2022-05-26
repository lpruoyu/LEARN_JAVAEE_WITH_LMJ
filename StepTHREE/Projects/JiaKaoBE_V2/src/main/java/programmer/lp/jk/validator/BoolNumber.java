package programmer.lp.jk.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = BoolNumber.BoolNumberValidator.class)
public @interface BoolNumber {
    String message() default "只能为0或1";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class BoolNumberValidator implements ConstraintValidator<BoolNumber, Short> {
        @Override
        public boolean isValid(Short value, ConstraintValidatorContext context) {
            return value == null || value == 0 || value == 1;
        }
    }
}
