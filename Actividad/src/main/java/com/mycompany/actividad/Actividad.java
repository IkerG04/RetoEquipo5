/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.actividad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author DAW129
 */
public class Actividad extends JFrame {

    private JTextField tituloField, transporteField, inicioField, finField, grupoField, alumnosField, comentariosField;
    private JCheckBox programacionCheck, alojamientoCheck;
    private JButton guardarButton, modificarButton;

    private ActividadData actividadData;

    public Actividad(ActividadData actividadData) {
        this.actividadData = actividadData;
        initComponents();
        displayActividad();
    }

    private void iniciarComponentes() {
        setTitle("Gestión de Actividad");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        panel.add(new JLabel("Título de la Actividad:"));
        tituloField = new JTextField();
        panel.add(tituloField);

        panel.add(new JLabel("Empresa de Transporte:"));
        transporteField = new JTextField();
        panel.add(transporteField);

        panel.add(new JLabel("Fecha y Hora de Inicio (yyyy-MM-dd HH:mm):"));
        inicioField = new JTextField();
        panel.add(inicioField);

        panel.add(new JLabel("Fecha y Hora de Fin (yyyy-MM-dd HH:mm):"));
        finField = new JTextField();
        panel.add(finField);

        panel.add(new JLabel("Grupo/Curso:"));
        grupoField = new JTextField();
        panel.add(grupoField);

        panel.add(new JLabel("Número de Alumnos:"));
        alumnosField = new JTextField();
        panel.add(alumnosField);

        panel.add(new JLabel("¿En Programación Didáctica? (sí/no):"));
        programacionCheck = new JCheckBox();
        panel.add(programacionCheck);

        panel.add(new JLabel("¿Alojamiento? (sí/no):"));
        alojamientoCheck = new JCheckBox();
        panel.add(alojamientoCheck);

        panel.add(new JLabel("Comentarios Adicionales:"));
        comentariosField = new JTextField();
        panel.add(comentariosField);

        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarActividad();
            }
        });
        panel.add(guardarButton);

        modificarButton = new JButton("Modificar");
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarActividad();
            }
        });
        panel.add(modificarButton);

        add(panel);
    }

    private void displayActividad() {
        tituloField.setText(actividadData.getTitulo());
        transporteField.setText(actividadData.getTransporte());
        inicioField.setText(actividadData.getInicio().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        finField.setText(actividadData.getFin().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        grupoField.setText(actividadData.getGrupo());
        alumnosField.setText(String.valueOf(actividadData.getNumAlumnos()));
        programacionCheck.setSelected(actividadData.isEnProgramacion());
        alojamientoCheck.setSelected(actividadData.isAlojamiento());
        comentariosField.setText(actividadData.getComentarios());
    }

    private void guardarActividad() {
        // Implementar lógica para guardar la actividad en la base de datos o sistema
        JOptionPane.showMessageDialog(this, "Actividad guardada correctamente.", "Guardar Actividad", JOptionPane.INFORMATION_MESSAGE);
    }

    private void modificarActividad() {
        // Implementar lógica para modificar la actividad
        // Ejemplo de validación si faltan menos de 5 días para la actividad
        LocalDate inicio = actividadData.getInicio();
        LocalDate actual = LocalDate.now();
        long diasRestantes = java.time.temporal.ChronoUnit.DAYS.between(actual, inicio);

        if (diasRestantes < 5) {
            JOptionPane.showMessageDialog(this, "Quedan menos de 5 días para el inicio de la actividad.", "Modificar Actividad", JOptionPane.WARNING_MESSAGE);
        }

        // Ejemplo de modificación de datos en la actividadData
        actividadData.setTitulo(tituloField.getText());
        actividadData.setTransporte(transporteField.getText());
        // Actualizar otros campos de actividadData según los campos de la interfaz
        JOptionPane.showMessageDialog(this, "Actividad modificada correctamente.", "Modificar Actividad", JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ejemplo de uso
        ActividadData actividadData = new ActividadData();
        // Inicializar o cargar datos de actividadData
        Actividad actividad = new Actividad(actividadData);
        actividad.setVisible(true);
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
