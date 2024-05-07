/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.actividad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Actividad extends JFrame {

    private JTextField tituloField, transporteField, inicioField, finField, grupoField, alumnosField, comentariosField;
    private JCheckBox programacionCheck, alojamientoCheck;
    private JButton guardarButton;

    private ActividadData actividadData;
    private AccesoBaseDatos accesoBaseDatos;
    private Usuario usuario; // Supongamos que tenemos una clase Usuario con atributos de roles

    public Actividad(AccesoBaseDatos accesoBaseDatos) {
        this.accesoBaseDatos = accesoBaseDatos;
        this.actividadData = new ActividadData(); // Instanciar una nueva ActividadData
        this.usuario = new Usuario(); // Instanciar un nuevo Usuario (asumiendo un constructor sin parámetros)

        iniciarComponentes();
        displayActividad();
    }

    private void iniciarComponentes() {
        setTitle("Gestión de Actividad");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));

        panel.add(new JLabel("Título de la Actividad:"));
        tituloField = new JTextField();
        panel.add(tituloField);

        panel.add(new JLabel("Empresa de Transporte:"));
        transporteField = new JTextField();
        panel.add(transporteField);

        panel.add(new JLabel("Fecha y Hora de Inicio (yyyy-MM-dd HH:mm):"));
        inicioField = new JTextField();
        panel.add(inicioField);

        panel.add(new JLabel("Fecha y Hora de Fin (yyyy-MM-dd HH:mm):"));
        finField = new JTextField();
        panel.add(finField);

        panel.add(new JLabel("Grupo/Curso:"));
        grupoField = new JTextField();
        panel.add(grupoField);

        panel.add(new JLabel("Número de Alumnos:"));
        alumnosField = new JTextField();
        panel.add(alumnosField);

        panel.add(new JLabel("¿En Programación Didáctica? (sí/no):"));
        programacionCheck = new JCheckBox();
        panel.add(programacionCheck);

        panel.add(new JLabel("¿Alojamiento? (sí/no):"));
        alojamientoCheck = new JCheckBox();
        panel.add(alojamientoCheck);

        panel.add(new JLabel("Comentarios Adicionales:"));
        comentariosField = new JTextField();
        panel.add(comentariosField);

        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarActividad();
            }
        });
        panel.add(guardarButton);

        add(panel);
    }

    private void displayActividad() {
        tituloField.setText(actividadData.getTitulo());
        transporteField.setText(actividadData.getTransporte());

        LocalDate inicio = actividadData.getInicio();
        if (inicio != null) {
            inicioField.setText(inicio.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        } else {
            inicioField.setText(""); // Puedes establecer un valor predeterminado si inicio es null
        }

        LocalDate fin = actividadData.getFin();
        if (fin != null) {
            finField.setText(fin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        } else {
            finField.setText(""); // Puedes establecer un valor predeterminado si fin es null
        }

        grupoField.setText(actividadData.getGrupo());
        alumnosField.setText(String.valueOf(actividadData.getNumAlumnos()));
        programacionCheck.setSelected(actividadData.isEnProgramacion());
        alojamientoCheck.setSelected(actividadData.isAlojamiento());
        comentariosField.setText(actividadData.getComentarios());
    }

    private void guardarActividad() {
        // Obtener los datos de la interfaz y asignarlos a la actividadData
        actividadData.setTitulo(tituloField.getText());
        actividadData.setTransporte(transporteField.getText());

        try {
            LocalDate inicio = LocalDate.parse(inicioField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            actividadData.setInicio(inicio);
        } catch (DateTimeParseException e) {
            actividadData.setInicio(null); // Establecer inicio como null si hay un error al parsear
        }

        try {
            LocalDate fin = LocalDate.parse(finField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            actividadData.setFin(fin);
        } catch (DateTimeParseException e) {
            actividadData.setFin(null); // Establecer fin como null si hay un error al parsear
        }

        actividadData.setGrupo(grupoField.getText());
        actividadData.setNumAlumnos(Integer.parseInt(alumnosField.getText()));
        actividadData.setEnProgramacion(programacionCheck.isSelected());
        actividadData.setAlojamiento(alojamientoCheck.isSelected());
        actividadData.setComentarios(comentariosField.getText());

        // Verificar permisos de usuario antes de guardar la actividad en la base de datos
        if (usuario.isAdmin() || usuario.isResponsable()) {
            // Insertar actividad en la base de datos utilizando el accesoBaseDatos
            boolean inserted = accesoBaseDatos.insertarActividad(actividadData);
            if (inserted) {
                JOptionPane.showMessageDialog(this, "Actividad guardada correctamente.", "Guardar Actividad", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar la actividad.", "Guardar Actividad", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Acceso denegado. Permisos insuficientes.", "Error", JOptionPane.ERROR_MESSAGE);
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
            public void run() {
                try {
                    AccesoBaseDatos accesoBD = AccesoBaseDatos.getInstance("jdbc:mysql://localhost:3306/gestoractividadesextraescolares", "root", "mysql");
                    Actividad actividad = new Actividad(accesoBD);
                    actividad.setVisible(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
