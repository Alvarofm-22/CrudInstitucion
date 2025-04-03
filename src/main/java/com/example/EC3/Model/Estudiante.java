package com.example.EC3.Model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  // Asegura el formato de la fecha
    private LocalDate fechaNacimiento;
    private String dni;
    private String genero;
    private String direccion;
    private String telefono;
    private String email;

    private String nombreApoderado;
    private String apellidoPaterApod;
    private String apellidoMaterApod;
    private String dniApoderado;
    private String generoApoderado;
    private String direccionApoderado;
    private String telefonoApoderado;
    private String emailApoderado;

    @OneToMany(mappedBy = "idEstudiante", cascade = CascadeType.ALL)
    private Set<Matricula> matriculas;


    public Estudiante() {
    }

    public Estudiante(String apellidoMaterApod, String apellidoMaterno, String apellidoPaterApod, String apellidoPaterno, String direccion, String direccionApoderado, String dni, String dniApoderado, String email, String emailApoderado, LocalDate fechaNacimiento, String genero, String generoApoderado, String nombreApoderado, String nombres, String telefono, String telefonoApoderado) {
        this.apellidoMaterApod = apellidoMaterApod;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterApod = apellidoPaterApod;
        this.apellidoPaterno = apellidoPaterno;
        this.direccion = direccion;
        this.direccionApoderado = direccionApoderado;
        this.dni = dni;
        this.dniApoderado = dniApoderado;
        this.email = email;
        this.emailApoderado = emailApoderado;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.generoApoderado = generoApoderado;
        this.nombreApoderado = nombreApoderado;
        this.nombres = nombres;
        this.telefono = telefono;
        this.telefonoApoderado = telefonoApoderado;
    }

    public String getApellidoMaterApod() {
        return apellidoMaterApod;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getApellidoPaterApod() {
        return apellidoPaterApod;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDireccionApoderado() {
        return direccionApoderado;
    }

    public String getDni() {
        return dni;
    }

    public String getDniApoderado() {
        return dniApoderado;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailApoderado() {
        return emailApoderado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public String getGeneroApoderado() {
        return generoApoderado;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

    public String getNombreApoderado() {
        return nombreApoderado;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTelefonoApoderado() {
        return telefonoApoderado;
    }

    // setter


    public void setApellidoMaterApod(String apellidoMaterApod) {
        this.apellidoMaterApod = apellidoMaterApod;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setApellidoPaterApod(String apellidoPaterApod) {
        this.apellidoPaterApod = apellidoPaterApod;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDireccionApoderado(String direccionApoderado) {
        this.direccionApoderado = direccionApoderado;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDniApoderado(String dniApoderado) {
        this.dniApoderado = dniApoderado;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmailApoderado(String emailApoderado) {
        this.emailApoderado = emailApoderado;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setGeneroApoderado(String generoApoderado) {
        this.generoApoderado = generoApoderado;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public void setNombreApoderado(String nombreApoderado) {
        this.nombreApoderado = nombreApoderado;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTelefonoApoderado(String telefonoApoderado) {
        this.telefonoApoderado = telefonoApoderado;
    }
}
