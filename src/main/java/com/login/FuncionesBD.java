/*
 * Diferentes métdos que puedo requerir en mi conexión
Es muy conveniente comprobar el resultado de las consultas ejecutadas en la propia BD
 */
package com.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

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
            String sql = "select usuario, password from usuarios";
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

}
