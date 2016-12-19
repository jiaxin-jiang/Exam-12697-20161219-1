package com.jjx.servlets;

import com.jjx.services.Service;
import com.jjx.services.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by TandTV on 2016/12/19.
 */
public class LoginServlet extends HttpServlet {
    /**
     * Constructor of the object.
     */
    public LoginServlet() {
        super();
    }

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String type = request.getParameter("type");
        Service s = null;
        if (type.equals("login")) {
            s = ServiceFactory.createLoginService();
        }
        s.execute(request, response);
    }
}
