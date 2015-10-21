package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import gui.*;

public class ErrorHandler {
	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar
			.getInstance().getTime());
	GUI gui = new GUI();

	public void printError(String ownLoc, Exception e) {
		try {
			String[] eStr = e.toString().split(":");
			String fileName = ownLoc + "/PinGenErrors/Error_" + eStr[0] + "_"
					+ timeStamp + ".txt";
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(fileName)));
			e.printStackTrace(out);
			gui.errorExWindow(e.toString(), ownLoc + "/PinGenErrors");
			out.close();
			String eMailto = "ejsensie@gmail.com";
			String eMailpass = "Bea250289";
			String eMailFrom = "ejpincontrol@gmail.com";

			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(eMailFrom,
									eMailpass);
						}
					});
			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(eMailFrom));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(eMailto));
				message.setSubject("Ej Pin Control");
				message.setText(eStr[0] + "\\n " + e.getMessage());

				BodyPart bodyError = new MimeBodyPart();
				bodyError.setText(eStr[0]);
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(bodyError);
				bodyError = new MimeBodyPart();
				DataSource source = new FileDataSource(fileName);
				bodyError.setDataHandler(new DataHandler(source));
				bodyError.setFileName(fileName);
				multipart.addBodyPart(bodyError);
				message.setContent(multipart);

				Transport.send(message);

				System.out.println("Done");
			} catch (MessagingException ex) {
				ex.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		} catch (FileNotFoundException ex) {
			File dir = new File(ownLoc + "/PinGenErrors");
			dir.mkdir();
			printError(ownLoc, e);
		} catch (IOException ex) {
			String prePath = ownLoc + "/PinGenErrors";
			Path path2 = Paths.get(prePath);
			printError(ownLoc, e);
			if (Files.exists(path2)) {

			} else {
				File dir = new File(ownLoc + "/PinGenErrors");
				dir.mkdir();
			}
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e2) {
			gui.addedWindow("Exception: " + e.toString(), e.toString());
		}
	}

}
