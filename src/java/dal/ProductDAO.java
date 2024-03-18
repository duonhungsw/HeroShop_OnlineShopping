package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

public class ProductDAO extends DBContext {

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[Category_id]\n"
                + "      ,[title]\n"
                + "      ,[size]\n"
                + "      ,[price]\n"
                + "      ,[description]\n"
                + "      ,[thumbnail]\n"
                + "  FROM [dbo].[Product]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setSize(rs.getString("size"));
                p.setPrice(rs.getString("price"));
                p.setDescription(rs.getString("description"));
                p.setThumbnail(rs.getString("thumbnail"));
                Category c = getCategoryById(rs.getInt("Category_id"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> productAllPaginationOfHome(int index, int size) {
        List<Product> list = new ArrayList<>();
        String sql = "with x as (select ROW_NUMBER() over(order by id asc) as r,\n"
                + "                * from Product)\n"
                + "                select * from x WHERE r BETWEEN (? * ? - 2) AND (? * ?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, index);
            st.setInt(2, size);
            st.setInt(3, index);
            st.setInt(4, size);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setSize(rs.getString("size"));
                p.setPrice(rs.getString("price"));
                p.setDescription(rs.getString("description"));
                p.setThumbnail(rs.getString("thumbnail"));
                Category c = getCategoryById(rs.getInt("Category_id"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product getProductById(String id) {
        String sql = "Select * from product where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setSize(rs.getString("size"));
                p.setPrice(rs.getString("price"));
                p.setDescription(rs.getString("description"));
                p.setThumbnail(rs.getString("thumbnail"));
                Category c = getCategoryById(rs.getInt("Category_id"));
                p.setCategory(c);
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Category getCategoryById(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Category]\n"
                + "  where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1),
                        rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Category]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("id"), rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProdutByCategoryID(int Category_id) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[Category_id]\n"
                + "      ,[title]\n"
                + "      ,[size]\n"
                + "      ,[price]\n"
                + "      ,[description]\n"
                + "      ,[thumbnail]\n"
                + "  FROM [dbo].[Product]\n"
                + "  where Category_id= ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Category_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product plist = new Product();
                plist.setId(rs.getInt("id"));
                Category c = getCategoryById(rs.getInt("Category_id"));
                plist.setCategory(c);
                plist.setTitle(rs.getString("title"));
                plist.setSize(rs.getString("size"));
                plist.setPrice(rs.getString("price"));
                plist.setDescription(rs.getString("description"));
                plist.setThumbnail(rs.getString("thumbnail"));

                list.add(plist);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    //Search
    public List<Product> searchProductByName(String name) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE title LIKE ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + name + "%"); // Đặt giá trị cho tham số
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setSize(rs.getString("size"));
                p.setPrice(rs.getString("price"));
                p.setDescription(rs.getString("description"));
                p.setThumbnail(rs.getString("thumbnail"));
                Category c = getCategoryById(rs.getInt("Category_id"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product checkProductById(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[Category_id]\n"
                + "      ,[title]\n"
                + "      ,[size]\n"
                + "      ,[price]\n"
                + "      ,[description]\n"
                + "      ,[thumbnail]\n"
                + "  FROM [dbo].[Product]\n"
                + "  where id =?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setSize(rs.getString("size"));
                p.setPrice(rs.getString("price"));
                p.setDescription(rs.getString("description"));
                p.setThumbnail(rs.getString("thumbnail"));
                Category c = getCategoryById(rs.getInt("Category_id"));
                p.setCategory(c);
                return p;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insert_Product(Product p) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([Category_id]\n"
                + "           ,[title]\n"
                + "           ,[size]\n"
                + "           ,[price]\n"
                + "           ,[description]\n"
                + "           ,[thumbnail])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getCategory().getId());
            st.setString(2, p.getTitle());
            st.setString(3, p.getSize());
            st.setString(4, p.getPrice());
            st.setString(5, p.getDescription());
            st.setString(6, p.getThumbnail());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update_Product(Product p) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [Category_id] = ?\n"
                + "      ,[title] = ?\n"
                + "      ,[size] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[thumbnail] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getCategory().getId());
            st.setString(2, p.getTitle());
            st.setString(3, p.getSize());
            st.setString(4, p.getPrice());
            st.setString(5, p.getDescription());
            st.setString(6, p.getThumbnail());
            st.setInt(7, p.getId());
            st.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void deleteCartProduct(int id) {
    try {
        String sql1 = "DELETE FROM [dbo].Cart_Product WHERE Product_id = ?";
        PreparedStatement st1 = connection.prepareStatement(sql1);
        st1.setInt(1, id);
        st1.executeUpdate();
        
        String sql2 = "DELETE FROM [dbo].Order_Details WHERE product_id = ?";
        PreparedStatement st2 = connection.prepareStatement(sql2);
        st2.setInt(1, id);
        st2.executeUpdate();
        
        String sql3 = "DELETE FROM [dbo].Product WHERE id = ?";
        PreparedStatement st3 = connection.prepareStatement(sql3);
        st3.setInt(1, id);
        st3.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        Category category = new Category();
        category.setId(4); // Đặt ID của danh mục


        // Tạo một đối tượng Product
        Product product = new Product();
        product.setTitle("Test Product");
        product.setSize("L");
        product.setPrice("19");
        product.setDescription("Description of Test Product");
        product.setThumbnail("test_thumbnail.jpg");
        product.setCategory(category); // Gán danh mục cho sản phẩm
        dao.insert_Product(product);
        List<Product> list = dao.getAll();
        for (Product p : list) {
            System.out.println(p.toString());
        }
    }
}
