package com.application._flowers.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FlowersTests {

	ObjectMapper obj = new ObjectMapper();

	@Test
	void flowers() throws JsonProcessingException {
		Flowers flowers = new Flowers();
		flowers.setUserId(1);
		flowers.setId(1);
		flowers.setTitle("1800Flowers");
		flowers.setBody("1800Flowers");
		assertNotNull(flowers.getUserId());
		assertNotNull(flowers.getId());
		assertNotNull(flowers.getTitle());
		assertNotNull(flowers.getBody());
		Flowers expected = new Flowers(1, 1, "1800Flowers", "1800Flowers");
		assertEquals(obj.writeValueAsString(expected), obj.writeValueAsString(flowers));
	}
}
