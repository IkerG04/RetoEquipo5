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

public class Curso extends JFrame {

    private Connection connection;
    private JTable cursosTable;
    private DefaultTableModel tableModel;

    public Curso(Connection connection) {
        super("Administración de Cursos");
        this.connection = connection;
        initComponents();
        loadCursos();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);

        // Configurar modelo de tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Etapa");
        tableModel.addColumn("Descripción");

        // Crear tabla de cursos
        cursosTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(cursosTable);

        // Botón para eliminar todos los cursos
        JButton deleteAllButton = new JButton("Eliminar Todos");

        // Botón para editar curso seleccionado
        JButton editButton = new JButton("Editar Curso");

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
                int confirmacion = JOptionPane.showConfirmDialog(Curso.this,
                        "¿Está seguro que desea eliminar todos los cursos?", "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    deleteAllCursos();
                }
            }
        });

        // Acción para botón Editar Curso
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = cursosTable.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) cursosTable.getValueAt(selectedRow, 0);
                    String etapaActual = (String) cursosTable.getValueAt(selectedRow, 1);
                    String descripcionActual = (String) cursosTable.getValueAt(selectedRow, 2);
                    // Aquí puedes mostrar un diálogo para editar estos campos
                    // y luego llamar a editCurso con los nuevos valores
                    // editCurso(id, nuevaEtapa, nuevaDescripcion);
                } else {
                    JOptionPane.showMessageDialog(Curso.this,
                            "Por favor, seleccione un curso para editar.",
                            "Editar Curso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private void loadCursos() {
        try {
            // Limpiar tabla antes de cargar nuevos datos
            tableModel.setRowCount(0);

            // Consulta SQL para obtener todos los cursos
            String sql = "SELECT id, etapa, descripcion FROM curso";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Agregar filas a la tabla con los datos de los cursos
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String etapa = resultSet.getString("etapa");
                String descripcion = resultSet.getString("descripcion");
                tableModel.addRow(new Object[]{id, etapa, descripcion});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar cursos: " + e.getMessage());
        }
    }

    private void deleteAllCursos() {
        try {
            // Consulta SQL para eliminar todos los cursos
            String sql = "DELETE FROM curso";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();

            // Actualizar la tabla después de la eliminación
            loadCursos();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar todos los cursos: " + e.getMessage());
        }
    }

    private void editCurso(int id, String nuevaEtapa, String nuevaDescripcion) {
        try {
            // Consulta SQL para actualizar la etapa y descripción del curso
            String sql = "UPDATE curso SET etapa = ?, descripcion = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nuevaEtapa);
            statement.setString(2, nuevaDescripcion);
            statement.setInt(3, id);
            statement.executeUpdate();

            // Actualizar la tabla después de la edición
            loadCursos();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al editar curso: " + e.getMessage());
        }
    }
}
