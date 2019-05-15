package com.ats.ATOS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
public class AtosApplication {
	@Autowired
	UserService service;
	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(AtosApplication.class, args);
		User user=new User();
		ObjectMapper mapper=new ObjectMapper();
		
		System.out.println(mapper.writeValueAsString(user));
		
	}
	List<User> list=new ArrayList<>();
	@PostMapping(value="/user",consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> postUser(@RequestBody String user) throws JsonParseException, JsonMappingException, IOException{
		
		/*ObjectMapper mapper=new ObjectMapper();
	User user2=	mapper.readValue(user, User.class);
	li
	
*/	User e= service.getuser(user);
		
		list.add(e);
		return ResponseEntity.ok(e);
	}
	
	@GetMapping("/allusers")
	public  List<User> getuser() {
		return null;
		// TODO Auto-generated method stub

	}

}
