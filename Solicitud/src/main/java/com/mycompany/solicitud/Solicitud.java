/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.solicitud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DAW129
 */
public class Solicitud extends JFrame {

    private JComboBox<String> departmentComboBox;
    private JComboBox<String> courseComboBox;
    private JComboBox<String> groupComboBox;
    private JTextField numStudentsField;

    public Solicitud() {
        super("Sistema de Gestión Educativa");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        JPanel createRequestPanel = new JPanel(new GridLayout(10, 2));

        createRequestPanel.add(new JLabel("Departamento:"));
        String[] departmentOptions = {"Informática", "Matemáticas", "Ciencias Sociales"};
        departmentComboBox = new JComboBox<>(departmentOptions);
        createRequestPanel.add(departmentComboBox);

        createRequestPanel.add(new JLabel("Curso:"));
        courseComboBox = new JComboBox<>();
        createRequestPanel.add(courseComboBox);

        createRequestPanel.add(new JLabel("Grupo:"));
        groupComboBox = new JComboBox<>();
        createRequestPanel.add(groupComboBox);

        createRequestPanel.add(new JLabel("Número de Alumnos:"));
        numStudentsField = new JTextField();
        createRequestPanel.add(numStudentsField);

        JButton createRequestButton = new JButton("Crear Solicitud");
        createRequestPanel.add(new JLabel()); 
        createRequestPanel.add(createRequestButton);

        departmentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDepartment = (String) departmentComboBox.getSelectedItem();
                loadCourses(selectedDepartment);
            }
        });

        createRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String department = (String) departmentComboBox.getSelectedItem();
                String course = (String) courseComboBox.getSelectedItem();
                String group = (String) groupComboBox.getSelectedItem();
                int numStudents = Integer.parseInt(numStudentsField.getText());

                boolean requestCreated = processCreateRequest(department, course, group, numStudents);

                if (requestCreated) {
                    JOptionPane.showMessageDialog(createRequestPanel,
                            "Solicitud creada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(createRequestPanel,
                            "Error al crear la solicitud. Inténtalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getContentPane().add(createRequestPanel);
    }

    private void loadCourses(String department) {
        if (department.equals("Informática")) {
            String[] courses = {"1º Informática", "2º Informática"};
            courseComboBox.setModel(new DefaultComboBoxModel<>(courses));
        } else if (department.equals("Matemáticas")) {
            String[] courses = {"1º Matemáticas", "2º Matemáticas", "3º Matemáticas"};
            courseComboBox.setModel(new DefaultComboBoxModel<>(courses));
        } else if (department.equals("Ciencias Sociales")) {
            String[] courses = {"1º Sociales", "2º Sociales", "3º Sociales"};
            courseComboBox.setModel(new DefaultComboBoxModel<>(courses));
        }
        groupComboBox.removeAllItems();
    }

    private boolean processCreateRequest(String department, String course, String group, int numStudents) {
        System.out.println("Procesando solicitud para: " + department + ", " + course + " - " + group + ", Alumnos: " + numStudents);

        try {
            Thread.sleep(2000); 
            System.out.println("Solicitud guardada exitosamente.");
            return true;
        } catch (InterruptedException ex) {
            System.out.println("Error al procesar la solicitud: " + ex.getMessage());
            return false;
        }
    }

    private void clearFields() {
        courseComboBox.setSelectedIndex(0);
        numStudentsField.setText("");
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
