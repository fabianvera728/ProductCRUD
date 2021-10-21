package com.company.view.product;

import com.company.view.components.RoundButtom;
import com.company.view.components.RoundTextField;
import com.company.view.vistaPatrones.Diseño;

import javax.swing.*;
import java.awt.*;

public class PaneRegisterInputs extends JPanel implements Diseño {

    private final JLabel lbl_title = new JLabel("Register new product");
    private final JLabel lbl_name = new JLabel("Name new product");
    private final JLabel lbl_price = new JLabel("Price new product");
    private final JLabel lbl_amount = new JLabel("Amount new's product");
    private final JLabel lbl_category = new JLabel("Category new product");
    private RoundTextField txt_name;
    private RoundTextField txt_price;
    private RoundTextField txt_amount;
    private RoundTextField txt_category;
    private final JLabel lbl_space = new JLabel("                     ");
    private final JLabel lbl_space1 = new JLabel("                     ");
    private RoundButtom btn_save_product;

    public PaneRegisterInputs() {
        this.initView();
        this.initComponents();
        this.addComponents();
    }

    public void initView() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setPreferredSize(new Dimension(300, 35));
        this.setOpaque(false);
    }

    public void initComponents() {
        this.txt_name = new RoundTextField(10, 300, 30, Diseño.COLOR_DEFAULT_BACKGROUND);
        this.txt_price = new RoundTextField(10, 300, 30, Diseño.COLOR_DEFAULT_BACKGROUND);
        this.txt_amount = new RoundTextField(10, 300, 30, Diseño.COLOR_DEFAULT_BACKGROUND);
        this.txt_category = new RoundTextField(10, 300, 30, Diseño.COLOR_DEFAULT_BACKGROUND);
        this.lbl_title.setPreferredSize(new Dimension(300, 40));
        this.lbl_name.setPreferredSize(new Dimension(300, 20));
        this.lbl_amount.setPreferredSize(new Dimension(300, 20));
        this.lbl_price.setPreferredSize(new Dimension(300, 20));
        this.lbl_category.setPreferredSize(new Dimension(300, 20));
        this.lbl_space.setPreferredSize(new Dimension(300, 40));
        this.lbl_title.setFont(Diseño.INTER_MEDIUM_16);
        this.lbl_name.setFont(Diseño.INTER_LIGTH_14);
        this.lbl_price.setFont(Diseño.INTER_LIGTH_14);
        this.lbl_amount.setFont(Diseño.INTER_LIGTH_14);
        this.lbl_category.setFont(Diseño.INTER_LIGTH_14);
        this.btn_save_product = new RoundButtom("Register new product");
        this.btn_save_product.setPreferredSize(new Dimension(300,40));
        this.btn_save_product.setBackground(Diseño.COLOR_VIOLET_PRIMARY);
        this.btn_save_product.setForegroundText(Diseño.COLOR_DEFAULT_WHITE,Diseño.COLOR_DEFAULT_BLACK);
        this.btn_save_product.setBorder_radius(10);
    }

    public void addComponents() {
        this.add(this.lbl_title);
        this.add(this.lbl_name);
        this.add(this.txt_name);
        this.add(this.lbl_price);
        this.add(this.txt_price);
        this.add(this.lbl_amount);
        this.add(this.txt_amount);
        this.add(this.lbl_category);
        this.add(this.txt_category);
        this.add(this.lbl_space);
        this.add(this.btn_save_product);
    }

    public RoundButtom getBtn_save_product() {
        return btn_save_product;
    }

    public RoundTextField getTxt_name() {
        return txt_name;
    }

    public RoundTextField getTxt_price() {
        return txt_price;
    }

    public RoundTextField getTxt_amount() {
        return txt_amount;
    }

    public RoundTextField getTxt_category() {
        return txt_category;
    }
}
