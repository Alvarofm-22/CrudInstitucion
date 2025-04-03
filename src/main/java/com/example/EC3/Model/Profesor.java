package com.example.EC3.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesor;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String dni;

    @OneToMany(mappedBy = "idProfesor", cascade = CascadeType.ALL)
    private Set<Curso> cursos;

    public Profesor() {
    }

    public Profesor(String apeMaterno, String apePaterno, String dni, String nombres) {
        this.apeMaterno = apeMaterno;
        this.apePaterno = apePaterno;
        this.dni = dni;
        this.nombres = nombres;
    }

    //get

    public String getApeMaterno() {
        return apeMaterno;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public String getDni() {
        return dni;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
