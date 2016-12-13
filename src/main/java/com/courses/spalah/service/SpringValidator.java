package com.courses.spalah.service;

import com.courses.spalah.domain.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Roman on 25.11.2016.
 */
@Component
public class SpringValidator  implements Validator {

        public boolean supports(Class<?> clazz) {
            return Person.class.isAssignableFrom(clazz);
        }

        public void validate(Object target, Errors errors) {
            Person person = (Person) target;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty", "Имя пользователя не должно быть пустым");
            String username = person.getFirstName();
            if ((username.length()) < 3) {
                errors.rejectValue("username", "username.tooShort", "Имя пользователя должно быть не короче 3-х символов");
            }

            /*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
            if (!(person.getLastName()).equals(person
                    .getConfirmPassword())) {
                errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
            }

            if( !EmailValidator.getInstance().isValid( signupForm.getEmail() ) ){
                errors.rejectValue("email", "email.notValid", "Email address is not valid.");
            }*/
        }
}
