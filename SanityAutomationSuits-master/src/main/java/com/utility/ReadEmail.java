package com.utility;

import java.io.IOException;
import java.security.NoSuchProviderException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

public class ReadEmail {

	static String result = "";
	static String messageBody = "";

	private final static String host = "imap.gmail.com";
	private final static String mailStoreType = "imaps";
	private final static String port = "993";
	// email is your email address where email with OTP is sent
	private final static String email = "shantanunew0410@gmail.com";
	// password is app password created for the email address above
	private final static String password = "djrpladknmtvztoz";

	public static String getOtp(String subject) {
		try {
			String otp = "";

			// delay to let backend sends email with OTP

			Properties properties = new Properties();
			properties.put("mail.imaps.host", host);
			properties.put("mail.imaps.port", port);
			properties.put("mail.imaps.starttls.enable", "true");
			properties.put("mail.imaps.ssl.trust", host);

//					properties.setProperty("http.proxySet", "true");
//					properties.setProperty("http.proxyHost", host);
//					properties.setProperty("http.proxyPort", port);
//					properties.setProperty("mail.imap.port", "993");

//					Session emailSession = Session.getDefaultInstance(properties);

//					Session emailSession = Session.getDefaultInstance(properties, null);
//					Session emailSession = Session.getInstance(properties, null);

//					Store store = emailSession.getStore("imaps");

			try {
				Session emailSession = Session.getDefaultInstance(properties, null);
				System.out.println("Here");
				Store store = emailSession.getStore("imaps");
				System.out.println("Here2");
				store.connect("imap.gmail.com", email, password);
				System.out.println("Here3");
				Folder inbox = store.getFolder("Inbox");

//					store.connect("imap.gmail.com", email, password);
				System.out.println("Here4");

			} catch (MessagingException e) {
				e.printStackTrace();
				System.exit(2);
			}

//					inbox.open(Folder.READ_ONLY);
//					
//					Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
//						
//					for (Message singleMessage : messages) {
//						
//						if (singleMessage.getSubject().equals(subject))
//						{
//							singleMessage.setFlag(Flags.Flag.SEEN, true);
//							String messageBody = getMessageBody(singleMessage);
//							
//							String otpPhrase = "Greetings from ICICI Prudential Mutual Fund!";
//							System.out.println(otpPhrase.length());
//							
//							System.out.println(singleMessage.getContent().toString());
//							System.out.println(messageBody.toString());
//							
//
//							System.out.println(messageBody.charAt(18));
//							int indexOfOtpStart = messageBody.indexOf(otpPhrase) + otpPhrase.length();
//
//							otp = otp + messageBody.substring(indexOfOtpStart + 1, indexOfOtpStart + 7);
//							
//							
//						}
//					}
//					inbox.close(false); 
//					store.close();

			return otp;
		} catch (Exception e) {
			throw new RuntimeException("There are problems with reading emails.");
		}

	}

	private static String getMessageBody(Message message) throws MessagingException, IOException {

		if (message.isMimeType("text/plain")) {
			messageBody = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			messageBody = getTextFromMimeMultipart(mimeMultipart);
		}
		return messageBody;
	}

	private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws IOException, MessagingException {
		int count = mimeMultipart.getCount();
		if (count == 0)
			throw new MessagingException("Multipart with no body parts not supported.");
		boolean multipartAlt = new ContentType(mimeMultipart.getContentType()).match("multipart/alternative");
		if (multipartAlt)
			return getTextFromBodyPart(mimeMultipart.getBodyPart(count - 1));
		String result = "";
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			result += getTextFromBodyPart(bodyPart);
		}
		return result;
	}

	private static String getTextFromBodyPart(BodyPart bodyPart) throws IOException, MessagingException {

		if (bodyPart.isMimeType("text/plain")) {
			result = (String) bodyPart.getContent();
		} else if (bodyPart.isMimeType("text/html")) {
			String html = (String) bodyPart.getContent();
			result = org.jsoup.Jsoup.parse(html).text();
		} else if (bodyPart.getContent() instanceof MimeMultipart) {
			result = getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
		}
		return result;

	}

}
