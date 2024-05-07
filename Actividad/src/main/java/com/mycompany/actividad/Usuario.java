/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad;

public class Usuario {
    private int idUsuario;
    private String correo;
    private String contraseña;
    private boolean isAdmin;
    private boolean isResponsable;

    // Constructor
    public Usuario(int idUsuario, String correo, String contraseña, boolean isAdmin, boolean isResponsable) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.isAdmin = isAdmin;
        this.isResponsable = isResponsable;
    }

    Usuario() {
    }

    // Getters
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isResponsable() {
        return isResponsable;
    }

    // Método para validar la contraseña
    public boolean validarContraseña(String contraseñaIngresada) {
        return this.contraseña.equals(contraseñaIngresada);
    }
}
