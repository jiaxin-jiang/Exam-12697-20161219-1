package com.jjx.daos.daosImpl;

import com.jjx.beans.Film;
import com.jjx.beans.Language;
import com.jjx.daos.iDaos.IFilmDao;
import com.jjx.db.DbcpConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by TandTV on 2016/12/19.
 */
public class FilmDaoImpl implements IFilmDao {

    /**
     * 新增电影
     *
     * @param film 电影
     * @return
     */
    public boolean addFilm(Film film) {

        boolean bool = false;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DbcpConnection.getConnection();
            String sql = "insert into film(title,description,language_id) values(?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, film.getTitle());
            pst.setString(2, film.getDescription());
            pst.setInt(3, film.getLanguage().getLanguage_id());
            bool = pst.executeUpdate()>0?true:false;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bool;
    }

    /**
     * 删除电影
     *
     * @param film_id
     * @return
     */
    public boolean delFilm(int film_id) {

        boolean bool = false;
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = DbcpConnection.getConnection();
            String sql = "delete from film where film_id=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, film_id);
            bool = pst.executeUpdate()>0?true:false;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bool;
    }

    /**
     * 通过ID更新电影
     *
     * @param film 电影
     * @return
     */
    public boolean updateFilm(Film film) {

        boolean bool = false;
        Connection conn = null;
        PreparedStatement pst = null;
        System.out.println("upda");

        try {
            conn = DbcpConnection.getConnection();
            String sql = "update film set title=?,description=?,language_id=? where film_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, film.getTitle());
            pst.setString(2, film.getDescription());
            pst.setInt(3, film.getLanguage().getLanguage_id());
            pst.setInt(4,film.getFilm_id());
            System.out.println(sql);
            bool = pst.executeUpdate()>0?true:false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bool;
    }

    /**
     * 显示所有的电影
     *
     * @return 电影集合
     */
    public ArrayList<Film> showAllFilm() {

        Film film = null;
        Language language = null;
        ArrayList<Film> films = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DbcpConnection.getConnection();
            String sql = "select * from film,language where film.language_id =language.language_id";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            films = new ArrayList<Film>();
            while (rs.next()) {
                film = new Film();
                language = new Language();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                language.setLanguage_id(rs.getInt("language_id"));
                language.setName(rs.getString("name"));
                language.getLast_update(rs.getDate("last_update"));
                film.setLanguage(language);
                films.add(film);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return films;
    }

    public boolean findFilmByID(int film_id) {

        boolean bool = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DbcpConnection.getConnection();
            String sql = "select * from film WHERE film_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, film_id);
            rs = pst.executeQuery();
            while (rs.next()) {
                bool = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bool;
    }

    public Film showFilmByID(int film_id) {
        Film film = null;
        Language language = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DbcpConnection.getConnection();
            String sql = "select * from film,language where film.language_id =language.language_id and film_id=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, film_id);
            rs = pst.executeQuery();

            while (rs.next()) {
                film = new Film();
                language = new Language();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                language.setLanguage_id(rs.getInt("language_id"));
                language.setName(rs.getString("name"));
                language.getLast_update(rs.getDate("last_update"));
                film.setLanguage(language);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return film;
    }
}