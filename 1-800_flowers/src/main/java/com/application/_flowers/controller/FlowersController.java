package com.application._flowers.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application._flowers.entity.Flowers;
import com.application._flowers.service.FlowersService;

@RestController
@RequestMapping("/flowers")
public class FlowersController {
	@Autowired
	FlowersService flowersService;

	@PutMapping
	public ResponseEntity<List<Flowers>> update(@RequestBody Flowers flowers) {
		return new ResponseEntity<List<Flowers>>(flowersService.update(flowers), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Map<String, Integer>> countUniqueUserId() {
		return new ResponseEntity<Map<String, Integer>>(flowersService.countUniqueUserIds(), HttpStatus.OK);

	}
}
