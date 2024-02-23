package com.example;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class Controller {
	
	Map<String,RestUser> allUsers=new HashMap<>();
	
	
	
	@GetMapping
	public Collection<RestUser> getMethod() {
		
		return allUsers.values();
	}
	@PostMapping
	public String postMethod(@RequestBody RestUser userdetails) {
		RestUser addValue=new RestUser();
		addValue.setUserId(userdetails.getUserId());
		addValue.setName(userdetails.getName());
		addValue.setEmail(userdetails.getEmail());
		allUsers.put(userdetails.getUserId(), addValue);
		
		return "user Added";
	}
	@PutMapping(path = "/{userId}")
	public String putMethod(@PathVariable String userId,@RequestBody RestUser userdetails) {
		if(allUsers.containsKey(userId)) {
			RestUser addValue=new RestUser();
			addValue.setUserId(userdetails.getUserId());
			addValue.setName(userdetails.getName());
			addValue.setEmail(userdetails.getEmail());
			allUsers.put(userId, addValue);
			return "User Data Edited Succesfully";
		}
		else {
		return "User Id Not Found";
		}
	}
	@DeleteMapping(path = "/{userId}")
	public String deleteMethod(@PathVariable String userId) {
		if(allUsers.containsKey(userId)) {
			allUsers.remove(userId);
			return "User Deleted Succesfully";
		}else {
		return "User Not Found";
		}
	}
}
