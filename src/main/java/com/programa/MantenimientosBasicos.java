/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programa;

import com.bd.AccesoBaseDatos;
import com.bd.FuncionesBD;
import com.datos.Curso;
import com.datos.Profesor;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DAW104
 */
public class MantenimientosBasicos {

    FuncionesBD funcionesBD = new FuncionesBD();
    private DefaultTableModel tablaModelo = new DefaultTableModel();

    public void mantenimientoProfesores(JTable tablaProfesores, JPanel profesorPanel) {
        System.out.println("Iniciando carga de datos de profesores...");

        // Consulta SQL para obtener todos los profesores
        ArrayList<Profesor> listaProfesores = funcionesBD.obtenerListaProfesores();

        // Crear un nuevo DefaultTableModel con los datos de los profesores
        tablaModelo.setColumnIdentifiers(new Object[]{"ID", "DNI", "Correo", "Nombre Completo", "Activo", "Perfil", "Contraseña", "Departamento"});

        // Verificar si se obtuvieron datos de algún profesor
        if (!listaProfesores.isEmpty()) {
            System.out.println("Se obtuvieron datos de profesores. Cargando en la tabla...");

            // Iterar sobre la lista de profesores y agregar una fila por cada uno
            for (Profesor profesor : listaProfesores) {
                System.out.println("Agregando profesor a la tabla: " + profesor.getNombreCompleto());
                tablaModelo.addRow(new Object[]{
                    profesor.getId(),
                    profesor.getDni(),
                    profesor.getCorreo(),
                    profesor.getNombreCompleto(),
                    profesor.getActivo(),
                    profesor.getPerfil(),
                    profesor.getPass(),
                    profesor.getDepartamento()
                });
            }
        } else {
            // Si no se encuentran datos de profesores, puedes mostrar un mensaje o realizar otra acción
            System.out.println("No se encontraron datos de profesores.");

            // Limpiar la tabla si no hay datos de profesores
            tablaModelo.setRowCount(0);
        }

        // Asignar el modelo de la tabla al JTable correspondiente
        tablaProfesores.setModel(tablaModelo);

        // Validar y repintar el contenedor que contiene la tabla
        profesorPanel.revalidate();
        profesorPanel.repaint();
        System.out.println("Carga de datos de profesores completada.");
    }

    public void mantenimientoCursos(JTable tablaCursos, JPanel cursoPanel) {
        System.out.println("Iniciando carga de datos de cursos...");

        // Consulta SQL para obtener todos los cursos
        ArrayList<Curso> listaCursos = funcionesBD.obtenerListaCursos();

        // Crear un nuevo DefaultTableModel con los datos de los cursos
        DefaultTableModel tablaModelo = new DefaultTableModel();
        tablaModelo.setColumnIdentifiers(new Object[]{"ID", "Etapa", "Descripción", "Código del Curso", "Activo"});

        // Verificar si se obtuvieron datos de algún curso
        if (!listaCursos.isEmpty()) {
            System.out.println("Se obtuvieron datos de cursos. Cargando en la tabla...");

            // Iterar sobre la lista de cursos y agregar una fila por cada uno
            for (Curso curso : listaCursos) {
                System.out.println("Agregando curso a la tabla: " + curso.getEtapa());
                tablaModelo.addRow(new Object[]{
                    curso.getId(),
                    curso.getEtapa(),
                    curso.getDescripcion(),
                    curso.getCodcurso(),
                    curso.isActivo()
                });
            }
        } else {
            // Si no se encuentran datos de cursos, puedes mostrar un mensaje o realizar otra acción
            System.out.println("No se encontraron datos de cursos.");

            // Limpiar la tabla si no hay datos de cursos
            tablaModelo.setRowCount(0);
        }

        // Asignar el modelo de la tabla al JTable correspondiente
        tablaCursos.setModel(tablaModelo);

        // Validar y repintar el contenedor que contiene la tabla
        cursoPanel.revalidate();
        cursoPanel.repaint();
        System.out.println("Carga de datos de cursos completada.");
    }
}
