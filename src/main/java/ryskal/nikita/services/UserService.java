package ryskal.nikita.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ryskal.nikita.UserDetailsImpl;
import ryskal.nikita.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return UserDetailsImpl.build(
                userRepository.findUsersByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User %s not found", username)
                )));
    }
}
