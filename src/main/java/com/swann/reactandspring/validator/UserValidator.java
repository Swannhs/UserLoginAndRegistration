package com.swann.reactandspring.validator;

import com.swann.reactandspring.entity.user.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        if(!user.getPassword().equals(user.getConfirm()))
        errors.rejectValue("confirm","match", "Password did not match");
    }
}
