package com.satish.iot.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class IoTAppApiZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(IoTAppApiZuulApiGatewayApplication.class, args);
	}

}
