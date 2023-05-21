package com.database.inventory.test;

import com.database.inventory.manager.ProductManager;

import java.sql.SQLException;

public class ProductDeleteTest {
    public static void main(String[] args) throws SQLException {
        long productId = 22;
        ProductManager productManager = new ProductManager();
        boolean deleted = productManager.delete(productId);
        if(deleted){
            System.out.println("Silindi....");
        }
    }
}
