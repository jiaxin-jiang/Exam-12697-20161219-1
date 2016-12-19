package com.jjx.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by TandTV on 2016/12/19.
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig fconfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        /*RequestDispatcher dispatcher = request
                .getRequestDispatcher("../index.jsp");*/
        HttpSession session = ((HttpServletRequest)request).getSession();
        System.out.println(session.getAttribute("customer"));
        if(session.getAttribute("customer")!=null){
            chain.doFilter(request, response);
        }else {
            request.setAttribute("msg", "未登陆请，返回登陆界面登陆");
            request.getRequestDispatcher("msg.jsp").forward((HttpServletRequest)request, (HttpServletResponse)response);
        }
    }

    public void destroy() {

    }

}