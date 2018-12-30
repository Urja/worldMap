package org.worldmap.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city")
public class City implements Comparable<City> {
	
	private Integer order;
	private String name;
	private String word;
	private String translation;
	private String successMessage;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getTranslation() {
		return translation;
	}
	
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	
	public String getSuccessMessage() {
		return successMessage;
	}
	
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	
	public Integer getOrder() {
		return order;
	}
	
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	/**
	 * Note: Not overriding equals method
	 */
	@Override
	public int compareTo(City city) {
		return  Integer.compare(this.order, city.order);
	}
}
