package com.datos;

/**
 * La clase Grupo representa un grupo de alumnos asociado a un curso.
 * Contiene información sobre el grupo, como su identificador, código, curso al que pertenece,
 * número de alumnos y estado de actividad.
 * 
 * @author Marcos
 * @author Álvaro
 */
public class Grupo {

    private int id;             // Identificador del grupo
    private String codgrupo;    // Código único del grupo
    private int curso;          // Identificador del curso al que pertenece el grupo
    private int numAlumnos;     // Número de alumnos en el grupo
    private boolean activo;     // Indica si el grupo está activo o no

    /**
     * Constructor para crear una instancia de Grupo.
     * 
     * @param id Identificador del grupo
     * @param codgrupo Código único del grupo
     * @param curso Identificador del curso al que pertenece el grupo
     * @param numAlumnos Número de alumnos en el grupo
     * @param activo Indica si el grupo está activo (true) o no (false)
     */
    public Grupo(int id, String codgrupo, int curso, int numAlumnos, boolean activo) {
        this.id = id;
        this.codgrupo = codgrupo;
        this.curso = curso;
        this.numAlumnos = numAlumnos;
        this.activo = activo;
    }

    /**
     * Obtiene el identificador del grupo.
     * 
     * @return Identificador del grupo
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del grupo.
     * 
     * @param id Identificador del grupo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el código único del grupo.
     * 
     * @return Código único del grupo
     */
    public String getCodgrupo() {
        return codgrupo;
    }

    /**
     * Establece el código único del grupo.
     * 
     * @param codgrupo Código único del grupo
     */
    public void setCodgrupo(String codgrupo) {
        this.codgrupo = codgrupo;
    }

    /**
     * Obtiene el identificador del curso al que pertenece el grupo.
     * 
     * @return Identificador del curso
     */
    public int getCurso() {
        return curso;
    }

    /**
     * Establece el identificador del curso al que pertenece el grupo.
     * 
     * @param curso Identificador del curso
     */
    public void setCurso(int curso) {
        this.curso = curso;
    }

    /**
     * Obtiene el número de alumnos en el grupo.
     * 
     * @return Número de alumnos en el grupo
     */
    public int getNumAlumnos() {
        return numAlumnos;
    }

    /**
     * Establece el número de alumnos en el grupo.
     * 
     * @param numAlumnos Número de alumnos en el grupo
     */
    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    /**
     * Verifica si el grupo está activo.
     * 
     * @return true si el grupo está activo, false si no está activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Establece el estado de actividad del grupo.
     * 
     * @param activo true para activar el grupo, false para desactivarlo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
