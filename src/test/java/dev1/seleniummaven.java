package dev1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class seleniummaven {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\shamalsystem\\shamalAutomation\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.saucedemo.com/");
//        System.out.println("Page title is: " + driver.getTitle());
//        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='About']")));
//        System.out.println("Page loaded and element found: " + element.getText());
//        driver.quit();
    try {
        driver.get("https://www.saucedemo.com/");
        System.out.println("WebPage title is : "+driver.getTitle());

        driver.manage().window().maximize();
        WebElement text = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        WebElement username= driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.className("title"));
        System.out.println("Login result message: " + message.getText());
        //negative scenario
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement invalidUsername = driver.findElement(By.xpath("//input[@id='user-name']"));
        invalidUsername.sendKeys("invalid_user"); // Invalid username
        WebElement invalidPassword = driver.findElement(By.xpath("//input[@id='password']"));
        invalidPassword.sendKeys("wrong_password"); // Invalid password
        WebElement invalidLoginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        invalidLoginButton.click();


        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3"));
        System.out.println("Login result message (negative scenario): " + errorMessage.getText());
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }
}


