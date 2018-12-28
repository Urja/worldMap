package org.worldmap.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "user")
public class User {
	
	private String name;
	
	private List<Integer> conqueredCountry;
	private Integer conqueredCityOrder;
	private Integer experiencePoint;
	
	public User() {
		
	}
	
	public User(String name) throws JAXBException {

		this.name = name;
		this.experiencePoint = 0;
		this.conqueredCountry = new ArrayList<>();
		this.conqueredCountry.add(0);
		this.conqueredCityOrder =0;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getConqueredCountry() {
		return conqueredCountry;
	}

	public void setConqueredCountry(List<Integer> conqueredCountry) {
		this.conqueredCountry = conqueredCountry;
	}
	
	public Integer getExperiencePoint() {
		return experiencePoint;
	}
	public void setExperiencePoint(Integer experiencePoint) {
		this.experiencePoint = experiencePoint;
	}

	public Integer getConqueredCityOrder() {
		return conqueredCityOrder;
	}

	public void setConqueredCityOrder(Integer conqueredCityOrder) {
		this.conqueredCityOrder = conqueredCityOrder;
	}

}
