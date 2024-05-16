package com.datos;

/**
 * La clase Profesor representa a un profesor dentro de una institución educativa.
 * Contiene información sobre el profesor, como su identificador, DNI, correo electrónico,
 * nombre completo, estado de actividad, perfil, contraseña y departamento al que pertenece.
 * 
 * @author Marcos
 * @author Álvaro
 */
public class Profesor {

    private int id;                 // Identificador del profesor
    private String dni;             // DNI del profesor
    private String correo;          // Correo electrónico del profesor
    private String nombreCompleto;  // Nombre completo del profesor
    private boolean activo;         // Indica si el profesor está activo o inactivo
    private String perfil;          // Perfil del profesor (por ejemplo, Administrador, Profesor, etc.)
    private String pass;            // Contraseña del profesor
    private int departamento;       // Identificador del departamento al que pertenece el profesor

    /**
     * Constructor para crear una instancia de Profesor.
     * 
     * @param id Identificador del profesor
     * @param dni DNI del profesor
     * @param correo Correo electrónico del profesor
     * @param nombreCompleto Nombre completo del profesor
     * @param activo Indica si el profesor está activo (true) o inactivo (false)
     * @param perfil Perfil del profesor
     * @param pass Contraseña del profesor
     * @param departamento Identificador del departamento al que pertenece el profesor
     */
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

    /**
     * Obtiene el identificador del profesor.
     * 
     * @return Identificador del profesor
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del profesor.
     * 
     * @param id Identificador del profesor
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el DNI del profesor.
     * 
     * @return DNI del profesor
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del profesor.
     * 
     * @param dni DNI del profesor
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el correo electrónico del profesor.
     * 
     * @return Correo electrónico del profesor
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del profesor.
     * 
     * @param correo Correo electrónico del profesor
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el nombre completo del profesor.
     * 
     * @return Nombre completo del profesor
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del profesor.
     * 
     * @param nombreCompleto Nombre completo del profesor
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Verifica si el profesor está activo.
     * 
     * @return true si el profesor está activo, false si está inactivo
     */
    public boolean getActivo() {
        return activo;
    }

    /**
     * Establece el estado de actividad del profesor.
     * 
     * @param activo true para activar al profesor, false para desactivarlo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Obtiene el perfil del profesor.
     * 
     * @return Perfil del profesor
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * Establece el perfil del profesor.
     * 
     * @param perfil Perfil del profesor
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * Obtiene la contraseña del profesor.
     * 
     * @return Contraseña del profesor
     */
    public String getPass() {
        return pass;
    }

    /**
     * Establece la contraseña del profesor.
     * 
     * @param pass Contraseña del profesor
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Obtiene el identificador del departamento al que pertenece el profesor.
     * 
     * @return Identificador del departamento
     */
    public int getDepartamento() {
        return departamento;
    }

    /**
     * Establece el identificador del departamento al que pertenece el profesor.
     * 
     * @param departamento Identificador del departamento
     */
    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }
}
