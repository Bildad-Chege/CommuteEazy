package com.bilchege.commuteazy.Services;

import com.bilchege.commuteazy.Entities.Feed;
import com.bilchege.commuteazy.Repositories.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FeedService {

    @Autowired
    private FeedRepository feedRepository;

    public Feed addFeed(Feed feed){
        return feedRepository.save(feed);
    }

    public Optional<Feed> getFeed(Long id){
        return feedRepository.findById(id);
    }

    public List<Feed> getAllFeeds(){
        List<Feed> feeds = new ArrayList<>();
        feedRepository.findAll().forEach(feeds::add);
        SortByDate s = new SortByDate();
        Collections.sort(feeds,s.reversed());
        return feeds;
    }

    public void deleteFeed(Long id){
        feedRepository.deleteById(id);
    }

    public class SortByDate implements Comparator<Feed>{

        @Override
        public int compare(Feed o1, Feed o2) {
            return (int) (o1.getDateCreated().getTime()-o2.getDateCreated().getTime());
        }


    }

}
