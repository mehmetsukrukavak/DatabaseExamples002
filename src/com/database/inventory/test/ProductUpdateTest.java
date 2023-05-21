package com.database.inventory.test;

import com.database.inventory.entity.Product;
import com.database.inventory.manager.ProductManager;

import java.sql.SQLException;

public class ProductUpdateTest {
    public static void main(String[] args) throws SQLException {
        long productId = 20;
        ProductManager productManager = new ProductManager();

        Product product = productManager.find(productId);

        if (product != null) {
            System.out.println("Before Change......");
            System.out.printf("Product Id : %d \r\nProduct Name : %-25s \r\nProduct Price : %5.2f \r\n", productId, product.getProductName(), product.getSalesPrice());
            product.setProductName("Updated Product 3");
            product.setSalesPrice(18.15);
            boolean updated = productManager.update(product);
            if (updated) {
                System.out.println("Güncelleme Başarılı...");
            } else {
                System.out.println("Güncelleme Başarısız...");
            }

        } else {
            System.out.println("Product not found. (" + productId + ")");
        }
    }
}
