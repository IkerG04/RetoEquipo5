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

    private String correo;
    private String password;

    public enum perfil {
        SuperUsuario, Administrador, EquipoDirectivo, Profesor
    };

    private perfil perfilUsuario;

    public Usuario(String correo, String password, int numPerfil) {
        this.correo = correo;
        this.password = password;
        perfilUsuario = perfil.values()[numPerfil];
    }

    public Enum getPerfil() {
        return perfilUsuario;
    }
}
