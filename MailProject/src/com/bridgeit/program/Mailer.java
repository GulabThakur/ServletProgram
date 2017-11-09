package com.bridgeit.program;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	public static void send(String to,String subject,String text) 
	{
		//System.out.println(to);
		final String user="gulabthakur238@gmail.com";
		final String pass="7024082813";
		
		Properties properties=new Properties();
		
	
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");    
		properties.put("mail.smtp.port", "587");
	 
		Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(user, pass);
				
			}
		});
		
		//
		
		try {
			MimeMessage mimeMessage=new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(user));
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(text);
			Transport.send(mimeMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
