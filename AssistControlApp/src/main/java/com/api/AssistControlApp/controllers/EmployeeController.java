package com.api.AssistControlApp.controllers;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.AssistControlApp.models.EmployeeModel;
import com.api.AssistControlApp.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getAll")
	public ArrayList<EmployeeModel> getEmployees(){
		return this.employeeService.getEmployees();
	}

	@PostMapping("/saveEmployee")
	public EmployeeModel saveEmployee(@RequestBody EmployeeModel employee) {
		return this.employeeService.saveEmployee(employee);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<EmployeeModel> getEmployeeById(@PathVariable Long id){
		return this.employeeService.getById(id);
	}

	@PutMapping(path = "/{id}")
	public EmployeeModel updateEmployeeById(@RequestBody EmployeeModel request, @PathVariable Long id) {
		return this.employeeService.updateById(request, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteEmployeeById(@PathVariable Long id){
		boolean response =  this.employeeService.deleteById(id);
		if(response) {
			return "Employee with id: " + id + " was succesfully deleted";
		}else {
			return "Cannot delete employee with id: " + id;
		}
	}
}
