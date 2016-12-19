package com.jjx.services;

import com.jjx.daos.daosImpl.FilmDaoImpl;
import com.jjx.daos.daosImpl.LanguageImpl;
import com.jjx.daos.iDaos.IFilmDao;
import com.jjx.daos.iDaos.ILanguage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowFilmService implements Service {

    private ILanguage language = new LanguageImpl();
    private IFilmDao filmDao = new FilmDaoImpl();

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub\

        if (request.getParameter("fid") == null) {
            request.setAttribute("languages", language.languages());
            request.getRequestDispatcher("addFilm.jsp").forward(request, response);
        } else {
            int fid = Integer.parseInt(request.getParameter("fid"));
            request.setAttribute("film", filmDao.showFilmByID(fid));
            request.setAttribute("languages", language.languages());
            request.getRequestDispatcher("updateFilm.jsp").forward(request, response);
        }

    }
}
