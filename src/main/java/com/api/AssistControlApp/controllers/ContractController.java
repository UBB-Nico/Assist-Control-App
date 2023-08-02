package com.api.AssistControlApp.controllers;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.AssistControlApp.models.ContractModel;
import com.api.AssistControlApp.services.ContractService;

@RestController
@RequestMapping("/contract")
@CrossOrigin("*")
public class ContractController {
	
	@Autowired
	private ContractService contracService;
	
	@GetMapping("/all")
	public ArrayList<ContractModel> getAllContracts(){
		return this.contracService.getContracts();
	}
	 
	@PostMapping("/save")
	public ContractModel saveContract(@RequestBody ContractModel contract) {
		return this.contracService.saveEmployee(contract);
	}
	 
	@GetMapping(path = "/{id}")
	public Optional<ContractModel> getContractById(@PathVariable Long id){
		return this.contracService.getById(id);
		 
	}
	 
	//Podria usar responseEntity pero no recuerdo la implementacion
	 @PutMapping(path = "/{id}")
	public ContractModel updateContract(@RequestBody ContractModel contract, @PathVariable Long id) {
		return this.contracService.updateById(contract, id);
	}
	 
	//Podria usar responseEntity pero no recuerdo la implementacion
	@DeleteMapping(path = "/{id}")
	public String deleteContractById(@PathVariable Long id) {
		boolean response = this.contracService.deleteById(id);
		if(response) {
			return ("Contract with id: " + id + "was succesfully deleted");
		}else {
			return ("Cannot delete contract with id: " + id);
		}
	}
}
