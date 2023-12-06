package ru.mirea.database.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.mirea.database.data.validator.UniquePopertyValidator;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniquePopertyValidator.class)
public @interface Unique {
    String message() default "Valude must be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
