package com.jjx.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by TandTV on 2016/12/19.
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig fconfig) throws ServletException {

    }


    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        String servletPath=request.getServletPath();
        HttpSession session=request.getSession();
        String flag= (String) session.getAttribute("customer");
        System.out.println(flag);
        System.out.println(servletPath);
        if(servletPath!=null&&servletPath.equals("/index.jsp")||
                servletPath.equals("/login.jsp")||servletPath.equals("/login")||servletPath.equals("/film")){

        }else{
            if(flag!=null){
                chain.doFilter(req, resp);
            }else if(flag!=null){
                RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }else{
                RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }
    }

    public void destroy() {

    }

}
