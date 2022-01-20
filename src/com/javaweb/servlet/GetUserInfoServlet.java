package com.javaweb.servlet;

import com.javaweb.bean.User;
import com.javaweb.service.UserService;
import com.javaweb.service.impl.UserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName VerifyUsernameServlet
 * @Description
 * @Author JingXu
 * @Date 1/17/22 3:54 PM
 */
@WebServlet(urlPatterns = "/getUserInfo")
public class GetUserInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        UserService userService = new UserServiceImpl();
        User user = userService.queryUserByUsername(username);
        JSONObject jsonObject = JSONObject.fromObject(user);
        pw.print(jsonObject);
    }
}
