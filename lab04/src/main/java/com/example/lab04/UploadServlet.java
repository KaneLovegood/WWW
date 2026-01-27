package com.example.lab04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form")
@MultipartConfig(
        fileSizeThreshold = 1024*1024,
        maxFileSize = 1024*1024 *10,
        maxRequestSize = 1024*1024*15
)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        String birthday = req.getParameter("birthday");
        String[] hobbies = req.getParameterValues("hobbies");

        // xử lý file
        Part picture = req.getPart("picture");
        String fileName = picture.getSubmittedFileName();

        // thư mục lưu ảnh
        String uploadPath = getServletContext()
                .getRealPath("") + File.separator + "uploads";

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        System.out.println(uploadPath);

        if (fileName != null && !fileName.isEmpty()) {
            picture.write(uploadPath + File.separator + fileName);
        }

        // đưa dữ liệu sang JSP
        req.setAttribute("name", name);
        req.setAttribute("gender", gender);
        req.setAttribute("country", country);
        req.setAttribute("birthday", birthday);
        req.setAttribute("hobbies", hobbies);
        req.setAttribute("image", fileName);

        // forward
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
