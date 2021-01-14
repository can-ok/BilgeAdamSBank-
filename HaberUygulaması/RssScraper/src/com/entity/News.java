package com.entity;

import java.util.List;

public class News {

    private String title;

    private String Description;

    private List<News> newsList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
    @Override
    public String toString() {
        return title;
    }
}
