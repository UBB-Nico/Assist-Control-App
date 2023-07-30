package com.api.AssistControlApp.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.AssistControlApp.models.ContractModel;
import com.api.AssistControlApp.repository.IContractRepository;

@Service
public class ContractService {
	@Autowired
	IContractRepository contractRepo;
	
	public ArrayList<ContractModel> getContracts(){
		return (ArrayList<ContractModel>) contractRepo.findAll();
	}
	
	public ContractModel saveEmployee (ContractModel employee) {
		return contractRepo.save(employee);
		
	}
	
	public Optional<ContractModel> getById(Long id){
		return contractRepo.findById(id);
	}
	
	public ContractModel updateById(ContractModel request, Long id){
		ContractModel contract = contractRepo.findById(id).get();
		contract.setContract_type(request.getContract_type());
		contractRepo.save(contract);
		return contract;
	}
	
	public Boolean deleteById(Long id){
		try {
			contractRepo.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

}
