package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileFilter;

import org.junit.Test;

public class FileFilterTest implements FileFilter {

	private String pathName = "C:\\Users\\HJCHOI\\Desktop\\TEST\\file";
	//private String pathName = "C:\\Users\\HJCHOI\\Desktop\\TEST\\gaia3d.png";
	File file = new File(pathName);

	@Test
	public void test() {
		//파일 suffix 체크
		accept(file);
		
		//파일 목록 조회
		checkList(pathName);
	}

	@Override
	public boolean accept(File file) {
		if(file.isFile()) { 
			String fileName = file.getName();
			if(fileName.endsWith(".jpg")) {
				System.out.println("jpg 파일입니다.");
				return true;
			}
			System.out.println("jpg 파일 형식만 사용할 수 있습니다.");
		}
		return false;
	}
	
	private void checkList(String pathName) {
		File file;
		try {
			file = new File(pathName);
			//File[] fileList = file.listFiles();
			File[] fileList = file.listFiles(new FileFilterTest());
			for(File tempFile : fileList) {
				System.out.println(tempFile.getName());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
