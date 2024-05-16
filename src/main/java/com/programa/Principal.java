package com.programa;

import java.awt.*;
import com.bd.AccesoBaseDatos;
import com.bd.FuncionesBD;
import com.datos.Curso;
import com.datos.Grupo;
import com.datos.Paneles;
import com.datos.Profesor;
import com.datos.Solicitud;
import com.datos.Usuario;
import com.login.Login;
import com.extra.ScrollBarCustom;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Principal extends javax.swing.JFrame {

    private boolean animacionEjecutada = false;
    private Usuario user;
    private JPanel activo;
    private JPanel activoMantenimiento;
    private JPanel activoSolicitud;
    int xMouse, yMouse;
    private List<SolicitudData> solicitudes = new ArrayList<>(); // Lista para almacenar las solicitudes
    private Connection connection;
    private FuncionesBD funcionesBD = new FuncionesBD();
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gestoractividadesextraescolares";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";
    ArrayList<Profesor> profesores;

    public Principal(Usuario user) {
        setUndecorated(true);
        initComponents();
        this.user = user;
        setVisible(true);
        activo = panelMantenimiento;
        activoMantenimiento = gruposPanel;
        activoSolicitud = verPanel;
        setLocationRelativeTo(null);
        JPanel[] paneles = {panelActividad, panelMantenimiento, panelSolicitud, panelCargaDatos, panelUsuario};
        for (JPanel p : paneles) {
            p.setSize(940, 540);
            p.setVisible(false);
        }

        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("raven.combobox");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();

        cursosSeleccion.setVisible(false);
        gruposSeleccion.setVisible(false);

        textoGrupo.setVisible(false);
        textoCurso.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        actividadPrevista = new javax.swing.ButtonGroup();
        vehiculo = new javax.swing.ButtonGroup();
        gruposCursos = new javax.swing.ButtonGroup();
        principal = new javax.swing.JPanel();
        panelMantenimiento = new javax.swing.JPanel();
        mantenimientoCursos = new javax.swing.JPanel();
        imagenVerSolicitud1 = new javax.swing.JLabel();
        textoVerSolicitud1 = new javax.swing.JLabel();
        mantenimientoGrupos = new javax.swing.JPanel();
        imagenCargarSolicitud1 = new javax.swing.JLabel();
        textoCargarSolicitud1 = new javax.swing.JLabel();
        mantenimientoDepartamentos = new javax.swing.JPanel();
        imagenCargarSolicitud2 = new javax.swing.JLabel();
        textoCargarSolicitud2 = new javax.swing.JLabel();
        mantenimientoProfesores = new javax.swing.JPanel();
        imagenVerSolicitud2 = new javax.swing.JLabel();
        textoVerSolicitud2 = new javax.swing.JLabel();
        fondoMantenimientoIzquierda = new javax.swing.JPanel();
        cursosPanel = new javax.swing.JPanel();
        editarCursos = new javax.swing.JButton();
        eliminarCursos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCursos = new javax.swing.JTable();
        profesorPanel = new javax.swing.JPanel();
        editarProfesores = new javax.swing.JButton();
        eliminarProfesor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProfesores = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        gruposPanel = new javax.swing.JPanel();
        editarGrupos = new javax.swing.JButton();
        eliminarGrupos = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaGrupos = new javax.swing.JTable();
        departamentosPanel = new javax.swing.JPanel();
        editarDepartamentos = new javax.swing.JButton();
        eliminarDepartamentos = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaDepartamentos = new javax.swing.JTable();
        cerrar = new javax.swing.JPanel();
        cerrarTexto = new javax.swing.JLabel();
        minimizar = new javax.swing.JPanel();
        minimizarTexto = new javax.swing.JLabel();
        panelActividad = new javax.swing.JPanel();
        panelActividades = new javax.swing.JPanel();
        verPanelScroll1 = new javax.swing.JScrollPane();
        verPanelScrollFrame1 = new javax.swing.JPanel();
        solicitudBusquedaTxt1 = new javax.swing.JTextField();
        solicitudBusquedaBotonVerTodo1 = new javax.swing.JButton();
        solicitudBusquedaBoton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panelSolicitud = new javax.swing.JPanel();
        cargarSolicitudes = new javax.swing.JPanel();
        imagenCargarSolicitud = new javax.swing.JLabel();
        textoCargarSolicitud = new javax.swing.JLabel();
        verSolicitudes = new javax.swing.JPanel();
        imagenVerSolicitud = new javax.swing.JLabel();
        textoVerSolicitud = new javax.swing.JLabel();
        fondoSolicitudIzquierda = new javax.swing.JPanel();
        verPanel = new javax.swing.JPanel();
        verPanelScroll = new javax.swing.JScrollPane();
        verPanelScrollFrame = new javax.swing.JPanel();
        solicitudBusquedaTxt = new javax.swing.JTextField();
        solicitudBusquedaBotonVerTodo = new javax.swing.JButton();
        solicitudBusquedaBoton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cargarPanel = new javax.swing.JPanel();
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
        solicitudCargarGrupo = new javax.swing.JLabel();
        solicitudCargarTitulo = new javax.swing.JLabel();
        botonCargar = new javax.swing.JPanel();
        textoCargar = new javax.swing.JLabel();
        botonCancelarCarga = new javax.swing.JPanel();
        textoCancelar = new javax.swing.JLabel();
        textoLlenarTodoSolicitudCargar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        solicitudCargarTituloTxt1 = new javax.swing.JTextField();
        gruposSeleccion = new com.extra.ComboBoxMultiSelection();
        cursosSeleccion = new com.extra.ComboBoxMultiSelection();
        vehiculoON = new javax.swing.JRadioButton();
        vehiculoOFF = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        botonesAbajo = new javax.swing.JPanel();
        solicitudCargarPrevistaON = new javax.swing.JRadioButton();
        solicitudCargarPrevistaOFF = new javax.swing.JRadioButton();
        solicitudCargarFechaFinTxt = new javax.swing.JTextField();
        solicitudCargarFechaInicioTxt = new javax.swing.JTextField();
        solicitudCargarFechaInicio = new javax.swing.JLabel();
        solicitudCargarFechaFin = new javax.swing.JLabel();
        solicitudCargarProfesorResponsable = new javax.swing.JLabel();
        solicitudCargarProfesoresInvolucrados = new javax.swing.JLabel();
        solicitudCargarPrevista = new javax.swing.JLabel();
        profesoresInvolucrados = new com.extra.ComboBoxMultiSelection();
        profesorResponsable = new javax.swing.JComboBox<>();
        botonGrupos = new javax.swing.JRadioButton();
        botonCursos = new javax.swing.JRadioButton();
        textoCurso = new javax.swing.JLabel();
        textoGrupo = new javax.swing.JLabel();
        panelCargaDatos = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        panelUsuario = new javax.swing.JPanel();
        nombreUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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

        panelMantenimiento.setBackground(new java.awt.Color(40, 40, 40));
        panelMantenimiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mantenimientoCursos.setBackground(new java.awt.Color(51, 51, 51));
        mantenimientoCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mantenimientoCursos.setPreferredSize(new java.awt.Dimension(90, 80));
        mantenimientoCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mantenimientoCursosMousePressed(evt);
            }
        });

        imagenVerSolicitud1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/solicitud.png"))); // NOI18N

        textoVerSolicitud1.setForeground(new java.awt.Color(255, 255, 255));
        textoVerSolicitud1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoVerSolicitud1.setText("Cursos");
        textoVerSolicitud1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout mantenimientoCursosLayout = new javax.swing.GroupLayout(mantenimientoCursos);
        mantenimientoCursos.setLayout(mantenimientoCursosLayout);
        mantenimientoCursosLayout.setHorizontalGroup(
            mantenimientoCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mantenimientoCursosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoVerSolicitud1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mantenimientoCursosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenVerSolicitud1)
                .addGap(19, 19, 19))
        );
        mantenimientoCursosLayout.setVerticalGroup(
            mantenimientoCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mantenimientoCursosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenVerSolicitud1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoVerSolicitud1)
                .addContainerGap())
        );

        panelMantenimiento.add(mantenimientoCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 133, 91, -1));

        mantenimientoGrupos.setBackground(new java.awt.Color(51, 51, 51));
        mantenimientoGrupos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mantenimientoGrupos.setPreferredSize(new java.awt.Dimension(90, 80));
        mantenimientoGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mantenimientoGruposMousePressed(evt);
            }
        });

        imagenCargarSolicitud1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/solicitud.png"))); // NOI18N

        textoCargarSolicitud1.setForeground(new java.awt.Color(255, 255, 255));
        textoCargarSolicitud1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCargarSolicitud1.setText("Grupos");
        textoCargarSolicitud1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout mantenimientoGruposLayout = new javax.swing.GroupLayout(mantenimientoGrupos);
        mantenimientoGrupos.setLayout(mantenimientoGruposLayout);
        mantenimientoGruposLayout.setHorizontalGroup(
            mantenimientoGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mantenimientoGruposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoCargarSolicitud1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mantenimientoGruposLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenCargarSolicitud1)
                .addGap(19, 19, 19))
        );
        mantenimientoGruposLayout.setVerticalGroup(
            mantenimientoGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mantenimientoGruposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenCargarSolicitud1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoCargarSolicitud1)
                .addContainerGap())
        );

        panelMantenimiento.add(mantenimientoGrupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 223, 91, 80));

        mantenimientoDepartamentos.setBackground(new java.awt.Color(51, 51, 51));
        mantenimientoDepartamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mantenimientoDepartamentos.setPreferredSize(new java.awt.Dimension(90, 80));
        mantenimientoDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mantenimientoDepartamentosMousePressed(evt);
            }
        });

        imagenCargarSolicitud2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/solicitud.png"))); // NOI18N

        textoCargarSolicitud2.setForeground(new java.awt.Color(255, 255, 255));
        textoCargarSolicitud2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCargarSolicitud2.setText("Departamentos");
        textoCargarSolicitud2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout mantenimientoDepartamentosLayout = new javax.swing.GroupLayout(mantenimientoDepartamentos);
        mantenimientoDepartamentos.setLayout(mantenimientoDepartamentosLayout);
        mantenimientoDepartamentosLayout.setHorizontalGroup(
            mantenimientoDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mantenimientoDepartamentosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenCargarSolicitud2)
                .addGap(19, 19, 19))
            .addGroup(mantenimientoDepartamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoCargarSolicitud2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
        );
        mantenimientoDepartamentosLayout.setVerticalGroup(
            mantenimientoDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mantenimientoDepartamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenCargarSolicitud2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCargarSolicitud2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMantenimiento.add(mantenimientoDepartamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 313, 91, -1));

        mantenimientoProfesores.setBackground(new java.awt.Color(40, 40, 40));
        mantenimientoProfesores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mantenimientoProfesores.setPreferredSize(new java.awt.Dimension(90, 80));
        mantenimientoProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mantenimientoProfesoresMousePressed(evt);
            }
        });

        imagenVerSolicitud2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/solicitud.png"))); // NOI18N

        textoVerSolicitud2.setForeground(new java.awt.Color(255, 255, 255));
        textoVerSolicitud2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoVerSolicitud2.setText("Profesores");
        textoVerSolicitud2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout mantenimientoProfesoresLayout = new javax.swing.GroupLayout(mantenimientoProfesores);
        mantenimientoProfesores.setLayout(mantenimientoProfesoresLayout);
        mantenimientoProfesoresLayout.setHorizontalGroup(
            mantenimientoProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mantenimientoProfesoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoVerSolicitud2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mantenimientoProfesoresLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(imagenVerSolicitud2)
                .addGap(19, 19, 19))
        );
        mantenimientoProfesoresLayout.setVerticalGroup(
            mantenimientoProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mantenimientoProfesoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenVerSolicitud2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoVerSolicitud2)
                .addContainerGap())
        );

        panelMantenimiento.add(mantenimientoProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 43, 91, -1));

        fondoMantenimientoIzquierda.setBackground(new java.awt.Color(51, 51, 51));
        fondoMantenimientoIzquierda.setPreferredSize(new java.awt.Dimension(91, 160));

        javax.swing.GroupLayout fondoMantenimientoIzquierdaLayout = new javax.swing.GroupLayout(fondoMantenimientoIzquierda);
        fondoMantenimientoIzquierda.setLayout(fondoMantenimientoIzquierdaLayout);
        fondoMantenimientoIzquierdaLayout.setHorizontalGroup(
            fondoMantenimientoIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );
        fondoMantenimientoIzquierdaLayout.setVerticalGroup(
            fondoMantenimientoIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        panelMantenimiento.add(fondoMantenimientoIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 540));

        cursosPanel.setBackground(new java.awt.Color(40, 40, 40));

        editarCursos.setText("Editar");
        editarCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editarCursosMousePressed(evt);
            }
        });

        eliminarCursos.setText("Eliminar");
        eliminarCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eliminarCursosMousePressed(evt);
            }
        });

        tablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO DEL CURSO", "DESCRIPCION", "ETAPA", "ACTIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaCursos);

        profesorPanel.setBackground(new java.awt.Color(40, 40, 40));
        profesorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editarProfesores.setText("Editar");
        editarProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editarProfesoresMousePressed(evt);
            }
        });
        profesorPanel.add(editarProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, -1, -1));

        eliminarProfesor.setText("Eliminar");
        eliminarProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eliminarProfesorMousePressed(evt);
            }
        });
        profesorPanel.add(eliminarProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, -1, -1));

        tablaProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "CORREO", "NOMBRE COMPLETO", "ACTIVO", "PERFIL", "CONTRASEÑA", "DEPARTAMENTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProfesores);
        if (tablaProfesores.getColumnModel().getColumnCount() > 0) {
            tablaProfesores.getColumnModel().getColumn(5).setHeaderValue("PERFIL");
            tablaProfesores.getColumnModel().getColumn(6).setHeaderValue("CONTRASEÑA");
            tablaProfesores.getColumnModel().getColumn(7).setHeaderValue("DEPARTAMENTO");
        }

        profesorPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 640, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("falta: (editar en cursos, grupos y departamentos)");
        profesorPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        javax.swing.GroupLayout cursosPanelLayout = new javax.swing.GroupLayout(cursosPanel);
        cursosPanel.setLayout(cursosPanelLayout);
        cursosPanelLayout.setHorizontalGroup(
            cursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(cursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cursosPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(cursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(cursosPanelLayout.createSequentialGroup()
                            .addGap(250, 250, 250)
                            .addComponent(editarCursos)
                            .addGap(18, 18, 18)
                            .addComponent(eliminarCursos)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        cursosPanelLayout.setVerticalGroup(
            cursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(cursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cursosPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23)
                    .addGroup(cursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(editarCursos)
                        .addComponent(eliminarCursos))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelMantenimiento.add(cursosPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 850, 540));

        gruposPanel.setBackground(new java.awt.Color(40, 40, 40));

        editarGrupos.setText("Editar");
        editarGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editarGruposMousePressed(evt);
            }
        });

        eliminarGrupos.setText("Eliminar");
        eliminarGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eliminarGruposMousePressed(evt);
            }
        });

        tablaGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO DEL GRUPO", "CURSO", "NUMERO DE ALUMNOS", "ACTIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaGrupos);

        javax.swing.GroupLayout gruposPanelLayout = new javax.swing.GroupLayout(gruposPanel);
        gruposPanel.setLayout(gruposPanelLayout);
        gruposPanelLayout.setHorizontalGroup(
            gruposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(gruposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(gruposPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(gruposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(gruposPanelLayout.createSequentialGroup()
                            .addGap(250, 250, 250)
                            .addComponent(editarGrupos)
                            .addGap(18, 18, 18)
                            .addComponent(eliminarGrupos)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        gruposPanelLayout.setVerticalGroup(
            gruposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(gruposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(gruposPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23)
                    .addGroup(gruposPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(editarGrupos)
                        .addComponent(eliminarGrupos))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelMantenimiento.add(gruposPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 850, 540));

        departamentosPanel.setBackground(new java.awt.Color(40, 40, 40));

        editarDepartamentos.setText("Editar");
        editarDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editarDepartamentosMousePressed(evt);
            }
        });

        eliminarDepartamentos.setText("Eliminar");
        eliminarDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eliminarDepartamentosMousePressed(evt);
            }
        });

        tablaDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO DEL DEPARTAMENTO", "NOMBRE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaDepartamentos);

        javax.swing.GroupLayout departamentosPanelLayout = new javax.swing.GroupLayout(departamentosPanel);
        departamentosPanel.setLayout(departamentosPanelLayout);
        departamentosPanelLayout.setHorizontalGroup(
            departamentosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(departamentosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(departamentosPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(departamentosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(departamentosPanelLayout.createSequentialGroup()
                            .addGap(250, 250, 250)
                            .addComponent(editarDepartamentos)
                            .addGap(18, 18, 18)
                            .addComponent(eliminarDepartamentos)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        departamentosPanelLayout.setVerticalGroup(
            departamentosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(departamentosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(departamentosPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23)
                    .addGroup(departamentosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(editarDepartamentos)
                        .addComponent(eliminarDepartamentos))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelMantenimiento.add(departamentosPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 850, 540));

        principal.add(panelMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 940, 540));

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

        panelActividad.setBackground(new java.awt.Color(40, 40, 40));

        panelActividades.setBackground(new java.awt.Color(40, 40, 40));
        panelActividades.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verPanelScroll1.setBorder(null);
        verPanelScroll1.setForeground(new java.awt.Color(255, 255, 255));
        verPanelScroll1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        verPanelScroll1.setColumnHeaderView(null);
        verPanelScroll1.setOpaque(false);
        verPanelScroll1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                verPanelScroll1MouseWheelMoved(evt);
            }
        });

        verPanelScrollFrame1.setBackground(new java.awt.Color(40, 40, 40));
        verPanelScrollFrame1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        solicitudBusquedaTxt1.setBackground(new java.awt.Color(51, 51, 51));
        solicitudBusquedaTxt1.setForeground(new java.awt.Color(255, 255, 255));
        solicitudBusquedaTxt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                solicitudBusquedaTxt1KeyPressed(evt);
            }
        });
        verPanelScrollFrame1.add(solicitudBusquedaTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 290, 30));

        solicitudBusquedaBotonVerTodo1.setBackground(new java.awt.Color(51, 51, 51));
        solicitudBusquedaBotonVerTodo1.setForeground(new java.awt.Color(255, 255, 255));
        solicitudBusquedaBotonVerTodo1.setText("Ver todo");
        solicitudBusquedaBotonVerTodo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                solicitudBusquedaBotonVerTodo1MouseReleased(evt);
            }
        });
        verPanelScrollFrame1.add(solicitudBusquedaBotonVerTodo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, 30));

        solicitudBusquedaBoton1.setBackground(new java.awt.Color(51, 51, 51));
        solicitudBusquedaBoton1.setForeground(new java.awt.Color(255, 255, 255));
        solicitudBusquedaBoton1.setText("Buscar");
        solicitudBusquedaBoton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                solicitudBusquedaBoton1MouseReleased(evt);
            }
        });
        verPanelScrollFrame1.add(solicitudBusquedaBoton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, 30));

        jPanel2.setBackground(new java.awt.Color(40, 40, 40));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        verPanelScrollFrame1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 70));

        verPanelScroll1.setViewportView(verPanelScrollFrame1);

        panelActividades.add(verPanelScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 540));

        javax.swing.GroupLayout panelActividadLayout = new javax.swing.GroupLayout(panelActividad);
        panelActividad.setLayout(panelActividadLayout);
        panelActividadLayout.setHorizontalGroup(
            panelActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
            .addGroup(panelActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelActividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelActividadLayout.setVerticalGroup(
            panelActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
            .addGroup(panelActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelActividadLayout.createSequentialGroup()
                    .addComponent(panelActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        principal.add(panelActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 940, 540));

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
        textoCargarSolicitud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCargarSolicitud.setText("Cargar");
        textoCargarSolicitud.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cargarSolicitudesLayout = new javax.swing.GroupLayout(cargarSolicitudes);
        cargarSolicitudes.setLayout(cargarSolicitudesLayout);
        cargarSolicitudesLayout.setHorizontalGroup(
            cargarSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargarSolicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoCargarSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cargarSolicitudesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenCargarSolicitud)
                .addGap(19, 19, 19))
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
        textoVerSolicitud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoVerSolicitud.setText("Ver");
        textoVerSolicitud.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout verSolicitudesLayout = new javax.swing.GroupLayout(verSolicitudes);
        verSolicitudes.setLayout(verSolicitudesLayout);
        verSolicitudesLayout.setHorizontalGroup(
            verSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verSolicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoVerSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, verSolicitudesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenVerSolicitud)
                .addGap(19, 19, 19))
        );
        verSolicitudesLayout.setVerticalGroup(
            verSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verSolicitudesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenVerSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        verPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verPanelScroll.setBorder(null);
        verPanelScroll.setForeground(new java.awt.Color(255, 255, 255));
        verPanelScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        verPanelScroll.setColumnHeaderView(null);
        verPanelScroll.setOpaque(false);
        verPanelScroll.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                verPanelScrollMouseWheelMoved(evt);
            }
        });

        verPanelScrollFrame.setBackground(new java.awt.Color(40, 40, 40));
        verPanelScrollFrame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        solicitudBusquedaTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudBusquedaTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudBusquedaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                solicitudBusquedaTxtKeyPressed(evt);
            }
        });
        verPanelScrollFrame.add(solicitudBusquedaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 290, 30));

        solicitudBusquedaBotonVerTodo.setBackground(new java.awt.Color(51, 51, 51));
        solicitudBusquedaBotonVerTodo.setForeground(new java.awt.Color(255, 255, 255));
        solicitudBusquedaBotonVerTodo.setText("Ver todo");
        solicitudBusquedaBotonVerTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                solicitudBusquedaBotonVerTodoMouseReleased(evt);
            }
        });
        verPanelScrollFrame.add(solicitudBusquedaBotonVerTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, 30));

        solicitudBusquedaBoton.setBackground(new java.awt.Color(51, 51, 51));
        solicitudBusquedaBoton.setForeground(new java.awt.Color(255, 255, 255));
        solicitudBusquedaBoton.setText("Buscar");
        solicitudBusquedaBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                solicitudBusquedaBotonMouseReleased(evt);
            }
        });
        verPanelScrollFrame.add(solicitudBusquedaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, 30));

        jPanel1.setBackground(new java.awt.Color(40, 40, 40));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        verPanelScrollFrame.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 70));

        verPanelScroll.setViewportView(verPanelScrollFrame);

        verPanel.add(verPanelScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 540));

        panelSolicitud.add(verPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 850, 540));

        cargarPanel.setBackground(new java.awt.Color(40, 40, 40));
        cargarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        solicitudCargarGrupo.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarGrupo.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarGrupo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarGrupo.setText("Grupos/Cursos (separados por comas)");
        cargarPanel.add(solicitudCargarGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 253, 250, -1));

        solicitudCargarTitulo.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarTitulo.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarTitulo.setText("Título");
        cargarPanel.add(solicitudCargarTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 71, 50, -1));

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
            .addGroup(botonCargarLayout.createSequentialGroup()
                .addComponent(textoCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        botonCargarLayout.setVerticalGroup(
            botonCargarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoCargar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        cargarPanel.add(botonCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, -1, 30));

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
            .addComponent(textoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        botonCancelarCargaLayout.setVerticalGroup(
            botonCancelarCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        cargarPanel.add(botonCancelarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 83, 30));

        textoLlenarTodoSolicitudCargar.setBackground(new java.awt.Color(40, 40, 40));
        textoLlenarTodoSolicitudCargar.setForeground(new java.awt.Color(255, 0, 0));
        cargarPanel.add(textoLlenarTodoSolicitudCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 200, -1));

        jButton1.setText("rellenar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        cargarPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, -1, -1));

        solicitudCargarTituloTxt1.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarTituloTxt1.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarTituloTxt1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarPanel.add(solicitudCargarTituloTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 71, 187, -1));
        cargarPanel.add(gruposSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 187, 20));
        cargarPanel.add(cursosSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 187, 20));

        vehiculo.add(vehiculoON);
        vehiculoON.setForeground(new java.awt.Color(255, 255, 255));
        vehiculoON.setText("Si");
        cargarPanel.add(vehiculoON, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 97, -1, -1));

        vehiculo.add(vehiculoOFF);
        vehiculoOFF.setForeground(new java.awt.Color(255, 255, 255));
        vehiculoOFF.setText("No");
        cargarPanel.add(vehiculoOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 97, -1, 20));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("falta: (profesor responsable) (profesores involucrados)");
        cargarPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        botonesAbajo.setOpaque(false);
        botonesAbajo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        actividadPrevista.add(solicitudCargarPrevistaON);
        solicitudCargarPrevistaON.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarPrevistaON.setText("Prevista");
        solicitudCargarPrevistaON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitudCargarPrevistaONActionPerformed(evt);
            }
        });
        botonesAbajo.add(solicitudCargarPrevistaON, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 104, -1, -1));

        actividadPrevista.add(solicitudCargarPrevistaOFF);
        solicitudCargarPrevistaOFF.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarPrevistaOFF.setText("No Prevista");
        botonesAbajo.add(solicitudCargarPrevistaOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 104, -1, -1));

        solicitudCargarFechaFinTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarFechaFinTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarFechaFinTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonesAbajo.add(solicitudCargarFechaFinTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 26, 187, -1));

        solicitudCargarFechaInicioTxt.setBackground(new java.awt.Color(51, 51, 51));
        solicitudCargarFechaInicioTxt.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarFechaInicioTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonesAbajo.add(solicitudCargarFechaInicioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 187, -1));

        solicitudCargarFechaInicio.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarFechaInicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarFechaInicio.setText("Fecha Inicio Actividad (YYYY-MM-DD)");
        botonesAbajo.add(solicitudCargarFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 230, -1));

        solicitudCargarFechaFin.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarFechaFin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarFechaFin.setText("Fecha Fin Actividad (YYYY-MM-DD)");
        botonesAbajo.add(solicitudCargarFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 26, 220, -1));

        solicitudCargarProfesorResponsable.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarProfesorResponsable.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarProfesorResponsable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarProfesorResponsable.setText("Profesor Responsable");
        botonesAbajo.add(solicitudCargarProfesorResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 52, 220, -1));

        solicitudCargarProfesoresInvolucrados.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarProfesoresInvolucrados.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarProfesoresInvolucrados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarProfesoresInvolucrados.setText("Profesores Involucrados");
        botonesAbajo.add(solicitudCargarProfesoresInvolucrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 78, 220, -1));

        solicitudCargarPrevista.setBackground(new java.awt.Color(40, 40, 40));
        solicitudCargarPrevista.setForeground(new java.awt.Color(255, 255, 255));
        solicitudCargarPrevista.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudCargarPrevista.setText("Actividad Prevista");
        botonesAbajo.add(solicitudCargarPrevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 104, 120, -1));
        botonesAbajo.add(profesoresInvolucrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 187, 20));

        botonesAbajo.add(profesorResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 52, 187, 20));

        cargarPanel.add(botonesAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 610, 190));

        gruposCursos.add(botonGrupos);
        botonGrupos.setForeground(new java.awt.Color(255, 255, 255));
        botonGrupos.setText("Grupos");
        botonGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonGruposMousePressed(evt);
            }
        });
        cargarPanel.add(botonGrupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 253, -1, -1));

        gruposCursos.add(botonCursos);
        botonCursos.setForeground(new java.awt.Color(255, 255, 255));
        botonCursos.setText("Cursos");
        botonCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonCursosMousePressed(evt);
            }
        });
        cargarPanel.add(botonCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 253, -1, -1));

        textoCurso.setForeground(new java.awt.Color(255, 255, 255));
        textoCurso.setText("Cursos");
        cargarPanel.add(textoCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        textoGrupo.setForeground(new java.awt.Color(255, 255, 255));
        textoGrupo.setText("Grupos");
        cargarPanel.add(textoGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        panelSolicitud.add(cargarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 850, 540));

        principal.add(panelSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 940, 540));

        panelCargaDatos.setBackground(new java.awt.Color(40, 40, 40));

        jButton2.setText("CargarDatos");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCargaDatosLayout = new javax.swing.GroupLayout(panelCargaDatos);
        panelCargaDatos.setLayout(panelCargaDatosLayout);
        panelCargaDatosLayout.setHorizontalGroup(
            panelCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaDatosLayout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
        );
        panelCargaDatosLayout.setVerticalGroup(
            panelCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaDatosLayout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        principal.add(panelCargaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 940, 540));

        panelUsuario.setBackground(new java.awt.Color(40, 40, 40));

        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreUsuario.setText("Profesor");
        nombreUsuario.setMaximumSize(new java.awt.Dimension(100, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/logoutBlanco.png"))); // NOI18N
        jLabel2.setText("Cerrar Sesión");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelUsuarioLayout = new javax.swing.GroupLayout(panelUsuario);
        panelUsuario.setLayout(panelUsuarioLayout);
        panelUsuarioLayout.setHorizontalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addGroup(panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUsuarioLayout.createSequentialGroup()
                        .addGap(426, 426, 426)
                        .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelUsuarioLayout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jLabel2)))
                .addContainerGap(416, Short.MAX_VALUE))
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        principal.add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 940, 540));

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

        solicitud.setBackground(new java.awt.Color(51, 51, 51));
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

        mantenimiento.setBackground(new java.awt.Color(40, 40, 40));
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

    private void editProfesor(int id, String dni, String correo, String nombreCompleto, boolean activo, String perfil, String contraseña, int departamento) {
        String[] partesNombre = nombreCompleto.split("\\s+");
        String nombre = partesNombre[0];
        String apellidos = (partesNombre.length > 1) ? partesNombre[1] : "";

        funcionesBD.actualizarDatosProfesor(id, dni, correo, nombre, apellidos, activo, perfil, contraseña, departamento);
        mantenimientoProfesoresMousePressed(null);
    }

    private void abrirMenu(JPanel panel, JPanel boton) {
        JPanel[] botones = {actividad, mantenimiento, solicitud, cargaDatos, usuario};
        activo.setVisible(false);
        panel.setVisible(true);
        activo = panel;

        boton.setBackground(new Color(40, 40, 40));
        for (JPanel botonNoActivo : botones) {
            if (!botonNoActivo.equals(boton)) {
                botonNoActivo.setBackground(new Color(51, 51, 51));
            }
        }

        principal.revalidate();
        principal.repaint();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
    }

    private void abrirMenuMantenimiento(JPanel panel, JPanel boton) {
        JPanel[] botones = {mantenimientoProfesores, mantenimientoCursos, mantenimientoGrupos, mantenimientoDepartamentos};
        activoMantenimiento.setVisible(false);
        panel.setVisible(true);
        activoMantenimiento = panel;

        boton.setBackground(new Color(40, 40, 40));
        for (JPanel botonNoActivo : botones) {
            if (!botonNoActivo.equals(boton)) {
                botonNoActivo.setBackground(new Color(51, 51, 51));
            }
        }

        panelMantenimiento.revalidate();
        panelMantenimiento.repaint();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
    }

    private void abrirMenuSolicitud(JPanel panel, JPanel boton) {
        JPanel[] botones = {cargarSolicitudes, verSolicitudes};
        activoSolicitud.setVisible(false);
        panel.setVisible(true);
        activoSolicitud = panel;

        boton.setBackground(new Color(40, 40, 40));
        for (JPanel botonNoActivo : botones) {
            if (!botonNoActivo.equals(boton)) {
                botonNoActivo.setBackground(new Color(51, 51, 51));
            }
        }

        panelSolicitud.revalidate();
        panelSolicitud.repaint();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
    }

    private int insertarSolicitud(int medioTransporte, int departamento, String comentarios, int alojamiento,
            int numeroAlumnos, String estado, int gruposCurso, String fechaInicio,
            String fechaFin, int prevista, String titulo) {
        int idSolicitud = -1; // Inicializar la ID de solicitud como -1 por defecto
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
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, medioTransporte);
            statement.setInt(2, departamento);
            statement.setString(3, comentarios);
            statement.setInt(4, alojamiento);
            statement.setInt(5, numeroAlumnos);
            statement.setString(6, estado);
            statement.setInt(7, gruposCurso);
            statement.setString(8, fechaInicio);
            statement.setString(9, fechaFin);
            statement.setInt(10, prevista);
            statement.setString(11, titulo);

            // Ejecutar la inserción
            statement.executeUpdate();

            // Obtener las claves generadas
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                idSolicitud = generatedKeys.getInt(1); // Obtener la primera columna generada, que sería la ID de la solicitud
            }

            generatedKeys.close(); // Cerrar el ResultSet
            statement.close(); // Cerrar el PreparedStatement

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al insertar la solicitud en la base de datos: " + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }

        return idSolicitud;
    }

    private void crearPanelesSolicitud(String textoBusqueda) {
        System.out.println("Iniciando creación de paneles de solicitud...");

        // Guardar referencias a los componentes que no deseas borrar
        Component[] componentesNoBorrables = {solicitudBusquedaTxt, solicitudBusquedaBotonVerTodo, solicitudBusquedaBoton};

        // Limpiar el verPanelScrollFrame1 antes de crear los nuevos paneles
        for (Component componente : verPanelScrollFrame.getComponents()) {
            boolean borrar = true;
            for (Component noBorrable : componentesNoBorrables) {
                if (componente == noBorrable) {
                    borrar = false;
                    break;
                }
            }
            if (borrar) {
                verPanelScrollFrame.remove(componente);
            }
        }

        // Calcular la posición vertical inicial
        int ultimaPosicion = 80;
        // Iterar sobre todas las solicitudes y crear los paneles que coincidan con la búsqueda
        List<Solicitud> solicitudes = funcionesBD.obtenerTodasLasSolicitudes();
        System.out.println("Número de solicitudes obtenidas: " + solicitudes.size());
        for (Solicitud solicitud : solicitudes) {
            String tituloSolicitud = solicitud.getTitulo();

            if (tituloSolicitud != null && tituloSolicitud.toLowerCase().contains(textoBusqueda.toLowerCase())) {
                String estadoSolicitud = solicitud.getEstado();

                if (estadoSolicitud != null && estadoSolicitud.equals("Pendiente")) {
                    System.out.println("Creando panel para solicitud: " + solicitud.getId());
                    JPanel solicitudPanel = new JPanel();
                    solicitudPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                    verPanelScrollFrame.add(solicitudPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, ultimaPosicion, 750, 80));

                    // Crear el JLabel para el título de la solicitud
                    JLabel tituloLabel = new JLabel(tituloSolicitud);
                    solicitudPanel.add(tituloLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

                    // Crear botones
                    if (user.getPerfil().equals("EquipoAdministrativo") || user.getPerfil().equals("Administrador")) {
                        JButton aceptarBtn = new JButton("Aceptar");
                        JButton noAceptarBtn = new JButton("No Aceptar");

                        // Agregar funcionalidad a los botones
                        aceptarBtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(null, "¡Has aceptado!");
                            }
                        });

                        noAceptarBtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(null, "¡No has aceptado!");
                            }
                        });

                        // Agregar los botones al JPanel
                        solicitudPanel.add(aceptarBtn);
                        solicitudPanel.add(noAceptarBtn);
                    }

                    // Asignar un nombre dinámico al panel
                    solicitudPanel.setName("solicitud" + solicitud.getId());

                    // Incrementar la posición vertical para el siguiente panel
                    ultimaPosicion += 100;
                }
            }
        }

        // Añadir un panel de relleno al final para mantener el espacio
        JPanel solicitudRelleno = new JPanel();
        solicitudRelleno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        solicitudRelleno.setBackground(new Color(0, 0, 0, 0)); // Color transparente
        verPanelScrollFrame.add(solicitudRelleno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, ultimaPosicion - 20, 850, 20));

        // Refrescar la interfaz gráfica para que los cambios sean visibles después de agregar los nuevos paneles de solicitud
        verPanelScrollFrame.revalidate();
        verPanelScrollFrame.repaint();

        System.out.println("Creación de paneles de solicitud completada.");
    }

    private void crearPanelesActividad(String textoBusqueda) {
        // Guardar referencias a los componentes que no deseas borrar
        Component[] componentesNoBorrables = {solicitudBusquedaTxt1, solicitudBusquedaBotonVerTodo1, solicitudBusquedaBoton1};

        // Limpiar el verPanelScrollFrame antes de crear los nuevos paneles
        for (Component componente : verPanelScrollFrame1.getComponents()) {
            boolean borrar = true;
            for (Component noBorrable : componentesNoBorrables) {
                if (componente == noBorrable) {
                    borrar = false;
                    break;
                }
            }
            if (borrar) {
                verPanelScrollFrame1.remove(componente);
            }
        }

        // Calcular la posición vertical inicial
        int ultimaPosicion = 80;

        // Iterar sobre todas las solicitudes y crear los paneles que coincidan con la búsqueda
        List<Solicitud> solicitudes = funcionesBD.obtenerTodasLasSolicitudes();
        for (Solicitud solicitud : solicitudes) {
            String tituloSolicitud = solicitud.getTitulo();

            if (tituloSolicitud != null && tituloSolicitud.toLowerCase().contains(textoBusqueda.toLowerCase())) {
                String estadoSolicitud = solicitud.getEstado();

                if (estadoSolicitud != null && estadoSolicitud.equals("Aceptada")) {
                    JPanel solicitudPanel = new JPanel();
                    solicitudPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                    verPanelScrollFrame1.add(solicitudPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, ultimaPosicion, 750, 80));

                    // Crear el JLabel para el título de la solicitud
                    JLabel tituloLabel = new JLabel(tituloSolicitud);
                    solicitudPanel.add(tituloLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
                    // Asignar un nombre dinámico al panel
                    solicitudPanel.setName("solicitud" + solicitud.getId());

                    // Incrementar la posición vertical para el siguiente panel
                    ultimaPosicion += 100;
                }
            }
        }

        // Añadir un panel de relleno al final para mantener el espacio
        JPanel solicitudRelleno = new JPanel();
        solicitudRelleno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        solicitudRelleno.setBackground(new Color(0, 0, 0, 0)); // Color transparente
        verPanelScrollFrame1.add(solicitudRelleno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, ultimaPosicion - 20, 850, 20));

        // Refrescar la interfaz gráfica para que los cambios sean visibles después de agregar los nuevos paneles de solicitud
        verPanelScrollFrame1.revalidate();
        verPanelScrollFrame1.repaint();
    }

    private void testData(JComboBox combo) {
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Sin Desplazamiento",
            "Andando",
            "Bici",
            "Autobus",
            "Taxi",
            "Tren",
            "Barco",
            "Avion"
        }));
    }

    private void ponerProfesores(JComboBox combo) {
        profesores = funcionesBD.obtenerListaProfesores();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Profesor profesor : profesores) {
            model.addElement(profesor.getNombreCompleto());
        }
        combo.setModel(model);
    }

    private void cargarGrupos(JComboBox combo) {
        ArrayList<Grupo> grupos = funcionesBD.obtenerListaGrupos();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Grupo grupo : grupos) {
            model.addElement(grupo.getCodgrupo());
        }
        combo.setModel(model);
    }

    private void cargarCursos(JComboBox combo) {
        ArrayList<Curso> cursos = funcionesBD.obtenerListaCursos();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Curso curso : cursos) {
            model.addElement(curso.getCodcurso());
        }
        combo.setModel(model);
    }


    private void cargaDatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargaDatosMousePressed
        abrirMenu(panelCargaDatos, cargaDatos);
    }//GEN-LAST:event_cargaDatosMousePressed

    private void mantenimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mantenimientoMousePressed
        abrirMenu(panelMantenimiento, mantenimiento);
    }//GEN-LAST:event_mantenimientoMousePressed

    private void solicitudMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_solicitudMousePressed
        abrirMenu(panelSolicitud, solicitud);
    }//GEN-LAST:event_solicitudMousePressed

    private void actividadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actividadMousePressed
        abrirMenu(panelActividad, actividad);
        crearPanelesActividad("");
        verPanelScroll.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.VERTICAL);
        verPanelScroll.setVerticalScrollBar(sp);
    }//GEN-LAST:event_actividadMousePressed

    private void usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMousePressed
        abrirMenu(panelUsuario, usuario);
        nombreUsuario.setText(funcionesBD.getNombreProfesor(user));
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
        abrirMenuSolicitud(cargarPanel, cargarSolicitudes);
        testData(gruposSeleccion);

        for (Profesor profesor : funcionesBD.obtenerListaProfesores()) {
            profesorResponsable.addItem(profesor.getNombreCompleto());
        }
        ponerProfesores(profesoresInvolucrados);
    }//GEN-LAST:event_cargarSolicitudesMousePressed

    private void verSolicitudesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verSolicitudesMousePressed
        cargarSolicitudes.setBackground(new Color(51, 51, 51));
        verSolicitudes.setBackground(new Color(40, 40, 40));
        abrirMenuSolicitud(verPanel, verSolicitudes);
        crearPanelesSolicitud("");
        verPanelScroll.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.VERTICAL);
        verPanelScroll.setVerticalScrollBar(sp);
    }//GEN-LAST:event_verSolicitudesMousePressed

    private void textoCargarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoCargarMouseReleased
        try {

            //ParaActvidad
            int medioTransporte = 0;
//            for (Object objeto : comboBoxMultiSelection1.getSelectedItems()) {
//                if (!objeto.equals("Sin Desplazamiento")) {
//                    medioTransporte = 1;
//                    break;
//                }
//            }

            cursosSeleccion.getSelectedItems();

            String[] grupoCurso;
            if (gruposCursos.getSelection().equals(botonGrupos)) {
                List<String> seleccion = gruposSeleccion.getSelectedItems();
                grupoCurso = seleccion.toArray(new String[seleccion.size()]);
            } else {
                List<String> seleccion = cursosSeleccion.getSelectedItems();
                grupoCurso = seleccion.toArray(new String[seleccion.size()]);
            }

            int departamento = Integer.parseInt(solicitudCargarDepartamentoTxt.getText());
            String comentarios = solicitudCargarComentariosTxt.getText();
            int alojamiento = Integer.parseInt(solicitudCargarAlojamientoTxt.getText());
            int numeroAlumnos = Integer.parseInt(solicitudCargarAlumnosTxt.getText());
            String estado = solicitudCargarEstadoTxt.getText();
            String fechaInicio = solicitudCargarFechaInicioTxt.getText();
            String fechaFin = solicitudCargarFechaFinTxt.getText();
            String titulo = solicitudCargarTituloTxt1.getText();
            int prevista;
            int gruposCurso = 0;
            if (botonGrupos.isSelected()) {
                gruposCurso = 0;
            } else {
                gruposCurso = 1;
            }

            ButtonModel selectedModelVehiculo = vehiculo.getSelection();

            if (selectedModelVehiculo == null) {
                throw new Exception("Error: Seleccione si hay vehiculo o no.");
            } else {
                if (selectedModelVehiculo.equals(vehiculoON.getModel())) {
                    medioTransporte = 1;
                } else if (selectedModelVehiculo.equals(vehiculoOFF.getModel())) {
                    medioTransporte = 0;
                } else {
                    throw new Exception("Error: Seleccione si hay vehiculo o no.");
                }
            }

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
                int idSolicitud = insertarSolicitud(medioTransporte, departamento, comentarios, alojamiento, numeroAlumnos, estado,
                        gruposCurso, fechaInicio, fechaFin, prevista, titulo);

                if (botonGrupos.isSelected()) {
                    for (Object objeto : gruposSeleccion.getSelectedItems()) {
                        String grupo = (String) objeto;
                        funcionesBD.insertarGrupo(idSolicitud, funcionesBD.getGrupo(grupo));
                    }
                } else {
                    for (Object objeto : cursosSeleccion.getSelectedItems()) {
                        String curso = (String) objeto;
                        funcionesBD.insertarCurso(idSolicitud, funcionesBD.getCurso(curso));
                    }
                }

                int idProfesor = -1;

                for (Profesor profesor : profesores) {
                    if (profesor.getNombreCompleto().equals((String) profesorResponsable.getSelectedItem().toString())) {
                        idProfesor = profesor.getId();
                    }
                }
                if (idProfesor > -1) {
                    funcionesBD.inseretarProfesor(idProfesor, idSolicitud, "Represntante");
                }

                for (Profesor profesor : profesores) {
                    idProfesor = profesor.getId();
                    funcionesBD.inseretarProfesor(idProfesor, idSolicitud, "Participante");
                }

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
        gruposSeleccion.setSelectedItems(new ArrayList<>());
        solicitudCargarDepartamentoTxt.setText("");
        solicitudCargarComentariosTxt.setText("");
        solicitudCargarAlojamientoTxt.setText("");
        solicitudCargarAlumnosTxt.setText("");
        solicitudCargarEstadoTxt.setText("");
        solicitudCargarFechaInicioTxt.setText("");
        solicitudCargarFechaFinTxt.setText("");
        actividadPrevista.clearSelection();
    }//GEN-LAST:event_textoCancelarMouseReleased

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        Random rand = new Random();

        // Números aleatorios de 0 a 50
        solicitudCargarDepartamentoTxt.setText(String.valueOf(rand.nextInt(51)));
        solicitudCargarAlojamientoTxt.setText(String.valueOf(rand.nextInt(51)));
        solicitudCargarAlumnosTxt.setText(String.valueOf(rand.nextInt(51)));

        // Letras aleatorias de 'a' a 'z'
        solicitudCargarComentariosTxt.setText(generarLetrasAleatorias(rand, 10)); // 10 letras
        solicitudCargarEstadoTxt.setText(generarLetrasAleatorias(rand, 8)); // 8 letras

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

    private void solicitudCargarPrevistaONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitudCargarPrevistaONActionPerformed

    }//GEN-LAST:event_solicitudCargarPrevistaONActionPerformed

    private void solicitudBusquedaBotonVerTodoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_solicitudBusquedaBotonVerTodoMouseReleased
        crearPanelesSolicitud("");
        solicitudBusquedaTxt.setText("");
    }//GEN-LAST:event_solicitudBusquedaBotonVerTodoMouseReleased

    private void solicitudBusquedaBotonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_solicitudBusquedaBotonMouseReleased
        crearPanelesSolicitud(solicitudBusquedaTxt.getText());
    }//GEN-LAST:event_solicitudBusquedaBotonMouseReleased

    private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased
        Login login = new Login();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseReleased

    private void solicitudBusquedaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_solicitudBusquedaTxtKeyPressed

    }//GEN-LAST:event_solicitudBusquedaTxtKeyPressed

    private void verPanelScrollMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_verPanelScrollMouseWheelMoved
        // Obtener la posición actual del scroll
        int currentValue = verPanelScroll.getVerticalScrollBar().getValue();

        // Calcular el desplazamiento
        int units = evt.getUnitsToScroll();

        // Establecer la nueva posición del scroll
        verPanelScroll.getVerticalScrollBar().setValue(currentValue + units * 20); // Ajustar el valor "20" según la velocidad deseada
    }//GEN-LAST:event_verPanelScrollMouseWheelMoved

    private void mantenimientoCursosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mantenimientoCursosMousePressed
        abrirMenuMantenimiento(cursosPanel, mantenimientoCursos);
        MantenimientosBasicos mantenimientosBasicos = new MantenimientosBasicos();
        mantenimientosBasicos.mantenimientoCursos(tablaCursos, cursosPanel);
    }//GEN-LAST:event_mantenimientoCursosMousePressed

    private void mantenimientoGruposMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mantenimientoGruposMousePressed
        abrirMenuMantenimiento(gruposPanel, mantenimientoGrupos);
        MantenimientosBasicos mantenimientosBasicos = new MantenimientosBasicos();
        mantenimientosBasicos.mantenimientoGrupos(tablaGrupos, gruposPanel);
    }//GEN-LAST:event_mantenimientoGruposMousePressed

    private void mantenimientoDepartamentosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mantenimientoDepartamentosMousePressed
        abrirMenuMantenimiento(departamentosPanel, mantenimientoDepartamentos);
        MantenimientosBasicos mantenimientosBasicos = new MantenimientosBasicos();
        mantenimientosBasicos.mantenimientoDepartamentos(tablaDepartamentos, departamentosPanel);
    }//GEN-LAST:event_mantenimientoDepartamentosMousePressed

    private void mantenimientoProfesoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mantenimientoProfesoresMousePressed
        abrirMenuMantenimiento(profesorPanel, mantenimientoProfesores);
        MantenimientosBasicos mantenimientosBasicos = new MantenimientosBasicos();
        mantenimientosBasicos.mantenimientoProfesores(tablaProfesores, profesorPanel);
    }//GEN-LAST:event_mantenimientoProfesoresMousePressed

    private void editarProfesoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarProfesoresMousePressed
        int selectedRow = tablaProfesores.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un profesor para editar.");
            return;
        }
        TableModel tableModel = tablaProfesores.getModel();
        // Verificar si el modelo de tabla no está vacío y si la fila seleccionada es válida
        if (tableModel != null && selectedRow >= 0 && selectedRow < tableModel.getRowCount()) {
            String idStr = tableModel.getValueAt(selectedRow, 0).toString();
            String dni = JOptionPane.showInputDialog(this, "Nuevo DNI del profesor:", tableModel.getValueAt(selectedRow, 1));
            String correo = JOptionPane.showInputDialog(this, "Nuevo Correo del profesor:", tableModel.getValueAt(selectedRow, 2));
            String nombreCompleto = JOptionPane.showInputDialog(this, "Nuevo Nombre completo del profesor:", tableModel.getValueAt(selectedRow, 3));
            String activoStr = JOptionPane.showInputDialog(this, "Activo (1 para sí, 0 para no):", tableModel.getValueAt(selectedRow, 4));
            boolean activo = (activoStr != null && activoStr.equals("1"));
            String perfil = JOptionPane.showInputDialog(this, "Nuevo Perfil del profesor:", tableModel.getValueAt(selectedRow, 5));
            String contraseña = JOptionPane.showInputDialog(this, "Nueva Contraseña del profesor:", tableModel.getValueAt(selectedRow, 6));
            String departamentoStr = JOptionPane.showInputDialog(this, "Nuevo ID del departamento:", tableModel.getValueAt(selectedRow, 7));

            if (dni != null && correo != null && nombreCompleto != null && perfil != null && contraseña != null && departamentoStr != null) {
                int id = Integer.parseInt(idStr);
                int departamento = Integer.parseInt(departamentoStr);
                editProfesor(id, dni, correo, nombreCompleto, activo, perfil, contraseña, departamento);
            }
        } else {
            // Manejar el caso en el que el modelo de tabla está vacío o la fila seleccionada no es válida
            JOptionPane.showMessageDialog(this, "No se puede editar la fila seleccionada.");
        }
    }//GEN-LAST:event_editarProfesoresMousePressed

    private void eliminarProfesorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarProfesorMousePressed
        int selectedRow = tablaProfesores.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un profesor para eliminar.");
            return;
        }
        TableModel tableModel = tablaProfesores.getModel();
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar el profesor seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            int id = (int) tableModel.getValueAt(selectedRow, 0); // Suponiendo que el ID del profesor está en la columna 0
            funcionesBD.eliminarProfesor(id);
            mantenimientoProfesoresMousePressed(null);
        }
    }//GEN-LAST:event_eliminarProfesorMousePressed

    private void editarCursosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarCursosMousePressed
        int selectedRow = tablaCursos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un curso para editar.");
            return;
        }
        TableModel tableModel = tablaCursos.getModel();
        // Verificar si el modelo de tabla no está vacío y si la fila seleccionada es válida
        if (tableModel != null && selectedRow >= 0 && selectedRow < tableModel.getRowCount()) {
            String idStr = tableModel.getValueAt(selectedRow, 0).toString();
            String nuevoCodCurso = tableModel.getValueAt(selectedRow, 1).toString(); // Suponiendo que el código de curso está en la columna 1
            String nuevaEtapa = JOptionPane.showInputDialog(this, "Nueva Etapa del curso:", tableModel.getValueAt(selectedRow, 2));
            String nuevaDescripcion = JOptionPane.showInputDialog(this, "Nueva Descripción del curso:", tableModel.getValueAt(selectedRow, 3));
            String nuevoActivoStr = JOptionPane.showInputDialog(this, "Nuevo Estado del curso (1 para activo, 0 para inactivo):", tableModel.getValueAt(selectedRow, 4));

            if (nuevaEtapa != null && nuevaDescripcion != null && nuevoActivoStr != null) {
                int id = Integer.parseInt(idStr);
                boolean activo = nuevoActivoStr.equals("1");
                funcionesBD.modificarDatosCurso(id, nuevoCodCurso, nuevaEtapa, nuevaDescripcion, activo);
                mantenimientoCursosMousePressed(null);
            }
        } else {
            // Manejar el caso en el que el modelo de tabla está vacío o la fila seleccionada no es válida
            JOptionPane.showMessageDialog(this, "No se puede editar la fila seleccionada.");
        }
        mantenimientoCursosMousePressed(null);
    }//GEN-LAST:event_editarCursosMousePressed

    private void eliminarCursosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarCursosMousePressed
        int selectedRow = tablaCursos.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tablaCursos.getValueAt(selectedRow, 0);
            // Aquí puedes mostrar un mensaje de confirmación antes de eliminar el curso
            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro que desea eliminar este curso?", "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                funcionesBD.eliminarCurso(id);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Por favor, seleccione un curso para eliminar.",
                    "Eliminar Curso", JOptionPane.WARNING_MESSAGE);
        }
        mantenimientoCursosMousePressed(null);
    }//GEN-LAST:event_eliminarCursosMousePressed

    private void editarGruposMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarGruposMousePressed
        int selectedRow = tablaGrupos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un grupo para editar.");
            return;
        }
        DefaultTableModel tableModel = (DefaultTableModel) tablaGrupos.getModel();
        // Verificar si el modelo de tabla no está vacío y si la fila seleccionada es válida
        if (tableModel != null && selectedRow >= 0 && selectedRow < tableModel.getRowCount()) {
            String idStr = tableModel.getValueAt(selectedRow, 0).toString();
            String nuevoCodGrupo = JOptionPane.showInputDialog(this, "Nuevo Código de Grupo:", tableModel.getValueAt(selectedRow, 1));
            String nuevoCursoStr = JOptionPane.showInputDialog(this, "Nuevo Curso:", tableModel.getValueAt(selectedRow, 2));
            String nuevoNumAlumnosStr = JOptionPane.showInputDialog(this, "Nuevo Número de Alumnos:", tableModel.getValueAt(selectedRow, 3));
            String nuevoActivoStr = JOptionPane.showInputDialog(this, "Nuevo Estado del Grupo (1 para activo, 0 para inactivo):", tableModel.getValueAt(selectedRow, 4));

            if (nuevoCodGrupo != null && nuevoCursoStr != null && nuevoNumAlumnosStr != null && nuevoActivoStr != null) {
                int id = Integer.parseInt(idStr);
                int nuevoCurso = Integer.parseInt(nuevoCursoStr);
                int nuevoNumAlumnos = Integer.parseInt(nuevoNumAlumnosStr);
                boolean nuevoActivo = nuevoActivoStr.equals("1");
                funcionesBD.actualizarDatosGrupo(id, nuevoCodGrupo, nuevoCurso, nuevoNumAlumnos, nuevoActivo);
            }
        } else {
            // Manejar el caso en el que el modelo de tabla está vacío o la fila seleccionada no es válida
            JOptionPane.showMessageDialog(this, "No se puede editar la fila seleccionada.");
        }
        mantenimientoGruposMousePressed(null); // Actualiza la tabla de grupos después de la edición
    }//GEN-LAST:event_editarGruposMousePressed

    private void eliminarGruposMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarGruposMousePressed
        int selectedRow = tablaGrupos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un grupo para eliminar.");
            return;
        }
        DefaultTableModel tableModel = (DefaultTableModel) tablaGrupos.getModel();
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar el grupo seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            int id = (int) tableModel.getValueAt(selectedRow, 0); // Suponiendo que el ID del grupo está en la columna 0
            funcionesBD.eliminarGrupo(id);
            // Remover la fila seleccionada del modelo de la tabla
            JOptionPane.showMessageDialog(this, "Grupo eliminado correctamente.");
            mantenimientoGruposMousePressed(null); // Actualiza la tabla de grupos después de la edición
        }
    }//GEN-LAST:event_eliminarGruposMousePressed

    private void editarDepartamentosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarDepartamentosMousePressed
        int selectedRow = tablaDepartamentos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un departamento para editar.");
            return;
        }
        DefaultTableModel tableModel = (DefaultTableModel) tablaDepartamentos.getModel();
        // Verificar si el modelo de tabla no está vacío y si la fila seleccionada es válida
        if (tableModel != null && selectedRow >= 0 && selectedRow < tableModel.getRowCount()) {
            String idStr = tableModel.getValueAt(selectedRow, 0).toString();
            String nuevoCodigo = JOptionPane.showInputDialog(this, "Nuevo Código del departamento:", tableModel.getValueAt(selectedRow, 1));
            String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo Nombre del departamento:", tableModel.getValueAt(selectedRow, 2));

            if (nuevoCodigo != null && nuevoNombre != null) {
                int id = Integer.parseInt(idStr);
                funcionesBD.actualizarDatosDepartamento(id, nuevoCodigo, nuevoNombre);
            }
        } else {
            // Manejar el caso en el que el modelo de tabla está vacío o la fila seleccionada no es válida
            JOptionPane.showMessageDialog(this, "No se puede editar la fila seleccionada.");
        }
    }//GEN-LAST:event_editarDepartamentosMousePressed

    private void eliminarDepartamentosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarDepartamentosMousePressed
        int selectedRow = tablaDepartamentos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un departamento para eliminar.");
            return;
        }
        DefaultTableModel tableModel = (DefaultTableModel) tablaDepartamentos.getModel();
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar el departamento seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            int id = (int) tableModel.getValueAt(selectedRow, 0); // Suponiendo que el ID del departamento está en la columna 0
            funcionesBD.eliminarDepartamento(id);
            MantenimientosBasicos mantenimientosBasicos = new MantenimientosBasicos();
            mantenimientosBasicos.mantenimientoDepartamentos(tablaDepartamentos, departamentosPanel); // Cambio del nombre del panel
        }
    }//GEN-LAST:event_eliminarDepartamentosMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cargarProfesoresDesdeCSV(File file) throws IOException, SQLException {
        Map<String, Integer> departamentoIdMap = new HashMap<>();
        boolean primeraLinea = true; // Variable para identificar la primera línea

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD); BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false; // Ignorar la primera línea
                    continue;
                }

                String[] datos = splitCSVLine(line);

                if (datos.length >= 4) { // Asegurarse de que haya al menos 4 campos en la línea
                    String apellidosNombre = datos[0].trim();
                    String dni = datos[1].trim().substring(0, Math.min(datos[1].trim().length(), 9));
                    String correo = datos[2].trim();
                    String departamentoNombre = datos[3].trim(); // Obtener el nombre del departamento del CSV

                    String[] apellidosNombreArray = apellidosNombre.split(",", 2);
                    String apellidos = (apellidosNombreArray.length > 0) ? apellidosNombreArray[0].trim() : "";
                    String nombre = (apellidosNombreArray.length > 1) ? apellidosNombreArray[1].trim() : apellidosNombre.trim();

                    // Obtener o insertar el ID del departamento
                    int departamentoId = obtenerOInsertarDepartamentoId(departamentoNombre, conn, departamentoIdMap);

                    String password = generarPassword();
                    String perfil = obtenerPerfilAleatorio();

                    // Preparar la inserción del nuevo profesor
                    String insertProfesorSQL = "INSERT INTO profesor (apellidos, nombre, dni, correo, activo, perfil, contraseña, departamento) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement pstmt = conn.prepareStatement(insertProfesorSQL);
                    pstmt.setString(1, apellidos);
                    pstmt.setString(2, nombre);
                    pstmt.setString(3, dni);
                    pstmt.setString(4, correo);
                    pstmt.setBoolean(5, true);
                    pstmt.setString(6, perfil);
                    pstmt.setString(7, password);
                    pstmt.setInt(8, departamentoId);

                    // Ejecutar la inserción del nuevo profesor
                    pstmt.executeUpdate();
                    pstmt.close();
                } else {
                    mostrarMensajeError("La línea del archivo CSV no tiene suficientes campos.");
                }
            }
        }
    }

    private int obtenerOInsertarDepartamentoId(String departamentoNombre, Connection conn, Map<String, Integer> departamentoIdMap) throws SQLException {
        if (departamentoIdMap.containsKey(departamentoNombre)) {
            return departamentoIdMap.get(departamentoNombre);
        } else {
            // Si el departamento no está en el mapa, obtener su ID de la base de datos o insertar uno nuevo
            String cod = generarCodigoUnico(conn);

            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO departamento (cod, nombre) VALUES (?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, cod);
            pstmt.setString(2, departamentoNombre);
            pstmt.executeUpdate();

            int departamentoId;
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    departamentoId = generatedKeys.getInt(1);
                    departamentoIdMap.put(departamentoNombre, departamentoId);
                } else {
                    throw new SQLException("Error al obtener el ID del departamento.");
                }
            }

            pstmt.close();
            return departamentoId;
        }
    }

    // Método para dividir una línea de CSV considerando solo comas como delimitadores
    private String[] splitCSVLine(String line) {
        return line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    }

    private String generarCodigoUnico(Connection conn) throws SQLException {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        String cod;

        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 2; i++) {
                int index = random.nextInt(caracteres.length());
                sb.append(caracteres.charAt(index));
            }
            cod = sb.toString();

            // Verificar si el código generado ya existe en la base de datos
            if (!codigoExiste(cod, conn)) {
                break; // Salir del bucle si el código es único
            }
        } while (true);

        return cod;
    }

    private boolean codigoExiste(String cod, Connection conn) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(
                "SELECT COUNT(*) AS count FROM departamento WHERE cod = ?");
        pstmt.setString(1, cod);
        ResultSet rs = pstmt.executeQuery();

        int count = 0;
        if (rs.next()) {
            count = rs.getInt("count");
        }

        rs.close();
        pstmt.close();

        return count > 0;
    }

    private String generarPassword() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }

    private String obtenerPerfilAleatorio() {
        String[] perfiles = {"SuperUsuario", "Administrador", "EquipoAdministrativo", "Profesor"};
        return perfiles[(int) (perfiles.length * Math.random())];
    }

    private void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Archivo CSV de Profesores");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv"));

        int returnValue = fileChooser.showOpenDialog(Principal.this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName().toLowerCase(); // Obtener el nombre del archivo en minúsculas

            // Verificar si el archivo seleccionado es un archivo CSV
            if (fileName.endsWith(".csv")) {
                try {
                    cargarProfesoresDesdeCSV(selectedFile);
                    mostrarMensajeExito("Datos de profesores cargados exitosamente desde: " + fileName);
                } catch (IOException | SQLException ex) {
                    mostrarMensajeError("Error al cargar el archivo CSV de profesores: " + ex.getMessage());
                }
            } else {
                mostrarMensajeError("Selecciona un archivo CSV válido.");
            }
        }
    }//GEN-LAST:event_jButton2MousePressed

    private void solicitudBusquedaTxt1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_solicitudBusquedaTxt1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_solicitudBusquedaTxt1KeyPressed

    private void solicitudBusquedaBotonVerTodo1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_solicitudBusquedaBotonVerTodo1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_solicitudBusquedaBotonVerTodo1MouseReleased

    private void solicitudBusquedaBoton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_solicitudBusquedaBoton1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_solicitudBusquedaBoton1MouseReleased

    private void verPanelScroll1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_verPanelScroll1MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_verPanelScroll1MouseWheelMoved

    private void botonGruposMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGruposMousePressed
        cursosSeleccion.setVisible(false);
        gruposSeleccion.setVisible(true);

        textoGrupo.setVisible(true);
        textoCurso.setVisible(false);

        Dimension size = botonesAbajo.getPreferredSize();
        cargarGrupos(gruposSeleccion);
    }//GEN-LAST:event_botonGruposMousePressed

    private void botonCursosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCursosMousePressed
        cursosSeleccion.setVisible(true);
        gruposSeleccion.setVisible(false);

        textoGrupo.setVisible(false);
        textoCurso.setVisible(true);

        Dimension size = botonesAbajo.getPreferredSize();
        cargarCursos(cursosSeleccion);
    }//GEN-LAST:event_botonCursosMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actividad;
    private javax.swing.ButtonGroup actividadPrevista;
    private javax.swing.JPanel botonCancelarCarga;
    private javax.swing.JPanel botonCargar;
    private javax.swing.JRadioButton botonCursos;
    private javax.swing.JRadioButton botonGrupos;
    private javax.swing.JPanel botonesAbajo;
    private javax.swing.JPanel cargaDatos;
    private javax.swing.JPanel cargarPanel;
    private javax.swing.JPanel cargarSolicitudes;
    private javax.swing.JPanel cerrar;
    private javax.swing.JLabel cerrarTexto;
    private javax.swing.JPanel cursosPanel;
    private com.extra.ComboBoxMultiSelection cursosSeleccion;
    private javax.swing.JPanel departamentosPanel;
    private javax.swing.JButton editarCursos;
    private javax.swing.JButton editarDepartamentos;
    private javax.swing.JButton editarGrupos;
    private javax.swing.JButton editarProfesores;
    private javax.swing.JButton eliminarCursos;
    private javax.swing.JButton eliminarDepartamentos;
    private javax.swing.JButton eliminarGrupos;
    private javax.swing.JButton eliminarProfesor;
    private javax.swing.JPanel fondoIzquierda;
    private javax.swing.JPanel fondoMantenimientoIzquierda;
    private javax.swing.JPanel fondoSolicitudIzquierda;
    private javax.swing.ButtonGroup gruposCursos;
    private javax.swing.JPanel gruposPanel;
    private com.extra.ComboBoxMultiSelection gruposSeleccion;
    private javax.swing.JLabel icono1;
    private javax.swing.JLabel imagenActividad;
    private javax.swing.JLabel imagenCargaDatos;
    private javax.swing.JLabel imagenCargarSolicitud;
    private javax.swing.JLabel imagenCargarSolicitud1;
    private javax.swing.JLabel imagenCargarSolicitud2;
    private javax.swing.JLabel imagenMantenimiento;
    private javax.swing.JLabel imagenSolicitud;
    private javax.swing.JLabel imagenUsuario;
    private javax.swing.JLabel imagenVerSolicitud;
    private javax.swing.JLabel imagenVerSolicitud1;
    private javax.swing.JLabel imagenVerSolicitud2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel mantenimiento;
    private javax.swing.JPanel mantenimientoCursos;
    private javax.swing.JPanel mantenimientoDepartamentos;
    private javax.swing.JPanel mantenimientoGrupos;
    private javax.swing.JPanel mantenimientoProfesores;
    private javax.swing.JPanel minimizar;
    private javax.swing.JLabel minimizarTexto;
    private javax.swing.JLabel nombreUsuario;
    private javax.swing.JPanel panelActividad;
    private javax.swing.JPanel panelActividades;
    private javax.swing.JPanel panelCargaDatos;
    private javax.swing.JPanel panelMantenimiento;
    private javax.swing.JPanel panelSolicitud;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JPanel principal;
    private javax.swing.JPanel profesorPanel;
    private javax.swing.JComboBox<String> profesorResponsable;
    private com.extra.ComboBoxMultiSelection profesoresInvolucrados;
    private javax.swing.JPanel solicitud;
    private javax.swing.JButton solicitudBusquedaBoton;
    private javax.swing.JButton solicitudBusquedaBoton1;
    private javax.swing.JButton solicitudBusquedaBotonVerTodo;
    private javax.swing.JButton solicitudBusquedaBotonVerTodo1;
    private javax.swing.JTextField solicitudBusquedaTxt;
    private javax.swing.JTextField solicitudBusquedaTxt1;
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
    private javax.swing.JLabel solicitudCargarPrevista;
    private javax.swing.JRadioButton solicitudCargarPrevistaOFF;
    private javax.swing.JRadioButton solicitudCargarPrevistaON;
    private javax.swing.JLabel solicitudCargarProfesorResponsable;
    private javax.swing.JLabel solicitudCargarProfesoresInvolucrados;
    private javax.swing.JLabel solicitudCargarTitulo;
    private javax.swing.JTextField solicitudCargarTituloTxt1;
    private javax.swing.JLabel solicitudCargarTransporte;
    private javax.swing.JTable tablaCursos;
    private javax.swing.JTable tablaDepartamentos;
    private javax.swing.JTable tablaGrupos;
    private javax.swing.JTable tablaProfesores;
    private javax.swing.JLabel textoActividad;
    private javax.swing.JLabel textoCancelar;
    private javax.swing.JLabel textoCargaDatos;
    private javax.swing.JLabel textoCargar;
    private javax.swing.JLabel textoCargarSolicitud;
    private javax.swing.JLabel textoCargarSolicitud1;
    private javax.swing.JLabel textoCargarSolicitud2;
    private javax.swing.JLabel textoCurso;
    private javax.swing.JLabel textoGrupo;
    private javax.swing.JLabel textoLlenarTodoSolicitudCargar;
    private javax.swing.JLabel textoMantenimiento;
    private javax.swing.JLabel textoSolicitud;
    private javax.swing.JLabel textoUsuario;
    private javax.swing.JLabel textoVerSolicitud;
    private javax.swing.JLabel textoVerSolicitud1;
    private javax.swing.JLabel textoVerSolicitud2;
    private javax.swing.JPanel usuario;
    private javax.swing.ButtonGroup vehiculo;
    private javax.swing.JRadioButton vehiculoOFF;
    private javax.swing.JRadioButton vehiculoON;
    private javax.swing.JPanel verPanel;
    private javax.swing.JScrollPane verPanelScroll;
    private javax.swing.JScrollPane verPanelScroll1;
    private javax.swing.JPanel verPanelScrollFrame;
    private javax.swing.JPanel verPanelScrollFrame1;
    private javax.swing.JPanel verSolicitudes;
    // End of variables declaration//GEN-END:variables
}
