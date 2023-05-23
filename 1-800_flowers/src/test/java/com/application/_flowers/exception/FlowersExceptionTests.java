package com.application._flowers.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.application._flowers.entity.Flowers;
import com.application._flowers.task.FlowersTask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@ExtendWith(MockitoExtension.class)
public class FlowersExceptionTests {
	
	@InjectMocks
	FlowersTask task;

	@InjectMocks
	FlowersException exception;

	@Mock
	Exception e;

	@Test
	void printUpdatesTest() throws JsonMappingException, JsonProcessingException {

		Flowers[] data = new Flowers[1];
		data[0] = new Flowers(1, 1, "title", "body");
		List<Flowers> list1 = Arrays.asList(data);
		assertThrows(RuntimeException.class, () -> task.update(list1), "UserId Not found");

		ResponseEntity<?> response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		assertEquals(response, exception.printException(e));
	}

}
