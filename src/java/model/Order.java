package model;

public class Order {
    private int id;
    private User user;
    private String fullname,phone_number,address,note;
    private Status status;
    private int total_money;

    public Order() {
    }

    public Order(int id, User user, String fullname, String phone_number, String address, String note, Status status, int total_money) {
        this.id = id;
        this.user = user;
        this.fullname = fullname;
        this.phone_number = phone_number;
        this.address = address;
        this.note = note;
        this.status = status;
        this.total_money = total_money;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", user=" + user + ", fullname=" + fullname + ", phone_number=" + phone_number + ", address=" + address + ", note=" + note + ", status=" + status + ", total_money=" + total_money + '}';
    }

}
