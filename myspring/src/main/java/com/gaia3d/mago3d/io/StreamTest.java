package com.gaia3d.mago3d.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.extra.spath.Step;
import org.junit.Test;
import org.w3c.dom.ls.LSException;

import com.gaia3d.mago3d.parser.JsonFactory;

public class StreamTest {

	@Test
	public void 바이트기반스트림() {
		Stream byteStream = new Stream();
		
		byteStream.ByteStream("C:\\DATA_Property\\json\\test7.json", "C:\\DATA_Property\\json\\write1.json");
	}
	
	
	@Test
	public void 문자기반스트림() {
		Stream characterStream = new Stream();
		
		characterStream.characterStream("C:\\DATA_Property\\json\\test8.json", "C:\\DATA_Property\\json\\write2.json");
	}
	
	@Test
	public void 보조스트림() {
		Stream bufferedStream = new Stream();
		
		bufferedStream.BufferedStream("C:\\DATA_Property\\json\\test9.json", "C:\\DATA_Property\\json\\write3.json");
	}
	
	@Test
	public void 스플릿() {
		String str = "오늘은 2018-03-01 입니다.";
		String[] strSplit = str.split(" ");
		for(String split : strSplit) {
			System.out.println(split);
		}
		
		String str2 = "오늘은 2018-03-01 입니다.";
		String word1 = str2.split("-")[0];
		String word2 = str2.split("-")[1];
		String word3 = str2.split("-")[2];
		System.out.println("word1: " + word1);
		System.out.println("word2: " + word2);
		System.out.println("word3: " + word3);
		assertEquals("03", word2);
		
		String str3 = "오늘은 2018-03-01 입니다.";
		String lastWord = str3.split(" ")[str3.indexOf(" ")-1];
		System.out.println("lastWord: " + lastWord);
		assertEquals("입니다.", lastWord);
		
	}
	
	@Test
	public void 보조스트림으로json파일생성() {
		Stream stream = new Stream();
		stream.createJsonStream("C:\\DATA_Property\\ifc", "C:\\DATA_Property\\json\\streamjson.json");
		
		
	}
	
	@Test
	public void 테스트() {

		File fileDirectory = new File("C:\\DATA_Property\\ifc");
		if(fileDirectory.exists()) {
			
			File[] fileList = fileDirectory.listFiles();
			for(File file : fileList) {
				String fileName = file.getName();
				System.out.println(fileName);
				
				if(fileName.isEmpty()) continue;
				
				int index = fileName.lastIndexOf(".");
				System.out.println("index=" + index);
				String result = fileName.substring(index, fileName.length());
				System.out.println("result=" + result);

//				String extension = fileName.split(".")[fileList.length];
//				assertEquals("txt", extension);
//				System.out.println("@@" + extension);
				
//				String[] extension = fileName.split("_");
//				for(String dd : extension) {
//					System.out.println("---" + dd);
//				}
			}
		}
	}

	
	
	

}
