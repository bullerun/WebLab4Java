package ryskal.nikita.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ryskal.nikita.models.User;
import ryskal.nikita.repositories.UserRepository;
import ryskal.nikita.requsts.SignInRequest;
import ryskal.nikita.requsts.SignUpRequest;
import ryskal.nikita.services.AuthenticationService;
import ryskal.nikita.services.UserServices;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;


    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpRequest sign) {
        return authenticationService.signUp(sign);
    }
    @PostMapping("/signin")
    public String signIn(@RequestBody SignInRequest sign) {
        return authenticationService.signIn(sign);

    }
}