package com_herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-3 - ProjectName : com-herokuapp
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Refresh the page.
 * 11. Close the browser.
 */
public class HerokuAppMultiBrowser {
    static String browser = "Edge";
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    // Creating main method
    public static void main(String[] args) {

        // Launch the Chrome browser
        // 1. Setup Chrome browser.
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        //2. Open URL.
        driver.get(baseUrl);
        // maximise the browser windows
        driver.manage().window().maximize();

        // We give implicit wait to driver - give it to beginning level
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        //3. Print the title of the page.
        driver.getTitle();

        //4. Print the current url.
        System.out.println("The current URL is: " + driver.getCurrentUrl());

        //5. Print the page source.
        System.out.println("The page source is :" + driver.getPageSource());

        //6. Enter the email to email field.
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("tomsmith");

        //7. Enter the password to password field.
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        //8. Click on Login Button.
        driver.findElement(By.className("fa-sign-in")).click();

        //9. Print the current url.
        System.out.println("The current url is :" + driver.getCurrentUrl());

        //10. Refresh the page.
        driver.navigate().refresh();

        //11. Close the browser.
        driver.quit();
    }
}
