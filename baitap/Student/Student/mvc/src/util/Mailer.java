package util;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	static boolean send(String email, String subject, String content) {
		try {
			Properties props = new Properties();
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("mail.properties"));
			Session session  = Session.getDefaultInstance(props, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					
					return new PasswordAuthentication(props.getProperty("mail.smtp.user"), props.getProperty("mail.smtp.password"));
				}
			});
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(props.getProperty("mail.smtp.user")));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			msg.setSubject(subject);
			msg.setText(content);
			Transport.send(msg);
			return true;
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		} 
		return false;
	}
}
