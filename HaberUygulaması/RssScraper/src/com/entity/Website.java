package com.entity;

import java.util.List;

public abstract class Website {

    private String name;
    private String urlRSS;

    public Website() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlRSS() {
        return urlRSS;
    }

    public void setUrlRSS(String urlRSS) {
        this.urlRSS = urlRSS;
    }


    public abstract List<News> getDescription();

    @Override
    public String toString() {
        return name;
    }
}
