package org.worldmap.service;

import org.worldmap.exception.AtlasDataException;
import org.worldmap.model.Atlas;

/**
 * For Atlas related operations
 *
 * @author uramanan
 */
public interface AtlasService {
	Atlas loadAtlas() throws AtlasDataException;
}
