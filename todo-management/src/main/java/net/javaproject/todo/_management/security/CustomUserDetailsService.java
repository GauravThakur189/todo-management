package net.javaproject.todo._management.security;

import lombok.AllArgsConstructor;
import net.javaproject.todo._management.entity.User;
import net.javaproject.todo._management.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

     private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

          User user = userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
                  .orElseThrow(()-> new UsernameNotFoundException("User does not exist!"));

        Set<GrantedAuthority> authorities = user.getRole().stream()
                .map((role)-> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                usernameOrEmail,
                user.getPassword(),
                authorities
        );
    }
}
