/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.solicitud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAW129
 */
public class Solicitud extends JFrame {

    private List<SolicitudData> solicitudes = new ArrayList<>(); // Lista para almacenar las solicitudes
    
    private Connection connection;

    public Solicitud() {
        super("Solicitudes");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Centrar en pantalla

        JPanel mainPanel = new JPanel(new BorderLayout());

        JButton createRequestButton = new JButton("Crear Solicitud");
        JButton viewRequestsButton = new JButton("Ver Solicitudes");

        createRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCreateRequestForm();
            }
        });

        viewRequestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRequestsList();
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(createRequestButton);
        buttonPanel.add(viewRequestsButton);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        getContentPane().add(mainPanel);
    }

    private void showCreateRequestForm() {
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));

        // Campos de solicitud
        JTextField medioTransporteField = new JTextField(20);
        JTextField departamentoField = new JTextField(20);
        JTextField comentariosField = new JTextField(20);
        JTextField alojamientoField = new JTextField(20);
        JTextField numeroAlumnosField = new JTextField(20);
        JTextField estadoField = new JTextField(20);
        JTextField grupoCursoField = new JTextField(20);
        JTextField fechaInicioField = new JTextField(20);
        JTextField fechaFinField = new JTextField(20);
        JTextField previstaField = new JTextField(20);
        JTextField tituloField = new JTextField(20);

        inputPanel.add(new JLabel("Medio de Transporte:"));
        inputPanel.add(medioTransporteField);
        inputPanel.add(new JLabel("Departamento:"));
        inputPanel.add(departamentoField);
        inputPanel.add(new JLabel("Comentarios Adicionales:"));
        inputPanel.add(comentariosField);
        inputPanel.add(new JLabel("Alojamiento:"));
        inputPanel.add(alojamientoField);
        inputPanel.add(new JLabel("Número de Alumnos:"));
        inputPanel.add(numeroAlumnosField);
        inputPanel.add(new JLabel("Estado:"));
        inputPanel.add(estadoField);
        inputPanel.add(new JLabel("Grupo/Curso:"));
        inputPanel.add(grupoCursoField);
        inputPanel.add(new JLabel("Fecha Inicio Actividad (YYYY-MM-DD):"));
        inputPanel.add(fechaInicioField);
        inputPanel.add(new JLabel("Fecha Fin Actividad (YYYY-MM-DD):"));
        inputPanel.add(fechaFinField);
        inputPanel.add(new JLabel("Actividad Prevista (0 = No, 1 = Sí):"));
        inputPanel.add(previstaField);
        inputPanel.add(new JLabel("Título:"));
        inputPanel.add(tituloField);

        int option = JOptionPane.showConfirmDialog(this, inputPanel, "Crear Nueva Solicitud", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            // Obtener valores de los campos
            try {
                int medioTransporte = Integer.parseInt(medioTransporteField.getText());
                int departamento = Integer.parseInt(departamentoField.getText());
                String comentarios = comentariosField.getText();
                int alojamiento = Integer.parseInt(alojamientoField.getText());
                int numeroAlumnos = Integer.parseInt(numeroAlumnosField.getText());
                String estado = estadoField.getText();
                Integer grupoCurso = grupoCursoField.getText().isEmpty() ? null : Integer.parseInt(grupoCursoField.getText());
                String fechaInicio = fechaInicioField.getText();
                String fechaFin = fechaFinField.getText();
                int prevista = Integer.parseInt(previstaField.getText());
                String titulo = tituloField.getText();

                // Insertar la nueva solicitud en la base de datos
                insertarSolicitud(medioTransporte, departamento, comentarios, alojamiento, numeroAlumnos, estado,
                        grupoCurso, fechaInicio, fechaFin, prevista, titulo);

                JOptionPane.showMessageDialog(this, "Solicitud creada exitosamente.", "Solicitud Creada", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error: Ingrese números válidos en los campos numéricos.",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void insertarSolicitud(int medioTransporte, int departamento, String comentarios, int alojamiento,
                                    int numeroAlumnos, String estado, Integer grupoCurso, String fechaInicio,
                                    String fechaFin, int prevista, String titulo) {
        try {
            String sql = "INSERT INTO solicitud " +
                         "(mediotransporte, departamento, comentariosadicionales, alojamiento, " +
                         "numeroalumnos, estado, grupocurso, fechainicioactividad, fechafinactividad, " +
                         "prevista, titulo) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, medioTransporte);
            statement.setInt(2, departamento);
            statement.setString(3, comentarios);
            statement.setInt(4, alojamiento);
            statement.setInt(5, numeroAlumnos);
            statement.setString(6, estado);
            if (grupoCurso == null) {
                statement.setObject(7, null);
            } else {
                statement.setInt(7, grupoCurso);
            }
            statement.setString(8, fechaInicio);
            statement.setString(9, fechaFin);
            statement.setInt(10, prevista);
            statement.setString(11, titulo);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al insertar la solicitud en la base de datos: " + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showRequestsList() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT id, titulo, estado FROM solicitud";
            ResultSet resultSet = statement.executeQuery(query);

            DefaultListModel<String> listModel = new DefaultListModel<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String estado = resultSet.getString("estado");
                listModel.addElement("ID: " + id + " - Título: " + titulo + " - Estado: " + estado);
            }

            JList<String> requestsList = new JList<>(listModel);

            JScrollPane scrollPane = new JScrollPane(requestsList);
            JPanel listPanel = new JPanel(new BorderLayout());
            listPanel.add(scrollPane, BorderLayout.CENTER);

            JButton acceptButton = new JButton("Aceptar Solicitud");
            JButton denyButton = new JButton("Denegar Solicitud");

            acceptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = requestsList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        int requestId = Integer.parseInt(listModel.getElementAt(selectedIndex).split(" ")[1]);
                        updateRequestStatus(requestId, "Aceptada");
                        listModel.remove(selectedIndex);
                    }
                }
            });

            denyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = requestsList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        int requestId = Integer.parseInt(listModel.getElementAt(selectedIndex).split(" ")[1]);
                        updateRequestStatus(requestId, "Denegada");
                        listModel.remove(selectedIndex);
                    }
                }
            });

            JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
            buttonsPanel.add(acceptButton);
            buttonsPanel.add(denyButton);

            listPanel.add(buttonsPanel, BorderLayout.SOUTH);

            JOptionPane.showMessageDialog(this, listPanel, "Lista de Solicitudes", JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al recuperar la lista de solicitudes: " + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateRequestStatus(int requestId, String newStatus) {
        try {
            String sql = "UPDATE solicitud SET estado = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newStatus);
            statement.setInt(2, requestId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el estado de la solicitud: " + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
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
