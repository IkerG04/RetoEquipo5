package com.mycompany.actividad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


public class AccesoBaseDatos {
    private static AccesoBaseDatos instance;
    private Connection conn;

    // Constructor privado para evitar instanciación directa
    private AccesoBaseDatos(String url, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, user, password);
    }

    // Método estático para obtener la instancia única de AccesoBaseDatos
    public static synchronized AccesoBaseDatos getInstance(String url, String user, String password) throws SQLException {
        if (instance == null) {
            instance = new AccesoBaseDatos(url, user, password);
        }
        return instance;
    }

    // Método para insertar una actividad en la base de datos
    public boolean insertarActividad(ActividadData actividad) {
        String query = "INSERT INTO solicitud (mediotransporte, departamento, comentariosadicionales, " +
                "alojamiento, numeroalumnos, estado, grupocurso, fechainicioactividad, " +
                "fechafinactividad, prevista, titulo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, actividad.isEnProgramacion());
            pstmt.setString(2, actividad.getDepartamento());
            pstmt.setString(3, actividad.getComentarios());
            pstmt.setBoolean(4, actividad.isAlojamiento());
            pstmt.setInt(5, actividad.getNumAlumnos());
            pstmt.setString(6, "Pendiente"); // Estado inicial (por ejemplo: Pendiente)
            pstmt.setString(7, actividad.getGrupo());
            pstmt.setDate(8, java.sql.Date.valueOf(actividad.getInicio()));
            pstmt.setDate(9, java.sql.Date.valueOf(actividad.getFin()));
            pstmt.setBoolean(10, true); // Actividad prevista (true/false)
            pstmt.setString(11, actividad.getTitulo());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            System.out.println("Error al insertar actividad: " + ex.getMessage());
            return false;
        }
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
    }
}