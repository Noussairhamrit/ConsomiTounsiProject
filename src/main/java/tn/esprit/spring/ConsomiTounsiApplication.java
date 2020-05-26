package tn.esprit.spring;

import java.util.EnumSet;
import java.util.Properties;

import javax.faces.webapp.FacesServlet;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.DispatcherType;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import Config.FileStorageProperties;

@EnableConfigurationProperties({ FileStorageProperties.class })
@SpringBootApplication
@ComponentScan({ "tn.esprit.spring.*" })

@EnableScheduling
public class ConsomiTounsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsomiTounsiApplication.class, args);

	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		return new ServletRegistrationBean(servlet, "*.jsf");
	}

	@Bean
	public FilterRegistrationBean rewriteFilter() {
		FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
		rwFilter.setDispatcherTypes(
				EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR));
		rwFilter.addUrlPatterns("/*");
		return rwFilter;
	}

	public class SendEmail {

		public void main(String[] args) {

			final String username = "khalilbelamine2005@gmail.com";
			final String password = "jerjmjpjvjhekdqj";

			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "465");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.socketFactory.port", "465");
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("khalilbelamine2005@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("khalilbelamine@hotmail.com"));
				message.setSubject("EVENT REMINDER!!");
				message.setText("Dear Mail Crawler," + "\n\n You are invited to this event!");

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				e.printStackTrace();
			}

		}
	}

}
