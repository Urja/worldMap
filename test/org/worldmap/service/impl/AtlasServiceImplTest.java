package org.worldmap.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.worldmap.exception.AtlasDataException;
import org.worldmap.service.AtlasService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class AtlasServiceImplTest {
	private AtlasService atlasService = new AtlasServiceImpl();

	@Test
	public void testLoadAtlas(){
		try {
			assertNotNull(atlasService.loadAtlas());
		} catch (AtlasDataException e) {
			fail();
		}
	}
}
