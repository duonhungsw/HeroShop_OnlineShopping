package controller.admin;

import dal.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import model.Category;
import model.Product;
import jakarta.servlet.annotation.MultipartConfig;

@WebServlet(name = "UpdateClothesControl", urlPatterns = {"/updateClothes"})
@MultipartConfig
public class UpdateClothesControl extends HttpServlet {

    private boolean isImageFile(String filename) {
        String[] allowedExtensions = {".jpg", ".jpeg", ".png", ".gif", ".webp"};
        for (String extension : allowedExtensions) {
            if (filename.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_draw = request.getParameter("id");
        ProductDAO productDAO = new ProductDAO();
        int id;
        try {
            id = Integer.parseInt(id_draw);
            Product p = productDAO.checkProductById(id);
            List<Category> listCategory = productDAO.getAllCategory();
            request.setAttribute("clothes", p);
            request.setAttribute("listCategory", listCategory);
            request.getRequestDispatcher("updateClothes.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_draw = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String category_draw = request.getParameter("categoryId");
        int clothesId;
        int categoryId;

        String realPath = request.getServletContext().getRealPath("/SavedImages");
        String image = null;
        String filename = null;


        // Kiểm tra xem có phần ảnh được gửi từ form hay không
        Part imagePart = request.getPart("image");
        if (imagePart != null && imagePart.getSize() > 0) {
             filename = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
            image = realPath + "/" + filename;

            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectory(Paths.get(realPath));
            }

            // Ghi ảnh vào thư mục SavedImages
            imagePart.write(image);
        }

        ProductDAO productDAO = new ProductDAO();
        try {
            clothesId = Integer.parseInt(id_draw);
            categoryId = Integer.parseInt(category_draw);
            Product p = new Product();
            p.setId(clothesId);
            p.setTitle(name);
            p.setPrice(price);
            p.setDescription(description);

            // Chỉ cập nhật thumbnail nếu ảnh mới được gửi từ form
            if (image != null) {
                p.setThumbnail("SavedImages/" + filename);
            }

            Category category = new Category();
            category.setId(categoryId);
            p.setCategory(category);
            productDAO.update_Product(p);

            response.sendRedirect("adminClothes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
