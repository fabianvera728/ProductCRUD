package com.company.DAO;

import com.company.database.ConnectionDatabase;
import com.company.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

    ConnectionDatabase con;
    Connection connection;


    public ProductDAO() {
        con = new ConnectionDatabase();
        connection = con.getConnection();
    }

    public ArrayList<Product> listProducts() {

        ArrayList<Product> products = new ArrayList<>();
        try {
            ResultSet result = null;
            PreparedStatement st = connection.prepareStatement("select * from productos");
            result = st.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("nombre");
                int amount = result.getInt("cantidad");
                double price = result.getDouble("precio");
                String category = result.getString("categoria");
                Product newprod = new Product(name, amount, category, price);
                newprod.setId(id);
                products.add(newprod);
            }
        } catch (SQLException ex) {
            System.out.println();
        }
        return products;
    }

    public void createProduct(Product new_product) {
        System.out.println("New product name: " + new_product.getName());
        try {
            String sql = "insert into productos " +
                    "(nombre,cantidad,categoria,precio)" +
                    " values('" + new_product.getName() + "'," + new_product.getAmount() +
                    ",'" + new_product.getCategory() + "'," + new_product.getPrice() + ")";
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try {
            String sql = "delete from productos where id=" + id;
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(int id_product, Product product) {
        try {
            String sql = "UPDATE productos SET nombre='" + product.getName() +
                    "', precio=" + product.getPrice() + ", categoria='" + product.getCategory() + "', cantidad=" + product.getAmount() + " where id=" + id_product + "";
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> filterProduct(String id_f, String name_f, String price_f, String amount_f, String category_f) {
        ArrayList<Product> consult_product = new ArrayList<>();
        try {
            String sql = "select * from productos where id LIKE '%" + id_f + "%'" +
                    " and upper(nombre) LIKE '%" + name_f.toUpperCase() + "%'" +
                    " and upper(precio) LIKE '%" + price_f.toUpperCase() + "%'" +
                    " and upper(cantidad) LIKE '%" + amount_f.toUpperCase() + "%'" +
                    " and upper(categoria) LIKE '%" + category_f.toUpperCase() + "%'";
            ;
            ResultSet result = null;
            PreparedStatement st = connection.prepareStatement(sql);
            result = st.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("nombre");
                int amount = result.getInt("cantidad");
                double price = result.getDouble("precio");
                String category = result.getString("categoria");
                Product newprod = new Product(name, amount, category, price);
                newprod.setId(id);
                consult_product.add(newprod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consult_product;
    }

}
