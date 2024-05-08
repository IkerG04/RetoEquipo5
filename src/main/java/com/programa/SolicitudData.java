/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programa;

/**
 *
 * @author DAW129
 */

class SolicitudData {
    private String professor;
    private String department;
    private String title;
    private String planningDidactic;
    private String transport;
    private String startDate;
    private String endDate;
    private String group;
    private int numStudents;
    private boolean accommodation;
    private String responsible;
    private String participants;
    private String comments;

    public SolicitudData(String professor, String department, String title, String planningDidactic,
                         String transport, String startDate, String endDate, String group, int numStudents,
                         boolean accommodation, String responsible, String participants, String comments) {
        this.professor = professor;
        this.department = department;
        this.title = title;
        this.planningDidactic = planningDidactic;
        this.transport = transport;
        this.startDate = startDate;
        this.endDate = endDate;
        this.group = group;
        this.numStudents = numStudents;
        this.accommodation = accommodation;
        this.responsible = responsible;
        this.participants = participants;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "SolicitudData{" +
                "title='" + title + '\'' +
                ", professor='" + professor + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}