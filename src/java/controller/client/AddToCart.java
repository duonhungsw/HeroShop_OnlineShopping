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
import model.Cart;
import model.CartProduct;
import model.Product;
import model.User;

@WebServlet(name = "AddToCart", urlPatterns = {"/addToCart"})
public class AddToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String productId = request.getParameter("id");
        String size = request.getParameter("size");
        String quantityString = request.getParameter("quantity");


        CartDAO cartDAO = new CartDAO();
        Cart cart = cartDAO.get_Cart_By_Id(user.getId());

        if (productId != null && quantityString != null) {
            try {
                int pid = Integer.parseInt(productId);
                int quantity = Integer.parseInt(quantityString);

                Product product = cartDAO.get_Product_By_Id(pid);
                if (product != null) {
                    int price = Integer.parseInt(product.getPrice());

                    CartProduct cartProduct = new CartProduct();
                    cartProduct.setCart(cart);
                    cartProduct.setProduct(product);
                    cartProduct.setQuantity(quantity);
                    cartProduct.setTotal_money(quantity * price);
                    cartProduct.setSize(size);
                    cartProduct.setPrice(price);

                    if (cart == null) {
                        cart = new Cart();
                        cart.setUser(user);
                        cart.setQuantity(0);
                        cartDAO.insert_Cart(cart);
                        cart = cartDAO.get_Cart_By_Id(user.getId());
                    }

                    // Kiểm tra và cập nhật sản phẩm trong giỏ hàng
                    CartProduct existingProduct = cartDAO.getCartProductByProductIdAndSize(pid, size);
                    if (existingProduct != null) {
                        // Sản phẩm đã tồn tại trong giỏ hàng, cập nhật quantity và totalMoney
                        existingProduct.setQuantity(existingProduct.getQuantity() + quantity);
                        existingProduct.setTotal_money(existingProduct.getTotal_money() + (quantity * price));
                        cartDAO.updateCartProduct(existingProduct);
                    } else {
                        cartDAO.addToCart(cartProduct);
                    }
                }
                response.sendRedirect("http://localhost:9999/heroshop/detail?pid=" + productId);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("error.jsp");
    }

    public CartProduct checkProduct(CartProduct c) {

        return null;
    }
}
