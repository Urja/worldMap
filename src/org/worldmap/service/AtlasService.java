package org.worldmap.service;

import org.worldmap.exception.AtlasDataException;
import org.worldmap.model.Atlas;

/**
 * 
 * @author uramanan
 * For Atlas related operations
 */
public interface AtlasService {
	Atlas loadAtlas() throws AtlasDataException;
}
