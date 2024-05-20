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

public class Departamento extends JFrame {

    private Connection connection;
    private JTable departamentosTable;
    private DefaultTableModel tableModel;

    public Departamento(Connection connection) {
        super("Administración de Departamentos");
        this.connection = connection;
        initComponents();
        loadDepartamentos();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);

        // Configurar modelo de tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Código");
        tableModel.addColumn("Nombre");

        // Crear tabla de departamentos
        departamentosTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(departamentosTable);

        // Botón para eliminar todos los departamentos
        JButton deleteAllButton = new JButton("Eliminar Todos");

        // Botón para editar departamento seleccionado
        JButton editButton = new JButton("Editar Departamento");

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
                int confirmacion = JOptionPane.showConfirmDialog(Departamento.this,
                        "¿Está seguro que desea eliminar todos los departamentos?", "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    deleteAllDepartamentos();
                }
            }
        });

        // Acción para botón Editar Departamento
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = departamentosTable.getSelectedRow();
                if (selectedRow != -1) {
                    int idDepartamento = (int) departamentosTable.getValueAt(selectedRow, 0);
                    String codigo = (String) departamentosTable.getValueAt(selectedRow, 1);
                    String nombre = (String) departamentosTable.getValueAt(selectedRow, 2);

                    // Mostrar cuadros de diálogo para editar el departamento
                    String nuevoCodigo = JOptionPane.showInputDialog(Departamento.this,
                            "Editar Código:", codigo);
                    String nuevoNombre = JOptionPane.showInputDialog(Departamento.this,
                            "Editar Nombre:", nombre);

                    // Validar y actualizar el departamento
                    if (nuevoCodigo != null && nuevoNombre != null) {
                        editDepartamento(idDepartamento, nuevoCodigo, nuevoNombre);
                    }
                } else {
                    JOptionPane.showMessageDialog(Departamento.this,
                            "Por favor, seleccione un departamento para editar.",
                            "Editar Departamento", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private void loadDepartamentos() {
        try {
            // Limpiar tabla antes de cargar nuevos datos
            tableModel.setRowCount(0);

            // Consulta SQL para obtener todos los departamentos
            String sql = "SELECT id, cod, nombre FROM departamento";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Agregar filas a la tabla con los datos de los departamentos
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String codigo = resultSet.getString("cod");
                String nombre = resultSet.getString("nombre");
                tableModel.addRow(new Object[]{id, codigo, nombre});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar departamentos: " + e.getMessage());
        }
    }

    private void deleteAllDepartamentos() {
        try {
            // Consulta SQL para eliminar todos los departamentos
            String sql = "DELETE FROM departamento";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();

            // Actualizar la tabla después de la eliminación
            loadDepartamentos();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar todos los departamentos: " + e.getMessage());
        }
    }

    private void editDepartamento(int id, String nuevoCodigo, String nuevoNombre) {
        try {
            // Consulta SQL para actualizar el departamento
            String sql = "UPDATE departamento SET cod = ?, nombre = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nuevoCodigo);
            statement.setString(2, nuevoNombre);
            statement.setInt(3, id);
            statement.executeUpdate();

            // Actualizar la tabla después de la edición
            loadDepartamentos();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al editar departamento: " + e.getMessage());
        }
    }
}
