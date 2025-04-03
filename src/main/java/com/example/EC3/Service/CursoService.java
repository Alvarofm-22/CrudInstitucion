package com.example.EC3.Service;

import com.example.EC3.Model.Curso;
import com.example.EC3.Model.Estudiante;
import com.example.EC3.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public List<Curso> getAll(){
        return (List<Curso>) repository.findAll();
    }

    public Curso getId(Long id){
        return repository.findById(id).orElse(null);
    }

    public void insertar(Curso curso){
        repository.save(curso);
    }

    public void actualizar(Curso curso){
        repository.save(curso);
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

}
