package controllers.servlets;

import models.Image;
import models.User;
import org.apache.commons.io.IOUtils;
import services.interfaces.ImageService;
import services.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/upload/db")
@MultipartConfig
public class UploadImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadDir = "C:\\Users\\Asus\\Desktop\\ITISPROJECTS\\Donut\\Donuts\\PuffyDonut\\src\\main\\webapp\\assets\\data";
        Part file = request.getPart("file");
        String path = UUID.randomUUID().toString() + "-" + file.getSubmittedFileName();

        User user = (User) request.getSession().getAttribute("user");
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        ImageService imageService = (ImageService) getServletContext().getAttribute("imageService");

        Image image = Image.builder()
                .type(file.getContentType())
                .path(path).build();
        imageService.addImage(image);

        user.setImage(imageService.getByPath(path));
        userService.update(user);

        IOUtils.copyLarge(
                file.getInputStream(),
                new FileOutputStream(uploadDir + File.separator + path)
        );

        request.getRequestDispatcher("/profile.ftl").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/profile.ftl").forward(request, response);
    }
}
