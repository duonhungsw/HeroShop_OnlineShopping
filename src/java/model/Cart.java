/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Cart {
    private int id;
    private User user;
    private int Quantity;

    public Cart() {
    }

    public Cart(int id, User user, int Quantity) {
        this.id = id;
        this.user = user;
        this.Quantity = Quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", user=" + user + ", Quantity=" + Quantity + '}';
    }

    
}
