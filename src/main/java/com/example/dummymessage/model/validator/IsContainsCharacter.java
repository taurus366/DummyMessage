package com.example.dummymessage.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsContainsCharacterValidator.class)
public @interface IsContainsCharacter {

    String message() default "There are characters in text";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
