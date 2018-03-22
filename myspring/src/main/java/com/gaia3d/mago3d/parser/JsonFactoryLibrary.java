package com.gaia3d.mago3d.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author HJCHOI
 *
 */
public class JsonFactoryLibrary {
	
	/**
	 * 특정 디렉토리의 파일명을 읽어서 리스트 형태로 리턴하는 메소드
	 * @param directory
	 * @return
	 */
	public List<String> getFileNames(String directory) {
		List<String> fileNameList = new ArrayList<>();

		File fileDirectory = new File(directory);
		if(!fileDirectory.exists()) return fileNameList;
		
		File[] fileArray = fileDirectory.listFiles();
		for(File file : fileArray) {
			String fileName = file.getName();
			
			if(fileName.isEmpty()) continue;
			
			int index = fileName.lastIndexOf(".");
			fileName = fileName.substring(0, index);
			fileNameList.add(fileName);
		}
		return fileNameList;
	}
	
	
	/*public JSONObject jsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "최희진");
		
		JSONObject school = new JSONObject();
		school.put("subject1", "math");
		school.put("subject2", "science");
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(school);
		jsonObject.put("school", jsonArray);

		System.out.println("jsonObject: " + jsonObject.toString());
		
		return jsonObject;
	}*/
	
/*	public void jsonParsr(JSONObject jsonObject) throws ParseException {
		JSONParser jsonParser = new JSONParser();
//		jsonObject = (JSONObject) jsonParser.parse(jsonObject.toJSONString());
		
		String jsonStrVal = (String) jsonObject.get("name");
		JSONArray jsonArrVal = (JSONArray) jsonObject.get("school");
		for(int i=0; i<jsonArrVal.size(); i++) {
			String subject = (String) jsonObject.get(i);
			System.out.println("[jsonParser] subject=" + subject);
		}
		System.out.println("[jsonParser] name=" + jsonStrVal);
		
	}*/
	
	public void makeJsonJackson(String directory) {
		//jackson 라이브러리를 이용해서 json 만들기
		//json 파일을 읽는다.
		//포멧에 맞게 저장한다.

		
		
		
	}

}
