package com.jjx.services;

import com.jjx.beans.Film;
import com.jjx.beans.Language;
import com.jjx.daos.daosImpl.CustomerDaoImpl;
import com.jjx.daos.daosImpl.FilmDaoImpl;
import com.jjx.daos.iDaos.ICustomerDao;
import com.jjx.daos.iDaos.IFilmDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginService implements Service {

    private ICustomerDao  customerDao = new CustomerDaoImpl();
    private IFilmDao filmDao = new FilmDaoImpl();
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        // TODO Auto-generated method stub
        String first_name = request.getParameter("name");
        if (customerDao.validateCustomer(first_name)){
            request.setAttribute("allFilm", filmDao.showAllFilm());
            HttpSession session = request.getSession();
            session.setAttribute("customer",first_name);
            request.getRequestDispatcher("showAll.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
