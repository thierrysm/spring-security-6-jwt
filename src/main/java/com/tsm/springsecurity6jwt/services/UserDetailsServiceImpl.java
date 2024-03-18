package com.tsm.springsecurity6jwt.services;

import com.tsm.springsecurity6jwt.repositories.UserRepository;
import com.tsm.springsecurity6jwt.security.UserAuthenticated;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(UserAuthenticated::new)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User Not Found with username: " + username));
    }
}
