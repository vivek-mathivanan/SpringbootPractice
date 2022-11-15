package org.example.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private ArrayList<Topic> topics = new ArrayList<>(
    Arrays.asList(
        new Topic("Spring", "Spring Framework", "Spring Description"),
        new Topic("Java", "Core Java", "Java Description")
        ));

    public List<Topic> getAllTopic(){
//        return topics;
        ArrayList<Topic> eachTopic = new ArrayList<>();
        topicRepository.findAll().forEach(t -> eachTopic.add(t));
        return eachTopic;
    }

    public Optional<Topic> getTopic(String id){
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        for (int i=0; i<topics.size(); i++){
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}
