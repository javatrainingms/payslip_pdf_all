package com.pdf.generate.test;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class CustomDomainEmailSender {
    public static void main(String[] args) {
        // SMTP server details
        String smtpHost = "mail.tatvasoftwareservices.com"; // Replace with your domain's SMTP server
        int smtpPort = 465; // Use 465 for SSL or 587 for TLS
        String fromEmail = "gaurav.j@tatvasoftwareservices.com"; // Your custom domain email
        String password = "Java@123"; // Email account password
        String toEmail = "arjunmca14@gmail.com"; // Recipient email

        // Set mail properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS (if using port 587)

        // Authenticate and start session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Create email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Test Email from Custom Domain");
            message.setText("Hello! This is a test email sent using a custom domain via Java.");

            // Send email
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
