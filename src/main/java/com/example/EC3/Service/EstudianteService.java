package com.example.EC3.Service;

import com.example.EC3.Model.Estudiante;
import com.example.EC3.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    public List<Estudiante> getAll(){
        return (List<Estudiante>) repository.findAll();
    }

    public Estudiante getId(Long id){
        return repository.findById(id).orElse(null) ;
    }

    public void insertar(Estudiante estudiante){
        repository.save(estudiante);
    }

    public void actualizar(Estudiante estudiante){
        repository.save(estudiante);
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }
}
