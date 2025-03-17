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

 /*   
 
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
    
    */
    
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Wait was interrupted.");
            e.printStackTrace();
        }
    }

    public static void openBlackjack(WebDriver driver) {
        try {
            // Click the search button
            WebElement searchButton = driver.findElement(By.xpath("//button[@data-testid='search-bar-icon-btn']"));
            searchButton.click();
            Thread.sleep(1000); // Allow search bar to open

            // Locate the search input field
            WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
            searchInput.sendKeys("Free Bet Blackjack");
            Thread.sleep(1000); // Allow search results to populate

            // Press ENTER to trigger search
            searchInput.sendKeys(Keys.RETURN);
            Thread.sleep(2000); // Allow search results to load

            // Click the first result (modify selector if needed)
            WebElement blackjackResult = driver.findElement(By.xpath("//p[contains(text(), 'Free Bet Blackjack')]"));
            blackjackResult.click();

            System.out.println("Navigated to Free Bet Blackjack.");
        } catch (Exception e) {
            System.out.println("Error in openBlackjack: " + e.getMessage());
        }
    }


    public void clickPlayButton() {
        try {
            // Locate the parent <a> tag that contains the Play button text
            WebElement playButton = driver.findElement(By.xpath("//a[contains(@class, 'game-tile-button-cash__root')]"));

            // Scroll into view if necessary
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", playButton);
            Thread.sleep(500); // Small delay to ensure visibility

            // Click the Play button
            playButton.click();

            System.out.println("Play button clicked successfully!");

        } catch (Exception e) {
            System.out.println("Error clicking Play button: " + e.getMessage());
        }
    }
    
    public void placeBet() {
        clickAtCoordinates(60, 230); // Estimated $1 chip coordinates
        waitForSeconds(1); // Optional: pause after clicking
    }

}
