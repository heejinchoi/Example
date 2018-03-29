package com.gaia3d.mago3d.parser;

import java.io.IOException;

import org.junit.Test;



public class JsonFactoryLibraryTest {
/*	
	@Test
	public void jsonObject() {
		JsonFactoryLibrary jsonFactoryLibrary = new JsonFactoryLibrary();
		jsonFactoryLibrary.jsonObject();
	}
	
	@Test
	public void jsonParsr() throws ParseException {
		JsonFactoryLibrary jsonFactoryLibrary = new JsonFactoryLibrary();
		JSONObject jsonData = jsonFactoryLibrary.jsonObject();
		jsonFactoryLibrary.jsonParsr(jsonData);
	}
*/
	@Test
	public void jackson() throws IOException {
		JsonFactoryLibrary jsonFactoryLibrary = new JsonFactoryLibrary();
		jsonFactoryLibrary.makeJsonJackson("C:\\DATA_Property\\ifc");

		
		
		
	}
	


}
