package com.spring.boot.online.initializer.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicsController {
    @Autowired
    private TopicsService topicsService;
    @RequestMapping ("/")
    public String homePage(){
        return "Welcome to HomePage";
    }

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicsService.getAllTopics();
    }

    @RequestMapping("/topics/{param}")
    public Optional<Topic> getAllTopicsById(@PathVariable ("param") int id){
        return topicsService.getAllTopicsById(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/topics")
    public List<Topic> addTopic(@RequestBody Topic topic){
        return topicsService.addTopic(topic);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{param}")
    public List<Topic> updateTopic(@RequestBody Topic topic, @PathVariable("param")int id){
        return topicsService.updateTopic(topic, id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{param}")
    public List<Topic> deleteTopic(@RequestBody Topic topic, @PathVariable("param")int id){
        return topicsService.deleteTopic(topic, id);
    }
}
