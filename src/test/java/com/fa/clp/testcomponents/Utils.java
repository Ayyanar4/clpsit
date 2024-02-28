package com.fa.clp.testcomponents;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {

	@Test()

	public static void emailAttachment() {

		try {
			System.out.println("Mail Started");

			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath("C:\\Users\\Fasoftwares\\eclipse-workspace\\Clpsit\\reports\\index.html");
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("CLP Sanity Automated Test Reports");
			attachment.setName("Archive.html");

			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.zoho.com");
			email.setSmtpPort(587);
			email.setSSLOnConnect(true);
			email.setAuthenticator(new DefaultAuthenticator("ayyanar.d@fasoftwares.com", "i2DthWPKv6w7"));
			email.setFrom("ayyanar.d@fasoftwares.com", "Ayyanar Dhanapaul");
			// email.addTo("vinodhkumar.s@fasoftwares.com", "Vinodh");
			email.addTo("mohanraj.s@fasoftwares.com", "Mohan");
			email.setSubject("CLP Sanity Automated Test Report");
			email.attach(attachment);
			email.setMsg(
					"Dear Vinodhkumar,\n\nPlease find the attachment of the CLP Sanity TestCase Report.  \n\n\nThanks & Regards\n G.Ayyanar\n\n");
			email.send();
			System.out.println("Mail is sent");

		} catch (EmailException e) {

			e.printStackTrace();
		}

	}

	@Test()
	public String getScreenshot(String testCaseName) throws IOException {

		String screenshotPath = "C:\\Users\\Fasoftwares\\eclipse-workspace\\Clpsit\\reports\\" + testCaseName + ".png";
		try {

			Robot ro = new Robot();
			Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenshot = ro.createScreenCapture(rect);
			ImageIO.write(screenshot, "PNG", new File(screenshotPath));

		} catch (Exception e) {

			e.printStackTrace();
		}
		return screenshotPath;

	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		// read json to string
		@SuppressWarnings("deprecation")
		String jsonContent = FileUtils.readFileToString(new File(filePath));

		// Convert string to HashMap - Using JackSon Databind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}

}
