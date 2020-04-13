package com.satish.iot.api.sensordata.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.pi4j.io.gpio.RaspiPin;

@RestController
public class SensorController {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	@RequestMapping("/")
	public String greeting() {
		return "Inventory detecting Service!!";
	}

//@GetMapping annotation is used to map the HTTP request to appropriate method.
//Here when ever the url contains /sensor-data/device/{deviceID} the function sensorFectch data is called.
	@GetMapping(path = "/sensor-data/device/{deviceID}")
	// This function sensorFetchData takes the device ID from the request as the
	// parameter.
	public SensorData sensorFetchData(@PathVariable String deviceID) {
		// store the time when sensor data is requested.
		LocalDateTime now = LocalDateTime.now();
		// The distance value from the sensor is stored in the distanceMeasured using
		// getDistance method.
		// getDistance method, takes the pin numbers of raspberrypi to which the device
		// is connected and returns the measured distance from the sensor.
		String distanceMeasured = SensorValue.getDistance(RaspiPin.GPIO_00, RaspiPin.GPIO_02);
		// State is used to see if the sensor is active or not.
		String state = "";
		// When the sensor is not working the getDistance method returns the NA
		if (distanceMeasured.equals("NA"))
			state = "Not Active";
		else
			state = "Active";
		// Now we are passing deviceID, distanceMeasured, time and state of the device
		// to the SensorData Method that converts the data
		// into JSON format and returns it.
		return new SensorData(deviceID, distanceMeasured, dtf.format(now), state);
	}

	LocalDateTime now = LocalDateTime.now();

	

	@GetMapping(path = "/sensor-data-test/device/{deviceID}")
	public SensorData sensorFetchDataDummy(@PathVariable String deviceID) {
		LocalDateTime now = LocalDateTime.now();
		return new SensorData(deviceID, "12.1", dtf.format(now), "Active");
	}

}
