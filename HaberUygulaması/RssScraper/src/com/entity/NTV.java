package com.entity;

import com.scraper.RssScraper;

import java.util.List;

public class NTV extends Website{

    public NTV() {

        this.setName("NTV");
        this.setUrlRSS("https://www.ntv.com.tr/son-dakika.rss");
    }

    @Override
    public List<News> getDescription() {
        List<News> newsList=RssScraper.getRss("https://www.ntv.com.tr/son-dakika.rss");

        return newsList;
    }

}

