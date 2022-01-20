package com.javaweb.servlet;

import com.javaweb.bean.User;
import com.javaweb.service.UserService;
import com.javaweb.service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName UserListServer
 * @Description
 * @Author JingXu
 * @Date 1/10/22 10:27 PM
 */
public class UserListServlet extends HttpServlet {

    private String encode;

    @Override
    public void init(ServletConfig config) throws ServletException {
        encode = config.getServletContext().getInitParameter("encode");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(encode);
        UserService userService = new UserServiceImpl();
        List<User> users = userService.listAll();
        req.setAttribute("userList", users);
        req.getRequestDispatcher("userList.jsp").forward(req, resp);
    }
}
