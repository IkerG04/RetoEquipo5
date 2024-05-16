/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datos;

/**
 *
 * @author DAW104
 */
public class Usuario {

    private String nombre;
    private String apellidos;
    private String correo;
    private String password;

    public enum perfil {
        SuperUsuario, Administrador, EquipoAdministrativo, Profesor
    };

    private perfil perfilUsuario;

    public Usuario(String nombre, String apellidos, String correo, String password, int numPerfil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
        perfilUsuario = perfil.values()[numPerfil];

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Enum getPerfil() {
        return perfilUsuario;
    }

    public String getCorreo() {
        return correo;
    }
}
