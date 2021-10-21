package com.company.view.product;

import com.company.view.components.RoundButtom;
import com.company.view.vistaPatrones.Diseño;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel implements Diseño {

    private JPanel container_buttons;
    private RoundButtom btn_register_product;
    private RoundButtom btn_consult_product;
    private JLabel title;

    public Header(){
        super();
        this.initPane();
        this.initComponents();
        this.addComponents();

    }

    private void initPane(){
        this.setPreferredSize(new Dimension(ANCHOVENTANA,40));
        this.setBackground(COLOR_BACKGROUND2);
        this.setLayout(new BorderLayout());
    }

    private void initComponents(){
        this.container_buttons = new JPanel();
        this.container_buttons.setBackground(Diseño.COLOR_DEFAULT_WHITE);

        this.btn_register_product = new RoundButtom("Register");
        this.btn_register_product.setPreferredSize(new Dimension(125,30));
        this.btn_register_product.setBackground(Diseño.COLOR_VIOLET_PRIMARY);
        this.btn_register_product.setForegroundText(Diseño.COLOR_DEFAULT_WHITE, Diseño.COLOR_DEFAULT_BLACK);
        this.btn_register_product.setBorder_color(Diseño.COLOR_VIOLET_PRIMARY);
        this.btn_register_product.setBorder_radius(10);

        this.btn_consult_product = new RoundButtom("Consult");
        this.btn_consult_product.setPreferredSize(new Dimension(125,30));
        this.btn_consult_product.setBackground(Diseño.COLOR_DEFAULT_WHITE);
        this.btn_consult_product.setForegroundText(Diseño.COLOR_DEFAULT_BLACK, Diseño.COLOR_DEFAULT_BLACK);
        this.btn_consult_product.setBorder_color(Diseño.COLOR_VIOLET_PRIMARY);
        this.btn_consult_product.setBorder_radius(10);

        this.title = new JLabel("Products   ");
        this.title.setHorizontalAlignment(JLabel.RIGHT);
        this.title.setFont(Diseño.INTER_MEDIUM_16);
    }

    private void addComponents(){
        this.container_buttons.add(this.btn_register_product);
        this.container_buttons.add(this.btn_consult_product);
        this.add(this.title, BorderLayout.CENTER);
        this.add(this.container_buttons, BorderLayout.WEST);
    }


    public RoundButtom getBtn_register_product() {
        return btn_register_product;
    }

    public RoundButtom getBtn_consult_product() {
        return btn_consult_product;
    }

}
