/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateControl", urlPatterns = {"/updateUser"})
public class UpdateControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id_draw = request.getParameter("id");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String address = request.getParameter("Address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int id;
        int role = 1;
        AccountDAO accountDAO = new AccountDAO();
        try {
            id = Integer.parseInt(id_draw);
            User unew = new User(id, name, pass, email, phone, address, role);
            accountDAO.updateAcconut(unew);
            response.sendRedirect("profile");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
