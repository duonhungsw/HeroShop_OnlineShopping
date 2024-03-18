package controller;

import dal.PaginationDAO;
import dal.ProductDAO;
import dal.SearchDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;

@WebServlet(name = "SearchControl", urlPatterns = {"/search"})
public class SearchControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String txtSearch = request.getParameter("txtSearch");
        String indexString  = request.getParameter("index");
        int index = Integer.parseInt(indexString);
        
        SearchDAO dao = new SearchDAO();
        PaginationDAO paginationDAO = new PaginationDAO();
        int count = paginationDAO.count(txtSearch);
        int pagesize = 8;
        int endPage = 0;
        endPage = count / pagesize;
        if (count / pagesize != 0) {
            endPage++;
        }
        List<Product> list = dao.search(txtSearch, index, pagesize);
        request.setAttribute("listP", list);
        request.setAttribute("end", endPage);
        request.setAttribute("save", txtSearch);
        request.getRequestDispatcher("searchResult.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String txtSearch = request.getParameter("txtSearch");
        String indexString  = request.getParameter("index");
        int index = Integer.parseInt(indexString);
        
        SearchDAO dao = new SearchDAO();
        PaginationDAO paginationDAO = new PaginationDAO();
        int count = paginationDAO.count(txtSearch);
        int pagesize = 8;
        int endPage = 0;
        endPage = count / pagesize;
        if (count / pagesize != 0) {
            endPage++;
        }
        List<Product> list = dao.search(txtSearch, index, pagesize);
        request.setAttribute("listP", list);
        request.setAttribute("end", endPage);
        request.setAttribute("save", txtSearch);
        request.setAttribute("index", index);
        request.getRequestDispatcher("searchResult.jsp").forward(request, response);
    }

}
