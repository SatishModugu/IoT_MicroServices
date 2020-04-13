package com.satish.sendEmail;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;


public class App 
{
	
    public static void main( String[] args )
    {
    String url="http://localhost:56989/sensor-data/device/test/1";
    RestTemplate restTemplate = new RestTemplate();
	String resp = restTemplate.getForObject(url, String.class);

	JsonParser springParser = JsonParserFactory.getJsonParser();
	Map<String, Object> map = springParser.parseMap(resp);

	String mapArray[] = new String[map.size()];
	System.out.println("Items found: " + mapArray.length);

	System.out.println("value at:");
	Object value = map.get("levelValue");
	double i = (Double) value;
System.out.println(value);
		/*
		 * int i = 0; for (Map.Entry<String, Object> entry : map.entrySet()) {
		 * System.out.println(entry.getKey() + " = " + entry.getValue()); i++; }
		 */
	try {
		Thread.sleep(5*1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(i<13)
	{
		  System.out.println("Sending Email...");
		    SendEmail.sendEmail(i);
	}
   
    }
}
