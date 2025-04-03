package com.example.EC3.Controller;

import com.example.EC3.Model.Curso;
import com.example.EC3.Model.Estudiante;
import com.example.EC3.Model.Matricula;
import com.example.EC3.Service.CursoService;
import com.example.EC3.Service.EstudianteService;
import com.example.EC3.Service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("Matriculas")
    public String Index(Model model){

        List<Matricula> matriculas = matriculaService.getAll();

        model.addAttribute("matriculas", matriculas);

        return "Matriculas/Index";
    }


    @GetMapping("Matriculas/Create")
    public String Create (Model model){

        List<Curso> cursos = cursoService.getAll();
        List<Estudiante> estudiantes = estudianteService.getAll();

        model.addAttribute("matriculas", new Matricula());
        model.addAttribute("cursos", cursos);
        model.addAttribute("estudiantes", estudiantes);


        return "Matriculas/Create";
    }

    @PostMapping("Matriculas/Create")
    public String CreateProcess(@RequestParam Curso idCurso,
                                @RequestParam Estudiante idEstudiante,
                                @RequestParam LocalDate fechaMatricula){

        Matricula matricula = new Matricula();
        matricula.setIdCurso(idCurso);
        matricula.setIdEstudiante(idEstudiante);
        matricula.setFechaMatricula(fechaMatricula);
        matriculaService.insertar(matricula);
        return "redirect:/Matriculas";

    }

    @GetMapping("Matriculas/{id}")
    public String Show(Model model, @PathVariable Long id){

        Matricula matricula = matriculaService.getId(id);

        if(matricula == null){
            throw new ResponseStatusException(NOT_FOUND, "Matricula Not Found");
        }

        model.addAttribute("matricula", matricula);

        return "Matriculas/Show";
    }


    @GetMapping("Matriculas/{id}/delete")
    public String Delete(@PathVariable Long id){

        Matricula matricula = matriculaService.getId(id);

        if(matricula == null){
            throw new ResponseStatusException(NOT_FOUND, "Matricula Not Found");
        }

        matriculaService.eliminar(id);

        return "redirect:/Matriculas";

    }



    @GetMapping("Matriculas/{id}/edit")
    public String Update(Model model, @PathVariable Long id){

        Matricula matricula = matriculaService.getId(id);

        List<Curso> cursos = cursoService.getAll();
        List<Estudiante> estudiantes = estudianteService.getAll();


        if(matricula == null){
            throw new ResponseStatusException(NOT_FOUND, "Matricula Not Found");
        }

        model.addAttribute("matricula", matricula);
        model.addAttribute("cursos", cursos);
        model.addAttribute("estudiantes", estudiantes);

        return "Matriculas/Edit";
    }


    @PostMapping("Matriculas/{idMatricula}/edit")
    public String UpdateProcess(@PathVariable Long idMatricula,
                                @RequestParam Curso idCurso,
                                @RequestParam Estudiante idEstudiante,
                                @RequestParam LocalDate fechaMatricula){

        Matricula matricula = matriculaService.getId(idMatricula);

        if(matricula == null){
            throw new ResponseStatusException(NOT_FOUND, "Matricula Not Found");
        }

        matricula.setIdCurso(idCurso);
        matricula.setIdEstudiante(idEstudiante);
        matricula.setFechaMatricula(fechaMatricula);

        matriculaService.actualizar(matricula);

        return "redirect:/Matriculas";

    }

}
