/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datos;

/**
 * La clase Curso representa un curso educativo.
 * Contiene información sobre el curso, como su identificador, código, descripción, etapa educativa y estado de actividad.
 * 
 * @author Marcos
 * @author Álvaro
 */
public class Curso {

    private int id;             // Identificador del curso
    private String codcurso;    // Código único del curso
    private String descripcion; // Descripción del curso
    private String etapa;       // Etapa educativa a la que pertenece el curso
    private boolean activo;     // Indica si el curso está activo o no

    /**
     * Constructor para crear una instancia de Curso.
     * 
     * @param id Identificador del curso
     * @param codcurso Código único del curso
     * @param descripcion Descripción del curso
     * @param etapa Etapa educativa a la que pertenece el curso
     * @param activo Indica si el curso está activo (true) o no (false)
     */
    public Curso(int id, String codcurso, String descripcion, String etapa, boolean activo) {
        this.id = id;
        this.codcurso = codcurso;
        this.descripcion = descripcion;
        this.etapa = etapa;
        this.activo = activo;
    }

    /**
     * Obtiene el identificador del curso.
     * 
     * @return Identificador del curso
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del curso.
     * 
     * @param id Identificador del curso
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el código único del curso.
     * 
     * @return Código único del curso
     */
    public String getCodcurso() {
        return codcurso;
    }

    /**
     * Establece el código único del curso.
     * 
     * @param codcurso Código único del curso
     */
    public void setCodcurso(String codcurso) {
        this.codcurso = codcurso;
    }

    /**
     * Obtiene la descripción del curso.
     * 
     * @return Descripción del curso
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del curso.
     * 
     * @param descripcion Descripción del curso
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la etapa educativa del curso.
     * 
     * @return Etapa educativa del curso
     */
    public String getEtapa() {
        return etapa;
    }

    /**
     * Establece la etapa educativa del curso.
     * 
     * @param etapa Etapa educativa del curso
     */
    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    /**
     * Verifica si el curso está activo.
     * 
     * @return true si el curso está activo, false si no está activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Establece el estado de actividad del curso.
     * 
     * @param activo true para activar el curso, false para desactivarlo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
