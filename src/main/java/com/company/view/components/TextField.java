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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.company.view.vistaPatrones.Diseño;

/**
 *
 * @author FABIAN-VC
 */
public class TextField extends JPanel implements Diseño, MouseListener {

    private int width;
    private int heigth;
    private Color background;
    private Color borderColor  = COLOR_GRAY_TEXT_FIELD;;
    private JTextField pf;    
    

    public TextField() {
        initComponents();
    }

    public TextField(int width,int heigth){
        TextField.this.width = width;
        TextField.this.heigth = heigth;
        TextField.this.background = COLOR_GRAY_TEXT_FIELD;
        TextField.this.setSize(new Dimension(width, heigth));
        TextField.this.setPreferredSize(new Dimension(width + 30, heigth));
        TextField.this.setMinimumSize(new Dimension(width, heigth));
        TextField.this.setOpaque(false);
        TextField.this.setBorder(null);
        TextField.this.setLayout(new BorderLayout(5, 0));

        TextField.this.pf = new JTextField();
        TextField.this.pf.setPreferredSize(new Dimension(width - 50, heigth));
        TextField.this.pf.setMaximumSize(new Dimension(width - 50, heigth));
        TextField.this.pf.setMinimumSize(new Dimension(width - 50, heigth));
        TextField.this.pf.setOpaque(false);
        TextField.this.pf.setBorder(null);
        TextField.this.pf.setHorizontalAlignment(JTextField.CENTER);
        TextField.this.pf.setForeground(COLOR_TEXT);

        TextField.this.pf.setCaretPosition(0);
        TextField.this.pf.addMouseListener(this);
        
        TextField.this.add(pf, BorderLayout.CENTER);

        Diseño.makeMargins(this);
        super.addMouseListener(this);
    }
    public void initComponents() {
        TextField.this.width = 100;
        TextField.this.heigth = 30;
        TextField.this.background = COLOR_GRAY_TEXT_FIELD;
        TextField.this.setSize(new Dimension(width, heigth));
        TextField.this.setPreferredSize(new Dimension(width + 30, heigth));
        TextField.this.setMinimumSize(new Dimension(width, heigth));
        TextField.this.setOpaque(false);
        TextField.this.setBorder(null);
        TextField.this.setLayout(new BorderLayout(5, 0));
        
        TextField.this.pf = new JTextField();
        TextField.this.pf.setPreferredSize(new Dimension(width - 50, heigth));
        TextField.this.pf.setMaximumSize(new Dimension(width - 50, heigth));
        TextField.this.pf.setMinimumSize(new Dimension(width - 50, heigth));
        TextField.this.pf.setOpaque(false);
        TextField.this.pf.setBorder(null);
        TextField.this.pf.setHorizontalAlignment(JTextField.CENTER);
        TextField.this.pf.setForeground(COLOR_TEXT);
        TextField.this.pf.setCaretPosition(0);
        TextField.this.pf.addMouseListener(this);
        
        TextField.this.add(pf, BorderLayout.CENTER);
       
        Diseño.makeMargins(this);
        super.addMouseListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(COLOR_GRAY_TEXT_FIELD);
        int prop = (int)(TextField.this.getWidth()*0.03);
        g2.fillRoundRect(0, 0, TextField.this.width+30-prop, 30-prop,30,30);
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(1));
        g2.drawRoundRect(0, 0, TextField.this.width+30-prop, 30-prop,30,30);
        
    }
    public void setText(String text){
        TextField.this.pf.setText(text);
    }
    public String getText(){
        return TextField.this.pf.getText();
    }
    public void mouseClicked(MouseEvent e) {
        TextField.this.pf.setText("");
    }
    public void mousePressed(MouseEvent e) {
        
    }
    public void mouseReleased(MouseEvent e) {
        TextField.this.pf.setText("");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        borderColor = COLOR_BORDER_TF;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!TextField.this.pf.isFocusOwner()){
            borderColor = COLOR_GRAY_TEXT_FIELD;
            repaint();
        }
    }
}
