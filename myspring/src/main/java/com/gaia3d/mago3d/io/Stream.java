package com.gaia3d.mago3d.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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

import org.springframework.instrument.classloading.ShadowingClassLoader;


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
	
	
	
	
	
	
	
	
	
	
	
	
}
