package com.programa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.datos.Usuario;

public class Principal extends JFrame {

    private JButton cargaDatosBoton;
    private JButton mantenimientosBoton;
    private JButton solicitudBoton;
    private JButton actividadBoton;
    private Usuario user;

    public Principal(Usuario user) {
        super("Sistema de Gestión de Actividades");

        this.user = user;

        // Configurar el JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear un panel principal con BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        getContentPane().add(panelPrincipal);

        // Crear un panel para los botones con GridLayout
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Añadir un borde vacío
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Crear los botones
        crearBotonesSegunPermisos(panelBotones);

        // Estilizar los botones
        estilizarBotones();

        agregarFuncionalidadBotones();

        // Mostrar el JFrame
        setVisible(true);
    }

    private void crearBotonesSegunPermisos(JPanel panelBotones) {
        // Verificar permisos y crear botones correspondientes
        if (user.getPerfil() == Usuario.perfil.SuperUsuario || user.getPerfil() == Usuario.perfil.Administrador) {
            cargaDatosBoton = new JButton("Carga de Datos");
            panelBotones.add(cargaDatosBoton);
        }

        if (user.getPerfil() == Usuario.perfil.SuperUsuario || user.getPerfil() == Usuario.perfil.Administrador) {
            mantenimientosBoton = new JButton("Mantenimientos Básicos");
            panelBotones.add(mantenimientosBoton);
        }

        solicitudBoton = new JButton("Solicitud");

        if (user.getPerfil() == Usuario.perfil.EquipoDirectivo || user.getPerfil() == Usuario.perfil.Administrador) {
            actividadBoton = new JButton("Actividad");
            panelBotones.add(actividadBoton);
        }

        panelBotones.add(solicitudBoton);
    }

    private void estilizarBotones() {
        Font font = new Font("Arial", Font.BOLD, 14);
        Color colorFondo = new Color(51, 153, 255); // Azul claro
        Color colorTexto = Color.WHITE;

        // Establecer la fuente y los colores para todos los botones
        JButton[] botones = {cargaDatosBoton, mantenimientosBoton, solicitudBoton, actividadBoton};
        for (JButton boton : botones) {
            if (boton != null) {
                boton.setFont(font);
                boton.setBackground(colorFondo);
                boton.setForeground(colorTexto);
                boton.setFocusPainted(false); // Eliminar el resaltado al enfocar
                boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Añadir un borde vacío
            }
        }
    }

    private void agregarFuncionalidadBotones() {
        if (user.getPerfil() == Usuario.perfil.SuperUsuario || user.getPerfil() == Usuario.perfil.Administrador) {
            cargaDatosBoton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //dispose();
                    CargaDatos carga = new CargaDatos();
                    carga.setVisible(true);
                }
            });
        }

        if (user.getPerfil() == Usuario.perfil.SuperUsuario || user.getPerfil() == Usuario.perfil.Administrador) {
            mantenimientosBoton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    MantenimientosBasicos mantenimiento = new MantenimientosBasicos();
                    mantenimiento.setVisible(true);
                }
            });
        }

        solicitudBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Solicitud solicitud = new Solicitud();
                solicitud.setVisible(true);
            }
        });

        if (user.getPerfil() == Usuario.perfil.EquipoDirectivo || user.getPerfil() == Usuario.perfil.Administrador) {
            actividadBoton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Agrega aquí la funcionalidad para el botón "Actividad"
                }
            });
        }
    }


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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
