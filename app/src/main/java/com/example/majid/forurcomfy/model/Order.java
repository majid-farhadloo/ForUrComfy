<<<<<<< HEAD
package com.example.majid.forurcomfy.model;

public class Order {
    private String ProductId;
    private String ProductName;
    private String Quantity;
    private String Price;
    private String Discount;

    public Order(String productID) {
    }

    public Order(String productId, String productName, String quantity, String price, String discount) {
        ProductId = productId;
        ProductName = productName;
        Quantity = quantity;
        Price = price;
        Discount = discount;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}
=======
package com.example.majid.forurcomfy.model;

/**
 * Created by farha on 4/9/2018.
 */

public class Order {
    private String ProductId;
    private String ProductName;
    private String Quantity;
    private String Discount;
    private String Price;

    public Order() {
    }

    public Order(String productId, String productName, String quantity, String discount, String price) {
        ProductId = productId;
        ProductName = productName;
        Quantity = quantity;
        Discount = discount;
        Price = price;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
>>>>>>> Shopping Cart internal Catalog no firebase
