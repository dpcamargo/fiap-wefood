package br.com.fiap.wefood.security;

import br.com.fiap.wefood.domain.model.User;
import br.com.fiap.wefood.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found."));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.username().value())
                .password(user.password().value())
                .roles(String.valueOf(user.role()))
                .build();
    }
}
