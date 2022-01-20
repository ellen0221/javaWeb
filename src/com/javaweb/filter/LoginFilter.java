package com.javaweb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LoginFilter
 * @Description 登陆过滤器
 * @Author JingXu
 * @Date 1/10/22 2:48 PM
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("utf-8"); // 处理乱码

        // 验证登陆
        String requestURI = req.getRequestURI(); // 获取请求地址
        Object username = req.getSession().getAttribute("username"); // 获取session中的用户名
        if (requestURI.endsWith(".jsp") && !requestURI.endsWith("login.jsp")) {
            if (!requestURI.endsWith("false.jsp") && username == null) {
                System.out.println("用户未登陆");
                // 未登陆则跳转至登陆页面
                resp.sendRedirect("login.jsp");
            } else if (requestURI.endsWith("userList.jsp") && !("xujing".equals(username.toString()))) {
                System.out.println("无权限查看用户列表");
                resp.sendRedirect("success.jsp");
            }
        }

        // 调取下一个filter，或servlet
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter have done.");
    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter destroy...");
    }
}
