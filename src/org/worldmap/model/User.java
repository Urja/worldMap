package org.worldmap.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.worldmap.util.LoadData;

@XmlRootElement(name = "user")
public class User {
	
	private String name;
	
	private List<String> conqueredCountry;
	private String currentBattleCountry;
	private String lastConqueredCity;
	private String currentCity;
	private Integer experiencePoint;
	private boolean wonWorldMap;
	
	public User() {
		
	}
	
	public User(String name) throws JAXBException {
		LoadData loadData =new LoadData();
		Optional<Country> country = loadData.loadGameData().getGameData().stream().findFirst();
		this.name = name;
		this.experiencePoint = 0;
		this.conqueredCountry = new ArrayList<>();
		this.conqueredCountry.add("none"); //TODO : where to remove
		this.currentBattleCountry = country.get().getName();
		this.currentCity = country.get().getCities().get(0).getName();
		this.lastConqueredCity ="none";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<String> getConqueredCountry() {
		return conqueredCountry;
	}

	public void setConqueredCountry(List<String> conqueredCountry) {
		this.conqueredCountry = conqueredCountry;
	}

	public String getCurrentBattleCountry() {
		return currentBattleCountry;
	}

	public void setCurrentBattleCountry(String currentBattleCountry) {
		this.currentBattleCountry = currentBattleCountry;
	}

	public Integer getExperiencePoint() {
		return experiencePoint;
	}
	public void setExperiencePoint(Integer experiencePoint) {
		this.experiencePoint = experiencePoint;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getLastConqueredCity() {
		return lastConqueredCity;
	}

	public void setLastConqueredCity(String lastConqueredCity) {
		this.lastConqueredCity = lastConqueredCity;
	}

	public boolean isWonWorldMap() {
		return wonWorldMap;
	}

	public void setWonWorldMap(boolean wonWorldMap) {
		this.wonWorldMap = wonWorldMap;
	}

}
