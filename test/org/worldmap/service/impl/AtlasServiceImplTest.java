package org.worldmap.service.impl;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.worldmap.exception.AtlasDataException;
import org.worldmap.service.AtlasService;
import org.worldmap.service.impl.AtlasServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AtlasServiceImplTest {
	AtlasService atlasService = new AtlasServiceImpl();
	@Test
	public void testLoadAtlas(){
		try {
			assert(atlasService.loadAtlas()!=null);
		} catch (AtlasDataException e) {
			assertFalse(true);
		}
	}
}
