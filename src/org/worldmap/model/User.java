package org.worldmap.model;

import org.worldmap.util.WorldMapConstant;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "user")
public class User {
	
	private String name;
	private Integer conqueredCountryOrder;
	private Integer conqueredCityOrder;
	private Integer experiencePoint;
	
	public User() {
		
	}
	
	public User(String name){

		this.name = name;
		this.experiencePoint = 0;
		this.conqueredCountryOrder = 0;
		this.conqueredCityOrder =0;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getConqueredCountryOrder() {
		return conqueredCountryOrder;
	}

	public void setConqueredCountryOrder(Integer conqueredCountryOrder) {
		this.conqueredCountryOrder = conqueredCountryOrder;
	}

	public Integer getConqueredCityOrder() {
		return conqueredCityOrder;
	}

	public void setConqueredCityOrder(Integer conqueredCityOrder) {
		this.conqueredCityOrder = conqueredCityOrder;
	}

	public Integer getExperiencePoint() {
		return experiencePoint;
	}

	public void setExperiencePoint(Integer experiencePoint) {
		this.experiencePoint = experiencePoint;
	}
	
	public void gainExperience() {
		this.experiencePoint = experiencePoint+ WorldMapConstant.EXPERIENCE_INCREASED_BY;
	}
}
