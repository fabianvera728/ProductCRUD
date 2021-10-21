/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

import com.company.view.vistaPatrones.Diseño;


/**
 *
 * @author FABIAN-VC
 */
public class ButtomBack extends JButton implements Diseño,MouseListener {

    private int radio;
    private Color background;
    private Color borderColor;
    private boolean entro = false;
    private boolean isRound = false;

    public ButtomBack(Color color,boolean round) {
        super();
        this.radio = radio;
        this.background = color;
        this.borderColor = color;
        isRound = round;
        this.radio = 10;
        
        ButtomBack.this.addMouseListener(ButtomBack.this);
        ButtomBack.this.setBorder(null);
        ButtomBack.this.setOpaque(false);
        ButtomBack.this.setContentAreaFilled(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         Graphics2D g2 = (Graphics2D) g;
        if(isRound){
            btnRound(g);
        }else{
            btnCornerRound(g);
        }
        g2.setColor(COLOR_TEXT);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine((int) (this.getWidth() - this.getWidth() * 0.7), (int) (this.getHeight()/2), 
                (int) (this.getWidth() - this.getWidth() * 0.4),(int)(this.getHeight()- this.getHeight() * 0.8));
        g2.drawLine((int) (this.getWidth() - this.getWidth() * 0.7), (int) (this.getHeight()/2), 
                (int) (this.getWidth() - this.getWidth() * 0.4),(int)(this.getHeight()- this.getHeight() * 0.22));
    }

    public void btnRound(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
         g2.setStroke(new BasicStroke(1));
        if (entro == false) {
            g2.setColor(background);
            g2.fillOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
            g2.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        } else {
            g2.setColor(COLORBOTON0);
            g2.fillOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
            g2.setColor(borderColor);
            g2.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        }
    }

    public void btnCornerRound(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1));
        if (entro == false) {
            g2.setColor(background);
            g2.fillRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, radio, radio);
            g2.drawRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, radio, radio);
        } else {
            g2.setColor(COLORBOTON0);
            g2.fillRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, radio, radio);
            g2.setColor(borderColor);
            g2.drawRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, radio, radio);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        borderColor = COLORBOTON0;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        borderColor = COLOR_BORDER_TF;
        repaint();
    }

    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        entro = true;
        borderColor = COLORBOTON0;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        entro = false;
        borderColor = background;
        repaint();
    }
}
