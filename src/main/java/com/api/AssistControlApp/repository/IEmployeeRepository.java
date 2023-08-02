package com.api.AssistControlApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.AssistControlApp.models.EmployeeModel;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeModel, Long>{
	
}
