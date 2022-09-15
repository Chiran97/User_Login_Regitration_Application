package com.example.user_login_regitration_application.registration;

import com.example.user_login_regitration_application.appuser.AppUser;
import com.example.user_login_regitration_application.appuser.AppUserRole;
import com.example.user_login_regitration_application.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(
               new AppUser(
                   request.getFirstName(),
                       request.getLastName(),
                       request.getEmail(),
                       request.getPassword(),
                       AppUserRole.USER

               )
        );
    }
}
