/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.mantenimientosbasicos;
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
        setLocationRelativeTo(null); // Centrar en pantalla

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Crear botones para las opciones de mantenimiento
        JButton professorsButton = new JButton("Profesores");
        JButton coursesButton = new JButton("Cursos");
        JButton groupsButton = new JButton("Grupos");
        JButton departmentsButton = new JButton("Departamentos");

        // Agregar los botones al panel principal
        mainPanel.add(professorsButton, BorderLayout.NORTH);
        mainPanel.add(coursesButton, BorderLayout.CENTER);
        mainPanel.add(groupsButton, BorderLayout.WEST);
        mainPanel.add(departmentsButton, BorderLayout.EAST);

        // Manejar eventos de botones
        professorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMaintenanceDialog("Profesores");
            }
        });

        coursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMaintenanceDialog("Cursos");
            }
        });

        groupsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMaintenanceDialog("Grupos");
            }
        });

        departmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMaintenanceDialog("Departamentos");
            }
        });

        getContentPane().add(mainPanel);
    }

    private void showMaintenanceDialog(String entityType) {
        int option = JOptionPane.showConfirmDialog(this,
                "¿Deseas eliminar la información de " + entityType + "?",
                "Confirmación de Eliminación",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
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
                new MantenimientosBasicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
