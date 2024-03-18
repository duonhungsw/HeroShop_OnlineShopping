/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

public class PaginationDAO extends DBContext {
    //phan trang home
    public int countAll() {
        String sql = "select count(*) from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    //phan trang search
    public int count(String txt) {
        String sql = "SELECT count(*) FROM Product WHERE title LIKE ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + txt + "%"); // Đặt giá trị cho tham số
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return 0;
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

    public List<Product> paginationOfHome(int index, int size) {
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
    

    public static void main(String[] args) {
        PaginationDAO d = new PaginationDAO();
        List<Product> list = d.paginationOfHome(1, 3);
        System.out.println(list.toString());
    }
}
