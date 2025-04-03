package com.example.EC3.Controller;

import com.example.EC3.Model.Curso;
import com.example.EC3.Model.Profesor;
import com.example.EC3.Service.CursoService;
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
public class CursoController {

    @Autowired
    private CursoService service;

    @Autowired
    private ProfesorService profesorService;

    @GetMapping("Cursos")
    public String Index(Model model){

        List<Curso> cursos = service.getAll();
        List<Profesor> profesores = profesorService.getAll();

        model.addAttribute("cursos", cursos);
        model.addAttribute("profesores", profesores); // Lista de profesores para el combobox

        return "Cursos/Index";
    }

    @GetMapping("Cursos/Create")
    public String Create (Model model){

        List<Profesor> profesores = profesorService.getAll();
        model.addAttribute("cursos", new Curso());
        model.addAttribute("profesores", profesores); // Lista de profesores para el combobox

        return "Cursos/Create";
    }

    @PostMapping("Cursos/Create")
    public String CreateProcess(@RequestParam String nombreCurso,
                                @RequestParam String cicloAcademico,
                                @RequestParam String aula,
                                @RequestParam Profesor idProfesor){

        Curso curso = new Curso();
        curso.setNombreCurso(nombreCurso);
        curso.setCicloAcademico(cicloAcademico);
        curso.setAula(aula);
        curso.setIdProfesor(idProfesor);

        service.insertar(curso);

        return "redirect:/Cursos";
    }

    @GetMapping("Cursos/{id}")
    public String Show(Model model, @PathVariable Long id){

        Curso curso = service.getId(id);

        if(curso == null){
            throw new ResponseStatusException(NOT_FOUND, "Curso Not Found");
        }

        model.addAttribute("curso", curso);

        return "Cursos/Show";
    }

    @GetMapping("Cursos/{id}/delete")
    public String Delete(@PathVariable Long id){

        Curso curso = service.getId(id);

        if(curso == null){
            throw new ResponseStatusException(NOT_FOUND, "Curso Not Found");
        }

        service.eliminar(id);

        return "redirect:/Cursos";

    }


    @GetMapping("Cursos/{id}/edit")
    public String Update(Model model, @PathVariable Long id){

        Curso curso = service.getId(id);
        List<Profesor> profesores = profesorService.getAll();

        if(curso == null){
            throw new ResponseStatusException(NOT_FOUND, "Curso Not Found");
        }

        model.addAttribute("curso", curso);
        model.addAttribute("profesores", profesores); // Lista de profesores para el combobox

        return "Cursos/Edit";
    }

    @PostMapping("Cursos/{idCurso}/edit")
    public String UpdateProcess(@PathVariable Long idCurso,
                                @RequestParam String nombreCurso,
                                @RequestParam String cicloAcademico,
                                @RequestParam String aula,
                                @RequestParam Profesor idProfesor){

        Curso curso = service.getId(idCurso);

        if(curso == null){
            throw new ResponseStatusException(NOT_FOUND, "Curso Not Found");
        }

        curso.setNombreCurso(nombreCurso);
        curso.setCicloAcademico(cicloAcademico);
        curso.setAula(aula);
        curso.setIdProfesor(idProfesor);

        service.actualizar(curso);

        return "redirect:/Cursos";
    }



}












