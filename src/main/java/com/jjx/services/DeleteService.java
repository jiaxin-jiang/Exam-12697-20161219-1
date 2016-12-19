package com.jjx.services;

import com.jjx.beans.Film;
import com.jjx.daos.daosImpl.FilmDaoImpl;
import com.jjx.daos.iDaos.IFilmDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteService implements Service {
    private IFilmDao filmDao = new FilmDaoImpl();
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int fid = Integer.parseInt(request.getParameter("fid"));

		if(filmDao.findFilmByID(fid)){

		    if(filmDao.delFilm(fid)){
                request.setAttribute("allFilm", filmDao.showAllFilm());
                request.getRequestDispatcher("showAll.jsp").forward(request, response);
            }else{
                request.setAttribute("msg", "有关联的数据，无法删除！！！");
                request.getRequestDispatcher("msg.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("msg", "此电影不存在，请刷新页面！！！");
            request.getRequestDispatcher("msg.jsp").forward(request, response);
        }
	}

}
