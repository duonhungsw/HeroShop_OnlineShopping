
package model;

public class Product {
    private int id;
    private String title,size,price,description,thumbnail;
    private Category category;

    public Product() {
    }

    public Product(int id, String title, String size, String price, String description, String thumbnail, Category category) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", title=" + title + ", size=" + size + ", price=" + price + ", description=" + description + ", thumbnail=" + thumbnail + ", category=" + category + '}';
    }
}
