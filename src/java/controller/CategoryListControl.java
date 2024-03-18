/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
@WebServlet(name="CategoryListControl", urlPatterns={"/categories"})
public class CategoryListControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_draw  = request.getParameter("category");
        int id;
        ProductDAO dao  =new ProductDAO();
        try {
            id = Integer.parseInt(id_draw);
            List<Product> list = dao.getProdutByCategoryID(id);
            request.setAttribute("listCategory", list);
            
        List<Category> listC = dao.getAllCategory();
        request.setAttribute("listC", listC);
            request.getRequestDispatcher("categoryProduct.jsp").forward(request, response);
        } catch (Exception e) {
        }
    } 
}
