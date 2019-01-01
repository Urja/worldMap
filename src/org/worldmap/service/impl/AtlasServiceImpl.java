package org.worldmap.service.impl;

import org.worldmap.exception.AtlasDataException;
import org.worldmap.model.Atlas;
import org.worldmap.service.AtlasService;
import org.worldmap.util.WorldMapConstant;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class AtlasServiceImpl implements AtlasService {

	@Override
	public Atlas loadAtlas() throws AtlasDataException {
		try {
			JAXBContext context = JAXBContext.newInstance(Atlas.class);
			Unmarshaller un = context.createUnmarshaller();
			return (Atlas) un.unmarshal(new File(WorldMapConstant.ATLAS_FILE));
		} catch (JAXBException e) {
			throw new AtlasDataException("Error while loading atlas.");
		}
	}
}
