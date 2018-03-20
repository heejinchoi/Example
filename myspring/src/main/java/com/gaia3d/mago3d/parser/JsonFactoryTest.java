package com.gaia3d.mago3d.parser;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class JsonFactoryTest {

	@Test
	public void 디렉토리_매개변수_테스트() {
		JsonFactory jsonFactory = new JsonFactory();
		
		String directory = "C:\\DATA_Property\\ifc";
		List<String> fileNameList = jsonFactory.getFileNames(directory);
		
		assertEquals("F4D_KSJ_100", fileNameList.get(0));
	}
	
	@Test
	public void 문자열_Json_만들기() {
		JsonFactory jsonFactory = new JsonFactory();
		
		String directory = "C:\\DATA_Property\\ifc";
		List<String> fileNameList = jsonFactory.getFileNames(directory);
		
		List<String> StringJson = jsonFactory.makeJson(fileNameList);		
		
		System.out.println("ifc 파일은 " + StringJson.size() + "개 입니다.");
		if(!StringJson.isEmpty()) {
			System.out.println(StringJson);
		}
	}
	
	@Test
	public void Json_파일_생성() {
		JsonFactory jsonFactory = new JsonFactory();
		
		String outputDirectory = "C:\\DATA_Property\\json\\";
		
		String directory = "C:\\DATA_Property\\ifc";
		List<String> fileNameList = jsonFactory.getFileNames(directory);
		
		List<String> StringJson = jsonFactory.makeJson(fileNameList);
		
		if(!StringJson.isEmpty()) {
			System.out.println(StringJson);
		}
		
		jsonFactory.fileWriter(outputDirectory, StringJson);
		
	}
}
