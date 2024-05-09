/*
 * Diferentes métdos que puedo requerir en mi conexión
Es muy conveniente comprobar el resultado de las consultas ejecutadas en la propia BD
 */
package com.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author pe
 */
public class FuncionesBD {

    // Validar datos
    public boolean validarDatos(String usuario, String password) {
        Statement sentencia = null;
        ResultSet rs = null;
        Connection conn = AccesoBaseDatos.getInstance().getConn();
        try {
            sentencia = conn.createStatement();
            // dentro de executeQuery va el código de la select
            String sql = "select correo, contraseña from profesor";
            rs = sentencia.executeQuery(sql);
            while (rs.next()) {

                if (usuario.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                    return true;
                }

            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta " + ex.getMessage());
        } finally {
            try {
                if (sentencia != null) {
                    rs.close();
                    sentencia.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la sentencia " + ex.getMessage());
            }
        }
        return false;
    }

    public int validarAdmin(String usuario) {
        Statement sentencia = null;
        ResultSet rs = null;
        Connection conn = AccesoBaseDatos.getInstance().getConn();
        boolean admin = false;

        try {
            sentencia = conn.createStatement();
            // dentro de executeQuery va el código de la select
            String sql = "select perfil from profesor where correo = ?";

            // Utilizamos PreparedStatement para evitar problemas de SQL Injection y mejorar la legibilidad del código
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                // Seleccionamos el administrador correspondiente al usuario y lo retornamos
                if (rs.getString("perfil").equals("SuperUsuario")) {
                    return 0;
                } else if (rs.getString("perfil").equals("Administrador")) {
                    return 1;
                } else if (rs.getString("perfil").equals("EquipoDirectivo")) {
                    return 2;
                } else if (rs.getString("perfil").equals("Profesor")) {
                    return 3;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta " + ex.getMessage());
        } finally {
            try {
                if (sentencia != null) {
                    rs.close();
                    sentencia.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la sentencia " + ex.getMessage());
            }
        }
        return 0;
    }

    public String getNombre(String usuario) {
        Statement sentencia = null;
        ResultSet rs = null;
        Connection conn = AccesoBaseDatos.getInstance().getConn();
        boolean admin = false;

        try {
            sentencia = conn.createStatement();
            // dentro de executeQuery va el código de la select
            String sql = "select nombre from profesor where correo = ?";

            // Utilizamos PreparedStatement para evitar problemas de SQL Injection y mejorar la legibilidad del código
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("nombre");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta " + ex.getMessage());
        } finally {
            try {
                if (sentencia != null) {
                    rs.close();
                    sentencia.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la sentencia " + ex.getMessage());
            }
        }
        return "";
    }

    public String getApellidos(String usuario) {
        Statement sentencia = null;
        ResultSet rs = null;
        Connection conn = AccesoBaseDatos.getInstance().getConn();
        boolean admin = false;

        try {
            sentencia = conn.createStatement();
            // dentro de executeQuery va el código de la select
            String sql = "select apellidos from profesor where correo = ?";

            // Utilizamos PreparedStatement para evitar problemas de SQL Injection y mejorar la legibilidad del código
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("apellidos");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta " + ex.getMessage());
        } finally {
            try {
                if (sentencia != null) {
                    rs.close();
                    sentencia.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la sentencia " + ex.getMessage());
            }
        }
        return "";
    }

    public int numeroSolicitudes() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta para obtener el número de solicitudes
            String sql = "SELECT COUNT(*) AS num_solicitudes FROM solicitud";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            // Verificamos si hay resultados y devolvemos el resultado de COUNT(*)
            if (rs.next()) {
                return rs.getInt("num_solicitudes");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }

        // Si algo falla o no se encuentra ningún resultado, retornamos 0
        return 0;

    }

    public String obtenerTituloSolicitud(int solicitud) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta para obtener el título de la solicitud
            String sql = "SELECT titulo FROM solicitud WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, solicitud); // Establecer el parámetro de la consulta

            rs = pstmt.executeQuery();

            // Verificar si hay resultados y devolver el título de la solicitud
            if (rs.next()) {
                return rs.getString("titulo");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());

            // Si algo falla o no se encuentra ningún resultado, retornamos una cadena vacía
            return "";
        }
        return "";
    }

}
