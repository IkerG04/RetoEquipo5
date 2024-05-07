package com.mycompany.actividad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


public class AccesoBaseDatos {

    private static final String BD = "gestoractividadesextraescolares";
    private static final String USUARIO = "root";
    private static final String CLAVE = "mysql";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD;

    private Connection conn = null;

    private AccesoBaseDatos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el controlador JDBC
            conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión establecida a la base de datos: " + URL);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
        }
    }

    public static AccesoBaseDatos getInstance() {
        return AccesoBaseDatosHolder.INSTANCE;
    }

    private static class AccesoBaseDatosHolder {
        private static final AccesoBaseDatos INSTANCE = new AccesoBaseDatos();
    }

    public Connection getConn() {
        return conn;
    }

    public boolean insertarActividad(ActividadData actividad) {
        if (conn != null) {
            try {
                String query = "INSERT INTO actividades (id, profesor_solicitante, departamento, titulo, " + //CAMBIAR TABLA
                        "en_programacion, medio_transporte, fecha_inicio, fecha_fin, grupo_curso, " +
                        "num_alumnos, necesita_alojamiento, comentarios_adicionales, empresa_transporte, " +
                        "actividad_realizada) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, actividad.getId());
                pstmt.setString(2, actividad.getProfesorSolicitante());
                pstmt.setString(3, actividad.getDepartamento());
                pstmt.setString(4, actividad.getTitulo());
                pstmt.setBoolean(5, actividad.isEnProgramacion());
                pstmt.setString(6, actividad.getTransporte());
                pstmt.setDate(7, java.sql.Date.valueOf(actividad.getInicio()));
                pstmt.setDate(8, java.sql.Date.valueOf(actividad.getFin()));
                pstmt.setString(9, actividad.getGrupo());
                pstmt.setInt(10, actividad.getNumAlumnos());
                pstmt.setBoolean(11, actividad.isAlojamiento());
                pstmt.setString(12, actividad.getComentarios());
                pstmt.setString(13, actividad.getEmpresaTransporte());
                pstmt.setBoolean(14, actividad.isActividadRealizada());

                int rowsInserted = pstmt.executeUpdate();
                pstmt.close();

                return rowsInserted > 0;
            } catch (SQLException ex) {
                System.out.println("Error al insertar actividad: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean cerrar() {
        boolean siCerrada = false;
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                siCerrada = true;
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
        return siCerrada;
    }
}