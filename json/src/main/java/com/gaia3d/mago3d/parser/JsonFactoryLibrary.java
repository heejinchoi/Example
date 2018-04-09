package com.gaia3d.mago3d.parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;

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
	
	
	public void makeJsonJackson(String directory) throws JsonParseException, JsonMappingException, IOException {
		//jackson 라이브러리를 이용해서 json 만들기
		//json 파일을 읽는다. - Data에 세팅을 해주고 DataList에 담아주는게 되나?
		//json 파일로 저장한다.
		DataList dataList = getDataList(directory);
		System.out.println("@@@jsonString : " + dataList);

		ObjectMapper mapper = new ObjectMapper();
		
/*		try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("result.json"), data);

            
//		List<Data> data = mapper.readValue(jsonString, new TypeReference<List<Data>>(){});
//		System.out.println("Data list size :-" + data.size());

		
		} catch (Exception e) {
            e.printStackTrace();
        }*/

		
		
//		mapper.enable(SerializationFeature.INDENT_OUTPUT);
//		jsonString = mapper.writeValueAsString(data);
//		System.out.println("DATA2 : " + data);
		
		
		
	}


	private DataList getDataList(String directory) {
//		JsonFactory jsonFactory = new JsonFactory();
//		List<String> fileNameList = jsonFactory.getFileNames(directory);
//		String jsonString = jsonFactory.makeJsonStringBuffer(fileNameList);
//		for(File file : fileNameList) {
//			
//		}
		
		Data data = new Data();
		DataList dataList = new DataList();
//		List<String> list = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		
		File fileDirectory = new File(directory);
		if(fileDirectory.exists()) {
			
			File[] fileList = fileDirectory.listFiles();
			for(File file : fileList) {
				String fileName = file.getName();
				
				String dataKeyName = fileName.substring(0, fileName.lastIndexOf("."));
				data.setData_key(dataKeyName);
				data.setLatitue("36.4457935");
				data.setLongitude("126.586641");
				data.setHeading("1");
				data.setPitch("2");
				data.setRoll("3");
				
				//data에서 하나씩 꺼내서 리스트를 넘겨줘야 함
//				String dataKey = data.getData_key();
//				String latitude = data.getLatitue();
//				String longitude = data.getLongitude();
//				String heading = data.getHeading();
//				String pitch = data.getPitch();
//				String roll = data.getRoll();
				
				
				try {
					mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\DATA_Property\\json\\aaaa.json"), data);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		else {
			System.out.println("해당 경로에 파일이 없습니다.");
		}
		return dataList;
	}


	


}
