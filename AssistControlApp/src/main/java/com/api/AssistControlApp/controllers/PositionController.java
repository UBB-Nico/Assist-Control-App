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
import com.api.AssistControlApp.models.PositionModel;
import com.api.AssistControlApp.services.PositionService;

@RestController
@RequestMapping("/positions")
@CrossOrigin(origins = "*")
public class PositionController {
	
	@Autowired
	private PositionService positionService;
	
	@GetMapping("/all")
	public ArrayList<PositionModel> getAllPositions(){
		return this.positionService.getPositions();
	}

	@PostMapping("/save")
	public PositionModel savePosition(@RequestBody PositionModel employee) {
		return this.positionService.savePosition(employee);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<PositionModel> getPositionById(@PathVariable Long id){
		return this.positionService.getById(id);
	}

	@PutMapping(path = "/{id}")
	public PositionModel updatePositionById(@RequestBody PositionModel request, @PathVariable Long id) {
		return this.positionService.updateById(request, id);
	}

	@DeleteMapping(path = "/delete/{id}")
	public String deletePositionById(@PathVariable Long id){
		this.positionService.deleteById(id);
		return "Deleted";
	}

}
