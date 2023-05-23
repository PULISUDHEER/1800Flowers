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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	ObjectMapper obj = new ObjectMapper();

	@Test
	void updateTests() throws JsonMappingException, JsonProcessingException {
		String reqBody = "{\"userId\":1,\"title\":\"1800flowers\", \"body\":\"1800flowers\"}";
		Flowers details = obj.readValue(reqBody, Flowers.class);
		Flowers[] value = new Flowers[1];
		value[0] = new Flowers(1, 1, "title", "Body");
		Mockito.when(restTemplate.getForObject(url, Flowers[].class)).thenReturn(value);
		assertNotNull(flowersService.update(details));
	}

	@Test
	void countUniqueUserIdsTests() {
		Flowers[] value = new Flowers[1];
		value[0] = new Flowers(1, 1, "title", "Body");
		Mockito.when(restTemplate.getForObject(url, Flowers[].class)).thenReturn(value);
		assertNotNull(flowersService.countUniqueUserIds());
	}

}
