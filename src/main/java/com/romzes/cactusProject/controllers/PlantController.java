package com.romzes.cactusProject.controllers;

import com.romzes.cactusProject.servicies.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/plants")
public class PlantController {
	
	PlantService plantService;
	
	@Autowired
	public PlantController(PlantService plantService){
		this.plantService = plantService;
	}
	
	@GetMapping("/index")
	public String index(Model model){
		model.addAttribute("plantsList", plantService.getPlantsList());
		
		System.out.println(plantService.getPlantsList());
		
		return "index";
	}
	
	@GetMapping("/{id}")
	public String showById(@PathVariable("id") int id, Model model){
		model.addAttribute("plant", plantService.getPlantById(id));
		
		System.out.println(plantService.getPlantById(id));
		return "plantInfo";
	}
}
