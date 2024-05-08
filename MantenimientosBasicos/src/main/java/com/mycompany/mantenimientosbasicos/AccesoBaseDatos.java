package com.mycompany.mantenimientosbasicos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoBaseDatos {

    private static final String BD = "gestoractividadesextraescolaresprueba";
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
