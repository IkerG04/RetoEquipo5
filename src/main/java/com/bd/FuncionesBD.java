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
 * Clase que contiene funciones para interactuar con la base de datos.
 *
 * @author Marcos
 * @author Alvaro
 */
public class FuncionesBD {

    /**
     * Valida los datos de usuario y contraseña.
     *
     * @param usuario el nombre de usuario
     * @param password la contraseña del usuario
     * @return true si los datos son válidos, false en caso contrario
     */
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

    /**
     * Valida si el usuario es administrador.
     *
     * @param usuario el nombre de usuario
     * @return un código entero que representa el perfil del usuario (0:
     * SuperUsuario, 1: Administrador, 2: EquipoDirectivo, 3: Profesor)
     */
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

    /**
     * Obtiene el nombre del usuario.
     *
     * @param usuario el nombre de usuario
     * @return el nombre del usuario, o una cadena vacía si no se encuentra
     */
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

    /**
     * Obtiene todas las solicitudes de la base de datos.
     *
     * @return una lista de todas las solicitudes
     */
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

    /**
     * Obtiene el estado de una solicitud por su ID.
     *
     * @param id el ID de la solicitud
     * @return el estado de la solicitud, o una cadena vacía si no se encuentra
     */
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

    /**
     * Obtiene los apellidos del usuario.
     *
     * @param usuario el nombre de usuario
     * @return los apellidos del usuario, o una cadena vacía si no se encuentra
     */
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

    /**
     * Obtiene el número total de solicitudes en la base de datos.
     *
     * @return el número total de solicitudes
     */
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

    /**
     * Obtiene el título de una solicitud por su ID.
     *
     * @param solicitud el ID de la solicitud
     * @return el título de la solicitud, o una cadena vacía si no se encuentra
     */
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

    /**
     * Obtiene el nombre completo de un profesor a partir de un objeto Usuario.
     *
     * @param user Objeto Usuario del cual se obtendrá el nombre y apellidos.
     * @return Nombre completo del profesor.
     */
    public String getNombreProfesor(Usuario user) {
        return user.getNombre() + " " + user.getApellidos();
    }

    /**
     * Obtiene el número total de profesores registrados en la base de datos.
     *
     * @return Número total de profesores.
     */
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

    /**
     * Obtiene una lista de todos los profesores registrados en la base de
     * datos.
     *
     * @return Lista de objetos Profesor.
     */
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

    /**
     * Actualiza los datos de un profesor en la base de datos.
     *
     * @param id ID del profesor a actualizar.
     * @param dni Nuevo DNI del profesor.
     * @param correo Nuevo correo del profesor.
     * @param nombre Nuevo nombre del profesor.
     * @param apellidos Nuevos apellidos del profesor.
     * @param activo Nuevo estado de actividad del profesor.
     * @param perfil Nuevo perfil del profesor.
     * @param contraseña Nueva contraseña del profesor.
     * @param departamento Nuevo departamento del profesor.
     */
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

    /**
     * Elimina un profesor de la base de datos.
     *
     * @param idProfesor ID del profesor a eliminar.
     */
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

    /**
     * Obtiene una lista de todos los cursos registrados en la base de datos.
     *
     * @return Lista de objetos Curso.
     */
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

    /**
     * Actualiza los datos de un curso en la base de datos.
     *
     * @param id ID del curso a actualizar.
     * @param nuevaCodCurso Nuevo código del curso.
     * @param nuevaEtapa Nueva etapa del curso.
     * @param nuevaDescripcion Nueva descripción del curso.
     * @param activo Nuevo estado de actividad del curso.
     */
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

    /**
     * Elimina un curso de la base de datos.
     *
     * @param idCurso ID del curso a eliminar.
     */
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

    /**
     * Obtiene una lista de todos los grupos registrados en la base de datos.
     *
     * @return Lista de objetos Grupo.
     */
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

    /**
     * Actualiza los datos de un grupo en la base de datos.
     *
     * @param id ID del grupo a actualizar.
     * @param codgrupo Nuevo código del grupo.
     * @param curso Nuevo curso del grupo.
     * @param numAlumnos Nuevo número de alumnos del grupo.
     * @param activo Nuevo estado de actividad del grupo.
     */
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

    /**
     * Elimina un grupo de la base de datos.
     *
     * @param idGrupo ID del grupo a eliminar.
     */
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

    /**
     * Obtiene una lista de todos los departamentos registrados en la base de
     * datos.
     *
     * @return Lista de objetos Departamento.
     */
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

    /**
     * Actualiza los datos de un departamento en la base de datos.
     *
     * @param id ID del departamento a actualizar.
     * @param cod Nuevo código del departamento.
     * @param nombre Nuevo nombre del departamento.
     */
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

