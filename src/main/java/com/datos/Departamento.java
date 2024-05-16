package com.datos;

/**
 * La clase Departamento representa un departamento dentro de una organización.
 * Contiene información sobre el departamento, como su identificador, código y nombre.
 * 
 * @author Marcos
 * @author Álvaro
 */
public class Departamento {

    private int id;         // Identificador del departamento
    private String cod;     // Código único del departamento
    private String nombre;  // Nombre del departamento

    /**
     * Constructor para crear una instancia de Departamento.
     * 
     * @param id Identificador del departamento
     * @param cod Código único del departamento
     * @param nombre Nombre del departamento
     */
    public Departamento(int id, String cod, String nombre) {
        this.id = id;
        this.cod = cod;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador del departamento.
     * 
     * @return Identificador del departamento
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del departamento.
     * 
     * @param id Identificador del departamento
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el código único del departamento.
     * 
     * @return Código único del departamento
     */
    public String getCod() {
        return cod;
    }

    /**
     * Establece el código único del departamento.
     * 
     * @param cod Código único del departamento
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * Obtiene el nombre del departamento.
     * 
     * @return Nombre del departamento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del departamento.
     * 
     * @param nombre Nombre del departamento
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

