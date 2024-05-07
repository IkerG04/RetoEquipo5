/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.actividad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author DAW129
 */
public class Actividad extends JFrame {

    private JTextField tituloField, transporteField, inicioField, finField, grupoField, alumnosField, comentariosField;
    private JCheckBox programacionCheck, alojamientoCheck;
    private JButton guardarButton, modificarButton;

    private AccesoBaseDatos accesoBD;

    public Actividad(AccesoBaseDatos accesoBD) {
        this.accesoBD = accesoBD;
        iniciarComponentes(); // Inicializar componentes al crear la ventana
    }

    private void iniciarComponentes() {
        setTitle("Gestión de Actividad");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2));

        panel.add(new JLabel("Título de la Actividad:"));
        tituloField = new JTextField();
        panel.add(tituloField);

        panel.add(new JLabel("Empresa de Transporte:"));
        transporteField = new JTextField();
        panel.add(transporteField);

        panel.add(new JLabel("Fecha de Inicio (yyyy-MM-dd):"));
        inicioField = new JTextField();
        panel.add(inicioField);

        panel.add(new JLabel("Fecha de Fin (yyyy-MM-dd):"));
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

        modificarButton = new JButton("Modificar");
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarActividad();
            }
        });
        panel.add(modificarButton);

        add(panel); // Agregar el panel al JFrame
    }

    private void guardarActividad() {
        modificarButton.setEnabled(true); // Habilitar el botón de modificar
        JOptionPane.showMessageDialog(this, "Actividad guardada correctamente.", "Guardar Actividad", JOptionPane.INFORMATION_MESSAGE);
    }

    private void modificarActividad() {
        guardarButton.setEnabled(true); // Habilitar el botón de guardar
        JOptionPane.showMessageDialog(this, "Actividad modificada correctamente.", "Modificar Actividad", JOptionPane.INFORMATION_MESSAGE);
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
        AccesoBaseDatos accesoBD = AccesoBaseDatos.getInstance(); // Obtener la instancia del acceso a la base de datos
        Actividad actividad = new Actividad(accesoBD);
        actividad.setVisible(true);
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
