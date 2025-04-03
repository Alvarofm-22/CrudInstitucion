package com.example.EC3.Model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatricula;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false)
    private Curso idCurso;

    @ManyToOne
    @JoinColumn(name = "idEstudiante", nullable = false)
    private Estudiante idEstudiante;


    @DateTimeFormat(pattern = "yyyy-MM-dd")  // Asegura el formato de la fecha
    private LocalDate fechaMatricula;

    public Matricula() {
    }

    public Matricula(LocalDate fechaMatricula, Estudiante idEstudiante, Curso idCurso) {
        this.fechaMatricula = fechaMatricula;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public Estudiante getIdEstudiante() {
        return idEstudiante;
    }

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public void setIdEstudiante(Estudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }
}
