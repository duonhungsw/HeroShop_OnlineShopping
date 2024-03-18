package dal;

import java.util.ArrayList;
import java.util.List;
import model.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.CartProduct;
import model.OrderDetails;
import model.Status;
import model.User;

public class OrderDAO extends DBContext {

    public Order getOrderById(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[user_id]\n"
                + "      ,[fullname]\n"
                + "      ,[phone_number]\n"
                + "      ,[address]\n"
                + "      ,[note]\n"
                + "      ,[status]\n"
                + "      ,[total_money]\n"
                + "  FROM [dbo].[Orders]\n"
                + "  WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt(1));
                User user = get_User_By_Id(rs.getInt(2));
                o.setUser(user);
                o.setFullname(rs.getString(3));
                o.setPhone_number(rs.getString(4));
                o.setAddress(rs.getString(5));
                o.setNote(rs.getString(6));
                Status s = get_Status_By_Id(rs.getInt(7));
                o.setStatus(s);
                o.setTotal_money(rs.getInt(8));
                return o;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Order getBillOrder() {
        String sql = "SELECT [id]\n"
                + "      ,[user_id]\n"
                + "      ,[fullname]\n"
                + "      ,[phone_number]\n"
                + "      ,[address]\n"
                + "      ,[note]\n"
                + "      ,[status]\n"
                + "      ,[total_money]\n"
                + "  FROM [dbo].[Orders]\n"
                + "  WHERE id = (Select MAX(id) from Orders) ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt(1));
                User user = get_User_By_Id(rs.getInt(2));
                o.setUser(user);
                o.setFullname(rs.getString(3));
                o.setPhone_number(rs.getString(4));
                o.setAddress(rs.getString(5));
                o.setNote(rs.getString(6));
                Status s = get_Status_By_Id(rs.getInt(7));
                o.setStatus(s);
                o.setTotal_money(rs.getInt(8));
                return o;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User get_User_By_Id(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[fullname]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "      ,[phone_number]\n"
                + "      ,[address]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[User]\n"
                + "  where [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setFullname(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setPhone_number(rs.getString(5));
                u.setAddress(rs.getString(6));
                u.setRole(rs.getInt(7));
                return u;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Status> getAllStatus() {
        List<Status> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[OrderStatus] ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Status s = new Status();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                list.add(s);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public Status get_Status_By_Id(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[OrderStatus] where id  = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Status s = new Status();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                return s;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public List<Order> get_All_Order() {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[user_id]\n"
                + "      ,[fullname]\n"
                + "      ,[phone_number]\n"
                + "      ,[address]\n"
                + "      ,[note]\n"
                + "      ,[status]\n"
                + "      ,[total_money]\n"
                + "  FROM [dbo].[Orders]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt(1));

                User u = get_User_By_Id(rs.getInt(2));
                order.setUser(u);

                order.setFullname(rs.getString(3));
                order.setPhone_number(rs.getString(4));
                order.setAddress(rs.getString(5));
                order.setNote(rs.getString(6));

                Status s = get_Status_By_Id(rs.getInt(7));
                order.setStatus(s);

                order.setTotal_money(rs.getInt(8));
                list.add(order);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insert_Order(Order o) {
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([user_id]\n"
                + "           ,[fullname]\n"
                + "           ,[phone_number]\n"
                + "           ,[address]\n"
                + "           ,[note]\n"
                + "           ,[status]\n"
                + "           ,[total_money])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, o.getUser().getId());
            st.setString(2, o.getFullname());
            st.setString(3, o.getPhone_number());
            st.setString(4, o.getAddress());
            st.setString(5, o.getNote());
            st.setInt(6, o.getStatus().getId());
            st.setInt(7, o.getTotal_money());

            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int get_Latest_Id() {
        String sql = "SELECT MAX(id) AS LastOrderID FROM Orders";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("LastOrderID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ nếu cần
        }
        return -1; // Hoặc trả về một giá trị mặc định nếu không có kết quả
    }

    public void insert_Order_Detail(OrderDetails ods) {
        String sql = "INSERT INTO [dbo].[Order_Details]\n"
                + "           ([order_id]\n"
                + "           ,[product_id]\n"
                + "           ,[price]\n"
                + "           ,[total_money]\n"
                + "           ,[quantity]\n"
                + "           ,[size])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, ods.getOrder_id().getId());
            st.setInt(2, ods.getProduct_id().getId());
            st.setInt(3, ods.getPrice());
            st.setInt(4, ods.getPrice() * ods.getQuantity());
            st.setInt(5, ods.getQuantity());
            st.setString(6, ods.getSize());

            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void update_Order_Status(int id) {
        String sql = "UPDATE [dbo].[Orders]\n"
                + "   SET [status] = 2\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    

    public void delete_Order(int id) {
        String sql1 = "DELETE FROM [dbo].Order_Details\n"
                + "WHERE order_id = ?";
        String sql2 = "DELETE FROM [dbo].[Orders]\n"
                + "      WHERE id =?";

        try {
            PreparedStatement st1 = connection.prepareStatement(sql1);
            st1.setInt(1, id);
            st1.executeUpdate();

            PreparedStatement st2 = connection.prepareStatement(sql2);
            st2.setInt(1, id);
            st2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Order> getDetailsByOrder(int id) {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[user_id]\n"
                + "      ,[fullname]\n"
                + "      ,[phone_number]\n"
                + "      ,[address]\n"
                + "      ,[note]\n"
                + "      ,[status]\n"
                + "      ,[total_money]\n"
                + "  FROM [dbo].[Orders]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt(1));

                User u = get_User_By_Id(rs.getInt(2));
                order.setUser(u);

                order.setFullname(rs.getString(3));
                order.setPhone_number(rs.getString(4));
                order.setAddress(rs.getString(5));
                order.setNote(rs.getString(6));

                Status s = get_Status_By_Id(rs.getInt(7));
                order.setStatus(s);

                order.setTotal_money(rs.getInt(8));
                list.add(order);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        OrderDAO dao = new OrderDAO();
//        
//        int id  =37;

        Order order = dao.getOrderById(81);
        System.out.println(order.toString());

//        List<Status> list = dao.getAllStatus();
//        for (Status status : list) {
//            System.out.println(status.toString());
//        }
    }
}
