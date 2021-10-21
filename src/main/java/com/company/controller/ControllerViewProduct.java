package com.company.controller;

import com.company.DAO.ProductDAO;
import com.company.model.Product;
import com.company.view.components.RoundPane;
import com.company.view.components.RoundTextField;
import com.company.view.product.*;
import com.company.view.vistaPatrones.Diseño;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ControllerViewProduct {

    private ProductDAO productdao;
    private ViewProduct view;

    public ControllerViewProduct(ProductDAO productdao, ViewProduct view) {
        this.productdao = productdao;
        this.view = view;
        this.view.setProducts(this.productdao.listProducts());
        this.addEvents();
    }

    public void addEvents() {
        this.view.getHeader().getBtn_register_product().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getPane_center().getConsult_pane().setVisible(false);
                view.getPane_center().getRegister_pane().setVisible(true);
                view.getHeader().getBtn_register_product().setBackground(Diseño.COLOR_VIOLET_PRIMARY);
                view.getHeader().getBtn_consult_product().setBackground(Diseño.COLOR_DEFAULT_WHITE);
                view.getHeader().getBtn_register_product().setForegroundText(Diseño.COLOR_DEFAULT_WHITE,Diseño.COLOR_DEFAULT_BLACK);
                view.getHeader().getBtn_consult_product().setForegroundText(Diseño.COLOR_DEFAULT_BLACK,Diseño.COLOR_DEFAULT_BLACK);
                repaintButtons();
            }
        });
        this.view.getHeader().getBtn_consult_product().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getPane_center().getConsult_pane().getTable().setProducts(productdao.listProducts());
                view.getPane_center().getRegister_pane().setVisible(false);
                view.getPane_center().getConsult_pane().setVisible(true);
                view.getHeader().getBtn_consult_product().setBackground(Diseño.COLOR_VIOLET_PRIMARY);
                view.getHeader().getBtn_register_product().setBackground(Diseño.COLOR_DEFAULT_WHITE);
                view.getHeader().getBtn_consult_product().setForegroundText(Diseño.COLOR_DEFAULT_WHITE,Diseño.COLOR_DEFAULT_BLACK);
                view.getHeader().getBtn_register_product().setForegroundText(Diseño.COLOR_DEFAULT_BLACK,Diseño.COLOR_DEFAULT_BLACK);
                repaintButtons();
            }
        });
        PaneRegisterInputs pane_register = this.view.getPane_center().getRegister_pane().getPane_register_inputs();
        TableProducts consult_pane = this.view.getPane_center().getConsult_pane().getTable();
        pane_register.getBtn_save_product().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = pane_register.getTxt_name().getText();
                        int price = Integer.parseInt(pane_register.getTxt_price().getText());
                        String category = pane_register.getTxt_category().getText();
                        int amount = Integer.parseInt(pane_register.getTxt_amount().getText());
                        Product new_product = new Product(name, amount, category, price);
                        productdao.createProduct(new_product);
                        consult_pane.getRows_product().removeAll();
                        uploadProducts(productdao.listProducts());
                    }
                }
        );

        PaneConsultInputs consult_inputs =  this.view.getPane_center().getConsult_pane().getPane_consult_inputs();
        consult_inputs.getBtn_delete_product().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id_product = consult_inputs.getTxt_id().getText();
                        productdao.deleteProduct(Integer.parseInt(id_product));
                        RoundTextField product_id = consult_inputs.getTxt_id();
                        RoundTextField name_product = consult_inputs.getTxt_name();
                        RoundTextField price_product = consult_inputs.getTxt_price();
                        RoundTextField amount_product = consult_inputs.getTxt_amount();
                        RoundTextField category_product = consult_inputs.getTxt_category();
                        product_id.setText("");
                        name_product.setText("");
                        price_product.setText("");
                        amount_product.setText("");
                        category_product.setText("");
                        consult_pane.getRows_product().removeAll();
                        ArrayList<Product> prods = productdao.listProducts();
                        uploadProducts(prods);
                        consult_pane.setCount_products(prods.size());
                        consult_pane.getRows_product().updateUI();
                    }
                }
        );

        consult_inputs.getBtn_consult_product().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Consult product");
                        String id_product = consult_inputs.getTxt_id().getText();
                        String name_product = consult_inputs.getTxt_name().getText();
                        String price_product = consult_inputs.getTxt_price().getText();
                        String amount_product = consult_inputs.getTxt_amount().getText();
                        String category_product = consult_inputs.getTxt_category().getText();
                        consult_pane.getRows_product().removeAll();
                        ArrayList<Product> prods = productdao.filterProduct(id_product,
                                name_product,
                                price_product,
                                amount_product,
                                category_product);
                        uploadProducts(prods);
                        consult_pane.setCount_products(prods.size());
                        consult_pane.getRows_product().updateUI();
                    }

                }
        );
        consult_inputs.getBtn_update_product().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id_product = Integer.parseInt(consult_inputs.getTxt_id().getText());
                String name = consult_inputs.getTxt_name().getText();
                double price = Double.parseDouble(consult_inputs.getTxt_price().getText());
                String category = consult_inputs.getTxt_category().getText();
                int amount = Integer.parseInt(consult_inputs.getTxt_amount().getText());
                Product new_product = new Product(name, amount, category, price);
                productdao.updateProduct(id_product,new_product);
                consult_pane.getRows_product().removeAll();
                ArrayList<Product> prods = productdao.listProducts();
                uploadProducts(prods);
                consult_pane.setCount_products(prods.size());
                consult_pane.getRows_product().updateUI();
            }
        });
        this.uploadProducts(this.productdao.listProducts());
    }

    public void uploadProducts(ArrayList<Product> products){
        TableProducts consult_pane = this.view.getPane_center().getConsult_pane().getTable();
        PaneConsultInputs consult_inputs =  this.view.getPane_center().getConsult_pane().getPane_consult_inputs();
        consult_pane.setCount_products(products.size());
        for(Product prod: products){
            DetailProduct pane = consult_pane.generateProduct(prod, true);
            pane.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    RoundTextField id_product = consult_inputs.getTxt_id();
                    RoundTextField name_product = consult_inputs.getTxt_name();
                    RoundTextField price_product = consult_inputs.getTxt_price();
                    RoundTextField amount_product = consult_inputs.getTxt_amount();
                    RoundTextField category_product = consult_inputs.getTxt_category();
                    id_product.setText(""+prod.getId());
                    name_product.setText(prod.getName());
                    price_product.setText(""+prod.getPrice());
                    amount_product.setText(""+prod.getAmount());
                    category_product.setText(prod.getCategory());
                }

                public void mousePressed(MouseEvent e) {

                }

                public void mouseReleased(MouseEvent e) {

                }

                public void mouseEntered(MouseEvent e) {
                    pane.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    pane.setBackgroundColor(Diseño.COLOR_DEFAULT_BORDERS);
                    pane.updateUI();
                }

                public void mouseExited(MouseEvent e) {
                    pane.setBackgroundColor(Diseño.COLOR_DEFAULT_BACKGROUND);
                    pane.updateUI();
                }
            });
            consult_pane.addProduct(pane);
        }
    }

    public void repaintButtons(){
        view.getHeader().getBtn_register_product().repaint();
        view.getHeader().getBtn_consult_product().repaint();
    }

}
