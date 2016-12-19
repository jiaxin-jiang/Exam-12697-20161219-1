package com.jjx.daos.daosImpl;

import com.jjx.beans.Film;
import com.jjx.beans.Language;
import com.jjx.daos.iDaos.ILanguage;
import com.jjx.db.DbcpConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by TandTV on 2016/12/19.
 */
public class LanguageImpl implements ILanguage {

    public ArrayList<Language> languages() {

        ArrayList<Language> languages = null ;
        Language language = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DbcpConnection.getConnection();
            String sql = "select * from language";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            languages = new ArrayList<Language>();
            while (rs.next()) {
                language = new Language();
                language.setLanguage_id(rs.getInt("language_id"));
                language.setName(rs.getString("name"));
                language.getLast_update(rs.getDate("last_update"));
                languages.add(language);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return languages;
    }
}
