package com.gaia3d.mago3d.parser;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JsonFactoryTest {
	
	@Before
	public void 모든메소드에서실행() {
		//System.out.println("실행되었다.");
	}
	
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
			System.out.println("스트링 리스트 Json: " + StringJson);
		}
	}
	
	@Test
	public void Json_파일_생성_String() {
		JsonFactory jsonFactory = new JsonFactory();
		
		String outputDirectory = "C:\\DATA_Property\\json\\";
		
		String directory = "C:\\DATA_Property\\ifc";
		List<String> fileNameList = jsonFactory.getFileNames(directory);
		
		jsonFactory.fileWriter(directory, outputDirectory, fileNameList);
	}
	
	@Test
	public void 스프링버퍼() {
		JsonFactory jsonFactory = new JsonFactory();
		
		String directory = "C:\\DATA_Property\\ifc";
		List<String> fileNameList = jsonFactory.getFileNames(directory);
		
		String stringBuffer = jsonFactory.makeJsonStringBuffer(fileNameList);
		System.out.println("스트링 버퍼 Json: " + stringBuffer);
		
		int count = fileNameList.size();
		assertFalse(count == fileNameList.size() -1);
		
	}
	
	@Test
	public void Json_파일_생성_StringBuffer() {
		JsonFactory jsonFactory = new JsonFactory();
		
		String outputDirectory = "C:\\DATA_Property\\json\\";
		
		String directory = "C:\\DATA_Property\\ifc";
		List<String> fileNameList = jsonFactory.getFileNames(directory);
		
		jsonFactory.StringBufferFileWriter(directory, outputDirectory, fileNameList);
		System.out.println("StringBuffer로 만든 json 생성 완료");
	}
	
	@Test
	public void 상위디렉토리() {
		JsonFactory jsonFactory = new JsonFactory();
		
		String directory = "C:\\DATA_Property\\ifc_cultural_assets";
		jsonFactory.parentDirectory(directory);
	}
	
	@Test
	public void toStringTest() {
		JsonFactory jsonFactory = new JsonFactory();
		System.out.println("JsonFactory : " + jsonFactory); //객체가 가지고 있는 주소 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
