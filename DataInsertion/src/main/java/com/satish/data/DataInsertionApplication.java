package com.satish.data;

import javax.activation.CommandObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class DataInsertionApplication{ //implements CommandLineRunner {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DataRepository dataRepository;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}

	public static void main(String[] args) {
		SpringApplication.run(DataInsertionApplication.class, args);
	}

//	@Override
//	
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		perform();
//		
//		
//	}
	@Scheduled(fixedRate = 30000)
	public void perform() {
		String uri="http://localhost:53008/sensor-data/device/test/1"; 
		
		 HttpHeaders requestHeaders = new HttpHeaders();
	        //set up HTTP Basic Authentication Header
	       
	        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity requestEntity = new HttpEntity<>(requestHeaders);

		ResponseEntity<SensorData> exchange = restTemplate.exchange(uri,HttpMethod.GET,requestEntity, SensorData.class);
		
		SensorData body = exchange.getBody();
		dataRepository.save(body);
		
		
		System.out.println(body);
	}

}
