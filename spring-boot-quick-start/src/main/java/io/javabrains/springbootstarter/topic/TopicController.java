package io.javabrains.springbootstarter.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    /**
     * Automatically creates a json object as response
     * @return
     */
    @RequestMapping("/topics")
    public List<Topic> getAllTopic() {
        return Arrays.asList(
                new Topic("spring", "Spring Framwework", "Spring Framwework Description"),
                new Topic("java", "Core Java", "Core Java Description"),
                new Topic("javascript", "Javascript", "Javascript Description")
        );
    }
}