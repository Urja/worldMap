package org.worldmap.service;

import javax.xml.bind.JAXBException;

import org.worldmap.model.GameData;

public interface GameDataService {
	GameData loadGameData() throws JAXBException;
}
