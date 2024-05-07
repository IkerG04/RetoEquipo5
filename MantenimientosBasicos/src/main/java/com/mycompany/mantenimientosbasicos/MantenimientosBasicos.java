/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.mantenimientosbasicos;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

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
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        JButton editProfessorsButton = new JButton("Editar Todos los Profesores");

        editProfessorsButton.addActionListener(e -> editAllProfessors());

        mainPanel.add(editProfessorsButton);
        add(mainPanel);

        setVisible(true);
    }

    private void editAllProfessors() {
        try {
            String query = "SELECT * FROM profesor";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int professorId = rs.getInt("id");
                String professorName = rs.getString("nombre");
                String professorApellidos = rs.getString("apellidos");
                String professorDNI = rs.getString("dni");
                String professorCorreo = rs.getString("correo");
                int professorActivo = rs.getInt("activo");
                String professorPerfil = rs.getString("perfil");
                String professorContraseña = rs.getString("contraseña");
                int professorDepartamento = rs.getInt("departamento");

                JPanel inputPanel = new JPanel(new GridLayout(0, 2));
                inputPanel.add(new JLabel("Nombre:"));
                JTextField nameField = new JTextField(professorName);
                inputPanel.add(nameField);
                inputPanel.add(new JLabel("Apellidos:"));
                JTextField apellidosField = new JTextField(professorApellidos);
                inputPanel.add(apellidosField);
                inputPanel.add(new JLabel("DNI:"));
                JTextField dniField = new JTextField(professorDNI);
                inputPanel.add(dniField);
                inputPanel.add(new JLabel("Correo:"));
                JTextField correoField = new JTextField(professorCorreo);
                inputPanel.add(correoField);
                inputPanel.add(new JLabel("Activo (1 = Sí, 0 = No):"));
                JTextField activoField = new JTextField(String.valueOf(professorActivo));
                inputPanel.add(activoField);
                inputPanel.add(new JLabel("Perfil:"));
                JTextField perfilField = new JTextField(professorPerfil);
                inputPanel.add(perfilField);
                inputPanel.add(new JLabel("Contraseña:"));
                JTextField contraseñaField = new JTextField(professorContraseña);
                inputPanel.add(contraseñaField);
                inputPanel.add(new JLabel("Departamento:"));
                JTextField departamentoField = new JTextField(String.valueOf(professorDepartamento));
                inputPanel.add(departamentoField);

                int option = JOptionPane.showConfirmDialog(this,
                        inputPanel,
                        "Editar Profesor: " + professorName + " " + professorApellidos,
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);

                if (option == JOptionPane.OK_OPTION) {
                    String updateQuery = "UPDATE profesor SET nombre = ?, apellidos = ?, dni = ?, correo = ?, "
                            + "activo = ?, perfil = ?, contraseña = ?, departamento = ? WHERE id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                    updateStmt.setString(1, nameField.getText());
                    updateStmt.setString(2, apellidosField.getText());
                    updateStmt.setString(3, dniField.getText());
                    updateStmt.setString(4, correoField.getText());
                    updateStmt.setInt(5, Integer.parseInt(activoField.getText()));
                    updateStmt.setString(6, perfilField.getText());
                    updateStmt.setString(7, contraseñaField.getText());
                    updateStmt.setInt(8, Integer.parseInt(departamentoField.getText()));
                    updateStmt.setInt(9, professorId);

                    updateStmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Profesor actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    updateStmt.close();
                }
            }

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al editar los profesores.", "Error", JOptionPane.ERROR_MESSAGE);
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
