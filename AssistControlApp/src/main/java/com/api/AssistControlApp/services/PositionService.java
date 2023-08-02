package com.api.AssistControlApp.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.AssistControlApp.models.PositionModel;
import com.api.AssistControlApp.repository.IPositionRepository;

@Service
public class PositionService {
	
	@Autowired
	IPositionRepository positionRepo;
	
	public ArrayList<PositionModel> getPositions (){
		return (ArrayList<PositionModel>) positionRepo.findAll();
	}
	
	public PositionModel savePosition(PositionModel position){
		return positionRepo.save(position);
	}
	
	public Optional<PositionModel> getById(Long id){
		return positionRepo.findById(id);
	}
	
	public PositionModel updateById(PositionModel request, Long id) {
		PositionModel position =  positionRepo.findById(id).get();
		position.setPosition(request.getPosition());
		return position;
	}
	
	public void deleteById(Long id){
		try {
			positionRepo.deleteById(id);
		} catch (Exception e) {
			
		}
	}

}
