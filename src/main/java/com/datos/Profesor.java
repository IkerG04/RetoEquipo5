/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datos;

/**
 *
 * @author DAW104
 */
public class Profesor {

    private int id;
    private String dni;
    private String correo;
    private String nombreCompleto;
    private boolean activo;
    private String perfil;
    private String pass;
    private int departamento;

    public Profesor(int id, String dni, String correo, String nombreCompleto, boolean activo, String perfil, String pass, int departamento) {
        this.id = id;
        this.dni = dni;
        this.correo = correo;
        this.nombreCompleto = nombreCompleto;
        this.activo = activo;
        this.perfil = perfil;
        this.pass = pass;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    
}
