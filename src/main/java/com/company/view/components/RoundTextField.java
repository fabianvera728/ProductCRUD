/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view.components;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;

import com.company.view.vistaPatrones.Diseño;


/**
 *
 * @author FABIAN-VC
 */
public class RoundTextField extends RoundPane implements Diseño, MouseListener {

    private Color borderColor;
    private JTextField text;
    private boolean clean = false;

    public RoundTextField(int radio, int width,int height, Color color) {
        super(radio, width, color);
        this.borderColor = COLOR_GRAY_TEXT_FIELD;
        this.text = new JTextField();
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new BorderLayout());
        this.setBackground(color);
        this.text.setOpaque(false);
        this.text.setBorder(null);
        this.text.addMouseListener(this);
        this.text.setHorizontalAlignment(JTextField.LEFT);
        this.text.setFont(Diseño.INTER_MEDIUM_12);
        this.add(text, BorderLayout.CENTER);
        Diseño.makeMargins(this);
        super.addMouseListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(1));
        g2.drawRoundRect(0, 0, RoundTextField.this.getWidth()-1, this.getHeight()-1, super.getRadius(), super.getRadius());
    }

    public void setText(String text) {
        RoundTextField.this.text.setText(text);
    }

    public String getText() {
        return RoundTextField.this.text.getText();
    }
    
    public void setFontTextField(Font font){
        this.text.setFont(font);
    }
    
    public JTextField getRoundText() {
        return text;
    }

    
    
    public void setClickedClean(boolean clean){
        this.clean = clean;
    }
    
    public void mouseClicked(MouseEvent e) {
        if(!clean){
        //RoundTextField.this.text.setText("");
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
        if(!clean){
        //RoundTextField.this.text.setText("");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        borderColor = Diseño.COLOR_VIOLET_PRIMARY;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        borderColor = COLOR_GRAY_TEXT_FIELD;
        repaint();
    }

}
