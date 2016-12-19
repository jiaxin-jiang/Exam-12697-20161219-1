package com.jjx.services;

import com.jjx.daos.daosImpl.FilmDaoImpl;
import com.jjx.daos.iDaos.IFilmDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShowService implements Service{
	private IFilmDao filmDao = new FilmDaoImpl();
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setAttribute("allFilm", filmDao.showAllFilm());
		request.getRequestDispatcher("showAll.jsp").forward(request, response);
	}

}
