package example;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObject3 implements Runnable {
	private String data;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public void run() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Data obj = mapper.readValue(data, Data.class);
			
			System.out.println("data_key: " + obj.getData_key());
			System.out.println("latitude: " + obj.getLatitude());
			System.out.println("longitude: " + obj.getLongitude());
			System.out.println("heading: " + obj.getHeading());
			System.out.println("pitch: " + obj.getPitch());
			System.out.println("roll: " + obj.getRoll());
			
		}catch (Throwable e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		JsonObject3 dataSet = new JsonObject3();
		dataSet.setData("{}");
		
		
		
		
		
		
		
	}
}
