package ryskal.nikita.models;

import lombok.Data;

@Data
public class SigninRequest {
    private String username;
    private String password;
}
