/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.programa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAW129
 */
public class Solicitud extends JFrame {

    private List<SolicitudData> solicitudes = new ArrayList<>(); // Lista para almacenar las solicitudes

    public Solicitud() {
        super("Mantenimiento de Solicitudes");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar en pantalla

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Crear botones para las opciones de mantenimiento
        JButton professorsButton = new JButton("Profesores");
        JButton coursesButton = new JButton("Cursos");
        JButton groupsButton = new JButton("Grupos");
        JButton departmentsButton = new JButton("Departamentos");
        JButton createRequestButton = new JButton("Crear Solicitud");

        // Agregar los botones al panel principal
        mainPanel.add(professorsButton, BorderLayout.NORTH);
        mainPanel.add(coursesButton, BorderLayout.CENTER);
        mainPanel.add(groupsButton, BorderLayout.WEST);
        mainPanel.add(departmentsButton, BorderLayout.EAST);
        mainPanel.add(createRequestButton, BorderLayout.SOUTH);

        // Manejar eventos de botones
        professorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showActionSelectionDialog("Profesores");
            }
        });

        coursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showActionSelectionDialog("Cursos");
            }
        });

        groupsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showActionSelectionDialog("Grupos");
            }
        });

        departmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showActionSelectionDialog("Departamentos");
            }
        });

        createRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCreateRequestForm();
            }
        });

        getContentPane().add(mainPanel);
    }

    private void showActionSelectionDialog(String entityType) {
        String[] options = {"Editar", "Eliminar"};
        int choice = JOptionPane.showOptionDialog(this,
                "¿Qué acción deseas realizar para " + entityType + "?",
                "Selección de Acción",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            // Editar
            showMaintenanceDialog(entityType, "Editar");
        } else if (choice == 1) {
            // Eliminar
            int confirmOption = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de eliminar la información de " + entityType + "?",
                    "Confirmación de Eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirmOption == JOptionPane.YES_OPTION) {
                // Aquí iría la lógica para eliminar la información (simulada)
                JOptionPane.showMessageDialog(this,
                        "Información de " + entityType + " eliminada exitosamente.",
                        "Eliminación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Operación de eliminación cancelada.",
                        "Operación Cancelada",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void showMaintenanceDialog(String entityType, String action) {
        // Aquí se implementaría la lógica para editar la información (pendiente de desarrollo)
        JOptionPane.showMessageDialog(this,
                "Lógica para editar " + entityType + " pendiente de desarrollo.",
                "Editar " + entityType,
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showCreateRequestForm() {
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));

        // Campos de solicitud
        JTextField professorField = new JTextField(20);
        JTextField departmentField = new JTextField(20);
        JTextField titleField = new JTextField(20);
        JComboBox<String> planningComboBox = new JComboBox<>(new String[]{"Sí", "No"});
        JComboBox<String> transportComboBox = new JComboBox<>(new String[]{"Andando", "Bici", "Bus", "Taxi", "Barco", "Tren", "Avión"});
        JTextField startDateField = new JTextField(20);
        JTextField endDateField = new JTextField(20);
        JComboBox<String> groupField = new JComboBox<>(new String[]{"Grupo A", "Grupo B", "Grupo C"});
        JTextField numStudentsField = new JTextField(20);
        JCheckBox accommodationCheckBox = new JCheckBox("Alojamiento");
        JTextField responsibleField = new JTextField(20);
        JTextField participantsField = new JTextField(20);
        JTextArea commentsArea = new JTextArea(4, 20);

        inputPanel.add(new JLabel("Profesor que hace la solicitud:"));
        inputPanel.add(professorField);
        inputPanel.add(new JLabel("Departamento:"));
        inputPanel.add(departmentField);
        inputPanel.add(new JLabel("Título de la actividad:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("¿Actividad prevista en la programación didáctica?"));
        inputPanel.add(planningComboBox);
        inputPanel.add(new JLabel("Medio de transporte:"));
        inputPanel.add(transportComboBox);
        inputPanel.add(new JLabel("Fecha y hora de inicio:"));
        inputPanel.add(startDateField);
        inputPanel.add(new JLabel("Fecha y hora de fin:"));
        inputPanel.add(endDateField);
        inputPanel.add(new JLabel("Grupo o cursos:"));
        inputPanel.add(groupField);
        inputPanel.add(new JLabel("Número de alumnos:"));
        inputPanel.add(numStudentsField);
        inputPanel.add(new JLabel("¿Alojamiento?"));
        inputPanel.add(accommodationCheckBox);
        inputPanel.add(new JLabel("Profesores responsables:"));
        inputPanel.add(responsibleField);
        inputPanel.add(new JLabel("Profesores participantes:"));
        inputPanel.add(participantsField);
        inputPanel.add(new JLabel("Comentarios adicionales:"));
        inputPanel.add(new JScrollPane(commentsArea));

        int option = JOptionPane.showConfirmDialog(this,
                inputPanel,
                "Crear Nueva Solicitud",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            // Obtener valores de los campos
            String professor = professorField.getText();
            String department = departmentField.getText();
            String title = titleField.getText();
            String planningDidactic = (String) planningComboBox.getSelectedItem();
            String transport = (String) transportComboBox.getSelectedItem();
            String startDate = startDateField.getText();
            String endDate = endDateField.getText();
            String group = (String) groupField.getSelectedItem();
            int numStudents = Integer.parseInt(numStudentsField.getText());
            boolean accommodation = accommodationCheckBox.isSelected();
            String responsible = responsibleField.getText();
            String participants = participantsField.getText();
            String comments = commentsArea.getText();

            // Crear nueva solicitud
            SolicitudData solicitud = new SolicitudData(professor, department, title, planningDidactic, transport, startDate, endDate,
                    group, numStudents, accommodation, responsible, participants, comments);

            solicitudes.add(solicitud); // Agregar solicitud a la lista

            JOptionPane.showMessageDialog(this,
                    "Solicitud creada exitosamente.",
                    "Solicitud Creada",
                    JOptionPane.INFORMATION_MESSAGE);
        }
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Solicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
