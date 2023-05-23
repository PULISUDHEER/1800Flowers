package com.application._flowers.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.application._flowers.entity.Flowers;
import com.application._flowers.task.FlowersTask;

@Service
public class FlowersService {
	
	@Autowired
	FlowersTask flowersTask;
	
	List<Flowers> list;
	
	RestTemplate restTemplate = new RestTemplate();
	
	public Map<String, Integer> countUniqueUserIds() {
		 list= Optional.ofNullable(list)
				.orElse(new ArrayList<>(Arrays.asList(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Flowers[].class))));
		 return flowersTask.countUniqueUserIds(list);
		
	}
	
	public List<Flowers> update() {
		 list= Optional.ofNullable(list)
				.orElse(new ArrayList<>(Arrays.asList(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Flowers[].class))));
		 return flowersTask.update(list);
	}
}
