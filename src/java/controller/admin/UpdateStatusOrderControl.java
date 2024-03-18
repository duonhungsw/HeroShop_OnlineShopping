package controller.admin;

import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Order;
import model.User;
import util.Email;

@WebServlet(name = "UpdateStatusOrderControl", urlPatterns = {"/updateStatus"})
public class UpdateStatusOrderControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_draw = request.getParameter("id");
        int id;
        OrderDAO dao = new OrderDAO();
        try {
            id = Integer.parseInt(id_draw);
            dao.update_Order_Status(id);
            response.sendRedirect("adminOrder");
            HttpSession session = request.getSession();
            
            Order order  = dao.getOrderById(id);

            String tieude = "Don Hang HeroShop";
            String noidung = "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<title>Page Title</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "\n"
                    + "<h1>Đơn hàng của bạn đang trên đường vận chuyển</h1>\n"
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
