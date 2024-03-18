package controller.admin;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;
import jakarta.servlet.annotation.MultipartConfig;


@WebServlet(name = "AddClothesControl", urlPatterns = {"/addClothes"})
@MultipartConfig
public class AddClothesControl extends HttpServlet {

    private boolean isImageFile(String filename) {
        // Validate if the file is an image (you can enhance this validation)
        String[] allowedExtensions = {".jpg", ".jpeg", ".png", ".gif", ".webp"};
        for (String extension : allowedExtensions) {
            if (filename.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        Part imagePart = request.getPart("image");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String categortId_draw = request.getParameter("cateId");

        String realPath = request.getServletContext().getRealPath("/SavedImages");
        String filename = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
        String image = realPath + "/" + filename;
        int cid;
        ProductDAO productDAO = new ProductDAO();
        try {
            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectory(Paths.get(realPath));
            }
            if (isImageFile(image)) {
                imagePart.write(image);
                cid = Integer.parseInt(categortId_draw);
                Category category = new Category();
                category.setId(cid);

                Product product = new Product();
                product.setTitle(name);
                product.setSize(null);
                product.setPrice(price);
                product.setDescription(description);
                product.setThumbnail("SavedImages/" + filename);
                product.setCategory(category);
                productDAO.insert_Product(product);

                response.sendRedirect("adminClothes");
            } else {
                // Handle invalid file type
                response.setContentType("text/plain");
                response.getWriter().write("Invalid file type. Please upload an image.");
            }

        } catch (Exception e) {
        }
    }
}
