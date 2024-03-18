/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBContext {
    protected Connection connection;
    public DBContext()
    {
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=HeroShop";
            String username = "sa";
            String password = "123456789";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException ex) {
            // Xử lý lỗi khi đóng kết nối
            System.out.println("Error closing the connection: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Tạo một đối tượng DBContext
        DBContext dbContext = new DBContext();

        // Kiểm tra xem kết nối có thành công không
        if (dbContext.getConnection() != null) {
            System.out.println("Kết nối đến cơ sở dữ liệu thành công!");

            // Thực hiện một số tương tác với cơ sở dữ liệu tại đây (nếu cần)

            // Đảm bảo đóng kết nối sau khi sử dụng
            dbContext.closeConnection();
        } else {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
        }
    }
}
