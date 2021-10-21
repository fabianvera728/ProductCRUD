package com.company.view.product;

import com.company.model.Product;
import com.company.view.components.RoundPane;
import com.company.view.vistaPatrones.Diseño;

import javax.swing.*;
import java.awt.*;

public class DetailProduct extends RoundPane implements Diseño {

    public DetailProduct(Product new_product){
        super(Diseño.COLOR_DEFAULT_BACKGROUND, 20);
        this.setLayout(new BorderLayout(5,5));
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(0, 40));
        this.setMaximumSize(new Dimension(0, 40));
        JPanel newpane = new JPanel();
        newpane.setOpaque(false);
        newpane.setLayout(new GridLayout(1, 5, 10, 10));
        this.generateLabels(newpane, new_product);
        this.add(newpane, BorderLayout.CENTER);
    }

    public void generateLabels(JComponent newpane, Product new_product) {
        JLabel lbl_id = new JLabel("       " + new_product.getId());
        lbl_id.setFont(Diseño.INTER_MEDIUM_14);
        lbl_id.setHorizontalAlignment(JLabel.LEFT);
        JLabel lbl_name = new JLabel("" + new_product.getName());
        lbl_name.setFont(Diseño.INTER_MEDIUM_14);
        JLabel lbl_price = new JLabel("" + new_product.getPrice());
        lbl_price.setFont(Diseño.INTER_MEDIUM_14);
        JLabel lbl_amount = new JLabel("" + new_product.getAmount());
        lbl_amount.setFont(Diseño.INTER_MEDIUM_14);
        JLabel lbl_category = new JLabel("" + new_product.getCategory());
        lbl_category.setFont(Diseño.INTER_MEDIUM_14);
        newpane.add(lbl_id);
        newpane.add(lbl_name);
        newpane.add(lbl_price);
        newpane.add(lbl_amount);
        newpane.add(lbl_category);
    }
}
