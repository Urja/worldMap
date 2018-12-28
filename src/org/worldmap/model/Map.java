package org.worldmap.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "gameMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class Map {
	
	@XmlElement(name = "country")
	private List<Country> MapInfo;

	public List<Country> getMapInfo() {
		return MapInfo;
	}

	public void setMapInfo(List<Country> mapInfo) {
		MapInfo = mapInfo;
	}

}
