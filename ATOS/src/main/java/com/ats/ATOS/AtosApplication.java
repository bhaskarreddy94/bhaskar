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
		User user=User.builder().address("chennai").age(25).firstName("bhaskar").lastName("reddy").build();
		ObjectMapper mapper=new ObjectMapper();
		
		System.out.println(mapper.writeValueAsString(user));
		
	}
	List<User> list=new ArrayList<>();
	@PostMapping(value="/user",consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> postUser(/*@RequestBody User user,*/@RequestBody String user1) throws JsonParseException, JsonMappingException, IOException{
		
		/*ObjectMapper mapper=new ObjectMapper();
	User user2=	mapper.readValue(user, User.class);
	li
	
*/	
		
	// to another service to get response as json string;
		ResponseEntity<String> response=getuser();
		String responseString=response.getBody();
	User e= service.getuser(responseString);
				list.add(e);
		return ResponseEntity.ok(e);
	}
	@PostMapping(value="/user1",consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> postNewUser(@RequestBody User user){
	System.out.println(user.toString());

		return ResponseEntity.ok(user);
		
	}
	@GetMapping("/allusers")
	public  ResponseEntity<String> getuser() {
		return ResponseEntity.ok( "{\"firstName\":null,\"lastName\":null,\"age\":0,\"phone\":null,\"mobile\":null}");
		// TODO Auto-generated method stub

	}
	
	

}
