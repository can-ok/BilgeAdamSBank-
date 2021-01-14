package com.entity;

import com.scraper.RssScraper;

import java.util.List;

public class CnnTurk extends Website{

    public CnnTurk() {
        this.setName("CNN TURK");
        this.setUrlRSS("https://www.cnnturk.com/feed/rss/all/news");
    }


    @Override
    public List<News> getDescription() {
        List<News> newsList= RssScraper.getRss("https://www.cnnturk.com/feed/rss/all/news");

        return newsList;
    }
}