    /**
     * Elimina un departamento de la base de datos.
     *
     * @param idDepartamento ID del departamento a eliminar.
     */
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

    /**
     * Inserta una relación entre una solicitud y un vehículo en la base de
     * datos.
     *
     * @param idSolicitud ID de la solicitud.
     * @param idVehiculo ID del vehículo.
     */
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

    /**
     * Obtiene el ID de un vehículo a partir de su descripción.
     *
     * @param vehiculo Descripción del vehículo.
     * @return ID del vehículo.
     */
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

    /**
     * Obtiene el ID de un grupo a partir de su código.
     *
     * @param grupo Código del grupo.
     * @return ID del grupo.
     */
    public int getGrupo(String grupo) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            String sql = "SELECT idgrupo FROM grupos WHERE codgrupo = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, grupo);
            rs = statement.executeQuery(); // Cambiado a executeQuery()

            if (rs.next()) {
                return rs.getInt("idgrupo"); // Corregido para obtener el valor de la columna "id"
            }

        } catch (SQLException ex) {
            System.out.println("Error al devolver la id de grupo: " + ex.getMessage());
        }

        return 0;
    }

    /**
     * Obtiene el ID de un curso a partir de su código.
     *
     * @param curso Código del curso.
     * @return ID del curso.
     */
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
            System.out.println("Error al devolver la id de curso: " + ex.getMessage());
        }

        return 0;
    }

    /**
     * Inserta un grupo asociado a una solicitud en la base de datos.
     *
     * @param idSolicitud ID de la solicitud.
     * @param idGrupo ID del grupo.
     */
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

    /**
     * Inserta un curso asociado a una solicitud en la base de datos.
     *
     * @param idSolicitud ID de la solicitud.
     * @param idCurso ID del curso.
     */
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

    /**
     * Inserta un profesor asociado a una solicitud en la base de datos con un
     * perfil específico.
     *
     * @param profesor ID del profesor.
     * @param solicitud ID de la solicitud.
     * @param perfil Perfil del profesor en la solicitud.
     */
    public void insertarProfesor(int profesor, int solicitud, String perfil) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            String sql = "INSERT INTO participa (IdProfesor, IdSolicitud, Rol) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, profesor);
            statement.setInt(2, solicitud);
            statement.setString(3, perfil);
            statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al insertar el profesor: " + ex.getMessage());
        }
    }

    /**
     * Actualiza el estado de una solicitud en la base de datos.
     *
     * @param estado Nuevo estado de la solicitud.
     * @param idSolicitud ID de la solicitud a actualizar.
     */
    public void actualizarSolicitud(String estado, int idSolicitud) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = AccesoBaseDatos.getInstance().getConn();

            String sql = "UPDATE solicitud SET estado = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, estado);
            statement.setInt(2, idSolicitud);
            statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al editar el estado de la solicitud: " + ex.getMessage());
        }
    }

    /**
     * Obtiene el perfil de un profesor a partir de su correo electrónico.
     *
     * @param usuario Correo electrónico del profesor.
     * @return Perfil del profesor.
     */
    public String getPerfil(String usuario) {
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
                return rs.getString(1);
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

    /**
     * Obtiene el ID de un profesor a partir de su correo electrónico.
     *
     * @param usuario Correo electrónico del profesor.
     * @return ID del profesor.
     */
    public String getIdProfesor(String usuario) {
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

    /**
     * Obtiene una solicitud a partir de su ID.
     *
     * @param idSolicitud ID de la solicitud.
     * @return Solicitud con los datos asociados.
     */

    public Solicitud obtenerSolicitudPorId(int idSolicitud) {
        Solicitud solicitud = null;
        Connection conn = AccesoBaseDatos.getInstance().getConn();
        try {
            String sql = "SELECT * FROM solicitud WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idSolicitud);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                boolean medioTransporte = rs.getBoolean("mediotransporte");
                int departamento = rs.getInt("departamento");
                String comentarios = rs.getString("comentariosadicionales");
                boolean alojamiento = rs.getBoolean("alojamiento");
                int numeroAlumnos = rs.getInt("numeroalumnos");
                String estado = rs.getString("estado");
                int grupocurso = rs.getInt("grupocurso");
                LocalDate fechaInicio = rs.getDate("fecha_inicio").toLocalDate();
                LocalDate fechaFin = rs.getDate("fecha_fin").toLocalDate();
                boolean prevista = rs.getBoolean("prevista");
                String titulo = rs.getString("titulo");

                solicitud = new Solicitud(idSolicitud, medioTransporte, departamento, comentarios,
                        alojamiento, numeroAlumnos, estado, grupocurso, fechaInicio, fechaFin, prevista, titulo);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la solicitud con id " + idSolicitud + ": " + ex.getMessage());
        }
        return solicitud;
    }

}
