package FileNameJson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class JsonObject {
	
	public static void main(String[] args) {
		String path="C:\\Users\\h2jin\\Desktop\\DATA_Property\\ifc_japan";
		File dir = new File(path);
		File[] fileList = dir.listFiles();
		
		for(File tempFile : fileList) {
			if(tempFile.isFile()) {
				String fileName = tempFile.getName();
				System.out.println(fileName);
			}
		}
		
		List<String> list= new ArrayList<String>();
		
		
		for(int i=0; i<fileList.length; i++) {
			String fileNameList = fileList[i].getName();
			System.out.println(fileNameList);
			
			list.add(fileList[i].getName());
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data_key", list);
		jsonObject.put("latitude", 36.44346);
		jsonObject.put("longitude", 127.8842459);
		jsonObject.put("heading", 0);
		jsonObject.put("pitch", 0);
		jsonObject.put("roll", 0);
		
		try {
			FileWriter file = new FileWriter("C:\\data\\myJson.json");
			file.write(jsonObject.toJSONString());
			file.flush();
			file.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(jsonObject);
	}
	
}
