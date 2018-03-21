package com.gaia3d.mago3d.parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.filechooser.FileNameExtensionFilter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;


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
			
			int index = fileName.lastIndexOf(".");
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
		
		List<String> resultJson = new ArrayList<>();
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
			
			resultJson.add(json); 
		}
		return resultJson;
	}
	
	/**
	 * json 파일을 생성하는 메소드 - String
	 * @param outputDirectory
	 * @param StringJson
	 */
	public void fileWriter(String directory, String outputDirectory, List<String> fileNameList) {
		fileNameList = getFileNames(directory);
		
		int count = fileNameList.size();
		for(int i=0; i<count; i++) {
			List<String> resultJson = makeJson(fileNameList);

			try (FileWriter file = new FileWriter(outputDirectory + "test3.json")) {
				file.write(resultJson.toString());		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 스트링 버퍼로 Json 만드는 메소드
	 * @param fileNameList
	 * @return
	 */
	public String makeJsonStringBuffer(List<String> fileNameList) {
		StringBuffer sb = new StringBuffer();
		
		int count = fileNameList.size();
		sb.append("[");
		for(int i=0; i<count; i++) {
			sb.append("{");
			sb.append("\"data_key\" : \"" + fileNameList.get(i) + "\", ");
			sb.append("\"latitude\" : \"36.4457935\", ");
			sb.append("\"longitude\" : \"126.586641\", ");
			sb.append("\"heading\" : \"0\", ");
			sb.append("\"pitch\" : \"0\", ");
			sb.append("\"roll\" : \"0\"");
			if(fileNameList.size()-1 != count) {
				sb.append("}, ");
			}else if(fileNameList.size()-1 == count) {
				sb.append("}");
			}
		}
		sb.append("]");
		String stringbuffer = sb.toString();
		
		return stringbuffer;
	}
	

	/**
	 * json 파일을 생성하는 메소드 - StringBuffer
	 * @param directory
	 * @param outputDirectory
	 * @param fileNameList
	 */
	public void StringBufferFileWriter(String directory, String outputDirectory, List<String> fileNameList) {
		fileNameList = getFileNames(directory);
		
		String resultJson = makeJsonStringBuffer(fileNameList);

		try (FileWriter file = new FileWriter(outputDirectory + "test5.json")) {
			file.write(resultJson);		
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	/**
	 * 상위 디렉토리 폴더명 구하는 메소드
	 * @param directory
	 */
	public void parentDirectory(String directory) {
		
		File fileDirectory = new File(directory);
		File[] fileArray = fileDirectory.listFiles();
		
		String parentFileDirectoryPath = null;
		for(File file : fileArray) {
			parentFileDirectoryPath = file.getParent();
		}
		System.out.println("부모 디렉토리 패스: " + parentFileDirectoryPath);
		
		StringTokenizer st = new StringTokenizer(parentFileDirectoryPath, "\\");
		String parentFileDirectoryName = null;
		while(st.hasMoreTokens()) {
			parentFileDirectoryName = st.nextToken();
		}
		System.out.println("부모 디렉토리명: " + parentFileDirectoryName);
	}
	
	
	public Map<String, Object> makeJsonJackson(String directory) {
		//jackson 라이브러리를 이용해서 json 만들기
		//object -> json
		Map<String, Object> jsonObject = new HashMap<>();
		Map<String, Object> jsonSubObject = null;
		ArrayList<Map<String, Object>> jsonList = new ArrayList<>();
		
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		Data data = new Data();
		try {
			mapper.writeValue(new File("C:\\DATA_Property\\json\\jackson.json"), data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		JsonNode rootNode = mapper.readTree(content);
		
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
	
	
	
	
	
}
