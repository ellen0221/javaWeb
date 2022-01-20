package com.javaweb.servlet;

import com.javaweb.dao.UserDao;
import com.javaweb.dao.UserDaoImpl;
import com.javaweb.service.UserService;
import com.javaweb.service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @ClassName com.javaweb.web.TestServlet
 * @Description
 * @Author JingXu
 * @Date 12/31/21 4:06 PM
 */
public class LoginServlet extends HttpServlet {

    private String encode;

    @Override
    public void init(ServletConfig config) throws ServletException {
        encode = config.getServletContext().getInitParameter("encode");
    }

    @Override // 处理get请求
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get------------");
    }

    @Override // 处理post请求
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(encode);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService userService = new UserServiceImpl();
        Boolean res = userService.login(username, password);
        Cookie cookie = new Cookie("username", username);
        resp.addCookie(cookie);
        cookie.setMaxAge(60); // 1分钟后失效
        if (!res) { // 登陆失败
            resp.sendRedirect("false.jsp");
        } else { // 登陆成功
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("success.jsp");
        }
    }
}
