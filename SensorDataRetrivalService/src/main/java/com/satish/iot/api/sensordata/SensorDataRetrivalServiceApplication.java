package com.satish.iot.api.sensordata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SensorDataRetrivalServiceApplication {

	public static void main(String[] args) {
		//Main
		SpringApplication.run(SensorDataRetrivalServiceApplication.class, args);
	}

}
