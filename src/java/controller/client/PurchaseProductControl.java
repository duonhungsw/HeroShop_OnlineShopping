/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.client;

import dal.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.OrderDetails;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name="PurchaseProductControl", urlPatterns={"/purchaseProduct"})
public class PurchaseProductControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("account");
        String id_draw  =request.getParameter("sid");
        int id;
        CartDAO dao  = new CartDAO();
        try {
            
            id = Integer.parseInt(id_draw);
            List<OrderDetails> list= dao.get_Purches_by_Status(id, acc.getId());
            request.setAttribute("listOrderDetails", list);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("purchase").forward(request, response);
    } 
}
