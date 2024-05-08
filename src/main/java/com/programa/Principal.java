package com.programa;

import com.bd.AccesoBaseDatos;
import com.datos.Usuario;
import java.awt.Color;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal extends javax.swing.JFrame {

    private boolean animacionEjecutada = false;
    private Usuario user;
    private JPanel activo;
    private JPanel activoSolicitud;
    int xMouse, yMouse;
    private List<SolicitudData> solicitudes = new ArrayList<>(); // Lista para almacenar las solicitudes
    private Connection connection;

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

        actividadPrevista = new javax.swing.ButtonGroup();
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
        solicitudCargarTransporteTxt = new javax.swing.JTextField();
        solicitudCargarTransporte = new javax.swing.JLabel();
        solicitudCargarDepartamento = new javax.swing.JLabel();
        solicitudCargarDepartamentoTxt = new javax.swing.JTextField();
        solicitudCargarComentariosTxt = new javax.swing.JTextField();
        solicitudCargarComentarios = new javax.swing.JLabel();
        solicitudCargarAlojamiento = new javax.swing.JLabel();
        solicitudCargarAlojamientoTxt = new javax.swing.JTextField();
        solicitudCargarAlumnos = new javax.swing.JLabel();
        solicitudCargarAlumnosTxt = new javax.swing.JTextField();
        solicitudCargarEstadoTxt = new javax.swing.JTextField();
        solicitudCargarEstado = new javax.swing.JLabel();
        solicitudCargarGrupoTxt = new javax.swing.JTextField();
        solicitudCargarGrupo = new javax.swing.JLabel();
        solicitudCargarFechaInicioTxt = new javax.swing.JTextField();
        solicitudCargarFechaInicio = new javax.swing.JLabel();
        solicitudCargarFechaFinTxt = new javax.swing.JTextField();
        solicitudCargarFechaFin = new javax.swing.JLabel();
        solicitudCargarPrevista = new javax.swing.JLabel();
        solicitudCargarTitulo = new javax.swing.JLabel();
        solicitudCargarTituloTxt = new javax.swing.JTextField();
        solicitudCargarPrevistaON = new javax.swing.JRadioButton();
        solicitudCargarPrevistaOFF = new javax.swing.JRadioButton();
        botonCargar = new javax.swing.JPanel();
        textoCargar = new javax.swing.JLabel();
        botonCancelarCarga = new javax.swing.JPanel();
        textoCancelar = new javax.swing.JLabel();
        textoLlenarTodoSolicitudCargar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        cargarSolicitudes.setBackground(new java.awt.Color(40, 40, 40));
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

        verSolicitudes.setBackground(new java.awt.Color(51, 51, 51));
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
            .addGap(0, 540, Short.MAX_VALUE)
        );

        panelSolicitud.add(verPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 850, 540));

        cargarPanel.setBackground(new java.awt.Color(40, 40, 40));
        cargarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        solicitudCargarTransporteTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarTransporteTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarTransporteTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarPanel.add(solicitudCargarTransporteTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 97, 187, -1));

        solicitudCargarTransporte.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarTransporte.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarTransporte.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarTransporte.setText("Medio de transporte");
        cargarPanel.add(solicitudCargarTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 97, 130, 20));

        solicitudCargarDepartamento.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarDepartamento.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarDepartamento.setText("Departamento");
        cargarPanel.add(solicitudCargarDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 123, 120, 20));

        solicitudCargarDepartamentoTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarDepartamentoTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarDepartamentoTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarPanel.add(solicitudCargarDepartamentoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 123, 187, -1));

        solicitudCargarComentariosTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarComentariosTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarComentariosTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarPanel.add(solicitudCargarComentariosTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 149, 187, -1));

        solicitudCargarComentarios.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarComentarios.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarComentarios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarComentarios.setText("Comentarios Adicionales");
        cargarPanel.add(solicitudCargarComentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 149, 140, 20));

        solicitudCargarAlojamiento.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarAlojamiento.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarAlojamiento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarAlojamiento.setText("Alojamiento");
        cargarPanel.add(solicitudCargarAlojamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 177, 100, -1));

        solicitudCargarAlojamientoTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarAlojamientoTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarAlojamientoTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarPanel.add(solicitudCargarAlojamientoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 175, 187, -1));

        solicitudCargarAlumnos.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarAlumnos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarAlumnos.setText("Número de Alumnos");
        cargarPanel.add(solicitudCargarAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 203, 140, -1));

        solicitudCargarAlumnosTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarAlumnosTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarAlumnosTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarPanel.add(solicitudCargarAlumnosTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 201, 187, -1));

        solicitudCargarEstadoTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarEstadoTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarEstadoTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarPanel.add(solicitudCargarEstadoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 227, 187, -1));

        solicitudCargarEstado.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarEstado.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarEstado.setText("Estado");
        cargarPanel.add(solicitudCargarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 229, 90, -1));

        solicitudCargarGrupoTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarGrupoTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarGrupoTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarPanel.add(solicitudCargarGrupoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 253, 187, -1));

        solicitudCargarGrupo.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarGrupo.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarGrupo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarGrupo.setText("Grupo/Curso");
        cargarPanel.add(solicitudCargarGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 255, 140, -1));

        solicitudCargarFechaInicioTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarFechaInicioTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarFechaInicioTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarPanel.add(solicitudCargarFechaInicioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 279, 187, -1));

        solicitudCargarFechaInicio.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarFechaInicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarFechaInicio.setText("Fecha Inicio Actividad (YYYY-MM-DD)");
        cargarPanel.add(solicitudCargarFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 281, 230, -1));

        solicitudCargarFechaFinTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarFechaFinTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarFechaFinTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarPanel.add(solicitudCargarFechaFinTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 305, 187, -1));

        solicitudCargarFechaFin.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarFechaFin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarFechaFin.setText("Fecha Fin Actividad (YYYY-MM-DD)");
        cargarPanel.add(solicitudCargarFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 307, 220, -1));

        solicitudCargarPrevista.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarPrevista.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarPrevista.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarPrevista.setText("Actividad Prevista");
        cargarPanel.add(solicitudCargarPrevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 333, 120, -1));

        solicitudCargarTitulo.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarTitulo.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarTitulo.setText("Título");
        cargarPanel.add(solicitudCargarTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 73, 50, -1));

        solicitudCargarTituloTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarTituloTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarTituloTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        solicitudCargarTituloTxt.setNextFocusableComponent(solicitudCargarTransporteTxt);
        cargarPanel.add(solicitudCargarTituloTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 71, 187, -1));

        actividadPrevista.add(solicitudCargarPrevistaON);
        solicitudCargarPrevistaON.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarPrevistaON.setText("Prevista");
        cargarPanel.add(solicitudCargarPrevistaON, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 331, -1, -1));

        actividadPrevista.add(solicitudCargarPrevistaOFF);
        solicitudCargarPrevistaOFF.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarPrevistaOFF.setText("No Prevista");
        cargarPanel.add(solicitudCargarPrevistaOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 331, -1, -1));

        botonCargar.setBackground(new java.awt.Color(51, 51, 51));

        textoCargar.setBackground(new java.awt.Color(51, 51, 51));
        textoCargar.setForeground(new java.awt.Color(255, 255, 255));
        textoCargar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCargar.setText("Cargar");
        textoCargar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textoCargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        textoCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                textoCargarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout botonCargarLayout = new javax.swing.GroupLayout(botonCargar);
        botonCargar.setLayout(botonCargarLayout);
        botonCargarLayout.setHorizontalGroup(
            botonCargarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoCargar, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );
        botonCargarLayout.setVerticalGroup(
            botonCargarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoCargar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        cargarPanel.add(botonCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, -1, -1));

        botonCancelarCarga.setBackground(new java.awt.Color(51, 51, 51));

        textoCancelar.setBackground(new java.awt.Color(51, 51, 51));
        textoCancelar.setForeground(new java.awt.Color(255, 255, 255));
        textoCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCancelar.setText("Cancelar");
        textoCancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        textoCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                textoCancelarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout botonCancelarCargaLayout = new javax.swing.GroupLayout(botonCancelarCarga);
        botonCancelarCarga.setLayout(botonCancelarCargaLayout);
        botonCancelarCargaLayout.setHorizontalGroup(
            botonCancelarCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
        );
        botonCancelarCargaLayout.setVerticalGroup(
            botonCancelarCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        cargarPanel.add(botonCancelarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 83, -1));

        textoLlenarTodoSolicitudCargar.setBackground(new java.awt.Color(40, 40, 40));
        textoLlenarTodoSolicitudCargar.setForeground(new java.awt.Color(255, 0, 0));
        cargarPanel.add(textoLlenarTodoSolicitudCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 200, -1));

        jButton1.setText("rellenar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        cargarPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, -1, -1));

        panelSolicitud.add(cargarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 850, 0));

        principal.add(panelSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 940, 540));

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

        panelUsuario.setBackground(new java.awt.Color(40, 40, 40));

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
        fondoIzquierda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        textoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoUsuario.setText("Usuario");
        textoUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout usuarioLayout = new javax.swing.GroupLayout(usuario);
        usuario.setLayout(usuarioLayout);
        usuarioLayout.setHorizontalGroup(
            usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagenUsuario)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usuarioLayout.createSequentialGroup()
                .addComponent(textoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        fondoIzquierda.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 470, 90, 80));

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
        textoCargaDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCargaDatos.setText("Carga de datos");
        textoCargaDatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cargaDatosLayout = new javax.swing.GroupLayout(cargaDatos);
        cargaDatos.setLayout(cargaDatosLayout);
        cargaDatosLayout.setHorizontalGroup(
            cargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargaDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagenCargaDatos)
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(textoCargaDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
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

        fondoIzquierda.add(cargaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 274, 90, 80));

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
        textoSolicitud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoSolicitud.setText("Solicitud");
        textoSolicitud.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout solicitudLayout = new javax.swing.GroupLayout(solicitud);
        solicitud.setLayout(solicitudLayout);
        solicitudLayout.setHorizontalGroup(
            solicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solicitudLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagenSolicitud)
                .addContainerGap(20, Short.MAX_VALUE))
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

        fondoIzquierda.add(solicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 182, 90, 80));

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
        textoMantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
            .addComponent(textoMantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
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

        fondoIzquierda.add(mantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 96, 90, 80));

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
        textoActividad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoActividad.setText("Actividad");
        textoActividad.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout actividadLayout = new javax.swing.GroupLayout(actividad);
        actividad.setLayout(actividadLayout);
        actividadLayout.setHorizontalGroup(
            actividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actividadLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagenActividad)
                .addContainerGap(20, Short.MAX_VALUE))
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

        fondoIzquierda.add(actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 90, 80));

        principal.add(fondoIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 90, 550));

        icono1.setFont(new java.awt.Font("Source Code Pro Black", 0, 24)); // NOI18N
        icono1.setForeground(new java.awt.Color(255, 255, 255));
        icono1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/logo blanco.png"))); // NOI18N
        icono1.setText("ACEX");
        icono1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        icono1.setIconTextGap(-10);
        icono1.setInheritsPopupMenu(false);
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

    private void insertarSolicitud(int medioTransporte, int departamento, String comentarios, int alojamiento,
            int numeroAlumnos, String estado, Integer grupoCurso, String fechaInicio,
            String fechaFin, int prevista, String titulo) {
        try {
            String sql = "INSERT INTO solicitud "
                    + "(mediotransporte, departamento, comentariosadicionales, alojamiento, "
                    + "numeroalumnos, estado, grupocurso, fechainicioactividad, fechafinactividad, "
                    + "prevista, titulo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Obtener una instancia de AccesoBaseDatos
            AccesoBaseDatos accesoBD = AccesoBaseDatos.getInstance();

            // Obtener la conexión a la base de datos
            Connection connection = accesoBD.getConn();

            // Crear un PreparedStatement para la inserción
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, medioTransporte);
            statement.setInt(2, departamento);
            statement.setString(3, comentarios);
            statement.setInt(4, alojamiento);
            statement.setInt(5, numeroAlumnos);
            statement.setString(6, estado);
            statement.setObject(7, grupoCurso);
            statement.setString(8, fechaInicio);
            statement.setString(9, fechaFin);
            statement.setInt(10, prevista);
            statement.setString(11, titulo);

            // Ejecutar la inserción
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al insertar la solicitud en la base de datos: " + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }

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

    private void textoCargarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoCargarMouseReleased
        try {
            int medioTransporte = Integer.parseInt(solicitudCargarTransporteTxt.getText());
            int departamento = Integer.parseInt(solicitudCargarDepartamentoTxt.getText());
            String comentarios = solicitudCargarComentariosTxt.getText();
            int alojamiento = Integer.parseInt(solicitudCargarAlojamientoTxt.getText());
            int numeroAlumnos = Integer.parseInt(solicitudCargarAlumnosTxt.getText());
            String estado = solicitudCargarEstadoTxt.getText();
            Integer grupoCurso = solicitudCargarGrupoTxt.getText().isEmpty() ? null : Integer.parseInt(solicitudCargarGrupoTxt.getText());
            String fechaInicio = solicitudCargarFechaInicioTxt.getText();
            String fechaFin = solicitudCargarFechaFinTxt.getText();
            String titulo = solicitudCargarTituloTxt.getText();
            int prevista;

            ButtonModel selectedModel = actividadPrevista.getSelection();

            if (selectedModel == null) {
                throw new Exception("Error: Seleccione si está prevista o no.");
            } else {
                if (selectedModel.equals(solicitudCargarPrevistaON.getModel())) {
                    prevista = 1;
                } else if (selectedModel.equals(solicitudCargarPrevistaOFF.getModel())) {
                    prevista = 0;
                } else {
                    throw new Exception("Error: Seleccione si está prevista o no.");
                }
            }

            // Ventana de confirmación
            int resultado = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cargar esta solicitud?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (resultado == JOptionPane.YES_OPTION) {
                // Insertar la nueva solicitud en la base de datos
                insertarSolicitud(medioTransporte, departamento, comentarios, alojamiento, numeroAlumnos, estado,
                        grupoCurso, fechaInicio, fechaFin, prevista, titulo);

                JOptionPane.showMessageDialog(this, "Solicitud creada exitosamente.", "Solicitud Creada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Operación cancelada
                // Puedes agregar aquí cualquier código necesario en caso de cancelación
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Ingrese números válidos en los campos numéricos.",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_textoCargarMouseReleased

    private void textoCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoCancelarMouseReleased
        solicitudCargarTituloTxt.setText("");
        solicitudCargarTransporteTxt.setText("");
        solicitudCargarDepartamentoTxt.setText("");
        solicitudCargarComentariosTxt.setText("");
        solicitudCargarAlojamientoTxt.setText("");
        solicitudCargarAlumnosTxt.setText("");
        solicitudCargarEstadoTxt.setText("");
        solicitudCargarGrupoTxt.setText("");
        solicitudCargarFechaInicioTxt.setText("");
        solicitudCargarFechaFinTxt.setText("");
        actividadPrevista.clearSelection();
    }//GEN-LAST:event_textoCancelarMouseReleased

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        Random rand = new Random();

        // Números aleatorios de 0 a 50
        solicitudCargarTransporteTxt.setText(String.valueOf(rand.nextInt(51)));
        solicitudCargarDepartamentoTxt.setText(String.valueOf(rand.nextInt(51)));
        solicitudCargarAlojamientoTxt.setText(String.valueOf(rand.nextInt(51)));
        solicitudCargarAlumnosTxt.setText(String.valueOf(rand.nextInt(51)));

        // Letras aleatorias de 'a' a 'z'
        solicitudCargarComentariosTxt.setText(generarLetrasAleatorias(rand, 10)); // 10 letras
        solicitudCargarTituloTxt.setText(generarLetrasAleatorias(rand, 5)); // 5 letras
        solicitudCargarEstadoTxt.setText(generarLetrasAleatorias(rand, 8)); // 8 letras

        // Grupo aleatorio de 0 a 99999
        solicitudCargarGrupoTxt.setText(String.valueOf(rand.nextInt(100000)));

        // Fechas aleatorias de 2000 hasta 2024
        int yearInicio = rand.nextInt(25) + 2000; // 2000 - 2024
        int yearFin = rand.nextInt(25) + 2000; // 2000 - 2024
        int month = rand.nextInt(12) + 1; // 1 - 12
        int day = rand.nextInt(28) + 1; // 1 - 28
        solicitudCargarFechaInicioTxt.setText(LocalDate.of(yearInicio, month, day).toString());
        solicitudCargarFechaFinTxt.setText(LocalDate.of(yearFin, month, day).toString());

        // Establecer aleatoriamente si está prevista o no
        if (rand.nextBoolean()) {
            actividadPrevista.setSelected(solicitudCargarPrevistaON.getModel(), true);
        } else {
            actividadPrevista.setSelected(solicitudCargarPrevistaOFF.getModel(), true);
        }
        java.awt.event.MouseEvent fakeMouseEvent = new java.awt.event.MouseEvent(new JLabel(), 0, 0, 0, 0, 0, 0, false);
        textoCargarMouseReleased(fakeMouseEvent);
    }

    private String generarLetrasAleatorias(Random rand, int longitud) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            char randomChar = (char) (rand.nextInt(26) + 'a');
            sb.append(randomChar);
        }
        return sb.toString();
    }//GEN-LAST:event_jButton1MouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actividad;
    private javax.swing.ButtonGroup actividadPrevista;
    private javax.swing.JPanel botonCancelarCarga;
    private javax.swing.JPanel botonCargar;
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
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel solicitudCargarAlojamiento;
    private javax.swing.JTextField solicitudCargarAlojamientoTxt;
    private javax.swing.JLabel solicitudCargarAlumnos;
    private javax.swing.JTextField solicitudCargarAlumnosTxt;
    private javax.swing.JLabel solicitudCargarComentarios;
    private javax.swing.JTextField solicitudCargarComentariosTxt;
    private javax.swing.JLabel solicitudCargarDepartamento;
    private javax.swing.JTextField solicitudCargarDepartamentoTxt;
    private javax.swing.JLabel solicitudCargarEstado;
    private javax.swing.JTextField solicitudCargarEstadoTxt;
    private javax.swing.JLabel solicitudCargarFechaFin;
    private javax.swing.JTextField solicitudCargarFechaFinTxt;
    private javax.swing.JLabel solicitudCargarFechaInicio;
    private javax.swing.JTextField solicitudCargarFechaInicioTxt;
    private javax.swing.JLabel solicitudCargarGrupo;
    private javax.swing.JTextField solicitudCargarGrupoTxt;
    private javax.swing.JLabel solicitudCargarPrevista;
    private javax.swing.JRadioButton solicitudCargarPrevistaOFF;
    private javax.swing.JRadioButton solicitudCargarPrevistaON;
    private javax.swing.JLabel solicitudCargarTitulo;
    private javax.swing.JTextField solicitudCargarTituloTxt;
    private javax.swing.JLabel solicitudCargarTransporte;
    private javax.swing.JTextField solicitudCargarTransporteTxt;
    private javax.swing.JLabel textoActividad;
    private javax.swing.JLabel textoCancelar;
    private javax.swing.JLabel textoCargaDatos;
    private javax.swing.JLabel textoCargar;
    private javax.swing.JLabel textoCargarSolicitud;
    private javax.swing.JLabel textoLlenarTodoSolicitudCargar;
    private javax.swing.JLabel textoMantenimiento;
    private javax.swing.JLabel textoSolicitud;
    private javax.swing.JLabel textoUsuario;
    private javax.swing.JLabel textoVerSolicitud;
    private javax.swing.JPanel usuario;
    private javax.swing.JPanel verPanel;
    private javax.swing.JPanel verSolicitudes;
    // End of variables declaration//GEN-END:variables
}
