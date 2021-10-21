/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view.components;

import com.company.view.vistaPatrones.Diseño;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author FABIAN-VC
 */
public class DoubleButtom extends JPanel implements Diseño {

    private RoundButtom bt1;
    private RoundButtom bt2;
    int width;
    int heigth;

    public DoubleButtom() {

        DoubleButtom.this.width = 70;
        DoubleButtom.this.heigth = 30;
        DoubleButtom.this.setSize(new Dimension(width, heigth));
        DoubleButtom.this.setPreferredSize(new Dimension(width, heigth));
        DoubleButtom.this.setMinimumSize(new Dimension(width, heigth));
        DoubleButtom.this.setOpaque(false);
        DoubleButtom.this.setBorder(null);
        bt1 = new RoundButtom(COLOR_VALIDATE, 30, 30);
        bt2 = new RoundButtom(COLOR_DELETE, 30, 30);

        DoubleButtom.this.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 0));
        this.add(bt1);
        this.add(bt2);
    }

    public RoundButtom getBt1() {
        return bt1;
    }

    public RoundButtom getBt2() {
        return bt2;
    }

}
