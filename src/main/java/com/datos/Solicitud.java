package com.datos;

import java.time.LocalDate;

/**
 * La clase Solicitud representa una solicitud de actividad o viaje.
 * Contiene información detallada sobre la solicitud, incluyendo su identificador,
 * medios de transporte, departamento asociado, comentarios, alojamiento requerido,
 * número de alumnos, estado de la solicitud, grupo de curso asociado,
 * fechas de inicio y fin, indicador de si es una solicitud prevista y título.
 * 
 * @author Marcos
 * @author Álvaro
 */
public class Solicitud {
    private int id;                  // Identificador único de la solicitud
    private boolean medioTransporte; // Indica si se requiere medio de transporte
    private int departamento;        // Identificador del departamento asociado a la solicitud
    private String comentarios;      // Comentarios adicionales para la solicitud
    private boolean alojamiento;     // Indica si se requiere alojamiento
    private int numeroAlumnos;       // Número de alumnos para la solicitud
    private String estado;           // Estado actual de la solicitud
    private int grupocurso;          // Identificador del grupo de curso asociado a la solicitud
    private LocalDate fechaInicio;   // Fecha de inicio de la actividad solicitada
    private LocalDate fechaFin;      // Fecha de fin de la actividad solicitada
    private boolean prevista;        // Indica si la solicitud es prevista o no
    private String titulo;           // Título de la solicitud

    /**
     * Constructor para crear una instancia de Solicitud.
     * 
     * @param id Identificador único de la solicitud
     * @param medioTransporte Indica si se requiere medio de transporte
     * @param departamento Identificador del departamento asociado a la solicitud
     * @param comentarios Comentarios adicionales para la solicitud
     * @param alojamiento Indica si se requiere alojamiento
     * @param numeroAlumnos Número de alumnos para la solicitud
     * @param estado Estado actual de la solicitud
     * @param grupocurso Identificador del grupo de curso asociado a la solicitud
     * @param fechaInicio Fecha de inicio de la actividad solicitada
     * @param fechaFin Fecha de fin de la actividad solicitada
     * @param prevista Indica si la solicitud es prevista o no
     * @param titulo Título de la solicitud
     */
    public Solicitud(int id, boolean medioTransporte, int departamento, String comentarios, boolean alojamiento, int numeroAlumnos, String estado, int grupocurso, LocalDate fechaInicio, LocalDate fechaFin, boolean prevista, String titulo) {
        this.id = id;
        this.medioTransporte = medioTransporte;
        this.departamento = departamento;
        this.comentarios = comentarios;
        this.alojamiento = alojamiento;
        this.numeroAlumnos = numeroAlumnos;
        this.estado = estado;
        this.grupocurso = grupocurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.prevista = prevista;
        this.titulo = titulo;
    }

    /**
     * Obtiene el identificador único de la solicitud.
     * 
     * @return Identificador único de la solicitud
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la solicitud.
     * 
     * @param id Identificador único de la solicitud
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Verifica si se requiere medio de transporte para la solicitud.
     * 
     * @return true si se requiere medio de transporte, false si no
     */
    public boolean isMedioTransporte() {
        return medioTransporte;
    }

    /**
     * Establece si se requiere medio de transporte para la solicitud.
     * 
     * @param medioTransporte true para requerir medio de transporte, false si no
     */
    public void setMedioTransporte(boolean medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    /**
     * Obtiene el identificador del departamento asociado a la solicitud.
     * 
     * @return Identificador del departamento asociado
     */
    public int getDepartamento() {
        return departamento;
    }

    /**
     * Establece el identificador del departamento asociado a la solicitud.
     * 
     * @param departamento Identificador del departamento asociado
     */
    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene los comentarios adicionales para la solicitud.
     * 
     * @return Comentarios adicionales para la solicitud
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * Establece los comentarios adicionales para la solicitud.
     * 
     * @param comentarios Comentarios adicionales para la solicitud
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Verifica si se requiere alojamiento para la solicitud.
     * 
     * @return true si se requiere alojamiento, false si no
     */
    public boolean isAlojamiento() {
        return alojamiento;
    }

    /**
     * Establece si se requiere alojamiento para la solicitud.
     * 
     * @param alojamiento true para requerir alojamiento, false si no
     */
    public void setAlojamiento(boolean alojamiento) {
        this.alojamiento = alojamiento;
    }

    /**
     * Obtiene el número de alumnos para la solicitud.
     * 
     * @return Número de alumnos para la solicitud
     */
    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    /**
     * Establece el número de alumnos para la solicitud.
     * 
     * @param numeroAlumnos Número de alumnos para la solicitud
     */
    public void setNumeroAlumnos(int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    /**
     * Obtiene el estado actual de la solicitud.
     * 
     * @return Estado actual de la solicitud
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de la solicitud.
     * 
     * @param estado Estado actual de la solicitud
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el identificador del grupo de curso asociado a la solicitud.
     * 
     * @return Identificador del grupo de curso asociado
     */
    public int getGrupocurso() {
        return grupocurso;
    }

    /**
     * Establece el identificador del grupo de curso asociado a la solicitud.
     * 
     * @param grupocurso Identificador del grupo de curso asociado
     */
    public void setGrupocurso(int grupocurso) {
        this.grupocurso = grupocurso;
    }

    /**
     * Obtiene la fecha de inicio de la actividad solicitada.
     * 
     * @return Fecha de inicio de la actividad
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio de la actividad solicitada.
     * 
     * @param fechaInicio Fecha de inicio de la actividad
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de fin de la actividad solicitada.
     * 
     * @return Fecha de fin de la actividad
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin de la actividad solicitada.
     * 
     * @param fechaFin Fecha de fin de la actividad
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Verifica si la solicitud es prevista o no.
     * 
     * @return true si la solicitud es prevista, false si no
     */
    public boolean isPrevista() {
        return prevista;
    }

    /**
     * Establece si la solicitud es prevista o no.
     * 
     * @param prevista true si la solicitud es prevista, false si no
     */
    public void setPrevista(boolean prevista) {
        this.prevista = prevista;
    }

    /**
     * Obtiene el título de la solicitud.
     * 
     * @return Título de la solicitud
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la solicitud.
     * 
     * @param titulo Título de la solicitud
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
