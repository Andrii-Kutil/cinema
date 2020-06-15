package com.gmail.kutilandrej.cinema.lib;

import com.gmail.kutilandrej.cinema.model.dto.UserRequestDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements
        ConstraintValidator<PasswordConstraint, UserRequestDto> {

    @Override
    public boolean isValid(UserRequestDto userRegistrationDto, ConstraintValidatorContext
            constraintValidatorContext) {
        String password = userRegistrationDto.getPassword();
        String repeatedPassword = userRegistrationDto.getRepeatedPassword();
        return password != null && password.equals(repeatedPassword);
    }
}
