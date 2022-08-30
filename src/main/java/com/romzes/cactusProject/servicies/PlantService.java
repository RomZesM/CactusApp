package com.romzes.cactusProject.servicies;


import com.romzes.cactusProject.models.Plant;
import com.romzes.cactusProject.repositories.PlantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlantService {
	
	private final PlantRepository plantRepository;
	
	@Autowired
	public PlantService(PlantRepository plantRepository){
		this.plantRepository = plantRepository;
	}
	
	public List<Plant> getPlantsList(){
		ArrayList<Plant> plantList = new ArrayList<>();
		plantList = (ArrayList<Plant>) plantRepository.findAll();
		return plantList;
	}
	
	public Plant getPlantById(int id){
		Optional optional = plantRepository.findById(id);
		Plant plant = (Plant) optional.orElse(null);
		return plant;
	}
}
