package com.datos;

/**
 * La clase Paneles representa un objeto que puede tener un estado activo o inactivo.
 * Se utiliza para controlar la activación o desactivación de ciertos elementos visuales o funcionales.
 * 
 * @author Marcos
 * @author Álvaro
 */
public class Paneles {

    private boolean activo;  // Indica si el panel está activo o inactivo

    /**
     * Constructor para crear una instancia de Paneles.
     * 
     * @param activo true para indicar que el panel está activo, false para indicar que está inactivo
     */
    public Paneles(boolean activo) {
        this.activo = activo;
    }

    /**
     * Verifica si el panel está activo.
     * 
     * @return true si el panel está activo, false si está inactivo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Establece el estado de actividad del panel.
     * 
     * @param activo true para activar el panel, false para desactivarlo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
