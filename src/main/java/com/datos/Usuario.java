/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datos;

/**
 * La clase Usuario representa un usuario del sistema.
 * Contiene información básica del usuario como nombre, apellidos, correo electrónico y perfil.
 * 
 * @author Marcos
 * @author Álvaro
 */
public class Usuario {

    private String nombre;
    private String apellidos;
    private String correo;
    private String password;

    /**
     * Enumeración que define los posibles perfiles de usuario.
     */
    public enum Perfil {
        SuperUsuario, Administrador, EquipoDirectivo, Profesor
    };

    private Perfil perfilUsuario;

    /**
     * Constructor para crear un nuevo Usuario.
     * 
     * @param nombre Nombre del usuario
     * @param apellidos Apellidos del usuario
     * @param correo Correo electrónico del usuario
     * @param password Contraseña del usuario
     * @param numPerfil Índice del perfil (0: SuperUsuario, 1: Administrador, 2: EquipoDirectivo, 3: Profesor)
     */
    public Usuario(String nombre, String apellidos, String correo, String password, int numPerfil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
        perfilUsuario = Perfil.values()[numPerfil];
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return Nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene los apellidos del usuario.
     * 
     * @return Apellidos del usuario
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Obtiene el perfil del usuario.
     * 
     * @return Perfil del usuario (enum Perfil)
     */
    public Perfil getPerfil() {
        return perfilUsuario;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return Correo electrónico del usuario
     */
    public String getCorreo() {
        return correo;
    }
}
