package com.ats.ATOS;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {
	
	 ObjectMapper mapper= new ObjectMapper();
	//static String json= "{\"firstName\":\"bhaskar\",\"lastName\":\"hari\",\"address\":\"urukundu\"}";
public   User getuser( String json){
	User user=null;

	 try {
		user= mapper.readValue(json, User.class);
	} catch (IOException e) {
		e.printStackTrace();
	}

return user;
}

/*public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	UserService service=new UserService();
	System.out.println(service.getuser(json));
}*/
}
