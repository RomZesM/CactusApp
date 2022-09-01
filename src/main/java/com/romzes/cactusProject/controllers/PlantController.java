package com.romzes.cactusProject.controllers;

import com.romzes.cactusProject.models.Plant;
import com.romzes.cactusProject.servicies.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value="/plants")
public class PlantController {
	
	PlantService plantService;
	
	@Autowired
	public PlantController(PlantService plantService){
		this.plantService = plantService;
	}
	
	@GetMapping("/index") //show all plants
	public String index(Model model){
		model.addAttribute("plantsList", plantService.getPlantsList());
		return "index";
	}
	
	@GetMapping("/{id}") //show plant by index
	public String showById(@PathVariable("id") int id, Model model){
		model.addAttribute("plant", plantService.getPlantById(id));
		return "plantInfo";
	}
	
	@GetMapping("/new") //put emple Plant.object into the model and return form for creating new plant
	public String getRequestForNewPlant(@ModelAttribute("plant") Plant plant){
		
		return "newPlantForm";
	}
	
	@PostMapping()
	public String createNewPlant(@ModelAttribute("plant") Plant plant){
		
		System.out.println(plant);
		plantService.save(plant);
		return "redirect:/plants/index";
	}
	
	@GetMapping("/{id}/edit") //open edit page and fill the form
	public String editForm(@PathVariable("id") int id, Model model){
		Plant plant = plantService.getPlantById(id);
		model.addAttribute("plant", plant);
		return "edit";
	}
	@PatchMapping("/{id}")
	public String updatePlant(@PathVariable("id") int id, @ModelAttribute("plant") Plant plant){
		plantService.update(id, plant);
		
		return "redirect:/plants/index";
	}
	
}
