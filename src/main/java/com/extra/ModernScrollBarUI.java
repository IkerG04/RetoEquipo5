package com.extra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * La clase ModernScrollBarUI personaliza la apariencia de las barras de desplazamiento (scrollbars) en componentes Swing.
 * Proporciona un diseño y estilo moderno para los botones y las áreas de la barra de desplazamiento.
 * 
 * @author Marcos
 * @author Álvaro
 */
public class ModernScrollBarUI extends BasicScrollBarUI {

    private final int THUMB_SIZE = 40;

    /**
     * Devuelve el tamaño máximo de la barra de desplazamiento.
     * 
     * @return Dimension que especifica el tamaño máximo del pulgar de la barra de desplazamiento
     */
    @Override
    protected Dimension getMaximumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    /**
     * Devuelve el tamaño mínimo del pulgar de la barra de desplazamiento.
     * 
     * @return Dimension que especifica el tamaño mínimo del pulgar de la barra de desplazamiento
     */
    @Override
    protected Dimension getMinimumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    /**
     * Crea un botón de incremento para la barra de desplazamiento.
     * 
     * @param orientation orientación de la barra de desplazamiento
     * @return JButton creado como botón de incremento
     */
    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new ScrollBarButton();
    }

    /**
     * Crea un botón de decremento para la barra de desplazamiento.
     * 
     * @param orientation orientación de la barra de desplazamiento
     * @return JButton creado como botón de decremento
     */
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new ScrollBarButton();
    }

    /**
     * Pinta la pista (track) de la barra de desplazamiento.
     * 
     * @param g objeto Graphics para pintar
     * @param c componente de barra de desplazamiento
     * @param r área del rectángulo que representa la pista
     */
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int size;
        int x;
        int y;
        int width;
        int height;
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            size = r.width / 2;
            x = r.x + ((r.width - size) / 2);
            y = r.y;
            width = size;
            height = r.height;
        } else {
            size = r.height / 2;
            y = r.y + ((r.height - size) / 2);
            x = 0;
            width = r.width;
            height = size;
        }
        g2.setColor(new Color(240, 240, 240));
        g2.fillRect(x, y, width, height);
    }

    /**
     * Pinta el pulgar (thumb) de la barra de desplazamiento.
     * 
     * @param g objeto Graphics para pintar
     * @param c componente de barra de desplazamiento
     * @param r área del rectángulo que representa el pulgar
     */
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = r.x;
        int y = r.y;
        int width = r.width;
        int height = r.height;
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            y += 8;
            height -= 16;
        } else {
            x += 8;
            width -= 16;
        }
        g2.setColor(scrollbar.getForeground());
        g2.fillRoundRect(x, y, width, height, 10, 10);
    }

    /**
     * Clase interna que representa un botón personalizado para la barra de desplazamiento.
     */
    private class ScrollBarButton extends JButton {

        /**
         * Constructor de ScrollBarButton.
         */
        public ScrollBarButton() {
            setBorder(BorderFactory.createEmptyBorder());
        }

        /**
         * Sustitución del método paint para no realizar ninguna operación.
         * 
         * @param g objeto Graphics para pintar
         */
        @Override
        public void paint(Graphics g) {
            // No se realiza ninguna operación de pintado
        }
    }
}
