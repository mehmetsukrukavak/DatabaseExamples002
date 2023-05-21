package com.database.inventory.manager;

import com.database.inventory.entity.Product;
import com.database.library.database.DatabaseUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    public boolean insert(Product product) throws SQLException {
        int affected = 0;

        Connection connection = DatabaseUtilities.getConnection();

        String sql = "INSERT INTO Product (productName, salesPrice) VALUES(?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getSalesPrice());
        affected = statement.executeUpdate();
        connection.close();


        return affected == 1;
    }

    public Product find(long productId)  throws SQLException {
        Product product = null;

        Connection connection = DatabaseUtilities.getConnection();

        String sql = "select * from Product where productId = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productId);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {

            String productName = resultSet.getString("productName");
            Double salesPrice = resultSet.getDouble("salesPRice");

            product = new Product();
            product.setProductId(productId);
            product.setProductName(productName);
            product.setSalesPrice(salesPrice);

        }
        connection.close();

        return product;
    }

    public boolean update(Product product) throws SQLException {
        int affected = 0;

        Connection connection = DatabaseUtilities.getConnection();

        String sql = "Update Product set productName=?, salesPrice=? Where productId = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getSalesPrice());
        statement.setLong(3, product.getProductId());
        affected = statement.executeUpdate();
        connection.close();


        return affected == 1;
    }

    public boolean delete(long productId) throws SQLException {
        int affected = 0;

        Connection connection = DatabaseUtilities.getConnection();

        String sql = "delete from Product Where productId = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setLong(1, productId);
        affected = statement.executeUpdate();
        connection.close();


        return affected == 1;
    }

    public List<Product> list() throws SQLException{
        List<Product> productList = new ArrayList<>();


        Connection connection = DatabaseUtilities.getConnection();

        String sql = "select * from Product order by productId asc";

        PreparedStatement statement = connection.prepareStatement(sql);


        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            long productId = resultSet.getLong("productId");
            String productName = resultSet.getString("productName");
            Double salesPrice = resultSet.getDouble("salesPRice");

            Product product = new Product();
            product.setProductId(productId);
            product.setProductName(productName);
            product.setSalesPrice(salesPrice);
            productList.add(product);

        }
        connection.close();

        return productList;
    }
}
