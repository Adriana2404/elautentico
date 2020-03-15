package com.ecodeup.beans;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailBean {
	private final Properties properties = new Properties();
	
	private Session session;
	
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private void init() {
 
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.mail.sender","graneroelautentico@gmail.com");
		properties.put("mail.smtp.user", "graneroelautentico@gmail.com");
		properties.put("mail.smtp.auth", "true");
 
		session = Session.getDefaultInstance(properties);
	}
 
	public String sendEmail(String emails, String subject, String emailmessage){
		emails = emails.trim();
		
		subject = subject.trim();
		emailmessage = emailmessage.trim();
		System.out.println(emails);
		System.out.println(subject);
		System.out.println(emailmessage);
		String[] emailArray = emails.split(",");
		List<String> emailList = Arrays.asList(emailArray);
		ArrayList<String> emailsRecipient = new ArrayList<String>(emailList);

		

		try{
			for(String email : emailsRecipient) {
				init();
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
				message.setSubject(subject);
				message.setText(emailmessage);
				Transport t = session.getTransport("smtp");
				t.connect((String)properties.get("mail.smtp.user"), "Naglesita");
				t.sendMessage(message, message.getAllRecipients());
				t.close();
				
			}
			return "El correo se ha enviado satisfactoriamente a " + emailsRecipient.size() + " destinatarios.";
		}catch (MessagingException me){
			return me.getMessage();
		}
	}
}