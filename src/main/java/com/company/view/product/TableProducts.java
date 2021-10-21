package com.company.view.product;

import com.company.model.Product;
import com.company.view.components.RoundPane;
import com.company.view.interfaces.BaseView;
import com.company.view.vistaPatrones.Diseño;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TableProducts extends JPanel implements BaseView, Diseño {

    private ArrayList<Product> products;
    private RoundPane headers_table;
    private JScrollPane scroll;
    private JPanel rows_product;
    private int count_products;

    public TableProducts(ArrayList<Product> products) {
        super();
        this.products = new ArrayList<>();
        this.count_products = 0;
        this.initView();
        this.initComponents();
        this.addComponents();
    }

    public void initView() {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
    }

    public void initComponents() {
        this.rows_product = new JPanel();
        this.rows_product.setOpaque(false);
        this.rows_product.setLayout(new GridLayout(this.products.size(), 1, 10, 10));
        this.scroll = new JScrollPane(this.rows_product, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.scroll = new JScrollPane(this.rows_product);
        this.scroll.setOpaque(false);
        this.scroll.setBorder(null);
        this.scroll.getViewport().setOpaque(false);
        this.scroll.setBackground(null);
        this.headers_table = new RoundPane(Diseño.COLOR_VIOLET_PRIMARY, 10);
        headers_table.setLayout(new BorderLayout());
        JPanel con3 = new JPanel();
        con3.setOpaque(false);
        con3.setLayout(new GridLayout(1, 5, 10, 10));
        JLabel textid = new JLabel("Id");
        textid.setForeground(Diseño.COLOR_DEFAULT_WHITE);
        textid.setFont(Diseño.INTER_MEDIUM_14);
        JLabel lbl_price = new JLabel("Price");
        lbl_price.setForeground(Diseño.COLOR_DEFAULT_WHITE);
        lbl_price.setFont(Diseño.INTER_MEDIUM_14);
        JLabel lbl_name = new JLabel("Name");
        lbl_name.setForeground(Diseño.COLOR_DEFAULT_WHITE);
        lbl_name.setFont(Diseño.INTER_MEDIUM_14);
        JLabel lbl_amount = new JLabel("Amount");
        lbl_amount.setForeground(Diseño.COLOR_DEFAULT_WHITE);
        lbl_amount.setFont(Diseño.INTER_MEDIUM_14);
        JLabel lbl_category = new JLabel("Category");
        lbl_category.setForeground(Diseño.COLOR_DEFAULT_WHITE);
        lbl_category.setFont(Diseño.INTER_MEDIUM_14);
        con3.add(textid);
        con3.add(lbl_name);
        con3.add(lbl_price);
        con3.add(lbl_amount);
        con3.add(lbl_category);
        headers_table.add(con3, BorderLayout.CENTER);
        Diseño.makeMarginsEast(headers_table, 20, 0);
        Diseño.makeMarginsWest(headers_table, 20, 0);
        Diseño.makeMarginsSouth(headers_table, 0, 10);
        Diseño.makeMarginsNorth(headers_table, 0, 10);
    }

    public void addComponents() {
        this.add(scroll, BorderLayout.CENTER);
        this.add(this.headers_table, BorderLayout.NORTH);
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
        this.rows_product.setLayout(new GridLayout(this.products.size(), 1, 10,10));
    }

    public DetailProduct generateProduct(Product new_product, boolean is_adding) {
        if (is_adding) {
            this.count_products += 1;
            this.products.add(new_product);
            this.rows_product.setLayout(new GridLayout(count_products, 1, 10,10));
        }
        return new DetailProduct(new_product);
    }

    public void addProduct(JComponent component) {
        this.rows_product.add(component);
    }

    public JPanel getRows_product() {
        return rows_product;
    }

    public void setCount_products(int count_products) {
        this.count_products = count_products;
        this.rows_product.setLayout(new GridLayout(this.count_products, 1, 10,10));
    }

}
