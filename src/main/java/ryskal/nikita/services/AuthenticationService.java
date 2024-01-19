package ryskal.nikita.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ryskal.nikita.models.User;
import ryskal.nikita.requsts.SignInRequest;
import ryskal.nikita.requsts.SignUpRequest;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserServices userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public String signUp(SignUpRequest request) {

        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userService.create(user);

        return jwtService.generateToken(user);
    }
    public String signIn(SignInRequest sign) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                sign.getUsername(),
                sign.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(sign.getUsername());
        return jwtService.generateToken(user);
    }
}