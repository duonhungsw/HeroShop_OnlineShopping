package controller.admin;

import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Order;
import util.Email;

@WebServlet(name="DeleteOrderControl", urlPatterns={"/deleteOrder"})
public class DeleteOrderControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_draw = request.getParameter("id");
        OrderDAO dao = new OrderDAO();
        int id;
        try {
            id  =Integer.parseInt(id_draw);
            dao.delete_Order(id);
            response.sendRedirect("adminOrder");
            
            Order order  = dao.getOrderById(id);
            
            String tieude = "Don Hang HeroShop";
            String noidung = "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<title>Cancel</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "\n"
                    + "<h1>Đơn hàng của bạn không hợp lệ</h1>\n"
                    + "<p>Cảm ơn Qúy Khách đã mua hàng.</p>\n"
                    + "\n"
                    + "</body>\n"
                    + "</html>";
            Email email = new Email();
            boolean sendSuccess = email.sendMail(order.getUser().getEmail(), tieude, noidung);
        } catch (Exception e) {
        }
    } 

}
