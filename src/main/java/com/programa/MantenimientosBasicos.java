/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.programa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DAW129
 */
public class MantenimientosBasicos extends JFrame {

    public MantenimientosBasicos() {
        super("Mantenimiento Básico");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JButton professorsButton = new JButton("Profesores");
        JButton coursesButton = new JButton("Cursos");
        JButton groupsButton = new JButton("Grupos");
        JButton departmentsButton = new JButton("Departamentos");

        mainPanel.add(professorsButton, BorderLayout.NORTH);
        mainPanel.add(coursesButton, BorderLayout.CENTER);
        mainPanel.add(groupsButton, BorderLayout.WEST);
        mainPanel.add(departmentsButton, BorderLayout.EAST);

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
            showMaintenanceDialog(entityType, "Editar");
        } else if (choice == 1) {
            int confirmOption = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de eliminar la información de " + entityType + "?",
                    "Confirmación de Eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirmOption == JOptionPane.YES_OPTION) {
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
        String[] currentData = fetchCurrentData(entityType);

        if (currentData == null) {
            JOptionPane.showMessageDialog(this,
                    "No se encontraron datos de " + entityType + ".",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        JPanel inputPanel = new JPanel(new GridLayout(currentData.length, 2));

        JTextField[] textFields = new JTextField[currentData.length];
        for (int i = 0; i < currentData.length; i++) {
            inputPanel.add(new JLabel(entityType + " " + (i + 1) + ":"));
            textFields[i] = new JTextField(currentData[i]);
            inputPanel.add(textFields[i]);
        }

        int option = JOptionPane.showConfirmDialog(this,
                inputPanel,
                action + " " + entityType,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String[] newData = new String[currentData.length];
            for (int i = 0; i < textFields.length; i++) {
                newData[i] = textFields[i].getText();
            }

            boolean changesSaved = saveChanges(entityType, newData);

            if (changesSaved) {
                JOptionPane.showMessageDialog(this,
                        "Cambios guardados exitosamente.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error al guardar los cambios. Inténtalo de nuevo.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String[] fetchCurrentData(String entityType) {
        if (entityType.equals("Profesores")) {
            return new String[]{"Juan Pérez", "María Gómez", "Carlos Ruiz"};
        } else if (entityType.equals("Cursos")) {
            return new String[]{"Matemáticas", "Historia", "Inglés"};
        } else if (entityType.equals("Grupos")) {
            return new String[]{"Grupo A", "Grupo B", "Grupo C"};
        } else if (entityType.equals("Departamentos")) {
            return new String[]{"Informática", "Matemáticas", "Ciencias Sociales"};
        }
        return null;
    }

    private boolean saveChanges(String entityType, String[] newData) {
        System.out.println("Guardando cambios para " + entityType + ": " + String.join(", ", newData));
        return true; // Simulación de éxito
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
