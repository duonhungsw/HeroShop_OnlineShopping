package dal;

import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.CartProduct;
import model.Category;
import model.Order;
import model.OrderDetails;
import model.Product;

public class CartDAO extends DBContext {

    public List<CartProduct> get_All() {
        List<CartProduct> list = new ArrayList<>();
        String sql = "SELECT [ID]\n"
                + "      ,[Cart_id]\n"
                + "      ,[Product_id]\n"
                + "      ,[Quantity]\n"
                + "      ,[Total_money]\n"
                + "      ,[size]\n"
                + "      ,[Price]\n"
                + "  FROM [dbo].[Cart_Product]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CartProduct cartP = new CartProduct();
                cartP.setId(rs.getInt("ID"));
                Cart c = get_Cart_By_Id(rs.getInt("Cart_id"));
                cartP.setCart(c);
                Product p = get_Product_By_Id(rs.getInt("Product_id"));
                cartP.setProduct(p);
                cartP.setQuantity(rs.getInt("Quantity"));
                cartP.setTotal_money(rs.getInt("Total_money"));
                cartP.setSize(rs.getString("size"));
                cartP.setPrice(rs.getInt("price"));
                list.add(cartP);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<CartProduct> get_CartProduct_By_Cid(Cart c) {
        List<CartProduct> cartProducts = new ArrayList<>();
        String sql = "SELECT [ID], [Cart_id], [Product_id], [Quantity], [Total_money], [size], [Price] "
                + "FROM [dbo].[Cart_Product] "
                + "WHERE Cart_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                CartProduct cartP = new CartProduct();
                cartP.setId(rs.getInt("ID"));
                cartP.setCart(c);

                Product p = get_Product_By_Id(rs.getInt("Product_id"));
                cartP.setProduct(p);
                cartP.setQuantity(rs.getInt("Quantity"));
                cartP.setTotal_money(rs.getInt("Total_money"));
                cartP.setSize(rs.getString("size"));
                cartP.setPrice(rs.getInt("Price"));

                cartProducts.add(cartP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartProducts;
    }

    public Product get_Product_By_Id(int id) {
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

    public Cart get_Cart_By_Id(int id) {
        String sql = "SELECT [ID]\n"
                + "      ,[User_id]\n"
                + "      ,[Quantity]\n"
                + "  FROM [dbo].[Cart]\n"
                + "  where [User_id] = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cart c = new Cart();
                c.setId(rs.getInt("ID"));
                User u = get_User_By_Id(rs.getInt("User_id"));
                c.setUser(u);
                c.setQuantity(rs.getInt("Quantity"));
                return c;
            }
        } catch (Exception e) {
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

    public void addToCart(CartProduct c) {
        String sql = "INSERT INTO [dbo].[Cart_Product]\n"
                + "           ([Cart_id]\n"
                + "           ,[Product_id]\n"
                + "           ,[Quantity]\n"
                + "           ,[Total_money]\n"
                + "           ,[size]\n"
                + "           ,[Price])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getCart().getId());
            st.setInt(2, c.getProduct().getId());
            st.setInt(3, c.getQuantity());
            st.setInt(4, c.getQuantity() * c.getPrice());
            st.setString(5, c.getSize());
            st.setInt(6, c.getPrice());

            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insert_Cart(Cart c) {
        String sql = "INSERT INTO [dbo].[Cart]\n"
                + "           ([User_id]\n"
                + "           ,[Quantity])\n"
                + "     VALUES\n"
                + "           (?,?)\n";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getUser().getId());
            st.setInt(2, c.getQuantity());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    //Quantity của Cart
    //Check đơn hàng đã tồn tại trong giỏ hàng chưa
    public CartProduct getCartProductByProductIdAndSize(int productId, String size) {
        String sql = "SELECT ID, Cart_id, Product_id, Quantity, Total_money, size, Price FROM Cart_Product WHERE Product_id = ? AND size = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, productId);
            st.setString(2, size);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                CartProduct cp = new CartProduct();
                cp.setId(rs.getInt("ID"));
                Cart cc = get_Cart_By_Id(rs.getInt("Cart_id"));
                cp.setCart(cc);
                Product p = get_Product_By_Id(rs.getInt("Product_id"));
                cp.setProduct(p);
                cp.setQuantity(rs.getInt("Quantity"));
                cp.setTotal_money(rs.getInt("Total_money"));
                cp.setSize(rs.getString("size"));
                cp.setPrice(rs.getInt("Price"));
                return cp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int getPriceForProduct(int id) {
        String sql = "select price from Cart_Product\n"
                + "where id = ?";
        int price = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                price = rs.getInt("price");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return price;
    }

    public void updateQuantityCartProduct(int quantity, int cartProductId) {
        String sql = "UPDATE [dbo].[Cart_Product]\n"
                + "SET [Quantity] = ?\n"
                + "WHERE ID = ?";
        String sql1 = "UPDATE [dbo].[Cart_Product]\n"
                + "SET [Total_money] = ? * Price\n"
                + "WHERE ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, quantity);
            st.setInt(2, cartProductId);
            st.executeUpdate();

            PreparedStatement st1 = connection.prepareStatement(sql1);
            st1.setInt(1, quantity);
            st1.setInt(2, cartProductId);
            st1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCartProduct(CartProduct c) {
        String sql = "UPDATE Cart_Product SET Quantity = ?, Total_money = ? WHERE ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getQuantity());
            st.setInt(2, c.getTotal_money());
            st.setInt(3, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCartProduct(int id) {
        String sql = "DELETE FROM [dbo].[Cart_Product]\n"
                + "      WHERE ID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);

            st.executeQuery();
        } catch (Exception e) {
        }
    }

    public void removeCart(User u) {
        String sql = "DELETE FROM [dbo].[Orders]\n"
                + "WHERE [user_id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, u.getId());

            st.executeQuery();
        } catch (Exception e) {
        }
    }

    public int totalMoneyCart(Cart cp) {
        String sql = "SELECT SUM(Total_money) AS TotalMoneySum\n"
                + "FROM [dbo].[Cart_Product]\n"
                + "WHERE Cart_id = ?";
        int total = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cp.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                total = rs.getInt("TotalMoneySum");
                rs.close();
                st.close();
            }
        } catch (Exception e) {
        }
        return total;
    }

    public List<OrderDetails> getBillDetailses() {
        List<OrderDetails> list = new ArrayList<>();
        String sql = "SELECT OD.id, OD.order_id, OD.product_id, OD.price, OD.total_money, OD.quantity, OD.size\n"
                + "FROM Order_Details OD\n"
                + "JOIN Orders O ON OD.order_id = O.id\n"
                + "WHERE OD.order_id = (SELECT MAX(id) FROM Orders)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CartDAO c = new CartDAO();
                OrderDAO odao = new OrderDAO();
                ProductDAO pdao = new ProductDAO();
                OrderDetails od = new OrderDetails();

                od.setId(rs.getInt(1));
                Order o = odao.getOrderById(rs.getInt(2));
                od.setOrder_id(o);

                Product p = pdao.checkProductById(rs.getInt(3));
                od.setProduct_id(p);

                od.setPrice(rs.getInt(4));
                od.setTotal_money(rs.getInt(5));
                od.setQuantity(rs.getInt(6));
                od.setSize(rs.getString(7));
                list.add(od);
            }
        } catch (Exception e) {
        }
        return list;
    }

    //Don Hang
    // dang loi o order id
    public List<OrderDetails> get_Purches_by_Status(int id, int uid) {
        List<OrderDetails> list = new ArrayList<>();
        String sql = "SELECT OD.id, OD.order_id, OD.product_id, OD.price, OD.total_money, OD.quantity, OD.size\n"
            + "FROM Order_Details OD\n"
            + "JOIN Orders O ON OD.order_id = O.id\n"
            + "WHERE O.status = ? AND O.user_id = ?";
//                +"Where 1 =1 ";
//                if(id!=0){
//                    sql+=" and id ="+id;
//                }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setInt(2, uid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CartDAO c = new CartDAO();
                OrderDAO odao = new OrderDAO();
                ProductDAO pdao = new ProductDAO();
                OrderDetails od = new OrderDetails();

                od.setId(rs.getInt(1));
                Order o = odao.getOrderById(rs.getInt(2));
                od.setOrder_id(o);

                Product p = pdao.checkProductById(rs.getInt(3));
                od.setProduct_id(p);

                od.setPrice(rs.getInt(4));
                od.setTotal_money(rs.getInt(5));
                od.setQuantity(rs.getInt(6));
                od.setSize(rs.getString(7));
                list.add(od);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        CartDAO c = new CartDAO();
//        int status = 2;
//        List<OrderDetails> list = c.getBillDetailses();
//        for (OrderDetails orderDetails : list) {
//            System.out.println(orderDetails.toString());
//        }
    }
}
