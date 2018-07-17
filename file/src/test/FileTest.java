package com.gaia3d.controller.board;


import java.io.File;
import java.util.Date;

import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

public class FileTest {
	private String pathName = "C:\\Users\\HJCHOI\\Desktop\\TEST";
	private String makePathName = "C:\\Users\\HJCHOI\\Desktop\\TEST\\file";
	private String fileName = "test.txt";
	File file = new File(pathName, fileName);
	
	@Test
	public void sample() throws Exception {
		// path 체크
		checkPath(pathName);
		
		// 디렉토리 생성
		//makeDir(makePathName);
		
		// 디렉토리인지 파일인지 확인
		checkFile(pathName);
		
		// 최종 수정일 확인
		lastModified(pathName);
		
		// 파일 정보 확인-경로,파일명,상위 디렉토리
		getFileInfo(file);
	}
	

	private void checkPath(String pathName) {
		File file = new File(pathName);
		System.out.println(pathName + " is exists? = " + file.exists() + "\n");
	}
	
	private void makeDir(String makePathName) {
		File file = new File(makePathName);
		System.out.println("Make " + makePathName + " result = " + file.mkdir() + "\n");
	}
	
	private void checkFile(String pathName) {
		File file = new File(pathName);
		System.out.println(pathName + " is directory? = " + file.isDirectory());
		System.out.println(pathName + " is file? = " + file.isFile());
		System.out.println(pathName + " is hidden? = " + file.isHidden() + "\n");
	}
	
	private void lastModified(String pathName) {
		File file = new File(pathName);
		System.out.println(pathName + " last modified " + new Date(file.lastModified()) + "\n");
	}
	
	private void getFileInfo(File file) {
		System.out.println("Absolute Path = " + file.getAbsolutePath());
		System.out.println("Absolute File= " + file.getAbsoluteFile());
		System.out.println("Name = " + file.getName());
		System.out.println("Path = " + file.getPath());
		System.out.println("Parent = " + file.getParent() + "\n");
	}
	


}
