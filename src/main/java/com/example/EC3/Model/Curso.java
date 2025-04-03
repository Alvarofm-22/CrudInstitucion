package com.example.EC3.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;
    private String nombreCurso;
    private String cicloAcademico;
    private String aula;


    @ManyToOne
    @JoinColumn(name = "idProfesor", nullable = false)
    private Profesor idProfesor;

    @OneToMany(mappedBy = "idCurso", cascade = CascadeType.ALL)
    private Set<Matricula> matriculas;

    public Curso() {
    }

    public Curso(String aula, Profesor idProfesor, Set<Matricula> matriculas, String nombreCurso, String cicloAcademico) {
        this.aula = aula;
        this.idProfesor = idProfesor;
        this.matriculas = matriculas;
        this.nombreCurso = nombreCurso;
        this.cicloAcademico = cicloAcademico;
    }

    public String getAula() {
        return aula;
    }

    public String getCicloAcademico() {
        return cicloAcademico;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public void setCicloAcademico(String cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
}
