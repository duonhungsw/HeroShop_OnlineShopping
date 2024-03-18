/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class CartProduct {
    private int id;
    private Cart cart;
    private Product product;
    private int quantity, total_money;
    private String size;
    private int price;
    

    public CartProduct() {
    }

    public CartProduct(int id, Cart cart, Product product, int quantity, int total_money, String size, int price) {
        this.id = id;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
        this.total_money = total_money;
        this.size = size;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartProduct{" + "id=" + id + ", cart=" + cart + ", product=" + product + ", quantity=" + quantity + ", total_money=" + total_money + ", size=" + size + ", price=" + price + '}';
    }

    
    
}
