package com.pdf.generate.test;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public static void main(String[] args) {
        // SMTP server for your custom domain
        String smtpHost = "smtp.office365.com"; // Replace with your SMTP server
        int smtpPort = 587; // Port 587 for TLS
        String fromEmail = "gaurav.j@tatvasoftwareservices.com"; // Your custom domain email
        String password = "Java@123"; // Your email password
        String toEmail = "ajunmca14@gmail.com"; // Gmail recipient

        // Set mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS

        // Create session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Create the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Test Email from Custom Domain");
            message.setText("Hello, this is a test email sent from Java using a custom domain email.");

            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
