package com.example.EC3.Controller;

import com.example.EC3.Model.Estudiante;
import com.example.EC3.Service.EstudianteService;
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
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @GetMapping("Estudiantes")
    public String Index(Model model){

        List<Estudiante> estudiantes = service.getAll();
        model.addAttribute("estudiantes", estudiantes);

        return "Estudiantes/Index";
    }

    @GetMapping("Estudiantes/Create")
    public String Create (Model model){
        model.addAttribute("estudiante", new Estudiante());
        return "Estudiantes/Create";
    }

    @PostMapping("Estudiante/Create")
    public String Create(@RequestParam String nombres,
                         @RequestParam String apellidoPaterno,
                         @RequestParam String apellidoMaterno,
                         @RequestParam LocalDate fechaNacimiento,
                         @RequestParam String dni,
                         @RequestParam String genero,
                         @RequestParam String direccion,
                         @RequestParam String telefono,
                         @RequestParam String email,

                         @RequestParam String nombreApoderado,
                         @RequestParam String apellidoPaterApod,
                         @RequestParam String apellidoMaterApod,
                         @RequestParam String dniApoderado,
                         @RequestParam String generoApoderado,
                         @RequestParam String direccionApoderado,
                         @RequestParam String telefonoApoderado,
                         @RequestParam String emailApoderado){

        Estudiante estudiante = new Estudiante();
        estudiante.setNombres(nombres);
        estudiante.setApellidoPaterno(apellidoPaterno);
        estudiante.setApellidoMaterno(apellidoMaterno);
        estudiante.setFechaNacimiento(fechaNacimiento);
        estudiante.setDni(dni);
        estudiante.setGenero(genero);
        estudiante.setDireccion(direccion);
        estudiante.setTelefono(telefono);
        estudiante.setEmail(email);

        estudiante.setNombreApoderado(nombreApoderado);
        estudiante.setApellidoPaterApod(apellidoPaterApod);
        estudiante.setApellidoMaterApod(apellidoMaterApod);
        estudiante.setDniApoderado(dniApoderado);
        estudiante.setGeneroApoderado(generoApoderado);
        estudiante.setDireccionApoderado(direccionApoderado);
        estudiante.setTelefonoApoderado(telefonoApoderado);
        estudiante.setEmailApoderado(emailApoderado);

        service.insertar(estudiante);

        return "redirect:/Estudiantes";

    }

    @GetMapping("Estudiante/{id}")
    public String Show(Model model, @PathVariable Long id){
        Estudiante estudiante = service.getId(id);

        if(estudiante == null){
            throw new ResponseStatusException(NOT_FOUND, "Student Not Found");
        }

        model.addAttribute("estudiante", estudiante);

        return "Estudiantes/Show";
    }

    @GetMapping("Estudiante/{id}/delete")
    public String Delete(@PathVariable Long id){

        Estudiante estudiante = service.getId(id);

        if(estudiante == null){
            throw new ResponseStatusException(NOT_FOUND, "Student Not Found");
        }

        service.eliminar(id);

        return "redirect:/Estudiantes";
    }

    @GetMapping("Estudiante/{id}/edit")
    public String Update(Model model, @PathVariable Long id){

        Estudiante estudiante = service.getId(id);

        if(estudiante == null){
            throw new ResponseStatusException(NOT_FOUND, "Student Not Found");
        }
        // System.out.println("Fecha de Nacimiento Recuperada: " + estudiante.getFechaNacimiento());

        model.addAttribute("estudiante",estudiante);
        return "Estudiantes/Edit";
    }

    @PostMapping("Estudiante/{idEstudiante}/edit")
    public String UpdateProcess(@PathVariable Long idEstudiante,
                                @RequestParam String nombres,
                                @RequestParam String apellidoPaterno,
                                @RequestParam String apellidoMaterno,
                                @RequestParam LocalDate fechaNacimiento,
                                @RequestParam String dni,
                                @RequestParam String genero,
                                @RequestParam String direccion,
                                @RequestParam String telefono,
                                @RequestParam String email,

                                @RequestParam String nombreApoderado,
                                @RequestParam String apellidoPaterApod,
                                @RequestParam String apellidoMaterApod,
                                @RequestParam String dniApoderado,
                                @RequestParam String generoApoderado,
                                @RequestParam String direccionApoderado,
                                @RequestParam String telefonoApoderado,
                                @RequestParam String emailApoderado){

        Estudiante estudiante = service.getId(idEstudiante);

        if(estudiante == null){
            throw new ResponseStatusException(NOT_FOUND, "Student Not Found");
        }
        // System.out.println("Fecha de Nacimiento enviada: " + fechaNacimiento);

        estudiante.setNombres(nombres);
        estudiante.setApellidoPaterno(apellidoPaterno);
        estudiante.setApellidoMaterno(apellidoMaterno);
        estudiante.setFechaNacimiento(fechaNacimiento);
        estudiante.setDni(dni);
        estudiante.setGenero(genero);
        estudiante.setDireccion(direccion);
        estudiante.setTelefono(telefono);
        estudiante.setEmail(email);

        estudiante.setNombreApoderado(nombreApoderado);
        estudiante.setApellidoPaterApod(apellidoPaterApod);
        estudiante.setApellidoMaterApod(apellidoMaterApod);
        estudiante.setDniApoderado(dniApoderado);
        estudiante.setGeneroApoderado(generoApoderado);
        estudiante.setDireccionApoderado(direccionApoderado);
        estudiante.setTelefonoApoderado(telefonoApoderado);
        estudiante.setEmailApoderado(emailApoderado);

        service.actualizar(estudiante);
        return "redirect:/Estudiantes";
    }


}
