/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.mantenimientosbasicos;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAW129
 */
public class MantenimientosBasicos extends JFrame {

    private Connection conn;

    public MantenimientosBasicos() {
        super("Mantenimiento Básico");

        // Establecer conexión a la base de datos
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestoractividadesextraescolares", "root", "mysql");
            System.out.println("Conexión establecida a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JButton professorsButton = new JButton("Profesores");
        JButton coursesButton = new JButton("Cursos");
        JButton groupsButton = new JButton("Grupos");
        JButton departmentsButton = new JButton("Departamento");

        mainPanel.add(professorsButton, BorderLayout.NORTH);
        mainPanel.add(coursesButton, BorderLayout.CENTER);
        mainPanel.add(groupsButton, BorderLayout.WEST);
        mainPanel.add(departmentsButton, BorderLayout.EAST);

        professorsButton.addActionListener(e -> showActionSelectionDialog("profesor"));
        coursesButton.addActionListener(e -> showActionSelectionDialog("curso"));
        groupsButton.addActionListener(e -> showActionSelectionDialog("grupos"));
        departmentsButton.addActionListener(e -> showActionSelectionDialog("departamento"));

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
                boolean deletionSuccess = deleteData(entityType);
                if (deletionSuccess) {
                    JOptionPane.showMessageDialog(this,
                            "Información de " + entityType + " eliminada exitosamente.",
                            "Eliminación Exitosa",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Error al eliminar la información de " + entityType + ".",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
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

        JPanel inputPanel = new JPanel(new GridLayout(currentData.length / 3, 3)); // 3 columnas para ID, Código y Nombre

        JTextField[] textFields = new JTextField[currentData.length];
        for (int i = 0; i < currentData.length; i += 3) { // Incremento de a 3 (ID, Código, Nombre)
            inputPanel.add(new JLabel("ID:"));
            textFields[i] = new JTextField(currentData[i]);
            inputPanel.add(textFields[i]);

            inputPanel.add(new JLabel("Código:"));
            textFields[i + 1] = new JTextField(currentData[i + 1]);
            inputPanel.add(textFields[i + 1]);

            inputPanel.add(new JLabel("Nombre:"));
            textFields[i + 2] = new JTextField(currentData[i + 2]);
            inputPanel.add(textFields[i + 2]);
        }

        int option = JOptionPane.showConfirmDialog(this,
                inputPanel,
                action + " " + entityType,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String[] newData = new String[currentData.length];
            for (int i = 0; i < currentData.length; i++) {
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
        try {
            String query = "SELECT id, cod, nombre FROM " + entityType;
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            StringBuilder dataList = new StringBuilder();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    dataList.append(rs.getString(i)).append(",");
                }
            }

            stmt.close();
            return dataList.toString().split(",");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener datos de la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private boolean saveChanges(String entityType, String[] newData) {
        try {
            String updateQuery = "UPDATE " + entityType + " SET cod = ?, nombre = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);

            for (int i = 0; i < newData.length; i += 3) {
                stmt.setString(1, newData[i + 1]); // Código
                stmt.setString(2, newData[i + 2]); // Nombre
                stmt.setInt(3, Integer.parseInt(newData[i])); // ID

                stmt.executeUpdate();
            }

            stmt.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar cambios en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean deleteData(String entityType) {
        try {
            String deleteQuery = "DELETE FROM " + entityType + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(deleteQuery);

            String input = JOptionPane.showInputDialog(this, "Ingrese el ID de " + entityType + " a eliminar:");
            int idToDelete = Integer.parseInt(input); // Convertir la entrada a entero

            stmt.setInt(1, idToDelete);
            int rowsAffected = stmt.executeUpdate();

            stmt.close();
            return rowsAffected > 0;

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar datos en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
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