package com.mn.spring.boot.hibernate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mn.spring.boot.hibernate.model.Employee;
import com.mn.spring.boot.hibernate.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping(value = "get/{id}")
	@ResponseBody
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
		Optional<Employee> findById = employeeRepository.findById(Long.parseLong(id));
		return new ResponseEntity<Employee>(HttpStatus.ACCEPTED).ok(findById.get());
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public String deleteEmployeeById(@PathVariable String id) {
		employeeRepository.deleteById(Long.parseLong(id));
		return "Deleted Successfully";
	}
	
	@PostMapping(value = "save/{id}")
	@ResponseBody
	public String saveEmployeeById(@PathVariable String id) {
		Employee entity = new Employee();
		entity.setEmailId("manish@gmail.com");
		entity.setFirstName("manish");
		entity.setLastName("nasarpuri");
		entity.setId(new Long(id));
		employeeRepository.save(entity);
		return "Save Successfully";
	}
	
	@GetMapping(value = "get")
	@ResponseBody
	public ResponseEntity<Object> getEmployees() {
		List<Employee> findAll = employeeRepository.findAll();
		return new ResponseEntity(HttpStatus.ACCEPTED).ok(findAll);
	}
}
