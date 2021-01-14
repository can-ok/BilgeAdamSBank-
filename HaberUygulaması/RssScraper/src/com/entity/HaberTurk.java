package com.entity;

import com.scraper.RssScraper;

import java.util.List;

public class HaberTurk extends Website {

    public HaberTurk() {
        this.setName("HaberTurk");
        this.setUrlRSS("https://www.haberturk.com/rss/manset.xml");
    }

    @Override
    public List<News> getDescription() {


        return RssScraper.getRss(this.getUrlRSS());
    }
}
