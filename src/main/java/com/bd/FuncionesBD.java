/*
 * Diferentes métdos que puedo requerir en mi conexión
Es muy conveniente comprobar el resultado de las consultas ejecutadas en la propia BD
 */
package com.bd;

import com.datos.Curso;
import com.datos.Profesor;
import com.datos.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

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

    public String getNombreProfesor(Usuario user) {
        return user.getNombre() + " " + user.getApellidos();
    }

    //Profesores
    public int numeroProfesores() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta para obtener el número de solicitudes
            String sql = "SELECT COUNT(*) AS num_profesores FROM profesor";
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

    public ArrayList<Profesor> obtenerListaProfesores() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Profesor> listaProfesores = new ArrayList<>();

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta para obtener todos los profesores
            String sql = "SELECT * FROM profesor";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            // Iterar sobre los resultados y crear objetos Profesor
            while (rs.next()) {
                int id = rs.getInt("id");
                String dni = rs.getString("dni");
                String correo = rs.getString("correo");
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellidos");
                boolean activo = rs.getBoolean("activo");
                String perfil = rs.getString("perfil");
                String pass = rs.getString("contraseña");
                int departamento = rs.getInt("departamento");

                // Agregar el profesor a la lista
                listaProfesores.add(new Profesor(id, dni, correo, nombreCompleto, activo, perfil, pass, departamento));
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        return listaProfesores;
    }

    public void actualizarDatosProfesor(int id, String dni, String correo, String nombre, String apellidos, boolean activo, String perfil, String contraseña, int departamento) {
        try {
            Connection conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta SQL para actualizar los datos del profesor
            String sql = "UPDATE profesor SET dni=?, correo=?, nombre=?, apellidos=?, activo=?, perfil=?, contraseña=?, departamento=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, dni);
            statement.setString(2, correo);
            statement.setString(3, nombre);
            statement.setString(4, apellidos);
            statement.setBoolean(5, activo);
            statement.setString(6, perfil);
            statement.setString(7, contraseña);
            statement.setInt(8, departamento);
            statement.setInt(9, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar datos del profesor: " + ex.getMessage());
        }
    }

    public void eliminarProfesor(int idProfesor) {
        try {
            Connection conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta SQL para eliminar un profesor por su ID
            String sql = "DELETE FROM profesor WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idProfesor);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el profesor: " + ex.getMessage());
        }
    }

    public ArrayList<Curso> obtenerListaCursos() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Curso> listaCursos = new ArrayList<>();

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta para obtener todos los cursos
            String sql = "SELECT * FROM curso";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            // Iterar sobre los resultados y crear objetos Curso
            while (rs.next()) {
                int id = rs.getInt("id");
                String etapa = rs.getString("etapa");
                String descripcion = rs.getString("descripcion");
                String codigoCurso = rs.getString("codcurso");
                boolean activo = rs.getBoolean("activo");

                // Agregar el curso a la lista
                listaCursos.add(new Curso(id, etapa, descripcion, codigoCurso, activo));
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        } finally {
            // Cerrar recursos
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar ResultSet: " + e.getMessage());
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return listaCursos;
    }

    public void modificarDatosCurso(int id, String nuevaCodCurso, String nuevaEtapa, String nuevaDescripcion, boolean activo) {
        try {
            Connection conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta SQL para actualizar el código de curso, etapa, descripción y estado del curso
            String sql = "UPDATE curso SET codcurso=?, etapa=?, descripcion=?, activo=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nuevaCodCurso);
            statement.setString(2, nuevaEtapa);
            statement.setString(3, nuevaDescripcion);
            statement.setBoolean(4, activo);
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al modificar datos del curso: " + ex.getMessage());
        }
    }

    public void eliminarCurso(int idCurso) {
        try {
            Connection conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta SQL para eliminar un curso por su ID
            String sql = "DELETE FROM curso WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idCurso);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el curso: " + ex.getMessage());
        }
    }
}
