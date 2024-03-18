package controller.client;

import dal.CartDAO;
import dal.OrderDAO;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import model.Cart;
import model.CartProduct;
import model.Order;
import model.OrderDetails;
import model.Status;
import model.User;
import util.Email;

@WebServlet(name = "Order", urlPatterns = {"/order"})
public class OrderControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        if (phone == null || address == null) {
            request.setAttribute("error", "*Vui lòng nhập thông tin");
            request.getRequestDispatcher("checkOut").forward(request, response);
        } else {
            User acc = (User) session.getAttribute("account");

            CartDAO cartDAO = new CartDAO();
            Cart c = cartDAO.get_Cart_By_Id(acc.getId());
            List<CartProduct> listCart = cartDAO.get_CartProduct_By_Cid(c);
            int totalMoney = cartDAO.totalMoneyCart(c);

            if (listCart == null || listCart.isEmpty()) {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                OrderDAO dao = new OrderDAO();
                Status s = new Status();
                s.setId(1);

                Order order = new Order();
                order.setUser(acc);
                order.setFullname(name);
                order.setPhone_number(phone);
                order.setAddress(address);
                order.setNote(note);
                order.setStatus(s);
                order.setTotal_money(totalMoney);

                dao.insert_Order(order);
                int orderId = dao.get_Latest_Id();
                order.setId(orderId);

                // Đường dẫn tới tệp JSP
                for (CartProduct cartProduct : listCart) {
                    OrderDetails ods = new OrderDetails();
                    ods.setOrder_id(order);
                    ods.setProduct_id(cartProduct.getProduct());
                    ods.setPrice(cartProduct.getPrice());
                    ods.setTotal_money(cartProduct.getPrice() * cartProduct.getQuantity());
                    ods.setQuantity(cartProduct.getQuantity());
                    ods.setSize(cartProduct.getSize());

                    dao.insert_Order_Detail(ods);
                    
                    Order billOrder = dao.getBillOrder();
                    List<OrderDetails> listBillDetailses = cartDAO.getBillDetailses();

//                    LocalDateTime currentTime = LocalDateTime.now();
                    String tieude = "Cam on quy khach";
                    // Gửi email với nội dung tệp JSP và thời gian hiện tại
                    String noidung = "<!DOCTYPE html>\n"
                            + "<html>\n"
                            + "<head>\n"
                            + "    <title>Email</title>\n"
                            + "    <style>\n"
                            + "        body {\n"
                            + "            background-color: #f5f5f5; \n"
                            + "            font-family: Arial, sans-serif;\n"
                            + "        }\n"
                            + "        .container {\n"
                            + "            width: 80%; \n"
                            + "            margin: 0 auto;\n"
                            + "            padding: 20px;\n"
                            + "            background-color: #fff;\n"
                            + "            border: 1px solid #ddd; \n"
                            + "            border-radius: 5px; \n"
                            + "            box-shadow: 0 0 10px rgba(0,0,0,0.1); \n"
                            + "        }\n"
                            + "        h1, h2, h3, h4, h5 {\n"
                            + "            color: #333;\n"
                            + "        }\n"
                            + "        .important {\n"
                            + "            color: #ff0000; \n"
                            + "        }\n"
                            + "        .no-reply {\n"
                            + "            background-color: var(--green); \n"
                            + "            color: #fff; \n"
                            + "            padding: 10px;\n"
                            + "            border-radius: 5px;\n"
                            + "            margin-bottom: 20px;\n"
                            + "        }\n"
                            + "    </style>\n"
                            + "</head>\n"
                            + "<body>\n"
                            + "    <div class=\"container\">\n"
                            + "        <div class=\"no-reply\">\n"
                            + "            <h1>Đây là email tự động, Quý khách vui lòng không trả lời email này</h1>\n"
                            + "        </div>\n"
                            + "        <h1>HeroShop</h1>\n"
                            + "        <h1>Chào bạn :" + billOrder.getUser().getFullname() + "</h1>\n"
                            + "        <h1>Bạn hoặc ai đó đã đăng ký dịch vụ của shop với thông tin sau:</h1>\n"
                            + "        <h2 class=\"important\">Thông tin đơn hàng</h2>\n"
                            + "        <h2>Mã đơn hàng: " + billOrder.getId() + "</h2>\n"
                            + "        <h3>Mã khuyến mãi áp dụng: Không có</h3>\n"
                            + "        <h3>Phí vận chuyển: 0 đồng</h3>\n"
                            + "        <h3>Dịch vụ: Đặt hàng trực tuyến</h3>\n"
                            + "        <h1>Thông tin người nhận</h1>\n"
                            + "        <h2>Địa chỉ nhận hàng: " + billOrder.getAddress() + "</h2>\n"
                            + "        <h2>Số điện thoại: " + billOrder.getPhone_number() + "</h2>\n"
                            + "        <h3>Ghi chú đơn hàng: " + billOrder.getNote() + "</h3>\n"
                            + "        <h3>Hình thức thanh toán: Khi nhận hàng</h3>\n"
                            + "        <h4>Sản phẩm đã đặt</h4>\n"
                            + "        <table>\n"
                            + "            <tr>\n"
                            + "                <th>San pham</th>\n"
                            + "                <th>Gía tien</th>\n"
                            + "                <th>So luong dat</th>\n"
                            + "                <th>Thanh tien</th>\n"
                            + "            </tr>\n";
                    if (listBillDetailses == null) {
                        noidung += "<h1>Khong ton tai</1>/n";
                    } else {
                        for (OrderDetails listBillDetailse : listBillDetailses) {
                            noidung
                                    += "                <tr>\n"
                                    + "                    <td>" + listBillDetailse.getProduct_id().getTitle() + "</td>\n"
                                    + "                    <td>" + listBillDetailse.getPrice() + "$</td>\n"
                                    + "                    <td>" + listBillDetailse.getQuantity() + "</td>\n"
                                    + "                    <td>" + listBillDetailse.getTotal_money() + "</td>\n"
                                    + "                </tr>\n";
                        }

                        noidung += "        </table>\n"
                                + "        <h5>Tổng tiền thanh toán: \n" + billOrder.getTotal_money() + "$</h5>"
                                + "    </div>"
                                + "</body>"
                                + "</html>";
                    }
                    String nguoinhan = acc.getEmail();
                    Email email = new Email();
                    boolean sendSuccess = email.sendMail(nguoinhan, tieude, noidung);

                }
            }
            response.sendRedirect("thankyou.jsp");
        }
    }

}
