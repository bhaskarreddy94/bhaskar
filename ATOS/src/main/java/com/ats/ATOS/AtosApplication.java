package com.ats.ATOS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
@CrossOrigin
public class AtosApplication {
	@Autowired
	UserService service;
	@Autowired
	UserRepository repository;
	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(AtosApplication.class, args);
		//User user=User.builder().address("chennai").age(25).firstName("bhaskar").lastName("reddy").build();
		ObjectMapper mapper=new ObjectMapper();
		
				
	}
	@PostMapping(value="/pageuser",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<List<User>>  findByFirsName(@RequestBody PageModel pageModel,@RequestParam("firstName") String firstName){
		return  ResponseEntity.ok(service.getUserByFirstName(firstName, pageModel));
	}
	
	
	
	List<User> list=new ArrayList<>();
	@PostMapping(value="/user",consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> postUser(/*@RequestBody User user,*/@RequestBody String user1) throws JsonParseException, JsonMappingException, IOException{
		
		/*ObjectMapper mapper=new ObjectMapper();
	User user2=	mapper.readValue(user, User.class);
	li
	
*/	
		
	// to another service to get response as json string;
	//	ResponseEntity<String> response=getuser();
		//String responseString=response.getBody();
	//User e= service.getuser(responseString);
			//	list.add(e);
		//return ResponseEntity.ok(e);
		return null;
	}
	@PostMapping(value="/user1",consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> postNewUser(@RequestBody User user){
	System.out.println(user.toString());
		return ResponseEntity.ok(repository.save(user));
		
	}
	@GetMapping("/allusers")
	public  ResponseEntity<Iterable<User>> getuser() {
	//	return ResponseEntity.ok( "{\"firstName\":null,\"lastName\":null,\"age\":0,\"phone\":null,\"mobile\":null}");
		return ResponseEntity.ok(repository.findAll());
		// TODO Auto-generated method stub

	}
	@GetMapping("/say")
	public String sayWish() {
		/* return Arrays.asList(
				User.builder().address("indai").age(13).firstName("bhaskar").lastName("reddy").phone("9003164501")
						.build(),
				User.builder().address("chennai").age(13).firstName("bhaskar").lastName("reddy").phone("9003164501")
						.build(),
				User.builder().address("banglor").age(13).firstName("bhaskar").lastName("reddy").phone("9003164501")
						.build(),
				User.builder().address("krishna").age(13).firstName("bhaskar").lastName("reddy").phone("9003164501")
						.build()).stream().filter(e->e.getAddress().equalsIgnoreCase("indai")).collect(Collectors.toList()).stream().findFirst().get().getFirstName();

*/	
	return "good day";
	
	}
	
	
	

}
