package com.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @ClassName DownloadServlet
 * @Description
 * @Author JingXu
 * @Date 1/19/22 11:41 AM
 */
@WebServlet(urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("imgName");
        System.out.println("filename=" + fileName);
        String url = "uploads/" + fileName;
        resp.setContentType("application/octect-stream");
        fileName = URLEncoder.encode(fileName, "utf-8");
        resp.addHeader("Content-Disposition", "attachment;filename=" + fileName);

        req.getRequestDispatcher(url).forward(req, resp);
        resp.flushBuffer();
    }
}
