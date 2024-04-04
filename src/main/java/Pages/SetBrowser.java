package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


import static Threadlocal.DriverManager.*;

public class SetBrowser {

    public void setBrowser(String browser) throws MalformedURLException {

        if(browser.equalsIgnoreCase("Chrome"))
            setDriver(setChrome());
        else if (browser.equalsIgnoreCase("Edge"))
            setDriver(setEdge());
        else if(browser.equalsIgnoreCase("FireBox"))
            setDriver(setFireBox());
        else if(browser.equalsIgnoreCase("Opera"))
            setDriver(setFireBox());

        else
            System.out.println("Unsupported command or driver not specified!!");

    }


    public RemoteWebDriver setChrome() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/Browser/chromedriver.exe");
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");

        return new ChromeDriver(options);
//        DesiredCapabilities dd = new DesiredCapabilities();
//        dd.setBrowserName("Chrome");
//
//        return new RemoteWebDriver(new URL("http://172.17.0.2:4444"),dd);
    }

    public EdgeDriver setEdge() throws MalformedURLException {
        System.setProperty("webdriver.edge.driver","./src/main/resources/Browser/msedgedriver.exe");
        EdgeOptions options =  new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        return new EdgeDriver(options);
//        DesiredCapabilities dd = new DesiredCapabilities();
//        dd.setBrowserName("MicrosoftEdge");
//
//        return new RemoteWebDriver(new URL("http://192.168.0.102:4444"),dd);
   }

    public FirefoxDriver setFireBox() {
        System.setProperty("webdriver.gecko.driver","./src/main/resources/Browser/geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private");// nac danh
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        return new FirefoxDriver(options);
//        DesiredCapabilities dd = new DesiredCapabilities();
//        dd.setBrowserName("firefox");

        //return new RemoteWebDriver(new URL("http://192.168.0.102:4444"),options);
    }

//    public OperaDriverManager setOperaBox(){
//        //System.setProperty("webdriver.gecko.driver","./src/main/resources/Browser/geckodriver.exe");
//        WebDriverManager.operadriver().setup();
//
//        WebDriver dd = new Op
////        FirefoxOptions options = new FirefoxOptions();
////        options.addArguments("-private");// nac danh
////        options.addArguments("--incognito");
////        options.addArguments("start-maximized");
//        return new OperaDriverManager();
//    }


    // Send email method
    public void sendEmail(String subject, String body , String attachfilePath) throws IOException {
        // Configure email server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.outlook.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Authenticate sender
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("citestchennai2@hotmail.com", "Comp@123");
            }
        };

        // Create session
        Session session = Session.getInstance(properties, authenticator);

        try {
            // Create message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("citestchennai2@hotmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("lsanthanakumar@compindia.com"));
            message.setSubject(subject);
            message.setText(body);

            // Create multipart
            Multipart multipart = new MimeMultipart();

            // Create text part
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("This is a test email with attachments.");

            // Attach text part to multipart
            multipart.addBodyPart(textPart);

            // Attach files
            String[] attachmentFiles = {attachfilePath}; // Paths to attachment files
            for (String attachmentFile : attachmentFiles) {
                MimeBodyPart attachmentPart = new MimeBodyPart();
                attachmentPart.attachFile(attachmentFile);
                multipart.addBodyPart(attachmentPart);
            }

            // Set content of message
            message.setContent(multipart);


            // Send email
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
