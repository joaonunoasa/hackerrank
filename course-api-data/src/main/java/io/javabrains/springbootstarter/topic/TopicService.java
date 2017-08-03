package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Business service.
 * In spring, business services are typically singletons.
 * When the application starts up, spring creates an instance of this service and keeps it in memory
 */
@Service
class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    List<Topic> getAllTopic() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    Topic getTopic(String id) {
        return topicRepository.findOne(id);
    }

    void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    void setTopic(String id, Topic topic) {
        topicRepository.save(topic);
    }

    void deleteTopic(String id) {
        topicRepository.delete(id);
    }
}
