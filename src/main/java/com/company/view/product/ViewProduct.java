package com.company.view.product;

import com.company.model.Product;
import com.company.view.components.RoundButtom;
import com.company.view.vistaPatrones.Diseño;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewProduct extends JFrame implements Diseño {

    private Header header;
    private PaneCenter pane_center;
    private ArrayList<Product> products;

    public ViewProduct(ArrayList<Product> products) {
        super();
        this.initView();
        this.products =  products;
        this.initComponents();
        this.addComponents();
        pack();
    }

    private void initView() {
        this.setTitle("Manage products");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ALTOVENTANA- 50,ALTOVENTANA);
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(ANCHOVENTANA, ALTOVENTANA));
        this.setLayout(new BorderLayout());
    }

    public void initComponents() {
        this.header = new Header();
        this.pane_center = new PaneCenter(this.products);
    }

    public void addComponents() {
        this.add(this.header, BorderLayout.NORTH);
        this.add(this.pane_center);
    }

    public Header getHeader() {
        return header;
    }

    public PaneCenter getPane_center() {
        return pane_center;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
