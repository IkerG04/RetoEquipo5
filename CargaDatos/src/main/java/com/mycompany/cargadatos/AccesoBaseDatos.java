/*
 * sigue el patrón Singleton para la conexión a la base de datos
En ingeniería de software, singleton o instancia única es un patrón de diseño que restringe 
la creación a un único objeto la creación de objetos pertenecientes a una clase 
y asegura de que sólo haya esta instancia única

 */
package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author pe
 */
public class AccesoBaseDatos {

    private Connection conn = null; //atributo conexión
    // constantes a definir. pueden depender de la base a usar, qué credenciales tiene la BD...
    private static final String BD = "test";
    private static final String USUARIO = "root";//son los datos para conectarse a la BD Mysql
    private static final String CLAVE = "";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD; //conexión al servidor de la BD

    private AccesoBaseDatos() {

        try {
            Properties properties = new Properties();
            properties.setProperty("user", USUARIO);
            properties.setProperty("password", CLAVE);
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");
            conn = (Connection) DriverManager.getConnection(URL, properties);
            if (conn == null) {
                System.out.println("Error en conexion");
            } else {
                System.out.println("Conexion correcta a: " + URL);
            }
        } catch (SQLException ex) {
            // manejo de los errores
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState()); 

            System.out.println("VendorError: " + ex.getErrorCode()); 
        }
    }

    public static AccesoBaseDatos getInstance() {
        return AccesoBaseDatosHolder.INSTANCE;
    }

    private static class AccesoBaseDatosHolder {//método privado

        private static final AccesoBaseDatos INSTANCE = new AccesoBaseDatos();//variable estática privada
    }
    
    
    //otros métodos que puedan ser necesarios
    
    //obtener la conexion
    public Connection getConn() {
        return conn;
    }
 
    // cerrar la conexión
    public boolean cerrar() {
        boolean siCerrada = false;
        try {
            conn.close();
            if (conn.isClosed()) {
                siCerrada = true;
            }
        } catch (SQLException sqe) {
            System.out.println("Se produjo un error en el cierre");
        }
        return siCerrada;
    }

}
