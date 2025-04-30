package com.pdf.generate.tatva;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
//	public static void main(String[] args) {
//		emailSend("arjunmca14@gmail.com","October",2024,"");
//	}
	
    public static void emailSend(EmployeeDetails empDetails,String filePath) {

        // Set mail properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.office365.com");
        properties.put("mail.smtp.port", "587");


        // Define the email credentials
        final String username = "payroll.admin@tatvasoftwareservices.com";
        final String password = "Java@123";

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            // Create the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("payroll.admin@tatvasoftwareservices.com", "Payroll-Admin"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(empDetails.getEmail()));
            message.setSubject("Payslip for the Month: "+empDetails.getMonth()+"-"+empDetails.getYear());
            message.setContent("Payslip for the Month: "+empDetails.getMonth()+"-"+empDetails.getYear(),"text/html");

            // Adding an attachment
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("<p>Dear <strong>"+empDetails.getEmpname()+" <br /></strong>Employee ID<strong>"
            		+ "&nbsp; : "+empDetails.getEmpid()+"</strong></p>\r\n"
            		+ "<p>we are sending here with "+empDetails.getMonth()+"-"+empDetails.getYear()+" Payslip.</p>\r\n"
            		+ "<p>&nbsp;</p>\r\n"
            		+ "<p>Greetings to you! Trust you and your "
            		+ "family are staying safe and in good health.</p>\r\n"
            		+ "<p>You will require an 8 character password to "
            		+ "open this file. The password for opening the PDF file is "
            		+ "combination of the first 4 letters of PAN and Date and month of your Birth date.</p>\r\n"
            		+ "<p>For example: If your PAN is AEGPS11118 and Date of "
            		+ "Birth 01/01/1900, then your password will be AEGP0101 (PAN in CAPS only)</p>\r\n"
            		+ "<p>In case PAN is not updated in SSC masters then the "
            		+ "password for opening the PDF file is combination of the "
            		+ "first 4 letters of Name and Date and month of your Birth date.</p>\r\n"
            		+ "<p>For example: If your Name is MUKESH RAVAT and Date "
            		+ "of Birth 01/01/1900, then your password will be MUKE0101</p>\r\n"
            		+ "<p>For any queries we request you to lodge HELPDESK request. "
            		+ "In case you are unable to open, please login online.</p>\r\n"
            		+ "<p>Shared Services&nbsp;Centre</p>\r\n"
            		+ "<p>Bangalore</p>", 
            		
            		"text/html");

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(filePath);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            // Send the email
            Transport.send(message);

            System.out.println("Email has been sent");
        } catch (Exception e) {
            System.out.println("Email could not be sent. Error: " + e.getMessage());
        }
    }
}
