package com.gaia3d.mago3d.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.gaia3d.mago3d.parser.JsonFactory;


/**
 * @author HJCHOI
 *
 */
public class Stream {
		
	/**
	 * 바이트기반 스트림 (InputStream/OutputStram)
	 * @param readDirectory
	 * @param writeDirectory
	 */
	public void ByteStream(String readDirectory, String writeDirectory) {

		try (
			InputStream inputStream = new FileInputStream(readDirectory);
			OutputStream outputStream = new FileOutputStream(writeDirectory);
			){
			
			int readByte;
			while((readByte = inputStream.read()) != -1) {
				outputStream.write(readByte);
			}
			inputStream.close();
			outputStream.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 문자기반 스트림(Reader/Writer)
	 * @param readDirectory
	 * @param writeDirectory
	 */
	public void characterStream(String readDirectory, String writeDirectory) {
		try(
			Reader reader = new FileReader(readDirectory);
			Writer writer = new FileWriter(writeDirectory);
			){
			
			int readData;
			char charData;
			while((readData = reader.read()) != -1) {
				charData = (char) readData;
				writer.write(charData);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 보조 스트림(Buffered)
	 * @param readDirectory
	 * @param writeDirectory
	 */
	public void BufferedStream(String readDirectory, String writeDirectory) {
		try (
			FileInputStream fileInputStream = new FileInputStream(readDirectory);
			FileOutputStream fileOutputStream = new FileOutputStream(writeDirectory);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			){
			
			int readData;
			char charData;
			while((readData=bufferedInputStream.read()) != -1) {
				charData = (char) readData;
				bufferedOutputStream.write(charData);
			}
			int bufferLength = bufferedInputStream.read();
			System.out.println("bufferedInputStream: " +  bufferedInputStream.read());
			System.out.println("bufferLength: " + bufferLength);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 스트림으로 json생성
	 * @param directory
	 * @param writeDirectory
	 */
	public void createJsonStream(String directory, String writeDirectory) {
		//디렉토리 파일명을 읽어들인다.
		//BufferedStream을 이용해서 json 형태로 만든다.
		//json 파일을 생성한다.
		List<String> fileNameList = new ArrayList<>();
		
		File fileDirectory = new File(directory);
		if(fileDirectory.exists()) {
			
			File[] fileList = fileDirectory.listFiles();
			for(File file : fileList) {
				String fileName = file.getName();
				
				String dataKeyName = fileName.substring(0, fileName.lastIndexOf("."));
				System.out.println("데이터명: " + dataKeyName);
				
				try(FileWriter outputFile = new FileWriter(writeDirectory)) {
					
					String json = "{"
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
					outputFile.write(json);
				
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		else {
			System.out.println("해당 경로에 파일이 없습니다.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
