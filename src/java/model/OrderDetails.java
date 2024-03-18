
package model;

public class OrderDetails {
    private int id;
    private Order order_id;
    private Product product_id;
    private  int price;
    private int total_money;
    private int quantity;
    private String size;

    public OrderDetails() {
    }

    public OrderDetails(int id, Order order_id, Product product_id, int price, int total_money, int quantity, String size) {
        this.id = id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.price = price;
        this.total_money = total_money;
        this.quantity = quantity;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Order order_id) {
        this.order_id = order_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "id=" + id + ", order_id=" + order_id + ", product_id=" + product_id + ", price=" + price + ", total_money=" + total_money + ", quantity=" + quantity + ", size=" + size + '}';
    }
    
    
}
