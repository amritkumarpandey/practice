package com.amrit.springboot.demo.demo.services.users;

import org.springframework.stereotype.Component;

import antlr.StringUtils;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */

/**
 * @author amrit
 *
 */
@Component
public class UserComponent {
	private static List<User> usersList = new ArrayList<User>();

	long idCounter = 0;
	{
		usersList.add(new User(++idCounter, "Amrit Pandey", new Date()));
		usersList.add(new User(++idCounter, "Sri Ashok Kumar Pandey", new Date()));
		usersList.add(new User(++idCounter, "Sri Amit Pandey", new Date()));
		usersList.add(new User(++idCounter, "Sri Amar Pandey", new Date()));
		usersList.add(new User(++idCounter, "Sri Anupam Pandey", new Date()));
	}

	/**
	 * 
	 */
	public UserComponent() {
		// TODO Auto-generated constructor stub
	}

	/* @GetMapping("") */
	public List<User> retrieveAllUsers() {
		return usersList;
	}

	public User retrieveUserById(long inputId) {
		User retrievedUser = null;
		/*
		 * usersList.forEach(user->{ if(user !=null && user.id == id) { retrievedUser =
		 * user; //return user; } });
		 */

		for (User user : usersList) {
			if (user != null && user.getId() == inputId) {
				retrievedUser = user;
				// return user;
			}
		}

		return retrievedUser;
	}

	public String createUser(User newUser) {
		String message = null;
		if (newUser == null) {
			message = "User cannot be created, please pass the User Information to be created.";
		} else if (newUser.getId() < idCounter) {
			message = String.format("User cannot be created as user with %l is already present.", newUser.getId());
		} else {
			User addedUser = addUser(newUser);
			if (addedUser != null) {
				usersList.add(newUser);
				message = String.format("New User added with details : %s", addedUser.toString());
			}

		}
		return message;
	}
	
	public User createNewUser(User newUser) {
		
		return addUser(newUser);
	}

	private User addUser(User user) {
		User retrievedUser = retrieveUserById(user.getId());

		if (retrievedUser == null && user != null) {
			if (user.getId() == 0) {
				user.setId(++idCounter);
			}
			retrievedUser = user;
			usersList.add(retrievedUser);
		}
		return retrievedUser;
	}

	public User createUser(String newUser) {
		return addUser(newUser);
	}

	private User addUser(String name) {
		User addedUser = null;
		if (name != null && !name.isEmpty()) {
			addedUser = new User(++idCounter, name, new Date());
		}
		return addedUser;
	}

	/*
	 * private User findUserById(long id) { for (User user : usersList) { if (user
	 * != null && user.id == inputId) { retrievedUser = user; // return user; } } }
	 */

}
