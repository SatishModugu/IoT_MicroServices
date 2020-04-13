package com.satish.iot.api.sensordata.data;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;

public class SensorValue {
	public static GpioPinDigitalOutput pin;
	public static GpioPinDigitalOutput gpioTrigger;
	public static GpioPinDigitalInput gpioEcho;
	
	public static String getSensorValue(String deviceID) {
		
		return deviceID;
		
	}
	//Takes triggerPin and echoPin as arguments.
	public static String getDistance(Pin triggerPin, Pin echoPin) {
		//getting the instance of GPIO Controller to acces GPIO pins of rasperyPI.
		GpioController gpio = GpioFactory.getInstance();
		if (gpioTrigger == null)
			//Making the trigger Pin as output pin
			gpioTrigger = gpio.provisionDigitalOutputPin(triggerPin);
		if (gpioEcho == null)
			//Making the echo Pin as input pin
			gpioEcho = gpio.provisionDigitalInputPin(echoPin, PinPullResistance.PULL_DOWN); 
		// Initializing start and end times
		long startTime = 0;
		long endTime = 0;
		while (true) {
			try {
				//waiting for 2 seconds
				Thread.sleep(2000);
				// Make trigger pin HIGH
				gpioTrigger.high(); 
				// Delay for 10 microseconds
				Thread.sleep((long) 0.01);
				// Make trigger pin LOW
				gpioTrigger.low(); 
				// Wait until the ECHO pin gets HIGH
				while (gpioEcho.isLow()) { 
				}
				// Store the current time to calculate ECHO pin HIGH time.
				startTime = System.nanoTime(); 
				// Wait until the ECHO pin gets LOW
				while (gpioEcho.isHigh()) { 
				}
				 // Store the echo pin HIGH end time to calculate ECHO pin HIGH time.
				endTime = System.nanoTime();
				//distance  in cm
				System.out.println("Distance :" + ((((endTime - startTime) / 1e3) / 2) / 29.1) + " cm"); 
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Returning distance.
			return "Distance :" + ((((endTime - startTime) / 1e3) / 2) / 29.1) + " cm";
		}

	}
}
