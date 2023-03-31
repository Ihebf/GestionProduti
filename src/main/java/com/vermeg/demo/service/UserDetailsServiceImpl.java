package com.vermeg.demo.service;

import com.vermeg.demo.entities.AppUser;
import com.vermeg.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = ur.findByUsername(username);
        List<GrantedAuthority> ga = new ArrayList<>();

        user.getRoles()
                .forEach(r -> ga.add(new SimpleGrantedAuthority(r.getRole())));

        return new User(user.getUsername(),user.getPassword(),ga);
    }
}
