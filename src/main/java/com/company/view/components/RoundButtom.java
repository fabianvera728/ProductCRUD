/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view.components;

import com.company.view.vistaPatrones.Diseño;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author FABIAN-VC
 */
public class RoundButtom extends JButton implements MouseListener, Diseño {

    private int border_radius = 0;
    private int width = 100;
    private int heigth = 40;

    private Color foreground = Diseño.COLOR_DEFAULT_WHITE;
    private Color foreground_hover = Diseño.COLOR_DEFAULT_WHITE;

    private Color background;
    private Color background_hover = Diseño.COLOR_DEFAULT_BACKGROUND;

    private Color border_color_hover = Diseño.COLOR_VIOLET_PRIMARY;
    private Color border_color_pressed = Diseño.COLOR_BACKGROUND3;
    private Color border_color;

    private boolean is_entry = false;
    private boolean isRound = false;
    private boolean is_pressed = false;
    private JLabel text;

    public RoundButtom(String text) {
        this.text = new JLabel("");
        this.setSize(new Dimension(width, heigth));
        this.setPreferredSize(new Dimension(width, heigth));
        this.setMinimumSize(new Dimension(width, heigth));
        this.addMouseListener(RoundButtom.this);
        this.setBorder(null);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setLayout(new BorderLayout());
        this.setFont(Diseño.INTER_MEDIUM_14);
        this.text.setText(text);
        this.text.setOpaque(false);
        this.text.setFont(Diseño.INTER_MEDIUM_14);
        this.text.setHorizontalAlignment(JLabel.CENTER);
        this.text.setForeground(this.foreground);
        this.add(this.text, BorderLayout.CENTER);
    }

    public RoundButtom(Color color, int border_radius, int width, int heigth) {
        super();
        this.border_radius = border_radius;
        this.width = width;
        this.heigth = heigth;
        this.background = color;
        this.border_color = color;
        RoundButtom.this.setSize(new Dimension(width, heigth));
        RoundButtom.this.setPreferredSize(new Dimension(width, heigth));
        RoundButtom.this.setMinimumSize(new Dimension(width, heigth));
        RoundButtom.this.addMouseListener(RoundButtom.this);
        RoundButtom.this.setBorder(null);
        RoundButtom.this.setOpaque(false);
        RoundButtom.this.setContentAreaFilled(false);
    }

    public RoundButtom(Color color, int width, int heigth) {
        super();
        this.border_radius = border_radius;
        this.width = width;
        this.heigth = heigth;
        this.background = color;
        this.border_color = color;
        isRound = true;
        RoundButtom.this.setSize(new Dimension(width, heigth));
        RoundButtom.this.setPreferredSize(new Dimension(width, heigth));
        RoundButtom.this.setMinimumSize(new Dimension(width, heigth));
        RoundButtom.this.addMouseListener(RoundButtom.this);
        RoundButtom.this.setBorder(null);
        RoundButtom.this.setOpaque(false);
        RoundButtom.this.setContentAreaFilled(false);
    }

    public RoundButtom(Color color, int border_radius, int width, int heigth, String text) {
        super();
        this.border_radius = border_radius;
        this.width = width;
        this.heigth = heigth;
        this.background = color;
        this.border_color = color;
        RoundButtom.this.setSize(new Dimension(width, heigth));
        RoundButtom.this.setPreferredSize(new Dimension(width, heigth));
        RoundButtom.this.setMinimumSize(new Dimension(width, heigth));
        RoundButtom.this.addMouseListener(RoundButtom.this);
        RoundButtom.this.setBorder(null);
        RoundButtom.this.setOpaque(false);
        RoundButtom.this.setContentAreaFilled(false);
        RoundButtom.this.setLayout(new BorderLayout());
        RoundButtom.this.setFont(new Font("Verdana", Font.BOLD, 12));
        JLabel name = new JLabel(text);
        name.setOpaque(false);
        name.setHorizontalAlignment(JLabel.CENTER);
//        name.setFont(new Font("Verdana", Font.BOLD, 12));
        name.setForeground(COLOR_TEXT);
        RoundButtom.this.add(name, BorderLayout.CENTER);

    }


    public void setBorder_radius(int border_radius) {
        this.border_radius = border_radius;
    }

    public void setForegroundText(Color foreground, Color foreground_hover) {
        this.foreground = (foreground);
        this.foreground_hover = foreground_hover;
        this.text.setForeground(foreground);
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public void setBorder_color(Color border_color) {
        this.border_color = border_color;
    }

    @Override
    public void paintComponent(Graphics g) {
        if (isRound) {
            btnRound(g);
        } else {
            btnCornerRound(g);
        }
    }

    public void btnRound(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1));
        if (!is_entry) {
            g2.setColor(background);
            g2.fillOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        } else {
            g2.setColor(COLORTP3);
            g2.fillOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
            g2.setColor(border_color);
        }
        g2.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
    }

    public void btnCornerRound(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1));
        if (!is_entry) {
            g2.setColor(background);
            g2.fillRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, border_radius, border_radius);
            g2.setColor(this.border_color);
        } else {
            g2.setColor(this.background_hover);
            g2.fillRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, border_radius, border_radius);
            if (!is_pressed) {
                g2.setColor(this.border_color_hover);
            } else {
                g2.setColor(this.border_color_pressed);
            }
        }
        g2.drawRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, border_radius, border_radius);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.text.setForeground(this.foreground_hover);
        this.is_pressed = true;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.is_pressed = false;
        repaint();
    }

    public void mouseReleased(MouseEvent e) {
        this.is_pressed = false;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.is_entry = true;
        this.text.setForeground(this.foreground_hover);
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        is_entry = false;
        this.text.setForeground(this.foreground);
        repaint();
    }
}
