package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.example.GameBot;

public class Main {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver 
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jackc\\OneDrive - Villanova University\\Documents\\chromedriver-win64\\chromedriver.exe");
    
        // Launch Chrome
        WebDriver driver = new ChromeDriver();

        // Open the 247 Blackjack website
        driver.get("https://casino.draftkings.com/?casinoPartner=Hollywood");
    

         // Print the page title
         System.out.println("Opened: " + driver.getTitle());

         // Keep the browser open for 10 seconds, so you can see it
        try {
            // Give the page time to load
            Thread.sleep(5000);

            //initialize the bot
            GameBot bot = new GameBot(driver);
           
            Thread.sleep(10000);
            Thread.sleep(10000);
           // bot.listButtons();

            bot.clickPlayButton();

            bot.placeBet();

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Browser Closed");
        }

      
    }
}
