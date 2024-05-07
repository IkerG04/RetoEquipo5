/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad;

import java.time.LocalDate;

/**
 *
 * @author DAW129
 */
public class ActividadData {
    private int id;
    private String profesorSolicitante;
    private String departamento;
    private String titulo;
    private boolean enProgramacion;
    private String Transporte;
    private LocalDate Inicio;
    private LocalDate Fin;
    private String Grupo;
    private int numAlumnos;
    private boolean Alojamiento;
    private String comentarios;
    private String empresaTransporte;
    private boolean actividadRealizada;

    public ActividadData(int id, String profesorSolicitante, String departamento, String tituloActividad,
                         boolean enProgramacionDidactica, String medioTransporte, LocalDate fechaInicio,
                         LocalDate fechaFin, String grupoCurso, int numAlumnos, boolean necesitaAlojamiento,
                         String comentariosAdicionales, String empresaTransporte) {
        this.id = id;
        this.profesorSolicitante = profesorSolicitante;
        this.departamento = departamento;
        this.titulo = tituloActividad;
        this.enProgramacion = enProgramacionDidactica;
        this.Transporte = medioTransporte;
        this.Inicio = fechaInicio;
        this.Fin = fechaFin;
        this.Grupo = grupoCurso;
        this.numAlumnos = numAlumnos;
        this.Alojamiento = necesitaAlojamiento;
        this.comentarios = comentariosAdicionales;
        this.empresaTransporte = empresaTransporte;
        this.actividadRealizada = false; // Inicialmente la actividad no está realizada
    }

    ActividadData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public String getProfesorSolicitante() {
        return profesorSolicitante;
    }

    public void setProfesorSolicitante(String profesorSolicitante) {
        this.profesorSolicitante = profesorSolicitante;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isEnProgramacion() {
        return enProgramacion;
    }

    public void setEnProgramacion(boolean enProgramacion) {
        this.enProgramacion = enProgramacion;
    }

    public String getTransporte() {
        return Transporte;
    }

    public void setTransporte(String Transporte) {
        this.Transporte = Transporte;
    }

    public LocalDate getInicio() {
        return Inicio;
    }

    public void setInicio(LocalDate Inicio) {
        this.Inicio = Inicio;
    }

    public LocalDate getFin() {
        return Fin;
    }

    public void setFin(LocalDate Fin) {
        this.Fin = Fin;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    public boolean isAlojamiento() {
        return Alojamiento;
    }

    public void setAlojamiento(boolean Alojamiento) {
        this.Alojamiento = Alojamiento;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEmpresaTransporte() {
        return empresaTransporte;
    }

    public void setEmpresaTransporte(String empresaTransporte) {
        this.empresaTransporte = empresaTransporte;
    }

    public boolean isActividadRealizada() {
        return actividadRealizada;
    }

    public void setActividadRealizada(boolean actividadRealizada) {
        this.actividadRealizada = actividadRealizada;
    }

    @Override
    public String toString() {
        return "ActividadData{" +
                "id=" + id +
                ", profesorSolicitante='" + profesorSolicitante + '\'' +
                ", departamento='" + departamento + '\'' +
                ", tituloActividad='" + titulo + '\'' +
                ", enProgramacionDidactica=" + enProgramacion +
                ", medioTransporte='" + Transporte + '\'' +
                ", fechaInicio=" + Inicio +
                ", fechaFin=" + Fin +
                ", grupoCurso='" + Grupo + '\'' +
                ", numAlumnos=" + numAlumnos +
                ", necesitaAlojamiento=" + Alojamiento +
                ", comentariosAdicionales='" + comentarios + '\'' +
                ", empresaTransporte='" + empresaTransporte + '\'' +
                ", actividadRealizada=" + actividadRealizada +
                '}';
    }
}
