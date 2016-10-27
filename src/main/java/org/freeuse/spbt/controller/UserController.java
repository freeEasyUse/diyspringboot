package org.freeuse.spbt.controller;

import java.util.ArrayList;
import java.util.List;

import org.freeuse.spbt.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/{user}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long user) {
		User userModel = new User();
		userModel.setId(user);
		userModel.setAge(18);
		userModel.setUserName("test");
		return userModel;
	}
	
	@RequestMapping(value = "/list/{user}",method = RequestMethod.GET)
	public List<User> getUserList(@PathVariable Long user) throws Exception{
		List<User> result = new ArrayList<User>();
		if(user==1){
			User userModel = new User();
			userModel.setId(user);
			userModel.setAge(18);
			userModel.setUserName("test");
			result.add(userModel);
		}
		else{
			throw new Exception("has error");
		}
		return result;
	}

}
