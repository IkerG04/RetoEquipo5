/*
 * Diferentes métdos que puedo requerir en mi conexión
Es muy conveniente comprobar el resultado de las consultas ejecutadas en la propia BD
 */
package com.bd;

import com.datos.Curso;
import com.datos.Departamento;
import com.datos.Grupo;
import com.datos.Profesor;
import com.datos.Solicitud;
import com.datos.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Solicitud> obtenerTodasLasSolicitudes() {
        List<Solicitud> solicitudes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = AccesoBaseDatos.getInstance().getConn();
            String sql = "SELECT * FROM solicitud";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                boolean medioTransporte = rs.getBoolean("mediotransporte");
                int departamento = rs.getInt("departamento");
                String comentarios = rs.getString("comentariosadicionales");
                boolean alojamiento = rs.getBoolean("alojamiento");
                int numeroAlumnos = rs.getInt("numeroalumnos");
                String estado = rs.getString("estado");
                int grupocurso = rs.getInt("grupocurso");
                LocalDate fechaInicio = rs.getDate("fechainicioactividad").toLocalDate();
                LocalDate fechaFin = rs.getDate("fechafinactividad").toLocalDate();
                boolean prevista = rs.getBoolean("prevista");
                String titulo = rs.getString("titulo");

                // Crear objeto Solicitud y agregarlo a la lista
                Solicitud solicitud = new Solicitud(id, medioTransporte, departamento, comentarios, alojamiento, numeroAlumnos, estado, grupocurso, fechaInicio, fechaFin, prevista, titulo);
                solicitudes.add(solicitud);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener todas las solicitudes: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar ResultSet y PreparedStatement: " + ex.getMessage());
            }
        }
        return solicitudes;
    }

    public String getEstadoSolicitud(int id) {
        Connection conn = AccesoBaseDatos.getInstance().getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT estado FROM solicitud WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String estado = rs.getString("estado");
                return estado;
            } else {
                System.out.println("No se encontró ninguna solicitud con el ID proporcionado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
        return ""; // Retorna una cadena vacía si no se pudo obtener el estado.
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
                listaCursos.add(new Curso(id, codigoCurso, descripcion, etapa, activo));
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

    public ArrayList<Grupo> obtenerListaGrupos() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Grupo> listaGrupos = new ArrayList<>();

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta para obtener todos los grupos
            String sql = "SELECT * FROM grupos";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            // Iterar sobre los resultados y crear objetos Grupo
            while (rs.next()) {
                int id = rs.getInt("idgrupo");
                String codgrupo = rs.getString("codgrupo");
                int curso = rs.getInt("curso");
                int numAlumnos = rs.getInt("numeroalumnos");
                boolean activo = rs.getBoolean("activo");

                // Agregar el grupo a la lista
                listaGrupos.add(new Grupo(id, codgrupo, curso, numAlumnos, activo));
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        return listaGrupos;
    }

    public void actualizarDatosGrupo(int id, String codgrupo, int curso, int numAlumnos, boolean activo) {
        try {
            Connection conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta SQL para actualizar los datos del grupo
            String sql = "UPDATE grupo SET codgrupo=?, curso=?, numAlumnos=?, activo=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, codgrupo);
            statement.setInt(2, curso);
            statement.setInt(3, numAlumnos);
            statement.setBoolean(4, activo);
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar datos del grupo: " + ex.getMessage());
        }
    }

    public void eliminarGrupo(int idGrupo) {
        try {
            Connection conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta SQL para eliminar un grupo por su ID
            String sql = "DELETE FROM grupos WHERE idgrupo=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idGrupo);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el grupo: " + ex.getMessage());
        }
    }

    public ArrayList<Departamento> obtenerListaDepartamentos() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Departamento> listaDepartamentos = new ArrayList<>();

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta para obtener todos los departamento
            String sql = "SELECT * FROM departamento";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            // Iterar sobre los resultados y crear objetos Departamento
            while (rs.next()) {
                int id = rs.getInt("id");
                String cod = rs.getString("cod");
                String nombre = rs.getString("nombre");

                // Agregar el departamento a la lista
                listaDepartamentos.add(new Departamento(id, cod, nombre));
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        return listaDepartamentos;
    }

    public void actualizarDatosDepartamento(int id, String cod, String nombre) {
        try {
            Connection conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta SQL para actualizar los datos del departamento
            String sql = "UPDATE departamento SET cod=?, nombre=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cod);
            statement.setString(2, nombre);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar datos del departamento: " + ex.getMessage());
        }
    }

    public void eliminarDepartamento(int idDepartamento) {
        try {
            Connection conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta SQL para eliminar un departamento por su ID
            String sql = "DELETE FROM departamento WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idDepartamento);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el departamento: " + ex.getMessage());
        }
    }

    public void insertarVehiculos(int idSolicitud, int idVehiculo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Departamento> listaDepartamentos = new ArrayList<>();

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta para obtener todos los departamento
            String sql = "INSERT INTO listamediostransporte SET idactividad = ?, idtransporte = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idSolicitud);
            statement.setInt(2, idVehiculo);
            statement.executeUpdate();

            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al insertar el vehiculo: " + ex.getMessage());
        }
    }

    public int getVehiculos(String vehiculo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Departamento> listaDepartamentos = new ArrayList<>();

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            // Consulta para obtener todos los departamento
            String sql = "SELECT id FROM mediostranporte WHERE descripcion = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, vehiculo);
            statement.executeUpdate();

            if (rs.next()) {
                return rs.getInt(sql);
            }

            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al insertar el vehiculo: " + ex.getMessage());
        }
        return 0;
    }

    public int getGrupo(String grupo) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            String sql = "SELECT id FROM grupos WHERE codgrupo = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, grupo);
            rs = statement.executeQuery(); // Cambiado a executeQuery()

            if (rs.next()) {
                return rs.getInt("id"); // Corregido para obtener el valor de la columna "id"
            }

        } catch (SQLException ex) {
            System.out.println("Error al devolver la id: " + ex.getMessage());
        }

        return 0;
    }

    public int getCurso(String curso) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            String sql = "SELECT id FROM curso WHERE codcurso = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, curso);
            rs = statement.executeQuery(); // Cambiado a executeQuery()

            if (rs.next()) {
                return rs.getInt("id"); // Corregido para obtener el valor de la columna "id"
            }

        } catch (SQLException ex) {
            System.out.println("Error al devolver la id: " + ex.getMessage());
        }

        return 0;
    }

    public void insertarGrupo(int idSolicitud, int idGrupo) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            String sql = "INSERT INTO gruposparticipantes (codigogrupo, idsolicitud, alumnostotales) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idGrupo);
            statement.setInt(2, idSolicitud);
            statement.setInt(3, 0);
            statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al insertar el grupo: " + ex.getMessage());
        }
    }

    public void insertarCurso(int idSolicitud, int idCurso) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            String sql = "INSERT INTO cursosparticipantes (codigocurso, idsolicitud, alumnostotales) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idCurso);
            statement.setInt(2, idSolicitud);
            statement.setInt(3, 0);
            statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al insertar el curso: " + ex.getMessage());
        }
    }

}
