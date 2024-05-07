package com.programa;

import com.datos.Usuario;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal extends javax.swing.JFrame {

    private boolean animacionEjecutada = false;
    private Usuario user;
    private JPanel activo;
    private JPanel activoSolicitud;
    int xMouse, yMouse;

    public Principal(Usuario user) {
        setUndecorated(true);
        initComponents();
        this.user = user;
        setVisible(true);
        activo = panelSolicitud;
        activoSolicitud = verPanel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JPanel();
        panelMantenimiento = new javax.swing.JPanel();
        cerrar = new javax.swing.JPanel();
        cerrarTexto = new javax.swing.JLabel();
        minimizar = new javax.swing.JPanel();
        minimizarTexto = new javax.swing.JLabel();
        panelActividad = new javax.swing.JPanel();
        panelSolicitud = new javax.swing.JPanel();
        cargarSolicitudes = new javax.swing.JPanel();
        imagenCargarSolicitud = new javax.swing.JLabel();
        textoCargarSolicitud = new javax.swing.JLabel();
        verSolicitudes = new javax.swing.JPanel();
        imagenVerSolicitud = new javax.swing.JLabel();
        textoVerSolicitud = new javax.swing.JLabel();
        fondoSolicitudIzquierda = new javax.swing.JPanel();
        verPanel = new javax.swing.JPanel();
        cargarPanel = new javax.swing.JPanel();
        panelCargaDatos = new javax.swing.JPanel();
        panelUsuario = new javax.swing.JPanel();
        fondoIzquierda = new javax.swing.JPanel();
        usuario = new javax.swing.JPanel();
        imagenUsuario = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JLabel();
        cargaDatos = new javax.swing.JPanel();
        imagenCargaDatos = new javax.swing.JLabel();
        textoCargaDatos = new javax.swing.JLabel();
        solicitud = new javax.swing.JPanel();
        imagenSolicitud = new javax.swing.JLabel();
        textoSolicitud = new javax.swing.JLabel();
        mantenimiento = new javax.swing.JPanel();
        imagenMantenimiento = new javax.swing.JLabel();
        textoMantenimiento = new javax.swing.JLabel();
        actividad = new javax.swing.JPanel();
        imagenActividad = new javax.swing.JLabel();
        textoActividad = new javax.swing.JLabel();
        icono1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        principal.setBackground(new java.awt.Color(51, 51, 51));
        principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMantenimiento.setBackground(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout panelMantenimientoLayout = new javax.swing.GroupLayout(panelMantenimiento);
        panelMantenimiento.setLayout(panelMantenimientoLayout);
        panelMantenimientoLayout.setHorizontalGroup(
            panelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        panelMantenimientoLayout.setVerticalGroup(
            panelMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        principal.add(panelMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 940, 0));

        cerrar.setBackground(new java.awt.Color(51, 51, 51));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cerrarMouseReleased(evt);
            }
        });

        cerrarTexto.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        cerrarTexto.setForeground(new java.awt.Color(255, 255, 255));
        cerrarTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrarTexto.setText("x");
        cerrarTexto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout cerrarLayout = new javax.swing.GroupLayout(cerrar);
        cerrar.setLayout(cerrarLayout);
        cerrarLayout.setHorizontalGroup(
            cerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(cerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cerrarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(cerrarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        cerrarLayout.setVerticalGroup(
            cerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(cerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cerrarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(cerrarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        principal.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 40, 40));

        minimizar.setBackground(new java.awt.Color(51, 51, 51));
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                minimizarMouseReleased(evt);
            }
        });

        minimizarTexto.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        minimizarTexto.setForeground(new java.awt.Color(255, 255, 255));
        minimizarTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizarTexto.setText("_");
        minimizarTexto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout minimizarLayout = new javax.swing.GroupLayout(minimizar);
        minimizar.setLayout(minimizarLayout);
        minimizarLayout.setHorizontalGroup(
            minimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(minimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(minimizarTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );
        minimizarLayout.setVerticalGroup(
            minimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(minimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(minimizarLayout.createSequentialGroup()
                    .addComponent(minimizarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );

        principal.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 40, 40));

        panelActividad.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelActividadLayout = new javax.swing.GroupLayout(panelActividad);
        panelActividad.setLayout(panelActividadLayout);
        panelActividadLayout.setHorizontalGroup(
            panelActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        panelActividadLayout.setVerticalGroup(
            panelActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        principal.add(panelActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 940, 0));

        panelSolicitud.setBackground(new java.awt.Color(40, 40, 40));
        panelSolicitud.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cargarSolicitudes.setBackground(new java.awt.Color(51, 51, 51));
        cargarSolicitudes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargarSolicitudes.setPreferredSize(new java.awt.Dimension(90, 80));
        cargarSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cargarSolicitudesMousePressed(evt);
            }
        });

        imagenCargarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/solicitud.png"))); // NOI18N

        textoCargarSolicitud.setForeground(new java.awt.Color(255, 255, 255));
        textoCargarSolicitud.setText("Cargar");
        textoCargarSolicitud.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cargarSolicitudesLayout = new javax.swing.GroupLayout(cargarSolicitudes);
        cargarSolicitudes.setLayout(cargarSolicitudesLayout);
        cargarSolicitudesLayout.setHorizontalGroup(
            cargarSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargarSolicitudesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagenCargarSolicitud)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(cargarSolicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoCargarSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cargarSolicitudesLayout.setVerticalGroup(
            cargarSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargarSolicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenCargarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoCargarSolicitud)
                .addContainerGap())
        );

        panelSolicitud.add(cargarSolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 223, 91, 80));

        verSolicitudes.setBackground(new java.awt.Color(40, 40, 40));
        verSolicitudes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verSolicitudes.setPreferredSize(new java.awt.Dimension(90, 80));
        verSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                verSolicitudesMousePressed(evt);
            }
        });

        imagenVerSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/solicitud.png"))); // NOI18N

        textoVerSolicitud.setForeground(new java.awt.Color(255, 255, 255));
        textoVerSolicitud.setText("Ver");
        textoVerSolicitud.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout verSolicitudesLayout = new javax.swing.GroupLayout(verSolicitudes);
        verSolicitudes.setLayout(verSolicitudesLayout);
        verSolicitudesLayout.setHorizontalGroup(
            verSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verSolicitudesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagenVerSolicitud)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(verSolicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoVerSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        verSolicitudesLayout.setVerticalGroup(
            verSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verSolicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenVerSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoVerSolicitud)
                .addContainerGap())
        );

        panelSolicitud.add(verSolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 133, 91, -1));

        fondoSolicitudIzquierda.setBackground(new java.awt.Color(51, 51, 51));
        fondoSolicitudIzquierda.setPreferredSize(new java.awt.Dimension(91, 160));

        javax.swing.GroupLayout fondoSolicitudIzquierdaLayout = new javax.swing.GroupLayout(fondoSolicitudIzquierda);
        fondoSolicitudIzquierda.setLayout(fondoSolicitudIzquierdaLayout);
        fondoSolicitudIzquierdaLayout.setHorizontalGroup(
            fondoSolicitudIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );
        fondoSolicitudIzquierdaLayout.setVerticalGroup(
            fondoSolicitudIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        panelSolicitud.add(fondoSolicitudIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 540));

        verPanel.setBackground(new java.awt.Color(40, 40, 40));
        verPanel.setPreferredSize(new java.awt.Dimension(850, 540));

        javax.swing.GroupLayout verPanelLayout = new javax.swing.GroupLayout(verPanel);
        verPanel.setLayout(verPanelLayout);
        verPanelLayout.setHorizontalGroup(
            verPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        verPanelLayout.setVerticalGroup(
            verPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelSolicitud.add(verPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 850, 540));

        cargarPanel.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout cargarPanelLayout = new javax.swing.GroupLayout(cargarPanel);
        cargarPanel.setLayout(cargarPanelLayout);
        cargarPanelLayout.setHorizontalGroup(
            cargarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        cargarPanelLayout.setVerticalGroup(
            cargarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelSolicitud.add(cargarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 850, 0));

        principal.add(panelSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 940, 0));

        panelCargaDatos.setBackground(new java.awt.Color(0, 255, 204));

        javax.swing.GroupLayout panelCargaDatosLayout = new javax.swing.GroupLayout(panelCargaDatos);
        panelCargaDatos.setLayout(panelCargaDatosLayout);
        panelCargaDatosLayout.setHorizontalGroup(
            panelCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        panelCargaDatosLayout.setVerticalGroup(
            panelCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        principal.add(panelCargaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 940, 0));

        panelUsuario.setBackground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout panelUsuarioLayout = new javax.swing.GroupLayout(panelUsuario);
        panelUsuario.setLayout(panelUsuarioLayout);
        panelUsuarioLayout.setHorizontalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        principal.add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 940, 0));

        fondoIzquierda.setBackground(new java.awt.Color(51, 51, 51));

        usuario.setBackground(new java.awt.Color(51, 51, 51));
        usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuario.setPreferredSize(new java.awt.Dimension(90, 80));
        usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuarioMousePressed(evt);
            }
        });

        imagenUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/usuario.png"))); // NOI18N

        textoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        textoUsuario.setText("Usuario");

        javax.swing.GroupLayout usuarioLayout = new javax.swing.GroupLayout(usuario);
        usuario.setLayout(usuarioLayout);
        usuarioLayout.setHorizontalGroup(
            usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(usuarioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(textoUsuario))
                    .addComponent(imagenUsuario))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        usuarioLayout.setVerticalGroup(
            usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoUsuario)
                .addContainerGap())
        );

        cargaDatos.setBackground(new java.awt.Color(51, 51, 51));
        cargaDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargaDatos.setPreferredSize(new java.awt.Dimension(90, 80));
        cargaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cargaDatosMousePressed(evt);
            }
        });

        imagenCargaDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/cargaDatos.png"))); // NOI18N

        textoCargaDatos.setForeground(new java.awt.Color(255, 255, 255));
        textoCargaDatos.setText("Carga de datos");
        textoCargaDatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cargaDatosLayout = new javax.swing.GroupLayout(cargaDatos);
        cargaDatos.setLayout(cargaDatosLayout);
        cargaDatosLayout.setHorizontalGroup(
            cargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargaDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagenCargaDatos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(textoCargaDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );
        cargaDatosLayout.setVerticalGroup(
            cargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargaDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenCargaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCargaDatos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        solicitud.setBackground(new java.awt.Color(40, 40, 40));
        solicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        solicitud.setPreferredSize(new java.awt.Dimension(90, 80));
        solicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                solicitudMousePressed(evt);
            }
        });

        imagenSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/solicitud.png"))); // NOI18N

        textoSolicitud.setForeground(new java.awt.Color(255, 255, 255));
        textoSolicitud.setText("Solicitud");
        textoSolicitud.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout solicitudLayout = new javax.swing.GroupLayout(solicitud);
        solicitud.setLayout(solicitudLayout);
        solicitudLayout.setHorizontalGroup(
            solicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solicitudLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagenSolicitud)
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(textoSolicitud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        solicitudLayout.setVerticalGroup(
            solicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solicitudLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoSolicitud)
                .addContainerGap())
        );

        mantenimiento.setBackground(new java.awt.Color(51, 51, 51));
        mantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mantenimiento.setPreferredSize(new java.awt.Dimension(90, 80));
        mantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mantenimientoMousePressed(evt);
            }
        });

        imagenMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/mantenimiento.png"))); // NOI18N

        textoMantenimiento.setForeground(new java.awt.Color(255, 255, 255));
        textoMantenimiento.setText("Mantenimiento");
        textoMantenimiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout mantenimientoLayout = new javax.swing.GroupLayout(mantenimiento);
        mantenimiento.setLayout(mantenimientoLayout);
        mantenimientoLayout.setHorizontalGroup(
            mantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mantenimientoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagenMantenimiento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(textoMantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );
        mantenimientoLayout.setVerticalGroup(
            mantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mantenimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoMantenimiento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        actividad.setBackground(new java.awt.Color(51, 51, 51));
        actividad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        actividad.setPreferredSize(new java.awt.Dimension(90, 80));
        actividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actividadMousePressed(evt);
            }
        });

        imagenActividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/actividad.png"))); // NOI18N

        textoActividad.setForeground(new java.awt.Color(255, 255, 255));
        textoActividad.setText("Actividad");
        textoActividad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout actividadLayout = new javax.swing.GroupLayout(actividad);
        actividad.setLayout(actividadLayout);
        actividadLayout.setHorizontalGroup(
            actividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actividadLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagenActividad)
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(textoActividad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        actividadLayout.setVerticalGroup(
            actividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actividadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoActividad)
                .addContainerGap())
        );

        javax.swing.GroupLayout fondoIzquierdaLayout = new javax.swing.GroupLayout(fondoIzquierda);
        fondoIzquierda.setLayout(fondoIzquierdaLayout);
        fondoIzquierdaLayout.setHorizontalGroup(
            fondoIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
            .addGroup(fondoIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fondoIzquierdaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(fondoIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(actividad, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(solicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cargaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        fondoIzquierdaLayout.setVerticalGroup(
            fondoIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(fondoIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fondoIzquierdaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(actividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(mantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(solicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(cargaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(105, 105, 105)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        principal.add(fondoIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 90, 550));

        icono1.setFont(new java.awt.Font("Source Code Pro Black", 0, 36)); // NOI18N
        icono1.setForeground(new java.awt.Color(255, 255, 255));
        icono1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/logo blanco.png"))); // NOI18N
        icono1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                icono1MouseDragged(evt);
            }
        });
        icono1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icono1MousePressed(evt);
            }
        });
        principal.add(icono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirMenu(JPanel panel) {
        if (activo != null) {
            activo.setSize(940, 0);
        }
        panel.setSize(940, 540);
    }

    private void abrirMenuSolicitud(JPanel panel) {
        if (activo != null) {
            activoSolicitud.setSize(850, 0);
        }
        panel.setSize(850, 540);
    }

    private void cargaDatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargaDatosMousePressed
        cargaDatos.setBackground(new Color(40, 40, 40));
        mantenimiento.setBackground(new Color(51, 51, 51));
        solicitud.setBackground(new Color(51, 51, 51));
        actividad.setBackground(new Color(51, 51, 51));
        usuario.setBackground(new Color(51, 51, 51));
        abrirMenu(panelCargaDatos);
        activo = panelCargaDatos;
        animacionEjecutada = true;
    }//GEN-LAST:event_cargaDatosMousePressed

    private void mantenimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mantenimientoMousePressed
        cargaDatos.setBackground(new Color(51, 51, 51));
        mantenimiento.setBackground(new Color(40, 40, 40));
        solicitud.setBackground(new Color(51, 51, 51));
        actividad.setBackground(new Color(51, 51, 51));
        usuario.setBackground(new Color(51, 51, 51));
        abrirMenu(panelMantenimiento);
        activo = panelMantenimiento;
        animacionEjecutada = true;
    }//GEN-LAST:event_mantenimientoMousePressed

    private void solicitudMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_solicitudMousePressed
        cargaDatos.setBackground(new Color(51, 51, 51));
        mantenimiento.setBackground(new Color(51, 51, 51));
        solicitud.setBackground(new Color(40, 40, 40));
        actividad.setBackground(new Color(51, 51, 51));
        usuario.setBackground(new Color(51, 51, 51));
        abrirMenu(panelSolicitud);
        activo = panelSolicitud;
        animacionEjecutada = true;
    }//GEN-LAST:event_solicitudMousePressed

    private void actividadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actividadMousePressed
        cargaDatos.setBackground(new Color(51, 51, 51));
        mantenimiento.setBackground(new Color(51, 51, 51));
        solicitud.setBackground(new Color(51, 51, 51));
        actividad.setBackground(new Color(40, 40, 40));
        usuario.setBackground(new Color(51, 51, 51));
        abrirMenu(panelActividad);
        activo = panelActividad;
        animacionEjecutada = true;
    }//GEN-LAST:event_actividadMousePressed

    private void usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMousePressed
        cargaDatos.setBackground(new Color(51, 51, 51));
        mantenimiento.setBackground(new Color(51, 51, 51));
        solicitud.setBackground(new Color(51, 51, 51));
        actividad.setBackground(new Color(51, 51, 51));
        usuario.setBackground(new Color(40, 40, 40));
        abrirMenu(panelUsuario);
        activo = panelUsuario;
        animacionEjecutada = true;
    }//GEN-LAST:event_usuarioMousePressed

    private void cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseEntered
        cerrar.setBackground(Color.RED);
    }//GEN-LAST:event_cerrarMouseEntered

    private void cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseExited
        cerrar.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_cerrarMouseExited

    private void minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseEntered
        minimizar.setBackground(new Color(60, 63, 65));
    }//GEN-LAST:event_minimizarMouseEntered

    private void minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseExited
        minimizar.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_minimizarMouseExited

    private void cerrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseReleased
        int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres cerrar la aplicación?", "Cerrar", javax.swing.JOptionPane.YES_NO_OPTION);

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_cerrarMouseReleased

    private void minimizarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseReleased
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizarMouseReleased

    private void icono1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_icono1MouseDragged

    private void icono1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_icono1MousePressed

    private void cargarSolicitudesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarSolicitudesMousePressed
        cargarSolicitudes.setBackground(new Color(40, 40, 40));
        verSolicitudes.setBackground(new Color(51, 51, 51));
        abrirMenuSolicitud(cargarPanel); // Pasar cargarPanel aquí
    }//GEN-LAST:event_cargarSolicitudesMousePressed

    private void verSolicitudesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verSolicitudesMousePressed
        cargarSolicitudes.setBackground(new Color(51, 51, 51));
        verSolicitudes.setBackground(new Color(40, 40, 40));
        abrirMenuSolicitud(verPanel); // Pasar verPanel aquí
    }//GEN-LAST:event_verSolicitudesMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actividad;
    private javax.swing.JPanel cargaDatos;
    private javax.swing.JPanel cargarPanel;
    private javax.swing.JPanel cargarSolicitudes;
    private javax.swing.JPanel cerrar;
    private javax.swing.JLabel cerrarTexto;
    private javax.swing.JPanel fondoIzquierda;
    private javax.swing.JPanel fondoSolicitudIzquierda;
    private javax.swing.JLabel icono1;
    private javax.swing.JLabel imagenActividad;
    private javax.swing.JLabel imagenCargaDatos;
    private javax.swing.JLabel imagenCargarSolicitud;
    private javax.swing.JLabel imagenMantenimiento;
    private javax.swing.JLabel imagenSolicitud;
    private javax.swing.JLabel imagenUsuario;
    private javax.swing.JLabel imagenVerSolicitud;
    private javax.swing.JPanel mantenimiento;
    private javax.swing.JPanel minimizar;
    private javax.swing.JLabel minimizarTexto;
    private javax.swing.JPanel panelActividad;
    private javax.swing.JPanel panelCargaDatos;
    private javax.swing.JPanel panelMantenimiento;
    private javax.swing.JPanel panelSolicitud;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JPanel principal;
    private javax.swing.JPanel solicitud;
    private javax.swing.JLabel textoActividad;
    private javax.swing.JLabel textoCargaDatos;
    private javax.swing.JLabel textoCargarSolicitud;
    private javax.swing.JLabel textoMantenimiento;
    private javax.swing.JLabel textoSolicitud;
    private javax.swing.JLabel textoUsuario;
    private javax.swing.JLabel textoVerSolicitud;
    private javax.swing.JPanel usuario;
    private javax.swing.JPanel verPanel;
    private javax.swing.JPanel verSolicitudes;
    // End of variables declaration//GEN-END:variables
}
