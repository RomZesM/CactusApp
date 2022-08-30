package com.romzes.cactusProject.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Plants")
public class Plant {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "wateringperiod")
	private int wateringPeriod;
	@Column(name = "nextwateringdate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date nextWateringDate;
	
	public Plant() {
	
	}
	
	public Plant(String name, int wateringPeriod, Date wateringDate) {
		this.name = name;
		this.wateringPeriod = wateringPeriod;
		this.nextWateringDate = wateringDate;
	}
	
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWateringPeriod() {
		return wateringPeriod;
	}
	
	public void setWateringPeriod(int wateringPeriod) {
		this.wateringPeriod = wateringPeriod;
	}
	
	public Date getNextWateringDate() {
		return nextWateringDate;
	}
	
	public void setNextWateringDate(Date nextWateringDate) {
		this.nextWateringDate = nextWateringDate;
	}
	
	@Override
	public String toString() {
		return "Plant{" +
				"id=" + id +
				", name='" + name + '\'' +
				", wateringPeriod=" + wateringPeriod +
				", nextWateringDate=" + nextWateringDate +
				'}';
	}
}
