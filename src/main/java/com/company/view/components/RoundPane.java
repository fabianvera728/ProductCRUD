package com.company.view.components;

import javax.swing.*;
import java.awt.*;

public class RoundPane extends JPanel {

    private Color background;
    private Color borderColor;
    private Color aux;
    private int radius;
    private int grosor;
    private boolean haveBorder = false;

    public RoundPane(Color color, int radio) {
        super();
        RoundPane.this.setVisible(true);
        RoundPane.this.borderColor = color;
        RoundPane.this.radius = radio;
        RoundPane.this.grosor = 0;
        RoundPane.this.background = color;
        RoundPane.this.setOpaque(false);
    }

    public RoundPane(int ancho, Color color) {
        super();
        RoundPane.this.setVisible(true);
        RoundPane.this.setSize(ancho, 0);
        RoundPane.this.setPreferredSize(new Dimension(ancho, 0));
        RoundPane.this.background = color;
        RoundPane.this.borderColor = color;
        RoundPane.this.radius = 50;
        RoundPane.this.grosor = 0;
        RoundPane.this.setOpaque(false);
    }

    public RoundPane(int radius, int ancho, Color color) {
        super();
        RoundPane.this.setVisible(true);
        RoundPane.this.setSize(ancho, 0);
        RoundPane.this.setPreferredSize(new Dimension(ancho, 0));
        RoundPane.this.background = color;
        RoundPane.this.borderColor = color;
        RoundPane.this.radius = radius;
        RoundPane.this.grosor = 0;
        RoundPane.this.setOpaque(false);
    }

    public RoundPane(int ancho, int radio, int grosor, Color background, Color borderColor) {
        super();
        RoundPane.this.setVisible(true);
        RoundPane.this.setPreferredSize(new Dimension((int) (ancho + ancho * 0.05), 0));
        RoundPane.this.setOpaque(false);
        RoundPane.this.background = background;
        RoundPane.this.borderColor = borderColor;
        RoundPane.this.radius = radio;
        RoundPane.this.grosor = grosor;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setOpaque(false);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(RoundPane.this.background);
        g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), RoundPane.this.radius, RoundPane.this.radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setBackgroundColor(Color color) {
        this.background = color;
        this.repaint();
    }

}
