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
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CargaDatos extends JFrame {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gestoractividadesextraescolares";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";

    public CargaDatos() {
        super("Carga de Datos desde Archivo CSV");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton cargarCSVButton = new JButton("Cargar Archivo CSV de Profesores");
        mainPanel.add(cargarCSVButton, BorderLayout.CENTER);

        cargarCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Seleccionar Archivo CSV de Profesores");
                fileChooser.setMultiSelectionEnabled(false);
                fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo CSV de Profesores (*.csv)", "csv"));

                int returnValue = fileChooser.showOpenDialog(CargaDatos.this);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile.getName().equalsIgnoreCase("profesor.csv")) {
                        try {
                            cargarProfesoresDesdeCSV(selectedFile);
                            mostrarMensajeExito("Datos de profesores cargados exitosamente.");
                        } catch (IOException | SQLException ex) {
                            mostrarMensajeError("Error al cargar el archivo CSV de profesores: " + ex.getMessage());
                        }
                    } else {
                        mostrarMensajeError("Selecciona solo el archivo 'profesor.csv'.");
                    }
                }
            }
        });

        getContentPane().add(mainPanel);
    }

    private void cargarProfesoresDesdeCSV(File file) throws IOException, SQLException {
        Map<String, Integer> departamentoIdMap = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            reader.readLine(); // Omitir la primera línea (encabezados)

            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO profesor (nombre, apellidos, dni, correo, departamento, contraseña, activo, perfil) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                
                // Verificar que haya al menos 4 elementos en datos antes de acceder a ellos
                if (datos.length >= 4) {
                    String apellidosNombre = datos[0].trim();
                    String dni = datos[1].trim();
                    String correo = datos[2].trim();
                    String departamento = datos[3].trim();

                    // Limitar el campo dni a 9 caracteres máximo
                    dni = dni.substring(0, Math.min(dni.length(), 9));

                    // Obtener o insertar el ID del departamento
                    int departamentoId = obtenerOInsertarDepartamentoId(departamento, conn, departamentoIdMap);

                    // Generar contraseña aleatoria
                    String password = generarPassword();

                    // Perfil aleatorio
                    String perfil = obtenerPerfilAleatorio();

                    // Insertar en la base de datos
                    pstmt.setString(1, extraerNombre(apellidosNombre));
                    pstmt.setString(2, extraerApellidos(apellidosNombre));
                    pstmt.setString(3, dni);
                    pstmt.setString(4, correo);
                    pstmt.setInt(5, departamentoId);
                    pstmt.setString(6, password);
                    pstmt.setBoolean(7, true); // activo por defecto es true
                    pstmt.setString(8, perfil);
                    pstmt.executeUpdate();
                } else {
                    // Manejar el caso donde la línea no tiene suficientes campos
                    mostrarMensajeError("La línea del archivo CSV no tiene suficientes campos.");
                }
            }

            pstmt.close();
        }
    }

    private int obtenerOInsertarDepartamentoId(String departamento, Connection conn, Map<String, Integer> departamentoIdMap)
            throws SQLException {
        if (departamentoIdMap.containsKey(departamento)) {
            return departamentoIdMap.get(departamento);
        } else {
            // Generar un código aleatorio para el departamento
            String cod = generarCodigoAleatorio();

            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO departamento (cod, nombre) VALUES (?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, cod);
            pstmt.setString(2, departamento);
            pstmt.executeUpdate();

            int departamentoId;
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    departamentoId = generatedKeys.getInt(1);
                    departamentoIdMap.put(departamento, departamentoId);
                } else {
                    throw new SQLException("Error al obtener el ID del departamento.");
                }
            }

            pstmt.close();
            return departamentoId;
        }
    } //Temporal

    private String extraerNombre(String apellidosNombre) {
        return apellidosNombre.split("\\s+")[1];
    }

    private String extraerApellidos(String apellidosNombre) {
        return apellidosNombre.split("\\s+")[0];
    }

    private String generarPassword() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }

    private String obtenerPerfilAleatorio() {
        String[] perfiles = {"SuperUsuario", "Administrador", "EquipoAdministrativo", "Profesor"};
        return perfiles[(int) (perfiles.length * Math.random())];
    } //Temporal

    private void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private String generarCodigoAleatorio() {
        String caracteres = "1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }//Temporal
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
        SwingUtilities.invokeLater(() -> {
            try {
                // Registrar el controlador JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");
                new CargaDatos().setVisible(true);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo cargar el controlador JDBC.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
