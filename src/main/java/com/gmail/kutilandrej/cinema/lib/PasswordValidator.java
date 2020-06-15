package com.gmail.kutilandrej.cinema.lib;

import com.gmail.kutilandrej.cinema.model.dto.UserRegistrationDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements
        ConstraintValidator<PasswordConstraint, UserRegistrationDto> {

    @Override
    public boolean isValid(UserRegistrationDto userRegistrationDto, ConstraintValidatorContext
            constraintValidatorContext) {
        String password = userRegistrationDto.getPassword();
        String repeatedPassword = userRegistrationDto.getRepeatedPassword();
        return password != null && password.equals(repeatedPassword);
    }
}
