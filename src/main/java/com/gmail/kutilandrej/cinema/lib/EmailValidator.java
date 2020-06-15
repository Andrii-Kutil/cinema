package com.gmail.kutilandrej.cinema.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements
        ConstraintValidator<EmailConstraint, String> {

    @Override
    public void initialize(EmailConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField.matches(".+@.+\\..+");
    }
}
