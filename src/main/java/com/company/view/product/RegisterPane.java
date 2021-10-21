package com.company.view.product;

import com.company.model.Product;
import com.company.view.components.RoundPane;
import com.company.view.interfaces.BaseView;
import com.company.view.vistaPatrones.Diseño;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RegisterPane extends RoundPane implements BaseView, Diseño {

    private RoundPane pane_left;
    private JPanel pane_center;

    private PaneRegisterInputs pane_register_inputs;


    public RegisterPane(){
        super(COLOR_DEFAULT_WHITE, 40);

        this.initView();
        this.initComponents();
        this.addComponents();
    }

    public void initView() {
        this.setLayout(new BorderLayout(0,0));
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
        Diseño.makeMarginsSouth(this.pane_center, 0, 40);
        Diseño.makeMarginsNorth(this.pane_center, 0, 70);

        this.pane_register_inputs = new PaneRegisterInputs();

    }

    public void addComponents() {
        this.pane_left.add(this.pane_register_inputs, BorderLayout.CENTER);
        this.add(this.pane_left, BorderLayout.WEST);
        this.add(this.pane_center, BorderLayout.CENTER);
    }

    public PaneRegisterInputs getPane_register_inputs() {
        return pane_register_inputs;
    }

}
