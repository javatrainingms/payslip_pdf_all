package com.pdf.generate.test;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender_uk {
    public static void main(String[] args) {
        // SMTP server configuration
        String host = "mail.tatvasolutions.uk";
        final String username = "_mainaccount@tatvasolutions.uk";
        final String password = "Solutions@674";
        int port = 587;

        // Recipient and sender details
        String from = "tatva@tatvasolutions.uk";
        String to = "arjunmca14@gmail.com";
        String subject = "Test Email from JavaMail";
        String body = "This is a <b>test email</b> sent from a Java application using JavaMail!";

        // Set up the SMTP properties
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Enable TLS encryption

        // Authenticate the session
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            // Set the email content (HTML and plain text)
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(body, "text/html");

            MimeBodyPart plainTextPart = new MimeBodyPart();
            plainTextPart.setText("This is a test email sent from a Java application using JavaMail!");

            // Combine the parts into a multipart email
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(htmlPart);
            multipart.addBodyPart(plainTextPart);

            message.setContent(multipart);

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
}
