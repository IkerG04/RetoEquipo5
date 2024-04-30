/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.cargadatos;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CargaDatos extends JFrame {

    public CargaDatos() {
        super("Carga de Datos desde Archivo CSV");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton cargarCSVButton = new JButton("Cargar Archivo CSV");
        mainPanel.add(cargarCSVButton, BorderLayout.CENTER);

        cargarCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Seleccionar Archivo CSV");
                fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv"));

                int returnValue = fileChooser.showOpenDialog(CargaDatos.this);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        cargarProfesoresDesdeCSV(selectedFile);
                        mostrarMensajeExito("Profesores cargados exitosamente desde el archivo CSV.");
                    } catch (IOException | SQLException ex) {
                        mostrarMensajeError("Error al cargar el archivo CSV: " + ex.getMessage());
                    }
                }
            }
        });

        getContentPane().add(mainPanel);
    }

    private void cargarProfesoresDesdeCSV(File file) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        AccesoBaseDatos db = AccesoBaseDatos.getInstance();
        Connection conn = db.getConn();

        String insertQuery = "INSERT INTO profesor (dni, correo, nombre, apellidos, activo, perfil, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertQuery);

        while ((line = reader.readLine()) != null) {
            String[] datos = line.split(",");

            if (datos.length >= 7) {
                String dni = datos[0].trim();
                String correo = datos[1].trim();
                String nombre = datos[2].trim();
                String apellidos = datos[3].trim();
                boolean activo = Boolean.parseBoolean(datos[4].trim());
                String perfil = datos[5].trim();
                String contraseña = datos[6].trim();

                pstmt.setString(1, dni);
                pstmt.setString(2, correo);
                pstmt.setString(3, nombre);
                pstmt.setString(4, apellidos);
                pstmt.setBoolean(5, activo);
                pstmt.setString(6, perfil);
                pstmt.setString(7, contraseña);

                pstmt.executeUpdate();
            }
        }

        reader.close();
        pstmt.close();
        db.cerrar();
    }

    private void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
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
                new CargaDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
