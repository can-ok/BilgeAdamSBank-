package com.scraper;

import com.entity.News;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class  RssScraper {

    public static List<News> getRss(String getUrl) {

        List<News> newsList=new ArrayList<>();

        try {
            SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(getUrl)));
            //System.out.println(feed.getEntries());


            for (SyndEntry syndEntry : feed.getEntries()) {

                //System.out.println(syndEntry.getTitle());
                News news=new News();
                news.setTitle(syndEntry.getTitle());
                news.setDescription(syndEntry.getDescription().getValue());
                newsList.add(news);

                //System.out.println(syndEntry.getDescription().getValue());
            }


        }catch (FeedException | IOException e ) {
            e.printStackTrace();
        }

        return newsList;
    }
}
