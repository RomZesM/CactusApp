package com.romzes.cactusProject.servicies;


import com.romzes.cactusProject.models.Plant;
import com.romzes.cactusProject.repositories.PlantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
	@Transactional
	public void save(Plant plant){
		plantRepository.save(plant);
	}
	
	@Transactional
	public void update(int id, Plant changedPlant) {
		changedPlant.setId(id); //cnahged plant from thymeleaf without id
		plantRepository.save(changedPlant); //if hibernate find same id, it would update it
	}
	
	@Transactional
	public void delete(int id){
		plantRepository.deleteById(id);
	}
}
