package com.example.EC3.Service;

import com.example.EC3.Model.Curso;
import com.example.EC3.Model.Matricula;
import com.example.EC3.Repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository repository;

    public List<Matricula> getAll(){
        return (List<Matricula>) repository.findAll();
    }

    public Matricula getId(Long id){
        return repository.findById(id).orElse(null);
    }

    public void insertar(Matricula matricula){
        repository.save(matricula);
    }

    public void actualizar(Matricula matricula){
        repository.save(matricula);
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }
}
