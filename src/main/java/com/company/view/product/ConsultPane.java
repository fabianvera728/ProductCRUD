package com.company.view.product;

import com.company.model.Product;
import com.company.view.components.RoundPane;
import com.company.view.interfaces.BaseView;
import com.company.view.vistaPatrones.Diseño;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ConsultPane extends RoundPane implements BaseView, Diseño {

    private RoundPane pane_left;
    private JPanel pane_center;
    private TableProducts table;
    private ArrayList<Product> products;
    private PaneConsultInputs pane_consult_inputs;

    public ConsultPane(ArrayList<Product> products) {
        super(COLOR_BACKGROUND2, 40);
        this.products = products;
        this.initView();
        this.initComponents();
        this.addComponents();
    }

    public void initView() {
        this.setLayout(new BorderLayout());
    }

    public void initComponents() {
        this.pane_left = new RoundPane(COLOR_DEFAULT_WHITE,40);
        this.pane_left.setOpaque(false);
        this.pane_left.setLayout(new BorderLayout());
        this.pane_center = new JPanel();
        this.pane_center.setOpaque(false);
        this.pane_center.setLayout(new BorderLayout());

        Diseño.makeMarginsEast(this.pane_left, 10, 0);
        Diseño.makeMarginsWest(this.pane_left, 40, 0);
        Diseño.makeMarginsSouth(this.pane_left, 0, 20);
        Diseño.makeMarginsNorth(this.pane_left, 0, 30);
        Diseño.makeMarginsEast(this.pane_center, 40, 0);
        Diseño.makeMarginsWest(this.pane_center, 20, 0);
        Diseño.makeMarginsSouth(this.pane_center, 0, 30);
        Diseño.makeMarginsNorth(this.pane_center, 0, 80);

        this.pane_consult_inputs = new PaneConsultInputs();
        this.table = new TableProducts(this.products);
    }

    public void addComponents() {
        this.pane_left.add(this.pane_consult_inputs, BorderLayout.CENTER);
        this.pane_center.add(this.table, BorderLayout.CENTER);
        this.add(this.pane_left, BorderLayout.WEST);
        this.add(this.pane_center, BorderLayout.CENTER);
    }

    public TableProducts getTable() {
        return table;
    }

    public PaneConsultInputs getPane_consult_inputs() {
        return pane_consult_inputs;
    }
}
