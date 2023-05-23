package com.application._flowers.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application._flowers.entity.Flowers;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FlowersTask {
	int count = 0;
	LocalDateTime presentDateTime = LocalDateTime.now();
	DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public List<Flowers> update(List<Flowers> list) {

		if(list.stream().anyMatch(i->i.getId()==4)) {
			list.stream().map(i -> {
				if (i.getId() == 4) {
					i.setBody("1800Flowers");
					i.setTitle("1800Flowers");
					log.info("Title and Body updated successfully for UserId:4 " + dt.format(presentDateTime));
				}
				return i;
			}).collect(Collectors.toList());
		return list;
		} 
		log.error("UserId Not found " + dt.format(presentDateTime));
		throw new RuntimeException("UserId Not found");
			
	}

	public Map<String, Integer> countUniqueUserIds(List<Flowers> list) {
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		try {
			Map<Integer, List<Flowers>> map;
			map = list.stream().collect(Collectors.groupingBy(Flowers::getUserId));
			map1.put("No.of Uniques UserId's", map.size());
			log.info("Number of uniqueUserId's:" + map.size() + " fetched successfully");
		}
		catch(Exception e) {
			log.error(e.getMessage());
			new RuntimeException(e.getMessage());
		}
		
		return map1;

	}
}
