package com.database.inventory.test;

import com.database.inventory.entity.Product;
import com.database.inventory.manager.ProductManager;

import java.sql.SQLException;
import java.util.List;

public class ProductListTest {
    public static void main(String[] args) throws SQLException {
        ProductManager productManager = new ProductManager();

        List<Product> productList = productManager.list();

        if (productList.size() > 0) {
            for (Product product : productList) {
                System.out.printf("Product %3d %-30s %5.2f \r\n", product.getProductId(), product.getProductName(), product.getSalesPrice());
            }
        } else {
            System.out.println("Product List empty...");
        }
    }
}
