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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CargaDatos extends JFrame {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gestoractividadesextraescolares";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";

    private final Random random = new Random();

    public CargaDatos() {
        super("Carga de Datos desde Archivos CSV");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton cargarCSVButton = new JButton("Cargar Archivos CSV");
        mainPanel.add(cargarCSVButton, BorderLayout.CENTER);

        cargarCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Seleccionar Archivos CSV");
                fileChooser.setMultiSelectionEnabled(true);
                fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv"));

                int returnValue = fileChooser.showOpenDialog(CargaDatos.this);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File[] selectedFiles = fileChooser.getSelectedFiles();
                    try {
                        cargarDatosDesdeArchivos(selectedFiles);
                        mostrarMensajeExito("Datos cargados exitosamente desde los archivos CSV.");
                    } catch (IOException | SQLException ex) {
                        mostrarMensajeError("Error al cargar los archivos CSV: " + ex.getMessage());
                    }
                }
            }
        });

        getContentPane().add(mainPanel);
    }

    private void cargarDatosDesdeArchivos(File[] files) throws IOException, SQLException {
        Map<String, Integer> departamentoIdMap = new HashMap<>();
        Map<String, Integer> cursoIdMap = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            for (File file : files) {
                String tableName = file.getName().toLowerCase();
                switch (tableName) {
                    case "profesores.csv":
                        cargarProfesoresDesdeCSV(file, conn, departamentoIdMap);
                        break;
                    case "departamentos.csv":
                        cargarDepartamentosDesdeCSV(file, conn, departamentoIdMap);
                        break;
                    case "cursos.csv":
                        cargarCursosDesdeCSV(file, conn, cursoIdMap);
                        break;
                    case "grupos.csv":
                        cargarGruposDesdeCSV(file, conn, cursoIdMap);
                        break;
                    default:
                        System.out.println("Archivo CSV no reconocido: " + tableName);
                        break;
                }
            }
        }
    }

    private void cargarProfesoresDesdeCSV(File file, Connection conn, Map<String, Integer> departamentoIdMap)
            throws IOException, SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine(); // Omitir la primera línea (encabezados)

            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO profesor (nombre, apellidos, dni, correo, departamento_id, password, activo, perfil) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                String apellidosNombre = datos[0].trim();
                String dni = datos[1].trim();
                String correo = datos[2].trim();
                String departamento = datos[3].trim();

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
            }

            pstmt.close();
        }
    }

    private int obtenerOInsertarDepartamentoId(String departamento, Connection conn, Map<String, Integer> departamentoIdMap)
            throws SQLException {
        if (departamentoIdMap.containsKey(departamento)) {
            return departamentoIdMap.get(departamento);
        } else {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO departamento (nombre) VALUES (?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, departamento);
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
    }

    private String extraerNombre(String apellidosNombre) {
        return apellidosNombre.split("\\s+")[1];
    }

    private String extraerApellidos(String apellidosNombre) {
        return apellidosNombre.split("\\s+")[0];
    }

    private String generarPassword() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }

    private String obtenerPerfilAleatorio() {
        String[] perfiles = {"SuperUsuario", "Administrador", "EquipoAdministrativo", "Profesor"};
        return perfiles[random.nextInt(perfiles.length)];
    }

    private void cargarDepartamentosDesdeCSV(File file, Connection conn, Map<String, Integer> departamentoIdMap)
        throws IOException, SQLException {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        reader.readLine(); // Omitir la primera línea (encabezados)

        PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO departamento (id, cod, nombre) VALUES (?, ?, ?)");

        while ((line = reader.readLine()) != null) {
            String[] datos = line.split(",");
            
            if (datos.length < 3) {
                // Verificar que haya suficientes datos en la línea
                continue; // O saltar esta línea si no hay suficientes datos
            }

            // Validar y convertir los datos a enteros
            int id;
            try {
                id = Integer.parseInt(datos[0].trim());
            } catch (NumberFormatException e) {
                // Manejar el caso donde no se puede convertir a entero
                System.err.println("Error al convertir el ID a entero: " + e.getMessage());
                continue; // Otra opción: detener el procesamiento de esta línea
            }
            
            String cod = datos[1].trim();
            String nombre = datos[2].trim();

            // Insertar en la base de datos
            pstmt.setInt(1, id);
            pstmt.setString(2, cod);
            pstmt.setString(3, nombre);
           
            pstmt.executeUpdate();
        }

        pstmt.close();
    }
}

    private void cargarCursosDesdeCSV(File file, Connection conn, Map<String, Integer> cursoIdMap)
            throws IOException, SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine(); // Omitir la primera línea (encabezados)

            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO curso (codcurso, descurso, etapa, activo) VALUES (?, ?, ?, ?)");

            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                String codcurso = datos[1].trim();
                String descurso = datos[2].trim();
                String etapa = datos[3].trim();
                int activo = Integer.parseInt(datos[4].trim());

                // Insertar en la base de datos
                pstmt.setString(1, codcurso);
                pstmt.setString(2, descurso);
                pstmt.setString(3, etapa);
                pstmt.setInt(4, activo);
                pstmt.executeUpdate();
            }

            pstmt.close();
        }
    }

    private void cargarGruposDesdeCSV(File file, Connection conn, Map<String, Integer> cursoIdMap)
            throws IOException, SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine(); // Omitir la primera línea (encabezados)

            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO grupos (codigogrupo, curso, numeroalumnos, activo) VALUES (?, ?, ?, 1)"); // Establecer activo como 1

            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                String codgrupo = datos[1].trim();
                int idcurso = Integer.parseInt(datos[2].trim());
                int alumnos = Integer.parseInt(datos[3].trim());

                // Insertar en la base de datos
                pstmt.setString(1, codgrupo);
                pstmt.setInt(2, idcurso);
                pstmt.setInt(3, alumnos);
                pstmt.executeUpdate();
            }

            pstmt.close();
        }
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
                try {
                    // Registrar el controlador JDBC
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    new CargaDatos().setVisible(true);
                } catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Error: No se pudo cargar el controlador JDBC.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
