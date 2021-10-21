package com.company.view.product;

import com.company.view.components.RoundButtom;
import com.company.view.components.RoundTextField;
import com.company.view.vistaPatrones.Diseño;

import javax.swing.*;
import java.awt.*;

public class PaneConsultInputs extends JPanel implements Diseño {

    private final JLabel lbl_title = new JLabel("Consult products");
    private final JLabel lbl_id = new JLabel("Id");
    private final JLabel lbl_name = new JLabel("Name");
    private final JLabel lbl_price = new JLabel("Price");
    private final JLabel lbl_amount = new JLabel("Amount");
    private final JLabel lbl_category = new JLabel("Category");
    private RoundTextField txt_name;
    private RoundTextField txt_price;
    private RoundTextField txt_amount;
    private RoundTextField txt_category;
    private RoundTextField txt_id;
    private final JLabel lbl_space = new JLabel("                     ");
    private final JLabel lbl_space1 = new JLabel("                     ");
    private RoundButtom btn_consult_product;
    private RoundButtom btn_delete_product;
    private RoundButtom btn_update_product;

    public PaneConsultInputs() {
        this.initView();
        this.initComponents();
        this.addComponents();
    }

    public void initView() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setPreferredSize(new Dimension(WIDTH_LEFT_PANE, 35));
        this.setOpaque(false);
    }

    public void initComponents() {
        this.txt_id = new RoundTextField(10, WIDTH_LEFT_PANE, 30, Diseño.COLOR_DEFAULT_BACKGROUND);
        this.txt_name = new RoundTextField(10, WIDTH_LEFT_PANE, 30, Diseño.COLOR_DEFAULT_BACKGROUND);
        this.txt_price = new RoundTextField(10, WIDTH_LEFT_PANE, 30, Diseño.COLOR_DEFAULT_BACKGROUND);
        this.txt_amount = new RoundTextField(10, WIDTH_LEFT_PANE, 30, Diseño.COLOR_DEFAULT_BACKGROUND);
        this.txt_category = new RoundTextField(10, WIDTH_LEFT_PANE, 30, Diseño.COLOR_DEFAULT_BACKGROUND);
        this.lbl_title.setPreferredSize(new Dimension(WIDTH_LEFT_PANE, 40));
        this.lbl_id.setPreferredSize(new Dimension(WIDTH_LEFT_PANE, 15));
        this.lbl_name.setPreferredSize(new Dimension(WIDTH_LEFT_PANE, 15));
        this.lbl_amount.setPreferredSize(new Dimension(WIDTH_LEFT_PANE, 15));
        this.lbl_price.setPreferredSize(new Dimension(WIDTH_LEFT_PANE, 15));
        this.lbl_category.setPreferredSize(new Dimension(WIDTH_LEFT_PANE, 15));
        this.lbl_space.setPreferredSize(new Dimension(WIDTH_LEFT_PANE, 20));
        this.lbl_title.setFont(Diseño.INTER_MEDIUM_16);
        this.lbl_id.setFont(Diseño.INTER_LIGTH_14);
        this.lbl_name.setFont(Diseño.INTER_LIGTH_14);
        this.lbl_price.setFont(Diseño.INTER_LIGTH_14);
        this.lbl_amount.setFont(Diseño.INTER_LIGTH_14);
        this.lbl_category.setFont(Diseño.INTER_LIGTH_14);
        this.btn_consult_product = new RoundButtom("Consult product");
        this.btn_consult_product.setPreferredSize(new Dimension(WIDTH_LEFT_PANE,35));
        this.btn_consult_product.setBackground(Diseño.COLOR_VIOLET_PRIMARY);
        this.btn_consult_product.setForegroundText(Diseño.COLOR_DEFAULT_WHITE,Diseño.COLOR_DEFAULT_BLACK);
        this.btn_consult_product.setBorder_radius(10);
        this.btn_update_product = new RoundButtom("Update product");
        this.btn_update_product.setPreferredSize(new Dimension(WIDTH_LEFT_PANE,35));
        this.btn_update_product.setBackground(Diseño.COLOR_DEFAULT_WHITE);
        this.btn_update_product.setBorder_color(Diseño.COLOR_VIOLET_PRIMARY);
        this.btn_update_product.setForegroundText(Diseño.COLOR_DEFAULT_BLACK,Diseño.COLOR_DEFAULT_BLACK);
        this.btn_update_product.setBorder_radius(10);
        this.btn_delete_product = new RoundButtom("Delete product");
        this.btn_delete_product.setPreferredSize(new Dimension(WIDTH_LEFT_PANE,35));
        this.btn_delete_product.setBackground(Diseño.COLOR_DEFAULT_WHITE);
        this.btn_delete_product.setBorder_color(Diseño.COLOR_RED_PRIMARY);
        this.btn_delete_product.setForegroundText(Diseño.COLOR_DEFAULT_BLACK,Diseño.COLOR_DEFAULT_BLACK);
        this.btn_delete_product.setBorder_radius(10);
    }

    public void addComponents() {
        this.add(this.lbl_title);
        this.add(this.lbl_id);
        this.add(this.txt_id);
        this.add(this.lbl_name);
        this.add(this.txt_name);
        this.add(this.lbl_price);
        this.add(this.txt_price);
        this.add(this.lbl_amount);
        this.add(this.txt_amount);
        this.add(this.lbl_category);
        this.add(this.txt_category);
        this.add(lbl_space);
        this.add(this.btn_consult_product);
        this.add(this.btn_update_product);
        this.add(this.btn_delete_product);
    }


    public RoundButtom getBtn_delete_product() {
        return btn_delete_product;
    }

    public RoundButtom getBtn_consult_product() {
        return btn_consult_product;
    }

    public RoundButtom getBtn_update_product() {
        return btn_update_product;
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

    public RoundTextField getTxt_id() {
        return txt_id;
    }
}
