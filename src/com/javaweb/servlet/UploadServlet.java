package com.javaweb.servlet;

import com.javaweb.service.UserService;
import com.javaweb.service.impl.UserServiceImpl;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName UploadServlet
 * @Description
 * @Author JingXu
 * @Date 1/17/22 9:18 PM
 */
@WebServlet(urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "uploads/";

        try {
            // 1. 获得smartupload对象
            SmartUpload smartUpload = new SmartUpload();
            // 2. 获得pagecontext对象
            PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, false, 1024, false);
            smartUpload.initialize(pageContext);
            smartUpload.setCharset("utf-8");
            smartUpload.upload();
            // 3. 获取文件及相关信息
            File f = smartUpload.getFiles().getFile(0);
            String fileName = f.getFileName();
            url += fileName;
            System.out.println("url==" + url);
            f.saveAs(url, SmartUpload.SAVE_VIRTUAL);

            // 保存用户头像路径
            UserService userService = new UserServiceImpl();
            PrintWriter pw = resp.getWriter();
            Integer res = userService.updateByUid(smartUpload.getRequest().getParameter("username"), url);
            if (res > 0) {
                resp.sendRedirect("success.jsp");
            } else {

            }
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
    }
}
