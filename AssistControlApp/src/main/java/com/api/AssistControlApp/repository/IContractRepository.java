package com.api.AssistControlApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.AssistControlApp.models.ContractModel;

@Repository
public interface IContractRepository extends JpaRepository<ContractModel, Long>{

}
