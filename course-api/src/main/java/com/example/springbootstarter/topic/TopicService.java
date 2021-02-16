package com.example.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring Framework", "Spring Framework Description"),
			new Topic("Java","Core Java", "Core Java Description"),
			new Topic("Javascript","Javascript", "Javascript Description")
             ));
	
	public List<Topic> getAllTopic(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		for(Topic topic : topics) {
			if(topic.getId().equals(id)) {
				return topic;
			}
		}
		return null;
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0; i<topics.size(); i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
			}
		}
	}

	public void deleteTopic(String id) {
		for(Topic t : topics) {
			if(t.getId().equals(id)) {
				topics.remove(t);
			}
		}
	}
}
