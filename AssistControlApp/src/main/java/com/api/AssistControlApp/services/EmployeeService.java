package com.api.AssistControlApp.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.AssistControlApp.models.EmployeeModel;
import com.api.AssistControlApp.repository.IEmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	IEmployeeRepository employeeRepo;
	
	public ArrayList<EmployeeModel> getEmployees(){
		return (ArrayList<EmployeeModel>) employeeRepo.findAll();
	}
	
	public EmployeeModel saveEmployee (EmployeeModel employee) {
		return employeeRepo.save(employee);
		
	}
	
	public Optional<EmployeeModel> getById(Long id){
		return employeeRepo.findById(id);
	}
	
	public EmployeeModel updateById(EmployeeModel request, Long id){
		EmployeeModel employee = employeeRepo.findById(id).get();
		employee.setName(request.getName());
		employee.setLastName(request.getLastName());
		employee.setPosition(request.getPosition());
		employee.setContract(request.getContract());
		employeeRepo.save(employee);
		return employee;
	}
	
	public Boolean deleteById(Long id){
		try {
			employeeRepo.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
}
