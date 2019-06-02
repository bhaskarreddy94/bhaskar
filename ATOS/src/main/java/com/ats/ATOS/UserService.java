package com.ats.ATOS;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
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
public List<User> getUserByFirstName(String FirstName,PageModel pageModel ){
	
PageRequest	pageRequest=new PageRequest(pageModel.getPage(), pageModel.getSize(),Direction.DESC , pageModel.getProperties());
	
	return userRepository.findByFirstName(FirstName, pageRequest);
}
/*public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	UserService service=new UserService();
	System.out.println(service.getuser(json));
}*/
}
