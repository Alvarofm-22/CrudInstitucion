package com.example.EC3.Service;

import com.example.EC3.Model.Profesor;
import com.example.EC3.Repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository repository;

    public List<Profesor> getAll(){
        return (List<Profesor>) repository.findAll();
    }

    public Profesor getId(Long id){
        return repository.findById(id).orElse(null);
    }

    public void insertar(Profesor profesor){
        repository.save(profesor);
    }

    public void actualizar(Profesor profesor){
        repository.save(profesor);
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }
}
