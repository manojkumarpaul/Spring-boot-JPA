package com.spring.boot.online.initializer.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicsService {

    @Autowired
    private TopicsRepository topicsRepository;

    private List<Topic> topicListComplete;

    public List<Topic> getAllTopics(){
        topicListComplete = new ArrayList<>();
        topicsRepository.findAll().forEach(topicListComplete::add);
        return topicListComplete;
    }

    public Optional<Topic> getAllTopicsById(final int id) {
        return  topicsRepository.findById(id);
    }

    public List<Topic> addTopic(Topic topic) {
        topicsRepository.save(topic);
        return getAllTopics();
    }

    public List<Topic> updateTopic(Topic topic, int id) {
        topicsRepository.save(topic);
        return getAllTopics();
    }

    public List<Topic> deleteTopic(Topic topic, int id) {
        topicsRepository.deleteById(id);
        return getAllTopics();
    }
}
