package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GameBot {

    private WebDriver driver;

    public GameBot(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToIframe() {
        try {
            driver.switchTo().defaultContent();
            WebElement iframe = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
            System.out.println("Found first iframe: " + iframe.getAttribute("src"));
            driver.switchTo().frame(iframe);
            System.out.println("Switched into first iframe.");
        } catch (Exception e) {
            System.out.println("Failed to switch to iframe: " + e.getMessage());
        }
    }

    public void clickAtCoordinates(int x, int y) {
        try {
            Actions actions = new Actions(driver);
            actions.moveByOffset(x, y).click().perform();
            System.out.println("Clicked at coordinates: (" + x + ", " + y + ")");
            // Reset the mouse position to avoid offset stacking
            actions.moveByOffset(-x, -y).perform();
        } catch (Exception e) {
            System.out.println("Failed to click at coordinates: (" + x + ", " + y + ")");
            e.printStackTrace();
        }
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Wait was interrupted.");
            e.printStackTrace();
        }
    }

    public void clickPlayButton() {
        waitForSeconds(15); // Optional: give the game time to load
        clickAtCoordinates(350, 400); // Estimated Play button coordinates
        waitForSeconds(2); // Optional: give the game time to load
    }
    
    public void placeBet() {
        clickAtCoordinates(60, 230); // Estimated $1 chip coordinates
        waitForSeconds(1); // Optional: pause after clicking
    }

}
