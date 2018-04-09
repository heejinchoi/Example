package com.gaia3d.mago3d.parser;

public class Data {
	//파일을 읽어들여서 object 형태로 생성해야 하나?
	
	String data_key;
	String latitue;
	String longitude;
	String heading;
	String pitch;
	String roll;
	
	
	public String getData_key() {
		return data_key;
	}
	public void setData_key(String data_key) {
		this.data_key = data_key;
	}
	public String getLatitue() {
		return latitue;
	}
	public void setLatitue(String latitue) {
		this.latitue = latitue;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getPitch() {
		return pitch;
	}
	public void setPitch(String pitch) {
		this.pitch = pitch;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	
	@Override
	public String toString() {
		return "Data [data_key=" + data_key + ", latitue=" + latitue + ", longitude=" + longitude + ", heading="
				+ heading + ", pitch=" + pitch + ", roll=" + roll + "]";
	}

}
