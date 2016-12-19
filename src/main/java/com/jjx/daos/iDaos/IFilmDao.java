package com.jjx.daos.iDaos;

import com.jjx.beans.Film;

import java.util.ArrayList;

/**
 * Created by TandTV on 2016/12/19.
 */
public interface IFilmDao {
    public boolean addFilm(Film film);
    public boolean delFilm(int film_id);
    public boolean updateFilm(Film film);
    public ArrayList<Film> showAllFilm();
    public boolean findFilmByID(int film_id);
    public Film showFilmByID(int film_id);

}
