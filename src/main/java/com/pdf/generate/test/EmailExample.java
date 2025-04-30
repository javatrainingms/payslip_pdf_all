package com.pdf.generate.test;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailExample {
    public static void main(String[] args) {
        System.out.println("Step 1");

        // Set mail properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "mail.socsoftware.in");
        properties.put("mail.smtp.port", "587");

        System.out.println("Step 2");

        // Define the email credentials
        final String username = "payroll.admin@socsoftware.in";
        final String password = "Pvtltd@123";

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            System.out.println("Step 3");

            // Create the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("payroll.admin@socsoftware.in", "PayrollAdmin"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("arjunmca14@gmail.com"));
            message.setSubject("Test Email from JavaMail");
            message.setContent("This is a <b>test email</b> sent from a Java application using JavaMail!", "text/html");

            // Adding an attachment
            System.out.println("Step 4");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("This is a <b>test email</b> with an attachment.", "text/html");

            MimeBodyPart attachmentPart = new MimeBodyPart();
            String filePath = "styled_email_link.pdf"; // Replace with your file path
            attachmentPart.attachFile(filePath);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            // Send the email
            Transport.send(message);

            System.out.println("Step 5");
            System.out.println("Email has been sent");
        } catch (Exception e) {
            System.out.println("Email could not be sent. Error: " + e.getMessage());
        }
    }
}
