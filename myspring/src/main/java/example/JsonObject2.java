package example;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonObject2 {
	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		
		json.put("name", "Heejin");
		json.put("age", 26);
		json.put("jobInfo", "programmer");
		
		JSONArray hobbyList = new JSONArray();
		hobbyList.add("programming");
		hobbyList.add("baking");
		hobbyList.add("piano");

		json.put("message", hobbyList);
		
		try {
			FileWriter file = new FileWriter("C:\\DATA_Property\\json\\1.json");
			file.write(json.toJSONString());
			file.flush();
			file.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(json);
	}

}
