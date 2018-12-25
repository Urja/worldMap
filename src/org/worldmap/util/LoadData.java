package org.worldmap.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.worldmap.model.GameData;


public class LoadData {

	
	public GameData loadGameData() throws JAXBException {
		
			JAXBContext context = JAXBContext.newInstance(GameData.class);
			Unmarshaller un = context.createUnmarshaller();
			GameData gameData = (GameData) un.unmarshal(new File("data.xml"));
			return gameData;
	}

}
