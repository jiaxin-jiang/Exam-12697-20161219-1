package com.jjx.beans;

import java.util.Date;

/**
 * Created by TandTV on 2016/12/19.
 */
public class Language {
    private int language_id;
    private String name;
    private Date last_update;

    public Language() {
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLast_update(java.sql.Date last_update) {
        return this.last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
