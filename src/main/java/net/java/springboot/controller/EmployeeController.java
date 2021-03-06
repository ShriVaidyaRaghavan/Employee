package net.java.springboot.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.entity.Employee;
import net.java.springboot.exception.ResourceNotFoundException;
import net.java.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

	@Autowired
	private EmployeeRepository userRepository;

	// get all users
	@GetMapping
	public List<Employee> getAllUsers() {
		return this.userRepository.findAll();
	}
	
	@GetMapping("/desc")
	public List<Employee> sort(String firstname) {
		List<Employee> l=(List<Employee>) userRepository.findAll();
		Collections.sort(l);
		return l;
	}

	// get user by id
	@GetMapping("/{id}")
	public Employee getUserById(@PathVariable (value = "id") long Id) {
		return this.userRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with Id :" + Id));
	}
	

	// create user
	@PostMapping
	public Employee createUser(@RequestBody Employee user) {
		return this.userRepository.save(user);
	}
	
	// update user
	@PutMapping("/{id}")
	public Employee updateUser(@RequestBody Employee user, @PathVariable ("id") long userId) {
		 Employee existingUser = this.userRepository.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		 existingUser.setName(user.getName());
		 existingUser.setSalary(user.getSalary());
		 existingUser.setDesignation(user.getDesignation());
		 return this.userRepository.save(existingUser);
	}
	
	@PutMapping("/update/{id}/{Salary}")
	public Employee updateUser(@RequestBody Employee employee,@PathVariable long id, @PathVariable int Salary) {
		Employee existingUser = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
			 existingUser.setName(employee.getName());
			 existingUser.setSalary(employee.getSalary());
			 existingUser.setDesignation(employee.getDesignation());
			 return this.userRepository.save(existingUser);
	}
	
	
	// delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteUser(@PathVariable ("id") long userId){
		 Employee existingUser = this.userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		 this.userRepository.delete(existingUser);
		 return ResponseEntity.ok().build();
	}

}


