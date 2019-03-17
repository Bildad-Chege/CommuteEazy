package com.bilchege.commuteazy.Controllers;

import com.bilchege.commuteazy.Entities.Feed;
import com.bilchege.commuteazy.Services.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FeedController {

    @Autowired
    private FeedService feedService;

    @RequestMapping(method = RequestMethod.POST,value = "/addfeed")
    public Feed addFeed(@RequestBody Feed feed){
        return feedService.addFeed(feed);
    }

    @RequestMapping("/getfeed/{id}")
    public Optional<Feed> getFeed(@PathVariable Long id){
        return feedService.getFeed(id);
    }

    @RequestMapping("/getfeeds")
    public List<Feed> getFeeds(){
        return feedService.getAllFeeds();
    }

    @RequestMapping("/deletefeed/{id}")
    public void deleteFeed(@PathVariable Long id){
        feedService.deleteFeed(id);
    }

}
