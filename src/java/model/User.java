package model;

public class User {
    private int id;
    private String fullname;
    private String password;
    private String email;
    private String phone_number;
    private String address;
    private int role;

    public User() {
    }

    public User(int id, String fullname, String password, String email, String phone_number, String address, int role) {
        this.id = id;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", fullname=" + fullname + ", password=" + password + ", email=" + email + ", phone_number=" + phone_number + ", address=" + address + ", role=" + role + '}';
    }

    
}
