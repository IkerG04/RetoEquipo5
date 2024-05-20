/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mantenimientosbasicos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Grupo extends JFrame {

    private Connection connection;
    private JTable gruposTable;
    private DefaultTableModel tableModel;

    public Grupo(Connection connection) {
        super("Administración de Grupos");
        this.connection = connection;
        initComponents();
        loadGrupos();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);

        // Configurar modelo de tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Código Grupo");
        tableModel.addColumn("Curso");
        tableModel.addColumn("Número de Alumnos");

        // Crear tabla de grupos
        gruposTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(gruposTable);

        // Botón para eliminar todos los grupos
        JButton deleteAllButton = new JButton("Eliminar Todos");

        // Botón para editar grupo seleccionado
        JButton editButton = new JButton("Editar Grupo");

        // Panel para botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteAllButton);
        buttonPanel.add(editButton);

        // Agregar componentes al contenedor principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Acción para botón Eliminar Todos
        deleteAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(Grupo.this,
                        "¿Está seguro que desea eliminar todos los grupos?", "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    deleteAllGrupos();
                }
            }
        });

        // Acción para botón Editar Grupo
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = gruposTable.getSelectedRow();
                if (selectedRow != -1) {
                    int codigoGrupo = (int) gruposTable.getValueAt(selectedRow, 0);
                    int curso = (int) gruposTable.getValueAt(selectedRow, 1);
                    int numeroAlumnos = (int) gruposTable.getValueAt(selectedRow, 2);

                    // Mostrar cuadros de diálogo para editar el grupo
                    String nuevoCursoStr = JOptionPane.showInputDialog(Grupo.this,
                            "Editar Curso:", curso);
                    String nuevoNumeroAlumnosStr = JOptionPane.showInputDialog(Grupo.this,
                            "Editar Número de Alumnos:", numeroAlumnos);

                    // Validar y actualizar el grupo
                    try {
                        if (nuevoCursoStr != null && nuevoNumeroAlumnosStr != null) {
                            int nuevoCurso = Integer.parseInt(nuevoCursoStr);
                            int nuevoNumeroAlumnos = Integer.parseInt(nuevoNumeroAlumnosStr);
                            editGrupo(codigoGrupo, nuevoCurso, nuevoNumeroAlumnos);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Grupo.this,
                                "Por favor, ingrese un valor numérico válido para el curso y el número de alumnos.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(Grupo.this,
                            "Por favor, seleccione un grupo para editar.",
                            "Editar Grupo", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private void loadGrupos() {
        try {
            // Limpiar tabla antes de cargar nuevos datos
            tableModel.setRowCount(0);

            // Consulta SQL para obtener todos los grupos
            String sql = "SELECT codigogrupo, curso, numeroalumnos FROM grupos";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Agregar filas a la tabla con los datos de los grupos
            while (resultSet.next()) {
                int codigoGrupo = resultSet.getInt("codigogrupo");
                int curso = resultSet.getInt("curso");
                int numeroAlumnos = resultSet.getInt("numeroalumnos");
                tableModel.addRow(new Object[]{codigoGrupo, curso, numeroAlumnos});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar grupos: " + e.getMessage());
        }
    }

    private void deleteAllGrupos() {
        try {
            // Consulta SQL para eliminar todos los grupos
            String sql = "DELETE FROM grupos";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();

            // Actualizar la tabla después de la eliminación
            loadGrupos();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar todos los grupos: " + e.getMessage());
        }
    }

    private void editGrupo(int codigoGrupo, int nuevoCurso, int nuevoNumeroAlumnos) {
        try {
            // Consulta SQL para actualizar el grupo
            String sql = "UPDATE grupos SET curso = ?, numeroalumnos = ? WHERE codigogrupo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, nuevoCurso);
            statement.setInt(2, nuevoNumeroAlumnos);
            statement.setInt(3, codigoGrupo);
            statement.executeUpdate();

            // Actualizar la tabla después de la edición
            loadGrupos();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al editar grupo: " + e.getMessage());
        }
    }
}
