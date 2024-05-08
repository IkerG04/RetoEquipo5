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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DAW129
 */
public class MantenimientosBasicos extends JFrame {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/gestoractividadesextraescolares";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "mysql";
    private Connection connection;

    public MantenimientosBasicos() {
        super("Mantenimientos Básicos");
        iniciarComponentes();
        conectar(); // Establecer conexión al iniciar la aplicación
    }

    private void conectar() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    private void iniciarComponentes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Crear botones para cada opción
        JButton profesoresBtn = new JButton("Profesores");
        JButton cursosBtn = new JButton("Cursos");
        JButton gruposBtn = new JButton("Grupos");
        JButton departamentosBtn = new JButton("Departamentos");

        // Asignar acción a cada botón
        profesoresBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showProfesores();
            }
        });

        cursosBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCursos();
            }
        });

        gruposBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showGrupos();
            }
        });

        departamentosBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDepartamentos();
            }
        });

        // Configurar disposición de componentes
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(profesoresBtn);
        panel.add(cursosBtn);
        panel.add(gruposBtn);
        panel.add(departamentosBtn);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void showProfesores() {
        // Lógica para administrar profesores
        new Profesor(connection).setVisible(true);
    }

    private void showCursos() {
        // Lógica para administrar cursos
        new Curso(connection).setVisible(true);
    }

    private void showGrupos() {
        // Lógica para administrar grupos
        new Grupo(connection).setVisible(true);
    }

    private void showDepartamentos() {
        // Lógica para administrar departamentos
        new Departamento(connection).setVisible(true);
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
            public void run() {
                new MantenimientosBasicos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
