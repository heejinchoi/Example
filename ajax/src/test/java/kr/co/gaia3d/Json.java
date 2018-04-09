package kr.co.gaia3d;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.junit.Test;

public class Json {

	/*파일 및 디렉토리 정보 출력*/
	@Test
	public void FileDirectory() {
		File dir = new File("C:/DATA_Property");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  a  HH:mm");
		File[] contents1 = dir.listFiles();
		
		System.out.println("날짜	 	 시간	  형태	     크기                     이름  	");
		System.out.println("────────────────────────────────────────────────────────────");
		for(File file : contents1) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			
			if(file.isDirectory()) {
				System.out.print("\t<DIR>\t\t\t" + file.getName());
			}else {
				System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
				
				
			}
			System.out.println();
		}

	}


	@Test
	public void FileInputStream() {
		File file = new File("C:\\DATA_Property\\DATA_Property\\ifc_japan");
		
		if(file.exists()) {
			System.out.println("현재 디렉토리 위치: " + file.getName());
		}else {
			System.out.println("경로가 존재하지 않습니다.");
		}
		
		File[] fileList = file.listFiles();
		for(int i=0; i<fileList.length; i++) {
			
		}
		
	}
	
	public void subDirList(String source) {
		File dir = new File(source);
		File[] fileList = dir.listFiles();
		
		try {
			for(int i=0; i<fileList.length; i++) {
				File file = fileList[i];
				if(file.isFile()) {
					if(i == 0) {
						
					}
					
				}
			}
			
		}catch(Exception e) {
			
		}
	}
	
	
	
}
