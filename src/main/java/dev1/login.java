package dev1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\shamalsystem\\shamalAutomation\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.saucedemo.com/");
            System.out.println("WebPage title is: " + driver.getTitle());
            driver.manage().window().maximize();

            // Negative scenario 1: Invalid username and password
            performNegativeLogin(driver, "invalid_user", "wrong_password");

            // Negative scenario 2: Valid username but invalid password
            performNegativeLogin(driver, "standard_user", "wrong_password");

            // Negative scenario 3: Invalid username but valid password
            performNegativeLogin(driver, "invalid_user", "secret_sauce");


            // Positive scenario: Successful login

            WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
            username.clear();
            username.sendKeys("standard_user");
            WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
            password.clear();
            password.sendKeys("secret_sauce");
            WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
            loginButton.click();

            // Wait for a brief moment to allow the next page to load
            Thread.sleep(2000);

            // Verify successful login by checking the title or a specific element
            WebElement message = driver.findElement(By.xpath("//span[@class='title']"));
            System.out.println("Login result message: " + message.getText());

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private static void performNegativeLogin(WebDriver driver, String username, String password) {
        // Navigate back to the login page for each negative scenario
        driver.navigate().to("https://www.saucedemo.com/");

        // Locate the username and password fields
        WebElement userField = driver.findElement(By.xpath("//input[@id='user-name']"));
        userField.clear();
        userField.sendKeys(username);

        WebElement passField = driver.findElement(By.xpath("//input[@id='password']"));
        passField.clear(); // Clear the field before entering a new value
        passField.sendKeys(password);

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        passField.clear();
        // Wait for a brief moment to allow the error message to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check for the error message
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3"));
        System.out.println("Login result message (negative scenario): " + errorMessage.getText());
    }
}
