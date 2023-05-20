package com.database.inventory.test;

import com.database.inventory.entity.Product;
import com.database.inventory.manager.ProductManager;

import java.sql.SQLException;

public class ProductInsert {
    public static void main(String[] args)  throws SQLException {
        Product product = new Product(0,"Test Product 5",19.99);
        ProductManager productManager = new ProductManager();
        boolean test = productManager.insert(product);
        System.out.println("Ekleme : " + test);
    }
}
