package com.gmail.kutilandrej.cinema.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements
        ConstraintValidator<EmailConstraint, String> {
    private static final String EMAIL_REGEXP = ".+@.+\\..+";

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField.matches(EMAIL_REGEXP);
    }
}
