package com.gaia3d.mago3d.parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author HJCHOI
 *
 */
public class JsonFactory {
	
	
	/**
	 * 특정 디렉토리의 파일명을 읽어서 리스트 형태로 리턴하는 메소드
	 * @param directory
	 * @return
	 */
	public List<String> getFileNames(String directory) {
		// 특정 디렉토리를 매개변수로 받아온다.
		// 디렉토리가 올바른지 체크한다.
		// 해당 파일명을 리스트 형태로 저장한다.
		
		List<String> fileNameList = new ArrayList<>();

		File fileDirectory = new File(directory);
		if(!fileDirectory.exists()) return fileNameList;
		
		File[] fileArray = fileDirectory.listFiles();
		for(File file : fileArray) {
			String fileName = file.getName();
			
			if(fileName.isEmpty()) continue;
			
			int index = fileName.indexOf(".");
			fileName = fileName.substring(0, index);
			fileNameList.add(fileName);
		}
		
		return fileNameList;
	}
	
	/**
	 * 문자열로 json을 만드는 메소드
	 * @param fileNameList
	 * @return
	 */
	public List<String> makeJson(List<String> fileNameList) {
		// 매개변수로 받은 리스트의 갯수만큼 반복문을 실행한다.
		// 라이브러리를 사용하지 않고 String 으로 json을 만들어 본다.
		// data_key 값을 fileNameList의 값으로 지정한다.
		
		List<String> StringJson = new ArrayList<>();
		
		for(int i=0; i<fileNameList.size(); i++) {
			
			String json = "";
			json = json + "{";
			json = json + "\"data_key\" : \"" + fileNameList.get(i) + "\", ";
			json = json + "\"latitude\" : \"36.4457935\", ";
			json = json + "\"longitude\" : \"126.586641\", ";
			json = json + "\"heading\" : \"0\", ";
			json = json + "\"pitch\" : \"0\", ";
			json = json + "\"roll\" : \"0\"";
			json = json + "}";
			
			StringJson.add(json);
		}
		return StringJson;
	}
	
	/**
	 * json 파일을 생성하는 메소드
	 * @param outputDirectory
	 * @param StringJson
	 */
	public void fileWriter(String outputDirectory, List<String> StringJson) {
		try (
				FileWriter file = new FileWriter(outputDirectory + "test1.json");
			) {
			file.write(StringJson.toString());
			file.flush();
			file.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	
	
	
	
	
	
}
