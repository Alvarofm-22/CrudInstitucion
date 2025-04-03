package com.example.EC3.Service;


import com.example.EC3.Model.User;
import com.example.EC3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // metodo para guardar
    public void registrar(User user){
        //crear objeto incriptador
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);

    }

    public User consultar(String userName){
        return repository.findByUserName(userName);
    }

    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }

    public User getId(Long id){
        return repository.findById(id).orElse(null);
    }




}
