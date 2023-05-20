package com.database.inventory.test;

import com.database.inventory.entity.Product;
import com.database.inventory.manager.ProductManager;

import java.sql.SQLException;

public class ProductFind {
    public static void main(String[] args)  throws SQLException {
        long productId = 24;
        ProductManager productManager = new ProductManager();

        Product product = productManager.find(productId);

        if(product != null){
            System.out.printf("Product Id : %d \r\nProduct Name : %-25s \r\nProduct Price : %5.2f \r\n", productId, product.getProductName(), product.getSalesPrice());
        }else{
            System.out.println("Product not found.");
        }
    }
}
