package com.gaia3d.mago3d.parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


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
	public List<String> makeJsonString(List<String> fileNameList) {
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
	 * json 파일을 생성하는 메소드 - makeJsonString()로 얻은 리스트값을  매개변수로 전달
	 * @param outputDirectory
	 * @param StringJson
	 */
	public void stringFileWriter(String directory, String outputDirectory, List<String> fileNameList) {
		fileNameList = getFileNames(directory);
		
		int count = fileNameList.size();
		for(int i=0; i<count; i++) {
			List<String> resultJson = makeJsonString(fileNameList);

			try (FileWriter file = new FileWriter(outputDirectory)) {
				file.write(resultJson.toString());		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 매개변수로 포맷(List형식)만 받고 값을 넣어 json을 만드는 방법 -for문으로 값을 넣어주는 위치에 따라 속도차이 발생하기 때문에
	 * @param outputDirectory
	 * @param fileNameList
	 */
	public void StringWriteJsonFile(String outputDirectory, List<String> fileNameList) {
		
		try(FileWriter file = new FileWriter(outputDirectory)) {
			
			for(String fileName : fileNameList) {
				String json = ""
						+ "{"
						+ "\"data_key\" : \"" + fileName + "\", "
						+ "\"latitude\" : \"36.4457935\", "
						+ "\"longitude\" : \"126.586641\", "
						+ "\"heading\" : \"0\", "
						+ "\"pitch\" : \"0\", "
						+ "\"roll\" : \"0\""		
						+ "}";
				if(fileName != fileNameList.get(fileNameList.size()-1)) {
					json += ",";
				} 
				file.write(json);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 스트링 버퍼로 Json 만드는 메소드
	 * @param fileNameList
	 * @return
	 */
	public String makeJsonStringBuffer(List<String> fileNameList) {
		int count = fileNameList.size();
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=0; i<count; i++) {
			sb.append("{");
			sb.append("\"data_key\" : \"" + fileNameList.get(i) + "\", ");
			sb.append("\"latitude\" : \"36.4457935\", ");
			sb.append("\"longitude\" : \"126.586641\", ");
			sb.append("\"heading\" : \"0\", ");
			sb.append("\"pitch\" : \"0\", ");
			sb.append("\"roll\" : \"0\"");
			if(i != count -1) {
				sb.append("}, ");
			}else if(i == count -1) {
				sb.append("}");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	/**
	 * json 파일을 생성하는 메소드 - makeJsonStringBuffer()로 얻은 스트링값을 매개변수로 전달
	 * @param directory
	 * @param outputDirectory
	 * @param fileNameList
	 */
	public void StringBufferFileWriter(String directory, String outputDirectory, List<String> fileNameList) {
		fileNameList = getFileNames(directory);
		
		String resultJson = makeJsonStringBuffer(fileNameList);

		try (FileWriter file = new FileWriter(outputDirectory)) {
			file.write(resultJson);		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 매개변수로 포맷(List형식)만 받고 값을 넣어 json을 만드는 방법 -for문으로 값을 넣어주는 위치에 따라 속도차이 발생하기 때문에
	 */
	public void StringBufferWriteJsonFile(String outputDirectory, List<String> fileNameList) {
		//fileNameList를 받아와서 데이터를 넣어서 json으로 만들어야 함.
		try(FileWriter file = new FileWriter(outputDirectory)){
			int count = fileNameList.size();
			for(String fileName : fileNameList) {
				StringBuffer sb = new StringBuffer();
				sb.append("{");
				sb.append("\"data_key\" : \"" + fileName + "\", ");
				sb.append("\"latitude\" : \"36.4457935\", ");
				sb.append("\"longitude\" : \"126.586641\", ");
				sb.append("\"heading\" : \"0\", ");
				sb.append("\"pitch\" : \"0\", ");
				sb.append("\"roll\" : \"0\"");
				if(fileName != fileNameList.get(count-1)) {
					sb.append("}, ");
				}else {
					sb.append("}");
				}
				file.write(sb.toString());
			}
		}catch(Exception e) {
			
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
	
	
	

	
	
	
	
	
	
	
	
}
