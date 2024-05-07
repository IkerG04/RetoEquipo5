/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad;

import java.time.LocalDate;

public class ActividadData {
    private int id;
    private String profesorSolicitante;
    private String departamento;
    private String titulo;
    private boolean enProgramacion;
    private String transporte;
    private LocalDate inicio;
    private LocalDate fin;
    private String grupo;
    private int numAlumnos;
    private boolean alojamiento;
    private String comentarios;
    private String empresaTransporte;
    private boolean actividadRealizada;

    public ActividadData(int id, String profesorSolicitante, String departamento, String titulo, boolean enProgramacion, String transporte, LocalDate inicio, LocalDate fin, String grupo, int numAlumnos, boolean alojamiento, String comentarios, String empresaTransporte, boolean actividadRealizada) {
        this.id = id;
        this.profesorSolicitante = profesorSolicitante;
        this.departamento = departamento;
        this.titulo = titulo;
        this.enProgramacion = enProgramacion;
        this.transporte = transporte;
        this.inicio = inicio;
        this.fin = fin;
        this.grupo = grupo;
        this.numAlumnos = numAlumnos;
        this.alojamiento = alojamiento;
        this.comentarios = comentarios;
        this.empresaTransporte = empresaTransporte;
        this.actividadRealizada = actividadRealizada;
    }

    // Constructor vacío por si se necesita
    public ActividadData() {
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
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    public boolean isAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(boolean alojamiento) {
        this.alojamiento = alojamiento;
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
                ", titulo='" + titulo + '\'' +
                ", enProgramacion=" + enProgramacion +
                ", transporte='" + transporte + '\'' +
                ", inicio=" + inicio +
                ", fin=" + fin +
                ", grupo='" + grupo + '\'' +
                ", numAlumnos=" + numAlumnos +
                ", alojamiento=" + alojamiento +
                ", comentarios='" + comentarios + '\'' +
                ", empresaTransporte='" + empresaTransporte + '\'' +
                ", actividadRealizada=" + actividadRealizada +
                '}';
    }
}