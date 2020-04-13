package com.satish.sendEmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	public static void sendEmail(double i)
	{
		// Recipient's email ID needs to be mentioned.
        String to = "smodugu@unomaha.edu";//change accordingly

        // Sender's email ID needs to be mentioned
        String from = "satishreddym@zoho.com";//change accordingly
        
        final String username = "satishreddym@zoho.com";//change accordingly
        final String password = "Aosproject100";//change accordingly

        // Zoho's SMTP server
        String host = "smtp.zoho.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", host);

        // Get the Session object.
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(username, password);
           }
        });

        try {
      	  System.out.println("Indisde rty");
           // Create a default MimeMessage object.
           Message message = new MimeMessage(session);

           // Set From: header field of the header.
           message.setFrom(new InternetAddress(from));

           // Set To: header field of the header.
           message.setRecipients(Message.RecipientType.TO,
           InternetAddress.parse(to));

           // Set Subject: header field
           message.setSubject("IoT App Alerts");

           // Now set the actual message
           message.setText("Hello, this is an alert email, The level vallue is:"+i+"                          "
              + "This is an automated message donot reply");

           // Send message
           Transport.send(message);

           System.out.println("Sent message successfully.... from Zoho");

        } catch (MessagingException e) {
      	  System.out.println(e.getMessage());
              throw new RuntimeException(e);
        }
	}

}
