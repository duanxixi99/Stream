package com.csv;

public class AmmeterInfo {
	private String ammeterID;//电表ID
	private String ammeterReading;//电表值
	private String readTime;// 时间

	public String getAmmeterID() {
		return ammeterID;
	}	

	public void setAmmeterID(String ammeterID) {
		this.ammeterID = ammeterID;
	}

	public String getAmmeterReading() {
		return ammeterReading;
	}

	public void setAmmeterReading(String ammeterReading) {
		this.ammeterReading = ammeterReading;
	}

	public String getReadTime() {
		return readTime;
	}

	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}

}
