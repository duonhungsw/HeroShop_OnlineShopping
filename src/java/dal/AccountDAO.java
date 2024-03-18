package dal;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.User;

public class AccountDAO extends DBContext {

    public List<User> getAllAccount() {
        List<User> accountList = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[fullname]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "      ,[phone_number]\n"
                + "      ,[address]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[User]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        rs.getInt("role"));
                accountList.add(u);
            }
        } catch (Exception e) {
        }
        return accountList;
    }

    public User checkId(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[fullname]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "      ,[phone_number]\n"
                + "      ,[address]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[User]\n"
                + "  Where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateAcconut(User u) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET [fullname] = ?\n"
                + "      ,[password] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[phone_number] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[role] = ?\n"
                + " WHERE id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, u.getFullname());
            st.setString(2, u.getPassword());
            st.setString(3, u.getEmail());
            st.setString(4, u.getPhone_number());
            st.setString(5, u.getAddress());
            st.setInt(6, u.getRole());
            st.setInt(7, u.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    //delete
    public void delete_Account(int id) {
        String sql = "DELETE FROM [dbo].[User]\n"
                + "      WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAO();
        List<User> list = accountDAO.getAllAccount();
        int id = 1;
        String name = "nhi";
        String pass = "123";
        String email = "abc@gmail.com";
        String phone = "1234";
        String address  ="DB";
        int role = 1;
        User u = new User(id, name, pass, email, phone, address, role);
        accountDAO.updateAcconut(u);
        
        for (User user : list) {
            System.out.println(user.toString());
        }
    }
}
