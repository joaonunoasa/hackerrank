package io.javabrains.springbootstarter.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Business service.
 * In spring, business services are typically singletons.
 * When the application starts up, spring creates an instance of this service and keeps it in memory
 */
@Service
class TopicService {

    private List<Topic> topics = new ArrayList<>(
            Arrays.asList(
                    new Topic("spring", "Spring Framwework", "Spring Framwework Description"),
                    new Topic("java", "Core Java", "Core Java Description"),
                    new Topic("javascript", "Javascript", "Javascript Description")
    ));

    List<Topic> getAllTopic() {
        return topics;
    }

    Topic getTopic(String id) {
        return topics.stream().filter(
                topic -> topic.getId().equals(id))
                .findFirst()
                .orElse(
                        new Topic("not found", "Topic not found", "Could not find topic"));
    }

    void addTopic(Topic topic) {
        topics.add(topic);
    }

    void setTopic(String id, Topic topic) {
        int index = topics.indexOf(getTopic(id));
        topics.set(index, topic);
    }

    void deleteTopic(String id) {
        topics.removeIf(topic -> topic.getId().equals(id));
    }
}
