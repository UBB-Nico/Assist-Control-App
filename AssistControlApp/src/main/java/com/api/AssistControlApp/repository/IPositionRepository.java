package com.api.AssistControlApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.AssistControlApp.models.PositionModel;

@Repository
public interface IPositionRepository  extends JpaRepository<PositionModel, Long>{

}
