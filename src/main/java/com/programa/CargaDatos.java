package com.programa;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CargaDatos extends JFrame {

    private JFrame principal; // Referencia al JFrame principal

    private Map<String, Boolean> profesoresActivos = new HashMap<>();

    public CargaDatos(JFrame principal) {
        super("Carga de Datos desde Archivo CSV");

        this.principal = principal; // Asignar la referencia al JFrame principal

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JButton cargarCSVButton = new JButton("Cargar Archivo CSV");
        JButton volverButton = new JButton("Volver");

        // Estilizar botones
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        cargarCSVButton.setFont(buttonFont);
        volverButton.setFont(buttonFont);

        Color buttonColor = new Color(255, 204, 153);
        cargarCSVButton.setBackground(buttonColor);
        volverButton.setBackground(buttonColor);

        // Agregar botones al panel principal
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(cargarCSVButton);
        buttonPanel.add(volverButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Manejar evento del botón "Cargar Archivo CSV"
        cargarCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Seleccionar Archivo CSV");
                fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv"));

                int returnValue = fileChooser.showOpenDialog(CargaDatos.this);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        cargarProfesoresDesdeCSV(selectedFile);
                        mostrarMensajeExito("Profesores cargados exitosamente desde el archivo CSV.");
                    } catch (IOException ex) {
                        mostrarMensajeError("Error al cargar el archivo CSV: " + ex.getMessage());
                    }
                }
            }
        });

        // Manejar evento del botón "Volver"
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hacer visible el JFrame principal y cerrar el actual
                principal.setVisible(true);
                dispose();
            }
        });

        getContentPane().add(mainPanel);
    }

    private void cargarProfesoresDesdeCSV(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] datos = line.split(",");

            if (datos.length >= 3) {
                String nombreProfesor = datos[0].trim();
                System.out.println(nombreProfesor);
                String emailProfesor = datos[1].trim();
                System.out.println(emailProfesor);
                boolean esActivo = Boolean.parseBoolean(datos[2].trim());
                System.out.println(esActivo);

                if (profesoresActivos.containsKey(emailProfesor)) {
                    profesoresActivos.put(emailProfesor, esActivo && profesoresActivos.get(emailProfesor));
                } else {
                    if (esActivo) {
                        profesoresActivos.put(emailProfesor, true);
                    }
                }
            }
        }
        reader.close();

        profesoresActivos.entrySet().removeIf(entry -> !entry.getValue());
    }

    private void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}