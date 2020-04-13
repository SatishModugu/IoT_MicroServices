package com.satish.data;

import java.util.TimerTask;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sensor")
public class SensorData {

	// Declaring the variables
	@Id
	@GeneratedValue
	private long id;
	
	private String deviceID;
	private String levelValue;
	private String timeStamp;
	private String state;

	
	
	public SensorData() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getter method for state variable.
	public String getState() {
		return state;
	}

	// setter method for state variable.
	public void setState(String state) {
		this.state = state;
	}

	// Constructor to initialize all the variables.
	public SensorData(String deviceID, String levelValue, String timeStamp, String state) {
		super();
		this.deviceID = deviceID;
		this.levelValue = levelValue;
		this.timeStamp = timeStamp;
		this.state = state;
	}

	// getter method for DeviceID variable.
	public String getDeviceID() {
		return deviceID;
	}

	// setter method for DeviceID variable.
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	// getter method for LevelValue variable.
	public String getLevelValue() {
		return levelValue;
	}

	// setter method for LevelValue variable.
	public void setLevelValue(String levelValue) {
		this.levelValue = levelValue;
	}

	// getter method for Date variable.
	public String getDate() {
		return timeStamp;
	}

	// setter method for Date variable.
	public void setDate(String date) {
		this.timeStamp = date;
	}

	// Method to convert the data to JSON format.
	@Override
	public String toString() {
		return "SensorData [deviceID=" + deviceID + ", levelValue=" + levelValue + ", timeStamp=" + timeStamp
				+ ", state=" + state + "]";
	}

}
