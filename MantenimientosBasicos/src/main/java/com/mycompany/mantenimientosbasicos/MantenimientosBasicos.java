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
    private JComboBox<String> grupoComboBox;
    private JComboBox<String> profesorComboBox;
    private JComboBox<String> departamentoComboBox;
    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField dniField;
    private JTextField correoField;
    private JTextField activoField;
    private JTextField perfilField;
    private JTextField contraseñaField;
    private JTextField departamentoField;
    private JTextField codField;

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
        entidadComboBox.addItem("Profesores");
        entidadComboBox.addItem("Grupos");
        entidadComboBox.addItem("Departamentos");

        // Botones de acción
        JButton editarButton = new JButton("Editar");
        JButton eliminarButton = new JButton("Eliminar");
        JButton eliminarTodosButton = new JButton("Eliminar Todos");

        // Agregar componentes al panel del menú
        menuPanel.add(new JLabel("Seleccionar Entidad:"));
        menuPanel.add(entidadComboBox);
        menuPanel.add(editarButton);
        menuPanel.add(eliminarButton);
        menuPanel.add(eliminarTodosButton);

        // Agregar el panel del menú antes del panel de edición
        mainPanel.add(menuPanel, BorderLayout.NORTH);

        // Panel para editar grupos (se mostrará cuando se seleccione la opción Grupos)
        JPanel editGrupoPanel = new JPanel(new GridLayout(0, 2));
        editGrupoPanel.setBorder(BorderFactory.createTitledBorder("Editar Grupo"));

        grupoComboBox = new JComboBox<>();
        populateGrupos();

        nombreField = new JTextField();
        apellidosField = new JTextField();
        dniField = new JTextField();
        correoField = new JTextField();
        activoField = new JTextField();
        perfilField = new JTextField();
        contraseñaField = new JTextField();
        departamentoField = new JTextField();

        editGrupoPanel.add(new JLabel("Seleccionar Grupo:"));
        editGrupoPanel.add(grupoComboBox);
        editGrupoPanel.add(new JLabel("Nombre:"));
        editGrupoPanel.add(nombreField);
        editGrupoPanel.add(new JLabel("Apellidos:"));
        editGrupoPanel.add(apellidosField);
        editGrupoPanel.add(new JLabel("DNI:"));
        editGrupoPanel.add(dniField);
        editGrupoPanel.add(new JLabel("Correo:"));
        editGrupoPanel.add(correoField);
        editGrupoPanel.add(new JLabel("Activo (1 = Sí, 0 = No):"));
        editGrupoPanel.add(activoField);
        editGrupoPanel.add(new JLabel("Perfil:"));
        editGrupoPanel.add(perfilField);
        editGrupoPanel.add(new JLabel("Contraseña:"));
        editGrupoPanel.add(contraseñaField);
        editGrupoPanel.add(new JLabel("Departamento:"));
        editGrupoPanel.add(departamentoField);

        // Agregar el panel de edición de grupos al centro del marco principal
        mainPanel.add(editGrupoPanel, BorderLayout.CENTER);

        // Acciones de los botones de editar y eliminar
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedEntity = (String) entidadComboBox.getSelectedItem();
                if (selectedEntity != null && selectedEntity.equals("Profesores")) {
                    editarProfesor();
                } else if (selectedEntity != null && selectedEntity.equals("Grupos")) {
                    editarGrupo();
                } else if (selectedEntity != null && selectedEntity.equals("Departamentos")) {
                    editarDepartamento();
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedEntity = (String) entidadComboBox.getSelectedItem();
                if (selectedEntity != null && selectedEntity.equals("Profesores")) {
                    eliminarProfesor();
                } else if (selectedEntity != null && selectedEntity.equals("Grupos")) {
                    eliminarGrupo();
                } else if (selectedEntity != null && selectedEntity.equals("Departamentos")) {
                    eliminarDepartamento();
                }
            }
        });

        eliminarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedEntity = (String) entidadComboBox.getSelectedItem();
                if (selectedEntity != null && selectedEntity.equals("Profesores")) {
                    eliminarTodosProfesores();
                } else if (selectedEntity != null && selectedEntity.equals("Grupos")) {
                    eliminarTodosGrupos();
                } else if (selectedEntity != null && selectedEntity.equals("Departamentos")) {
                    eliminarTodosDepartamentos();
                }
            }
        });

        // Agregar el panel principal al marco
        add(mainPanel);
        setVisible(true);
    }

     private String obtenerNuevoNombreDelGrupo() throws SQLException {
        String nuevoNombre = null;
        String query = "SELECT descripcion FROM curso WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        int curso = 0;
        stmt.setInt(1, curso);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            nuevoNombre = rs.getString("descripcion");
        }

        // Cerrar recursos
        rs.close();
        stmt.close();

        return nuevoNombre;
    }

    // Método para obtener el nuevo curso del grupo desde la base de datos
    private int obtenerNuevoCursoDelGrupo() throws SQLException {
        int nuevoCurso = 0;
        String query = "SELECT curso FROM grupos WHERE codigogrupo = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        int codigoGrupo = 0;
        stmt.setInt(1, codigoGrupo);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            nuevoCurso = rs.getInt("curso");
        }

        // Cerrar recursos
        rs.close();
        stmt.close();

        return nuevoCurso;
    }

    // Método para obtener el nuevo número de alumnos del grupo desde la base de datos
    private int obtenerNuevoNumeroAlumnosDelGrupo() throws SQLException {
        int nuevoNumeroAlumnos = 0;
        String query = "SELECT numeroalumnos FROM grupos WHERE codigogrupo = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        int codigoGrupo = 0;
        stmt.setInt(1, codigoGrupo);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            nuevoNumeroAlumnos = rs.getInt("numeroalumnos");
        }

        // Cerrar recursos
        rs.close();
        stmt.close();

        return nuevoNumeroAlumnos;
    }

    // Método principal para editar un grupo
    public void editarGrupo(int codigoGrupo) {
        try {
            // Obtener el curso actual del grupo
            int cursoActual = obtenerNuevoCursoDelGrupo();

            // Obtener los nuevos valores del grupo desde la base de datos
            String nuevoNombre = obtenerNuevoNombreDelGrupo();
            int nuevoCurso = obtenerNuevoCursoDelGrupo();
            int nuevoNumeroAlumnos = obtenerNuevoNumeroAlumnosDelGrupo();

            // Mostrar los nuevos valores obtenidos
            System.out.println("Nuevo Nombre del Grupo: " + nuevoNombre);
            System.out.println("Nuevo Curso del Grupo: " + nuevoCurso);
            System.out.println("Nuevo Número de Alumnos del Grupo: " + nuevoNumeroAlumnos);

            // Actualizar el grupo en la base de datos con los nuevos valores
            String updateQuery = "UPDATE grupos SET curso=?, numeroalumnos=? WHERE codigogrupo=?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, nuevoCurso);
            updateStmt.setInt(2, nuevoNumeroAlumnos);
            updateStmt.setInt(3, codigoGrupo);

            // Ejecutar la consulta UPDATE
            int rowsUpdated = updateStmt.executeUpdate();

            // Verificar si la actualización fue exitosa
            if (rowsUpdated > 0) {
                System.out.println("Grupo actualizado correctamente en la base de datos.");
            } else {
                System.out.println("Error al actualizar el grupo en la base de datos.");
            }

            // Cerrar recursos
            updateStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }
    }
    
    private void populateGrupos() {
        try {
            String query = "SELECT codigogrupo, curso FROM grupos";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int codigoGrupo = rs.getInt("codigogrupo");
                int curso = rs.getInt("curso");
                String grupoInfo = codigoGrupo + " - Curso " + curso;
                grupoComboBox.addItem(grupoInfo);
            }

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener la lista de grupos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarGrupo() {
    String selectedGrupo = (String) grupoComboBox.getSelectedItem();
    if (selectedGrupo != null && !selectedGrupo.isEmpty()) {
        int codigoGrupo = Integer.parseInt(selectedGrupo.split(" - ")[0]);

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de editar este grupo?", "Confirmar Edición", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Aquí puedes obtener los valores actualizados del grupo
                // Supongamos que estos valores se obtienen de alguna otra fuente o lógica en tu aplicación
                String nuevoNombre = obtenerNuevoNombreDelGrupo(); // Ejemplo: obtenerNuevoNombreDelGrupo() es un método para obtener el nuevo nombre
                int nuevoCurso = obtenerNuevoCursoDelGrupo(); // Ejemplo: obtenerNuevoCursoDelGrupo() es un método para obtener el nuevo curso
                int nuevoNumeroAlumnos = obtenerNuevoNumeroAlumnosDelGrupo(); // Ejemplo: obtenerNuevoNumeroAlumnosDelGrupo() es un método para obtener el nuevo número de alumnos

                // Crear la consulta SQL para actualizar el grupo seleccionado
                String query = "UPDATE grupos SET curso=?, numeroalumnos=? WHERE codigogrupo=?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, nuevoCurso);
                stmt.setInt(2, nuevoNumeroAlumnos);
                stmt.setInt(3, codigoGrupo);

                // Ejecutar la consulta UPDATE
                int rowsUpdated = stmt.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Grupo actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el grupo.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Cerrar el statement
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al actualizar el grupo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un grupo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}



    private void eliminarGrupo() {
        String selectedGrupo = (String) grupoComboBox.getSelectedItem();
        if (selectedGrupo != null && !selectedGrupo.isEmpty()) {
            int codigoGrupo = Integer.parseInt(selectedGrupo.split(" - ")[0]);

            try {
                String query = "DELETE FROM grupos WHERE codigogrupo=?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, codigoGrupo);

                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Grupo eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    grupoComboBox.removeItem(selectedGrupo); // Remove the selected item from combo box
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el grupo.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar el grupo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminarTodosGrupos() {
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar todos los grupos?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                String query = "DELETE FROM grupos";
                PreparedStatement stmt = conn.prepareStatement(query);

                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Se han eliminado todos los grupos correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    grupoComboBox.removeAllItems(); // Remove all items from combo box
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar ningún grupo.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar todos los grupos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void editarProfesor() {
    String selectedProfesor = (String) profesorComboBox.getSelectedItem();
    if (selectedProfesor != null && !selectedProfesor.isEmpty()) {
        int profesorId = Integer.parseInt(selectedProfesor.split(" - ")[0]);

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de editar este profesor?", "Confirmar Edición", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Obtener los valores de los campos de texto
                String nuevoNombre = nombreField.getText();
                String nuevosApellidos = apellidosField.getText();
                String nuevoDni = dniField.getText();
                String nuevoCorreo = correoField.getText();
                int nuevoActivo = Integer.parseInt(activoField.getText());
                String nuevoPerfil = perfilField.getText();
                String nuevaContraseña = contraseñaField.getText();
                int nuevoDepartamento = Integer.parseInt(departamentoField.getText());

                // Crear la consulta SQL para actualizar el profesor seleccionado
                String query = "UPDATE profesor SET nombre=?, apellidos=?, dni=?, correo=?, activo=?, perfil=?, contraseña=?, departamento=? WHERE id=?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, nuevoNombre);
                stmt.setString(2, nuevosApellidos);
                stmt.setString(3, nuevoDni);
                stmt.setString(4, nuevoCorreo);
                stmt.setInt(5, nuevoActivo);
                stmt.setString(6, nuevoPerfil);
                stmt.setString(7, nuevaContraseña);
                stmt.setInt(8, nuevoDepartamento);
                stmt.setInt(9, profesorId);

                // Ejecutar la consulta UPDATE
                int rowsUpdated = stmt.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Profesor actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el profesor.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Cerrar el statement
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al actualizar el profesor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un profesor.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void eliminarProfesor() {
    String selectedProfesor = (String) profesorComboBox.getSelectedItem();
    if (selectedProfesor != null && !selectedProfesor.isEmpty()) {
        int profesorId = Integer.parseInt(selectedProfesor.split(" - ")[0]);

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este profesor?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Crear la consulta SQL para eliminar el profesor seleccionado
                String query = "DELETE FROM profesor WHERE id=?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, profesorId);

                // Ejecutar la consulta DELETE
                int rowsDeleted = stmt.executeUpdate();

                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Profesor eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    profesorComboBox.removeItem(selectedProfesor); // Eliminar el profesor del combo box
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el profesor.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Cerrar el statement
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar el profesor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un profesor.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void eliminarTodosProfesores() {
    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar todos los profesores?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
    if (confirmacion == JOptionPane.YES_OPTION) {
        try {
            // Crear la consulta SQL para eliminar todos los registros de la tabla profesor
            String query = "DELETE FROM profesor";
            PreparedStatement stmt = conn.prepareStatement(query);

            // Ejecutar la consulta DELETE
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Se han eliminado todos los profesores correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                profesorComboBox.removeAllItems(); // Limpiar el combo box de profesores
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar ningún profesor.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Cerrar el statement
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar todos los profesores.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    private void editarDepartamento() {
    String selectedDepartamento = (String) departamentoComboBox.getSelectedItem();
    if (selectedDepartamento != null && !selectedDepartamento.isEmpty()) {
        int departamentoId = Integer.parseInt(selectedDepartamento.split(" - ")[0]);

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de editar este departamento?", "Confirmar Edición", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Obtener los valores de los campos de texto
                String nuevoNombre = nombreField.getText();
                String nuevoCodigo = codField.getText(); // Asumiendo que el código es un campo de texto

                // Crear la consulta SQL para actualizar el departamento seleccionado
                String query = "UPDATE departamento SET nombre=?, cod=? WHERE id=?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, nuevoNombre);
                stmt.setString(2, nuevoCodigo);
                stmt.setInt(3, departamentoId);

                // Ejecutar la consulta UPDATE
                int rowsUpdated = stmt.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Departamento actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el departamento.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Cerrar el statement
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al actualizar el departamento.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un departamento.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void eliminarDepartamento() {
    String selectedDepartamento = (String) departamentoComboBox.getSelectedItem();
    if (selectedDepartamento != null && !selectedDepartamento.isEmpty()) {
        int departamentoId = Integer.parseInt(selectedDepartamento.split(" - ")[0]);

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este departamento?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Crear la consulta SQL para eliminar el departamento seleccionado
                String query = "DELETE FROM departamento WHERE id=?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, departamentoId);

                // Ejecutar la consulta DELETE
                int rowsDeleted = stmt.executeUpdate();

                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Departamento eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    departamentoComboBox.removeItem(selectedDepartamento); // Eliminar el departamento del combo box
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el departamento.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Cerrar el statement
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar el departamento.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un departamento.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void eliminarTodosDepartamentos() {
    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar todos los departamentos?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
    if (confirmacion == JOptionPane.YES_OPTION) {
        try {
            // Crear la consulta SQL para eliminar todos los registros de la tabla departamento
            String query = "DELETE FROM departamento";
            PreparedStatement stmt = conn.prepareStatement(query);

            // Ejecutar la consulta DELETE
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Se han eliminado todos los departamentos correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                departamentoComboBox.removeAllItems(); // Limpiar el combo box de departamentos
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar ningún departamento.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Cerrar el statement
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar todos los departamentos.", "Error", JOptionPane.ERROR_MESSAGE);
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
