package example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParser {
	
	public static void main(String[] args) {
		
		JSONParser parser = new JSONParser();

		try {
				
				Object object = parser.parse(new FileReader("C:\\DATA_Property\\json\\1.json"));
				JSONObject jsonObject = (JSONObject) object;
				
				String name = (String) jsonObject.get("name");
				System.out.println("name: " + name);
				
				long age = (Long) jsonObject.get("age");
				System.out.println("age: " + age);
			
				String jobInfo = (String) jsonObject.get("jobInfo");
				System.out.println("jobInfo: " + jobInfo);
				
				JSONArray hobbyList = (JSONArray) jsonObject.get("message");
				Iterator<String> iterator = hobbyList.iterator();
				while(iterator.hasNext()) {
					System.out.println("hobby: " + iterator.next());
				}
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}

		
	}

}
