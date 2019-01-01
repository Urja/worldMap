package org.worldmap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 
 * @author uramanan
 * Use to pass atlas data through out the application.
 * Do not change order of country or city . If new city or country needs to be added than increase the order of the value
 */

@XmlRootElement(name = "gameMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class Atlas {

	@XmlElement(name = "country")
	private List<Country> countries;

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}
