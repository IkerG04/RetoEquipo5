package com.extra;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 * La clase ScrollBarCustom representa una barra de desplazamiento personalizada que utiliza la interfaz ModernScrollBarUI para su apariencia.
 * Configura las propiedades visuales y dimensiones de la barra de desplazamiento.
 * 
 * @author Marcos
 * @author Álvaro
 */
public class ScrollBarCustom extends JScrollBar {

    /**
     * Constructor de ScrollBarCustom que inicializa la barra de desplazamiento con la interfaz ModernScrollBarUI.
     * Configura el tamaño preferido, color de primer plano y color de fondo de la barra de desplazamiento.
     */
    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(16, 0)); // Establece el tamaño preferido (ancho, alto)
        setForeground(new Color(102, 102, 102)); // Establece el color de primer plano (foreground)
        setBackground(new Color(40, 40, 40)); // Establece el color de fondo (background)
    }
}
