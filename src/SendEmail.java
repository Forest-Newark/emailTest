import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter recipient email address(TO): ");

        // Recipient's email ID needs to be mentioned.
        String to = sc.nextLine();

        // Sender's email ID needs to be mentioned
        System.out.println("Enter your email address(FROM): ");
        String from = sc.nextLine();
        System.out.println("Enter SMTP UserName: ");
        final String username = sc.nextLine();
        System.out.println("Enter SMTP Password: ");
        final String password = sc.nextLine();


        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            System.out.println("Enter Email Subject Line: ");
            message.setSubject(sc.nextLine());

            // Now set the actual message
            System.out.println("Enter Email Body: ");
            message.setText(messageBuilder.buildMessage());

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}