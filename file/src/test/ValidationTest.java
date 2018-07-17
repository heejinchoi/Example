package com.gaia3d.controller.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ValidationTest {
	List<String> fileList = new ArrayList<>();
	String directory = "C:\\Users\\HJCHOI\\Desktop\\TEST\\file"; 
	File fileDirectory = new File(directory);
	String mkfolder = "copy";
	String copyPath = "C:\\Users\\HJCHOI\\Desktop\\TEST" + "\\" + mkfolder;
	File mkDirectory = new File(copyPath);
	
	@Test
	public void 파일목록_확장자() {
		fileList = listDirectory(directory);
		String fileName = "";
		System.out.print("확장자 : ");
		for(int i=0; i<fileList.size(); i++) {
			fileName = fileList.get(i);
			String extension = getFileExtension(fileName);
			if(i != fileList.size()-1) {
				System.out.print(extension + ",");
			} else {
				System.out.println(extension);
			}
		}
	}
	
	@Test
	public void 파일복사() {
		System.out.println("폴더를 생성할 디렉토리: " + copyPath);
		System.out.println("생성할 폴더명: " + copyPath.substring(copyPath.lastIndexOf("\\")+1, copyPath.length()));
		copyFile(directory, mkfolder);
	}
	
	@Test
	public void 파일사이즈() {
		fileSize();
	}
	
	//디렉토리의 절대위치, 상대위치



	
	// 디렉토리 위치 확인 후 파일 목록 읽기(파일명) 
	private List<String> listDirectory(String directory) {
		if(fileDirectory.exists()) {
			File[] fileArray = fileDirectory.listFiles();
			System.out.println("File Count : " + fileArray.length);
			for(File file : fileArray) {
				String fileName = file.getName();
				String dataKeyName = fileName.substring(0, fileName.lastIndexOf("."));
				System.out.println("데이터명: " + dataKeyName);
				fileList.add(file.toString());
			}
			System.out.println("@@@ fileList = " +  fileList);
		} else {
			System.out.println("해당 경로에 파일이 없습니다.");
		}
		return fileList;
	}
		
	// 파일 확장자
    private String getFileExtension(String fileName){
		String extension = "";
		int i = fileName.lastIndexOf('.');
		if(i > 0) {
			extension = fileName.substring(i+1);
		}
		return extension;
    }
	
	// 파일 용량
    private void fileSize() {
    	long fileSize = 0;
    	File file = new File(directory);
    	File[] files = file.listFiles();
    	for(int i=0; i<files.length; i++) {
    		fileSize = files[i].length();
    		System.out.println(i + ". 파일 사이즈 : " + fileSize + " byte");
    	}
    }
	
	// 파일 생성, 복사
    private void copyFile(String directory, String copyfolder) {
    	if(!mkDirectory.exists()) {
			System.out.println("현재 디렉토리 : " + mkDirectory.getAbsolutePath());
			File mkDirectory = new File(copyPath);
			if(mkDirectory.mkdir()) {
				System.out.println("@@ copyDirectory = " + mkDirectory.getName());
			} else {
				System.out.println("파일을 복사하지 못했습니다.");
			}
			
		} else {
			System.out.println("해당 경로에 이미 존재하는 폴더입니다.");
		}
    }

}
