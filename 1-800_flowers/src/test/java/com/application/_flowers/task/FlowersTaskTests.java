package com.application._flowers.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.application._flowers.entity.Flowers;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class FlowersTaskTests {
	@InjectMocks
	FlowersTask flowersTask;

	ObjectMapper obj = new ObjectMapper();

	@Test
	void updateTest() throws Exception {
		String resBody = "[{\"userId\":1,\"id\":4,\"title\":\"1800Flowers\",\"body\":\"1800Flowers\"}]";
		List<String> expected = Arrays.asList(resBody);

		Flowers[] data = new Flowers[1];
		data[0] = new Flowers(1, 4, "title", "body");
		List<Flowers> list1 = Arrays.asList(data);
		List<String> actual = Arrays.asList(obj.writeValueAsString(flowersTask.update(list1)));
		assertEquals(expected, actual);
	}

	@Test
	void printCountTest() throws Exception {

		Map<String, Integer> expected = new HashMap<>();
		expected.put("No.of Uniques UserId's", 1);
		Flowers[] data = new Flowers[1];
		data[0] = new Flowers(1, 1, "1800flowers", "1800flowers");
		List<Flowers> list1 = Arrays.asList(data);

		assertEquals(expected, flowersTask.countUniqueUserIds(list1));
	}

}
