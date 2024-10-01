package dev1;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    WebDriver driver;

    @Test
    public void positiveLoginTest() {
        setUp();
        driver.get("https://www.saucedemo.com/");
        String title = driver.getTitle();
        assertEquals("Swag Labs", title);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }
    private void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\shamalsystem\\shamalAutomation\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }



}
