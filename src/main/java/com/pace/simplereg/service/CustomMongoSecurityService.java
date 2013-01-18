package com.pace.simplereg.service;

import com.pace.simplereg.domain.Account;
import com.pace.simplereg.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("customMongoSecurityService")
public class CustomMongoSecurityService implements UserDetailsService {

    private Account user;

    @Autowired
    AccountService userService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        try {

            this.user = userService.findByUsername(username);

            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            return new User(this.user.getUsername(), this.user.getPassword(), true, true, true, true,
                    getGrantedAuthorities());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List getGrantedAuthorities() {

        List authorities = new ArrayList();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return authorities;
    }

}