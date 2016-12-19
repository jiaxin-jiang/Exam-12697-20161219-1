package com.jjx.services;

import com.jjx.beans.Film;
import com.jjx.beans.Language;
import com.jjx.daos.daosImpl.FilmDaoImpl;
import com.jjx.daos.iDaos.IFilmDao;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddService implements Service {

    private IFilmDao filmDao = new FilmDaoImpl();

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int language_id = Integer.parseInt(request.getParameter("language"));

        Film film = new Film();
        Language language = new Language();

        language.setLanguage_id(language_id);
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguage(language);

        if(filmDao.addFilm(film)){
            request.setAttribute("allFilm", filmDao.showAllFilm());
            request.getRequestDispatcher("showAll.jsp").forward(request, response);
        }else {
            request.setAttribute("msg", "新增失败！！！");
			request.getRequestDispatcher("msg.jsp").forward(request, response);
        }
	}
}
