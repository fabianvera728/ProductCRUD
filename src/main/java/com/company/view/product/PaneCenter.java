package com.company.view.product;

import com.company.model.Product;
import com.company.view.components.RoundPane;
import com.company.view.interfaces.BaseView;
import com.company.view.vistaPatrones.Diseño;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PaneCenter extends JPanel implements BaseView, Diseño {


    private RegisterPane register_pane;
    private ConsultPane consult_pane;
    private RoundPane center;
    private ArrayList<Product> products;

    public PaneCenter(ArrayList<Product> products) {
        super();
        this.initView();
        this.products = products;
        this.initComponents();
        this.addComponents();
    }

    public void initView() {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        Diseño.makeMarginsEast(this, 10, 0);
        Diseño.makeMarginsWest(this, 10, 0);
        Diseño.makeMarginsSouth(this, 0, 10);
        Diseño.makeMarginsNorth(this, 0, 10);
    }

    public void initComponents() {
        this.register_pane = new RegisterPane();
        this.consult_pane = new ConsultPane(this.products);
        this.center = new RoundPane(COLOR_BACKGROUND2, 50);
        this.center.setOpaque(false);
        this.center.setLayout(new CardLayout());
    }

    public void addComponents() {
        this.center.add(this.register_pane);
        this.center.add(this.consult_pane);
        this.add(center,BorderLayout.CENTER);
    }

    public RegisterPane getRegister_pane() {
        return register_pane;
    }

    public ConsultPane getConsult_pane() {
        return consult_pane;
    }

}
