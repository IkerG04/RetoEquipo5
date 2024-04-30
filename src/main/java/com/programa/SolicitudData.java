/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programa;

/**
 *
 * @author DAW129
 */
public class SolicitudData {

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

    public SolicitudData(String professor, String department, String title, String planningDidactic, String transport,
            String startDate, String endDate, String group, int numStudents, boolean accommodation,
            String responsible, String participants, String comments) {
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

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlanningDidactic() {
        return planningDidactic;
    }

    public void setPlanningDidactic(String planningDidactic) {
        this.planningDidactic = planningDidactic;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public boolean isAccommodation() {
        return accommodation;
    }

    public void setAccommodation(boolean accommodation) {
        this.accommodation = accommodation;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "SolicitudData{"
                + "professor='" + professor + '\''
                + ", department='" + department + '\''
                + ", title='" + title + '\''
                + ", planningDidactic='" + planningDidactic + '\''
                + ", transport='" + transport + '\''
                + ", startDate='" + startDate + '\''
                + ", endDate='" + endDate + '\''
                + ", group='" + group + '\''
                + ", numStudents=" + numStudents
                + ", accommodation=" + accommodation
                + ", responsible='" + responsible + '\''
                + ", participants='" + participants + '\''
                + ", comments='" + comments + '\''
                + '}';
    }
}
