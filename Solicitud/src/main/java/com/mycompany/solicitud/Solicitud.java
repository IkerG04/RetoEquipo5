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
        super("Mantenimiento de Solicitudes");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Centrar en pantalla

        JPanel mainPanel = new JPanel(new GridLayout(2, 1)); // Cambiamos el layout a GridLayout

        // Botones para crear solicitud y ver solicitudes
        JButton createRequestButton = new JButton("Crear Solicitud");
        JButton viewRequestsButton = new JButton("Ver Solicitudes");

        // Ajustamos el tamaño de los botones
        createRequestButton.setPreferredSize(new Dimension(200, 50));
        viewRequestsButton.setPreferredSize(new Dimension(200, 50));

        // Agregar los botones al panel principal
        mainPanel.add(createRequestButton);
        mainPanel.add(viewRequestsButton);

        // Manejar eventos de botones
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

        getContentPane().add(mainPanel);

    }

    public Solicitud(Connection connection) {
        this.connection = connection;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Mantenimiento de Solicitudes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JButton createRequestButton = new JButton("Crear Solicitud");
        createRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCreateRequestForm();
            }
        });

        mainPanel.add(createRequestButton, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
    }

    private void showCreateRequestForm() {
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));

        JTextField professorField = new JTextField(20);
        JTextField departmentField = new JTextField(20);
        JTextField titleField = new JTextField(20);
        JTextField startDateField = new JTextField(20);
        JTextField endDateField = new JTextField(20);
        JTextField groupField = new JTextField(20);
        JTextField numStudentsField = new JTextField(20);
        JTextArea commentsArea = new JTextArea(4, 20);

        inputPanel.add(new JLabel("Profesor que hace la solicitud:"));
        inputPanel.add(professorField);
        inputPanel.add(new JLabel("Departamento:"));
        inputPanel.add(departmentField);
        inputPanel.add(new JLabel("Título de la actividad:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Fecha y hora de inicio (AAAA-MM-DD HH:MM:SS):"));
        inputPanel.add(startDateField);
        inputPanel.add(new JLabel("Fecha y hora de fin (AAAA-MM-DD HH:MM:SS):"));
        inputPanel.add(endDateField);
        inputPanel.add(new JLabel("Grupo o curso:"));
        inputPanel.add(groupField);
        inputPanel.add(new JLabel("Número de alumnos:"));
        inputPanel.add(numStudentsField);
        inputPanel.add(new JLabel("Comentarios adicionales:"));
        inputPanel.add(new JScrollPane(commentsArea));

        int option = JOptionPane.showConfirmDialog(this,
                inputPanel,
                "Crear Nueva Solicitud",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            try {
                String professor = professorField.getText();
                String department = departmentField.getText();
                String title = titleField.getText();
                String startDateStr = startDateField.getText();
                String endDateStr = endDateField.getText();
                String group = groupField.getText();
                int numStudents = Integer.parseInt(numStudentsField.getText());
                String comments = commentsArea.getText();

                // Convertir fechas de texto a objetos Date
                Date startDate = Date.valueOf(startDateStr);
                Date endDate = Date.valueOf(endDateStr);

                // Insertar la solicitud en la base de datos
                insertSolicitud(professor, department, title, startDate, endDate, group, numStudents, comments);

                JOptionPane.showMessageDialog(this,
                        "Solicitud creada exitosamente.",
                        "Solicitud Creada",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error al crear la solicitud: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void insertSolicitud(String professor, String department, String title, Date startDate, Date endDate,
            String group, int numStudents, String comments) throws SQLException {
        String insertQuery = "INSERT INTO solicitud (professor, department, title, fechainicioactividad, fechafinactividad, "
                + "grupocurso, numeroalumnos, comentariosadicionales) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, professor);
        preparedStatement.setString(2, department);
        preparedStatement.setString(3, title);
        preparedStatement.setDate(4, startDate);
        preparedStatement.setDate(5, endDate);
        preparedStatement.setString(6, group);
        preparedStatement.setInt(7, numStudents);
        preparedStatement.setString(8, comments);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private void showRequestsList() {
        JPanel listPanel = new JPanel(new BorderLayout());

        DefaultListModel<SolicitudData> listModel = new DefaultListModel<>();
        for (SolicitudData solicitud : solicitudes) {
            listModel.addElement(solicitud);
        }

        JList<SolicitudData> requestsList = new JList<>(listModel);
        requestsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(requestsList);

        JButton approveButton = new JButton("Aceptar Solicitud");
        JButton rejectButton = new JButton("Denegar Solicitud");

        // Panel para colocar los botones de aceptar y denegar debajo de la lista
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);

        listPanel.add(scrollPane, BorderLayout.CENTER);
        listPanel.add(buttonPanel, BorderLayout.PAGE_END); // Colocar los botones debajo de la lista

        JFrame listFrame = new JFrame("Lista de Solicitudes");
        listFrame.getContentPane().add(listPanel);
        listFrame.setSize(400, 300);
        listFrame.setLocationRelativeTo(null);

        approveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SolicitudData selectedSolicitud = requestsList.getSelectedValue();
                if (selectedSolicitud != null) {
                    solicitudes.remove(selectedSolicitud);
                    listModel.removeElement(selectedSolicitud);
                    JOptionPane.showMessageDialog(listFrame, "Solicitud Aceptada");
                } else {
                    JOptionPane.showMessageDialog(listFrame, "Selecciona una solicitud para aceptar");
                }
            }
        });

        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SolicitudData selectedSolicitud = requestsList.getSelectedValue();
                if (selectedSolicitud != null) {
                    solicitudes.remove(selectedSolicitud);
                    listModel.removeElement(selectedSolicitud);
                    JOptionPane.showMessageDialog(listFrame, "Solicitud Denegada");
                } else {
                    JOptionPane.showMessageDialog(listFrame, "Selecciona una solicitud para denegar");
                }
            }
        });

        listFrame.setVisible(true);
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
