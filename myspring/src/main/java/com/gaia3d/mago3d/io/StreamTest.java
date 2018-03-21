package com.gaia3d.mago3d.io;

import org.junit.Test;

public class StreamTest {

	@Test
	public void 바이트기반스트림() {
		Stream byteStream = new Stream();
		
		byteStream.ByteStream("C:\\DATA_Property\\json\\test7.json", "C:\\DATA_Property\\json\\write1.txt");
	}
	
	
	@Test
	public void 문자기반스트림() {
		Stream characterStream = new Stream();
		
		characterStream.characterStream("C:\\DATA_Property\\json\\test8.json", "C:\\DATA_Property\\json\\write2.txt");
	}
	
	@Test
	public void 보조스트림() {
		Stream bufferedStream = new Stream();
		
		bufferedStream.BufferedStream("C:\\DATA_Property\\json\\test9.json", "C:\\DATA_Property\\json\\write3.txt");
	}
	

}
