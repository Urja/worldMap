package org.worldmap.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "gameMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameData {
	
	@XmlElement(name = "country")
	private List<Country> gameData;

	public List<Country> getGameData() {
		return gameData;
	}

	public void setGameData(List<Country> gameData) {
		this.gameData = gameData;
	}

}
