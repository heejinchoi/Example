package example;

import java.io.File;

public class FileStream {
	public static void main(String[] args) {
		String path="C:\\DATA_Property\\ifc_japan";
		File dir = new File(path);
		File[] fileList = dir.listFiles();
		
		for(File tempFile : fileList) {
			if(tempFile.isFile()) {
				String tempFileName = tempFile.getName();
				System.out.println(tempFileName);
			}
		}
		
		
	}

}
