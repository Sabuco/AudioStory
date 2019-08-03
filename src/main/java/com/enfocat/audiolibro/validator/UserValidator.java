package com.enfocat.audiolibro.validator;

import com.enfocat.audiolibro.models.User;
import com.enfocat.audiolibro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        //Validacion de campo de password
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        //Validacion de campo de password confirmacion
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        //Add campos nombre real del usuario 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (user.getName().length() < 8 || user.getName().length() > 32) {
            errors.rejectValue("name", "Size.userForm.password");
        }

        //Add campo nuevo de email

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (user.getEmail().length() < 8 || user.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.password");
        }

    }
}