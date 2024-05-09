package com.scrollBar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(16, 8));
        setForeground(new Color(102, 102, 102));
        setBackground(new Color(40, 40, 40));
    }
}
