package com.company.view.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import com.company.view.vistaPatrones.Diseño;


public class Swicth extends JComponent implements MouseListener, Diseño {
    private boolean OnOff = true;
    private final int MARGIN = 5;
    private final int BORDER = 4;
    private Color backgroundColor;
    private Color buttonColor;
    private final Color DISABLED_COMPONENT_COLOR = new Color(131,131,131);
    public Swicth(){
        super();
        Swicth.this.setSize(new Dimension(60, 40));
        Swicth.this.setPreferredSize(new Dimension(60, 40));
        Swicth.this.setMinimumSize(new Dimension(60, 40));
        Swicth.this.setVisible(true);
        Swicth.this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Swicth.this.addMouseListener(Swicth.this);
        //colores iniciales
        Swicth.this.setBackgroundColor(new Color(75,216,101));
        Swicth.this.setButtonColor(new Color(255,255,255));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint twoColorGradient = new GradientPaint(
            getWidth(), 0f, DISABLED_COMPONENT_COLOR, 0, getHeight(), COLORBOTON2);
        g2.setPaint(twoColorGradient);
        if (isOpaque()) {//Pinta el fondo del componente
            g2.setColor(getBackground());
            g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        }

        if(isEnabled()){//componente habilitado
            g2.setColor(( (OnOff) ? getBackgroundColor():new Color(216,217,219) ) );
            g2.fill(new RoundRectangle2D.Double((float) MARGIN, (float) MARGIN,
                    (float) getWidth() - MARGIN * 2, (float) getHeight() - MARGIN * 2,
                    getHeight() - MARGIN * 2, getHeight() - MARGIN * 2));
        }else{//componente desabilitado
            g2.setColor(DISABLED_COMPONENT_COLOR );
            g2.draw(new RoundRectangle2D.Double((float) MARGIN, (float) MARGIN,
                    (float) getWidth() - MARGIN * 2, (float) getHeight() - MARGIN * 2,
                    getHeight() - MARGIN * 2, getHeight() - MARGIN * 2));
        }

        g2.setColor((isEnabled()) ? getButtonColor() : DISABLED_COMPONENT_COLOR);
        //boton circular
        if (OnOff) {//ON a la izquierda
            g2.fillOval(MARGIN + BORDER / 2, MARGIN + BORDER / 2,
                    getHeight() - MARGIN * 2 - BORDER, getHeight() - MARGIN * 2 - BORDER);
        } else {//OFF a la derecha
            g2.fillOval(getWidth() - getHeight() + MARGIN + BORDER / 2, MARGIN + BORDER / 2,
                    getHeight() - MARGIN * 2 - BORDER, getHeight() - MARGIN * 2 - BORDER);
        }
    }

    public boolean isOnOff() {
        return OnOff;
    }

    public void setOnOff(boolean OnOff) {
        this.OnOff = OnOff;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(Color buttonColor) {
        this.buttonColor = buttonColor;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        this.OnOff = !this.OnOff;
        repaint();
    }
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {
    }
}
