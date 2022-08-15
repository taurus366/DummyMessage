package com.example.dummymessage.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsContainsCharacterValidator implements ConstraintValidator<IsContainsCharacter, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {


        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(value);

        return matcher.find();
    }
}
