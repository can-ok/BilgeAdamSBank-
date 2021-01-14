package com.entity;

import com.scraper.RssScraper;

import java.util.List;

public class Hurriyet extends Website{

    public Hurriyet(){
        this.setName("Hurriyet");
        this.setUrlRSS("https://www.hurriyet.com.tr/rss/anasayfa");
    }

    @Override
    public List<News> getDescription() {
        return RssScraper.getRss(this.getUrlRSS());
    }
}
