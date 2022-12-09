package com.springboot.sampleprojectstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics =new ArrayList<>(Arrays.asList(
			new Topic("Topic1","Core Java","Spring framework"),
			new Topic("Topic2","Advanced Java","Spring MVC"),
			new Topic("Topic3","Spring","Spring Boot")));
	
	public List<Topic> getListOfAllTopics() {
		return topics;	
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id ,Topic topic) {
		for (int i=0 ; i<topics.size() ; i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i,topic);
			};
		return;
	     }
    }
	public void deleteTopic(String id) {
		 topics.removeIf(t -> t.getId().equals(id));
	}
}
