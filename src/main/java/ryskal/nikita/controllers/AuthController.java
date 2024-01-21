package ryskal.nikita.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ryskal.nikita.requsts.SignInRequest;
import ryskal.nikita.requsts.SignUpRequest;
import ryskal.nikita.responses.JwtAuthenticationResponse;
import ryskal.nikita.services.AuthenticationService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public JwtAuthenticationResponse signUp(@RequestBody SignUpRequest sign) {
        return authenticationService.signUp(sign);
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse signIn(@RequestBody SignInRequest sign) {
        System.out.println(sign);
        return authenticationService.signIn(sign);

    }
}