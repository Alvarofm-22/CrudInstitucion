package com.example.EC3.Controller;


import com.example.EC3.Model.Estudiante;
import com.example.EC3.Model.Profesor;
import com.example.EC3.Service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class ProfesorController {

    @Autowired
    private ProfesorService service;

    @GetMapping("Profesores")
    public String Index(Model model){

        List<Profesor> profesores = service.getAll();
        model.addAttribute("profesores", profesores);

        return "Profesores/Index";
    }

    @GetMapping("Profesores/Create")
    public String Create(Model model){
        model.addAttribute("profesor", new Profesor());
        return "Profesores/Create";
    }

    @PostMapping("Profesores/Create")
    public String Create(@RequestParam String nombres,
                         @RequestParam String apePaterno,
                         @RequestParam String apeMaterno,
                         @RequestParam String dni){

        Profesor profesor = new Profesor();

        profesor.setNombres(nombres);
        profesor.setApePaterno(apePaterno);
        profesor.setApeMaterno(apeMaterno);
        profesor.setDni(dni);

        service.insertar(profesor);

        return "redirect:/Profesores";
    }

    @GetMapping("Profesores/{id}")
    public String Show(Model model, @PathVariable Long id){
        Profesor profesor = service.getId(id);

        if(profesor == null){
            throw new ResponseStatusException(NOT_FOUND, "Teacher Not Found");
        }

        model.addAttribute("profesor", profesor);

        return "Profesores/Show";
    }

    @GetMapping("Profesores/{id}/delete")
    public String Delete(@PathVariable Long id){

        Profesor profesor = service.getId(id);

        if(profesor == null){
            throw new ResponseStatusException(NOT_FOUND, "Teacher Not Found");
        }

        service.eliminar(id);

        return "redirect:/Profesores";
    }

    @GetMapping("Profesores/{id}/edit")
    public String Update(Model model, @PathVariable Long id) {

        Profesor profesor = service.getId(id);

        if (profesor == null) {
            throw new ResponseStatusException(NOT_FOUND, "Teacher Not Found");
        }
        // System.out.println("Fecha de Nacimiento Recuperada: " + estudiante.getFechaNacimiento());

        model.addAttribute("profesor", profesor);
        return "Profesores/Edit";
    }

    @PostMapping("Profesores/{idProfesor}/edit")
    public String UpdateProcess(@PathVariable Long idProfesor,
                                @RequestParam String nombres,
                                @RequestParam String apePaterno,
                                @RequestParam String apeMaterno,
                                @RequestParam String dni){

        Profesor profesor = service.getId(idProfesor);

        if(profesor == null){
            throw new ResponseStatusException(NOT_FOUND, "Teacher Not Found");
        }

        profesor.setNombres(nombres);
        profesor.setApePaterno(apePaterno);
        profesor.setApeMaterno(apeMaterno);
        profesor.setDni(dni);

        service.actualizar(profesor);

        return "redirect:/Profesores";

    }


}
