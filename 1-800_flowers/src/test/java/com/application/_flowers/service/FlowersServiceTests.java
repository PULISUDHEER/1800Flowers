package com.application._flowers.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.application._flowers.entity.Flowers;
import com.application._flowers.task.FlowersTask;

@ExtendWith(MockitoExtension.class)
public class FlowersServiceTests {
	
	@InjectMocks
	FlowersService flowersService;
	
	@Mock
	FlowersTask flowersTask;
	
	@Mock
	List<Flowers> list;
	
	@Mock
	private RestTemplate restTemplate;
	
	String url = "http://jsonplaceholder.typicode.com/posts";
	
	@Test
	void updateTests() {
		Flowers[] value = new Flowers[1];
		value[0]= new Flowers(1,1,"title", "Body");
		Mockito.when(restTemplate.getForObject(url, Flowers[].class)).thenReturn(value);
		assertNotNull(flowersService.update());
	}
	
	@Test
	void countUniqueUserIdsTests() {
		Flowers[] value = new Flowers[1];
		value[0]= new Flowers(1,1,"title", "Body");
		Mockito.when(restTemplate.getForObject(url, Flowers[].class)).thenReturn(value);
		assertNotNull(flowersService.countUniqueUserIds());
	}

}
