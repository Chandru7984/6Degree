package com.degree.subscribe.serviceImpl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.degree.subscribe.dto.SubscriberDto;
import com.degree.subscribe.entity.Subscriber;
import com.degree.subscribe.repository.SubscriberRepository;
import com.degree.subscribe.service.SubscriberService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	private SubscriberRepository repository;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public Subscriber saveSubscriber(SubscriberDto subscriberDto) throws Exception {
		Subscriber subscriber = new Subscriber();

		subscriber.setIsdeleted(0);
		if (Objects.nonNull(subscriberDto.getFullname()) && !subscriberDto.getFullname().isEmpty()) {
			subscriber.setFullname(subscriberDto.getFullname());
		}

		if (Objects.nonNull(subscriberDto.getEmail()) && !(subscriberDto.getEmail().isEmpty() )){
			subscriber.setEmail(subscriberDto.getEmail());
		}

//		if (Objects.nonNull(subscriberDto.getMobile()) && !subscriberDto.getMobile().isEmpty()) {
//			subscriber.setMobile(subscriberDto.getMobile());
//		}

		if (Objects.nonNull(subscriberDto.getDepartment()) && !subscriberDto.getDepartment().isEmpty()) {
			subscriber.setDepartment(subscriberDto.getDepartment());
		}

		repository.saveAndFlush(subscriber);
		sendConfirmationEmail(subscriberDto.getEmail(), subscriberDto.getDepartment());
		sendNotification(subscriberDto,subscriberDto.getDepartment());

		return subscriber;
	}

	public void sendConfirmationEmail(String email, String department) throws MessagingException {

		String website = "https://6degree.co/";
		String description = "Thank you for Subscribing our Website";
		String htmlContent = "<html><body>" + "<h1>Welcome to " + "<a href=\"" + website + "\">6Degree</a>" + "!</h1>"
				+ "<p>" + description + "</p>" + "<img src='cid:logo' width=\"200\" height=\"100\"> </body></html>";

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		messageHelper.setTo(email);
		messageHelper.setSubject("Subscription Confirmation");

		messageHelper.setText(htmlContent, true);

		String filePath = detectLogoFile(department);

		FileSystemResource logoResource = new FileSystemResource(filePath);
		messageHelper.addInline("logo", logoResource.getFile());

		mailSender.send(mimeMessage);

	}

	public void sendNotification(SubscriberDto dto, String department) throws MessagingException {

		String website = "https://6degree.co/";
//		String description = "A new Subscriber has added";
		String depart = dto.getDepartment();
		String mail = dto.getEmail();
		String htmlContent = "<html><body>" + "<h3>A new Subscriber has added to: &nbsp;" + " <a href=\"" + website
				+ "\">6Degree</a> <br>" + "Brand: &nbsp; " + depart + "<br>" + "Email: " + mail + "</h3>"
				+ "<img src='cid:logo' width=\"200\" height=\"100\"> </body></html>";

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		messageHelper.setTo("chandrashekhar.xworkz@gmail.com");
		messageHelper.setSubject("New Subscription");

		messageHelper.setText(htmlContent, true);

		String filePath = detectLogoFile(department);

		FileSystemResource logoResource = new FileSystemResource(filePath);
		messageHelper.addInline("logo", logoResource.getFile());

		mailSender.send(mimeMessage);

	}

	private String detectLogoFile(String department) {
		if ("Rolex".equalsIgnoreCase(department)) {
			return "E:\\6 Degree\\6degree e-commerce\\e-commerce\\subscription\\Rolex-Logo.jpg";
		} else if ("Omega".equalsIgnoreCase(department)) {
			return "E:\\6 Degree\\6degree e-commerce\\e-commerce\\subscription\\Omega-logo.jpg";
		}
		return null;
	}

}
