package com.onlineBookStore.BooksStore.HelperClasses;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.onlineBookStore.BooksStore.Entities.User;

public class EmailActions {

	static public boolean sendVerificationMail(User u, String verificationCode, JavaMailSender emailSender) {
	    boolean flag = false;
	    try {
	        String subject = "Please verify your registration";
	        String senderName = "Book Shop Team";
	        String senderEmail = "noreply@bookshop.com"; // Replace with the actual sender email
	        String mailContent = "<p>Dear " + u.getUserName() + ",</p>";
	        mailContent += "<p>Please click the link below to verify your registration:</p>";
	        String verifyUrl = "http://localhost:9090/verify?code=" + verificationCode;

	        mailContent += "<h3><a href=\"" + verifyUrl + "\">Verify</a></h3>";
	        mailContent += "<p>Thank you,<br>Book Shop Team</p>";
	        System.out.println("u email " + u.getUserEmail());

	        MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(senderEmail, senderName); // Set sender email and name
	        helper.setTo(u.getUserEmail());
	        helper.setSubject(subject);
	        helper.setText(mailContent, true);
	        emailSender.send(message);

	        flag = true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        // TODO: handle exception
	    }
	    return flag;
	}


	static public boolean sendActiveStoreMessage(User u, JavaMailSender emailSender) {
	    boolean flag = false;
	    try {
	        String subject = "Your book store now activated!!";
	        String senderName = "Book Shop Team";
	        String senderEmail = "noreply@bookshop.com"; // Replace with the actual sender email
	        String mailContent = "<p>Dear " + u.getUserName() + ",</p>";
	        mailContent += "<p>Your registered book store is now activated. Books related to your store can now be published publicly.</p>";
	        mailContent += "<p>Thank you,<br>Book Shop Team</p>";

	        System.out.println("u email " + u.getUserEmail());

	        MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(senderEmail, senderName); // Set sender email and name
	        helper.setTo(u.getUserEmail());
	        helper.setSubject(subject);
	        helper.setText(mailContent, true);
	        emailSender.send(message);

	        flag = true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        // TODO: handle exception
	    }
	    return flag;
	}


	static public boolean sendResetPasswordEmailMessage(User u, String verificationCode, JavaMailSender emailSender) {
	    boolean flag = false;
	    try {
	        String subject = "Reset the password";
	        String senderName = "Book Shop Team";
	        String senderEmail = "noreply@bookshop.com"; // Replace with the actual sender email
	        String mailContent = "<p>Dear " + u.getUserName() + ",</p>";
	        mailContent += "<p>Please click the link below to reset your online book store account password:</p>";
	        String verifyUrl = "http://localhost:9090/resetPasswordcodeVerification?code=" + verificationCode;

	        mailContent += "<h3><a href=\"" + verifyUrl + "\">Reset Password</a></h3>";
	        mailContent += "<p>Thank you,<br>Book Shop Team</p>";
	        System.out.println("u email " + u.getUserEmail());

	        MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(senderEmail, senderName); // Set sender email and name
	        helper.setTo(u.getUserEmail());
	        helper.setSubject(subject);
	        helper.setText(mailContent, true);
	        emailSender.send(message);

	        flag = true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        // TODO: handle exception
	    }
	    return flag;
	}


}
