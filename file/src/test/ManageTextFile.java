package test;

import static org.junit.jupiter.api.Assertions.*;

import static java.io.File.separator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class ManageTextFile {
	
	int numberCount = 10;
	
	@Test
	public void test() {
		String fullPath = separator + "Users" + separator + "HJCHOI" + separator + "Desktop" 
						+ separator + "TEST" + separator + "file" + "test.txt";
		writerFile(fullPath, numberCount);
		readFile(fullPath);
		readFileWithScanner(fullPath);
	}
	
	//텍스트 파일 쓰기
	private void writerFile(String fileName , int numberCount) {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(fileName, true);
			bufferedWriter = new BufferedWriter(fileWriter);
			for(int loop=0; loop<=numberCount; loop++) {
				bufferedWriter.write(Integer.toString(loop));
				bufferedWriter.newLine();
			}
			System.out.println("Write success!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			if(fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}
	
	//텍스트 파일 읽기
	private void readFile(String fileName) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			String data;
			while((data = bufferedReader.readLine()) != null) {
				System.out.println(data);
			}
			System.out.println("Read Success!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			if(fileReader != null) {
				try {
					fileReader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//파일 스캔
	private void readFileWithScanner(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			System.out.println("Scanner Read success!");
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
