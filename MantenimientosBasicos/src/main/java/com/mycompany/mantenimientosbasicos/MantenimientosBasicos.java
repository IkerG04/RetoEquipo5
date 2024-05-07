/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.mantenimientosbasicos;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 *
 * @author DAW129
 */

public class MantenimientosBasicos extends JFrame {

    private Connection conn;
    private JComboBox<String> entidadComboBox;
    private JButton eliminarTodosButton; // Nuevo botón para eliminar todos los profesores

    // Campos específicos para editar profesores
    private JComboBox<String> profesorComboBox;
    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField dniField;
    private JTextField correoField;
    private JCheckBox activoCheckBox;
    private JTextField perfilField;
    private JTextField contraseñaField;

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

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Crear el panel para el menú y los botones de acción
        JPanel menuPanel = new JPanel(new FlowLayout());

        // Combo box para seleccionar la entidad
        entidadComboBox = new JComboBox<>();
        entidadComboBox.addItem("Profesores"); // Solo implementamos para profesores en este ejemplo

        // Botón para eliminar todos los profesores
        eliminarTodosButton = new JButton("Eliminar Todos");

        // Agregar componentes al panel del menú
        menuPanel.add(new JLabel("Seleccionar Entidad:"));
        menuPanel.add(entidadComboBox);
        menuPanel.add(eliminarTodosButton); // Agregar el nuevo botón

        // Agregar el panel del menú antes del panel de edición
        mainPanel.add(menuPanel, BorderLayout.NORTH);

        // Panel para editar profesores (se mostrará por defecto)
        JPanel editProfesorPanel = new JPanel(new GridLayout(0, 2));
        editProfesorPanel.setBorder(BorderFactory.createTitledBorder("Editar Profesor"));

        // Combo box para seleccionar profesor
        profesorComboBox = new JComboBox<>();
        populateProfessors(); // Llenar el combo box con profesores disponibles

        // Campos de texto y otros componentes para editar información del profesor seleccionado
        nombreField = new JTextField();
        apellidosField = new JTextField();
        dniField = new JTextField();
        correoField = new JTextField();
        activoCheckBox = new JCheckBox("Activo");
        perfilField = new JTextField();
        contraseñaField = new JTextField();

        editProfesorPanel.add(new JLabel("Seleccionar Profesor:"));
        editProfesorPanel.add(profesorComboBox);
        editProfesorPanel.add(new JLabel("Nombre:"));
        editProfesorPanel.add(nombreField);
        editProfesorPanel.add(new JLabel("Apellidos:"));
        editProfesorPanel.add(apellidosField);
        editProfesorPanel.add(new JLabel("DNI:"));
        editProfesorPanel.add(dniField);
        editProfesorPanel.add(new JLabel("Correo:"));
        editProfesorPanel.add(correoField);
        editProfesorPanel.add(new JLabel("Activo:"));
        editProfesorPanel.add(activoCheckBox);
        editProfesorPanel.add(new JLabel("Perfil:"));
        editProfesorPanel.add(perfilField);
        editProfesorPanel.add(new JLabel("Contraseña:"));
        editProfesorPanel.add(contraseñaField);

        // Agregar el panel de edición de profesores al centro del marco principal
        mainPanel.add(editProfesorPanel, BorderLayout.CENTER);

        // Acción del botón para eliminar todos los profesores
        eliminarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTodosProfesores();
            }
        });

        // Agregar el panel principal al marco
        add(mainPanel);
        setVisible(true);
    }

    private void populateProfessors() {
        try {
            String query = "SELECT id, nombre, apellidos FROM profesor";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String profesorInfo = id + " - " + nombre + " " + apellidos;
                profesorComboBox.addItem(profesorInfo);
            }

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener la lista de profesores.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarTodosProfesores() {
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar todos los profesores?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                String query = "DELETE FROM profesor";
                PreparedStatement stmt = conn.prepareStatement(query);

                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Se han eliminado todos los profesores correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    // Limpiar combo box de profesores
                    profesorComboBox.removeAllItems();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar ningún profesor.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar todos los profesores.", "Error", JOptionPane.ERROR_MESSAGE);
            }
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
