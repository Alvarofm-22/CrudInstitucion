package com.example.EC3.Service;


import com.example.EC3.Model.User;
import com.example.EC3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsImplement implements UserDetailsService {

    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{

        User user = repository.findByUserName(userName);

        if (user == null){
            throw new UsernameNotFoundException("Usuario y/o contraseña incorrectos");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                syncAutority(user.getRole())

        );
    }


    private Collection<? extends GrantedAuthority> syncAutority(String role){

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));

        return authorities;
    }
}
