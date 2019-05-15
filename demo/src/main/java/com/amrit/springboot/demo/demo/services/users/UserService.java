/**
 * 
 */
package com.amrit.springboot.demo.demo.services.users;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.core.ControllerEntityLinks;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amrit.springboot.demo.exceptions.ApplicationUserNotFoundException;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.ResponseEntity;

//import org.springframework.hateoas;
/**
 * @author amrit
 *
 */
@RestController
public class UserService {
	@Autowired
	private UserComponent userComponent;

	/**
	 * 
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userComponent.retrieveAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public Resource<User> retrieveUserById(@Valid @PathVariable String id){
		User retrievedUser = userComponent.retrieveUserById(new Long(id).longValue());
		
		if(retrievedUser == null)
			throw new ApplicationUserNotFoundException("user-id:"+id);
		
		//implement HATEOAS "Hypermedia As The Engine Of Application State"
		
		Resource<User> resource = new Resource<User>(retrievedUser);
		
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-user"));
		return resource;
	}
	
	@PostMapping("/user")
	public ResponseEntity createUser(@Valid @RequestBody User newUser){
		User createdUser =  userComponent.createNewUser(newUser);
		long userId = -1;
		URI location = null;
		if(createdUser != null) {
			userId = createdUser.getId();
		}
		else {
			userId = newUser.getId();
		}
		
		location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(userId).toUri();
		
		if(createdUser!=null) {
			return ResponseEntity.created(location).build();
		}
		else {
			return ResponseEntity.badRequest().build();
		}
		//Uri location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(uriVariableValues)
	}

}
