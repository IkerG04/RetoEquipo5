package com.mycompany.mantenimientosbasicos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Profesor extends JFrame {

    private Connection connection;
    private JTable profesoresTable;
    private DefaultTableModel tableModel;

    public Profesor(Connection connection) {
        super("Administración de Profesores");
        this.connection = connection;
        initComponents();
        loadProfesores();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);

        // Configurar modelo de tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("DNI");
        tableModel.addColumn("Correo");
        tableModel.addColumn("Nombre completo");
        tableModel.addColumn("Activo");
        tableModel.addColumn("Perfil");
        tableModel.addColumn("Contraseña");
        tableModel.addColumn("Departamento");

        // Crear tabla de profesores
        profesoresTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(profesoresTable);

        // Botones para operaciones CRUD
        JButton addButton = new JButton("Editar");
        JButton deleteAllButton = new JButton("Eliminar Todos");

        // Panel para botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteAllButton);

        // Agregar componentes al contenedor principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Acción para botón Agregar/Editar
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = profesoresTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(Profesor.this, "Por favor seleccione un profesor para editar.");
                    return;
                }

                String idStr = tableModel.getValueAt(selectedRow, 0).toString();
                String dni = JOptionPane.showInputDialog(Profesor.this, "Nuevo DNI del profesor:", tableModel.getValueAt(selectedRow, 1));
                String correo = JOptionPane.showInputDialog(Profesor.this, "Nuevo Correo del profesor:", tableModel.getValueAt(selectedRow, 2));
                String nombreCompleto = JOptionPane.showInputDialog(Profesor.this, "Nuevo Nombre completo del profesor:", tableModel.getValueAt(selectedRow, 3));
                String activoStr = JOptionPane.showInputDialog(Profesor.this, "Activo (1 para sí, 0 para no):", tableModel.getValueAt(selectedRow, 4));
                boolean activo = (activoStr != null && activoStr.equals("1"));
                String perfil = JOptionPane.showInputDialog(Profesor.this, "Nuevo Perfil del profesor:", tableModel.getValueAt(selectedRow, 5));
                String contraseña = JOptionPane.showInputDialog(Profesor.this, "Nueva Contraseña del profesor:", tableModel.getValueAt(selectedRow, 6));
                String departamentoStr = JOptionPane.showInputDialog(Profesor.this, "Nuevo ID del departamento:", tableModel.getValueAt(selectedRow, 7));

                if (dni != null && correo != null && nombreCompleto != null && perfil != null && contraseña != null && departamentoStr != null) {
                    int id = Integer.parseInt(idStr);
                    int departamento = Integer.parseInt(departamentoStr);
                    editProfesor(id, dni, correo, nombreCompleto, activo, perfil, contraseña, departamento);
                }
            }
        });

        // Acción para botón Eliminar Todos
        deleteAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(Profesor.this,
                        "¿Está seguro que desea eliminar todos los profesores?", "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    deleteAllProfesores();
                }
            }
        });
    }

    private void loadProfesores() {
        try {
            // Limpiar tabla antes de cargar nuevos datos
            tableModel.setRowCount(0);

            // Consulta SQL para obtener todos los profesores
            String sql = "SELECT * FROM profesor";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Agregar filas a la tabla con los datos de los profesores
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String dni = resultSet.getString("dni");
                String correo = resultSet.getString("correo");
                String nombreCompleto = resultSet.getString("nombre") + " " + resultSet.getString("apellidos");
                boolean activo = resultSet.getBoolean("activo");
                String perfil = resultSet.getString("perfil");
                String contraseña = resultSet.getString("contraseña");
                int departamento = resultSet.getInt("departamento");
                tableModel.addRow(new Object[]{id, dni, correo, nombreCompleto, activo, perfil, contraseña, departamento});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar profesores: " + e.getMessage());
        }
    }

    private void editProfesor(int id, String dni, String correo, String nombreCompleto, boolean activo, String perfil, String contraseña, int departamento) {
        try {
            // Dividir el nombre completo en nombre y apellidos
            String[] partesNombre = nombreCompleto.split("\\s+");
            String nombre = partesNombre[0];
            String apellidos = (partesNombre.length > 1) ? partesNombre[1] : "";

            // Consulta SQL para actualizar los datos del profesor
            String sql = "UPDATE profesor SET dni=?, correo=?, nombre=?, apellidos=?, activo=?, perfil=?, contraseña=?, departamento=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, dni);
            statement.setString(2, correo);
            statement.setString(3, nombre);
            statement.setString(4, apellidos);
            statement.setBoolean(5, activo);
            statement.setString(6, perfil);
            statement.setString(7, contraseña);
            statement.setInt(8, departamento);
            statement.setInt(9, id);
            statement.executeUpdate();

            // Actualizar la tabla después de la edición
            loadProfesores();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al editar profesor: " + e.getMessage());
        }
    }

    private void deleteAllProfesores() {
        try {
            // Consulta SQL para eliminar todos los profesores
            String sql = "DELETE FROM profesor";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();

            // Actualizar la tabla después de la eliminación
            loadProfesores();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar todos los profesores: " + e.getMessage());
        }
    }
}