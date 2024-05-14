/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datos;

import java.time.LocalDate;

/**
 *
 * @author DAW104
 */
public class Solicitud {
    private int id;
    private boolean medioTransporte;
    private int departamento;
    private String comentarios;
    private boolean alojamiento;
    private int numeroAlumnos;
    private String estado;
    private int grupocurso;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean prevista;
    private String titulo;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(boolean medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public boolean isAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(boolean alojamiento) {
        this.alojamiento = alojamiento;
    }

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getGrupocurso() {
        return grupocurso;
    }

    public void setGrupocurso(int grupocurso) {
        this.grupocurso = grupocurso;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isPrevista() {
        return prevista;
    }

    public void setPrevista(boolean prevista) {
        this.prevista = prevista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
