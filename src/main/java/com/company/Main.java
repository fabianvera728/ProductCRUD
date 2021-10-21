package com.company;

import com.company.DAO.ProductDAO;
import com.company.controller.ControllerViewProduct;
import com.company.database.ConnectionDatabase;
import com.company.model.Product;
import com.company.view.components.CustomLineBorder;
import com.company.view.components.RoundPane;
import com.company.view.product.ViewProduct;
import com.company.view.vistaPatrones.Diseño;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ProductDAO productdao = new ProductDAO();
        ViewProduct view = new ViewProduct(productdao.listProducts());
        ControllerViewProduct controller = new ControllerViewProduct(productdao,view);
        view.setVisible(true);
    }
}
