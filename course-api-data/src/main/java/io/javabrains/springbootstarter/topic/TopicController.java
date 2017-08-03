package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    /**
     * marks the variable as needed dependency injection
     */
    @Autowired
    private TopicService topicService;

    /**
     * Automatically creates a json object as response
     */
    @RequestMapping("/topics")
    public List<Topic> getAllTopic() {
        return topicService.getAllTopic();
    }

    @RequestMapping("topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        topicService.setTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value= "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}