package com.starquick.test;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WhatsAppAutomation {

	  private static boolean killBrowser = true;
	  static WebDriver driver;
	  public static String clientName="Infinite monitoring";
    public static void main(String[] args) throws InterruptedException {
     ///   System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Path to your custom Chrome profile
    	//close();
    	System.out.println(System.currentTimeMillis());
    	 ChromeOptions options = new ChromeOptions();
         String chromeCachePath = String.valueOf(System.getProperty("user.home")) + "\\AppData\\Local\\Google\\Chrome\\User Data";
         
         options.addArguments(new String[] { "user-data-dir=" + chromeCachePath });
      
         
        driver = new ChromeDriver(options);

        try {
            // Open WhatsApp Web
            driver.get("https://web.whatsapp.com/");
            showPopup("Please Scan whatsapp");
            // Wait for WhatsApp Web to load fully
            Thread.sleep(10000); // Adjust this time if necessary
            
            // Find the search box and type the contact name
            driver.findElement(By.xpath("//div[@contenteditable='true'][@data-tab='3']")).sendKeys(clientName);
            Thread.sleep(5000); // Wait for the search results to appear
            
            // Select the contact
            driver.findElement(By.xpath("//span[@title='"+clientName+"']")).click();
            
            // Find the message box and type the message
            driver.findElement(By.xpath("//div[text()='Type a message']")).sendKeys("Hello, this is an automated message.");
            
            // Click the send button
            driver.findElement(By.xpath("//span[@data-icon='send']")).click();
            
            System.out.println("Message sent successfully!");
        } finally {
            // Wait for a few seconds to see the result
            Thread.sleep(5000);
            driver.quit();
        }
    }
    
   
    
public static void showPopup(String msg) {
    JFrame frame = new JFrame();
    JLabel label = new JLabel(msg, 0);
    JOptionPane jOptionPane = new JOptionPane(label);
    JDialog dialog = jOptionPane.createDialog(frame, "Message");
    dialog.setSize(600, 400);
    dialog.setAlwaysOnTop(true);
    dialog.show();
    dialog.toFront();
    dialog.setFocusable(true);
  }
public static void close() {
    if (killBrowser) {
      try {
    	  
//        logger.debug("Close all instance of browser");
        driver.close();
      } catch (Exception e) {
//        logger.debug("Selenium WebDriver close Exception" + e.getMessage());
      } 
      try {
        driver.quit();
      } catch (Exception e) {
//        logger.debug("Selenium WebDriver quit Exception" + e.getMessage());
      } 
      driver = null;
   
     
    } 
  }
}
