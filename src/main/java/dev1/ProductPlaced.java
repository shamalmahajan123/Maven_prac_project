package dev1;


import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils; // For saving the screenshot
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ProductPlaced {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeEach
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\shamalsystem\\shamalAutomation\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/"); // Navigate to the application
        Thread.sleep(2000);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void addProductToCartTest() throws InterruptedException {
        // Log in (if required)
        // Implement login logic if needed
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        takeScreenshot("screenshot_after_login");
        driver.findElement(By.id("login-button")).click();
        // Verify the title
        Thread.sleep(2000);  // This pauses for 2 seconds

        String title = driver.getTitle();
        assertEquals("Swag Labs", title);
        if (driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed()) {
            System.out.println("Products are present");
            takeScreenshot("screenshot_after_main_page");
        } else {
            System.out.println("No products found");
            return; // Exit the test if no products are present
        }

        // Click on the product to add to cart
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
        long startTime = System.currentTimeMillis();
        // Verify the product price
        String price = driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText();
        assertEquals("$29.99", price); // Replace with actual expected price
        takeScreenshot("verify_product_placed");
        Thread.sleep(2000);
        /* Click the "Add to Cart" button */
         driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
        // Navigate to the cart
        System.out.println("Checking cart");
        if (driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed()) {
            driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
            Thread.sleep(2000);
            takeScreenshot("checked_cart_link");
        } else {
            System.out.println("Cart icon not found");
        }

        // Proceed to checkout
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Thread.sleep(2000);
        System.out.println("checked out the item");
        takeScreenshot("screenshot_after_checkout");
        checkout();
        finish();
    }

    public void takeScreenshot(String fileName) {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\shamalsystem\\shamalAutomation\\SelMavenProject\\src\\main\\java\\screenshots\\" + fileName + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void checkout() throws InterruptedException {
        if(driver.findElement(By.id("first-name")).isDisplayed()){
        driver.findElement(By.id("first-name")).sendKeys("shawn");
        driver.findElement(By.id("last-name")).sendKeys("secret_sauce");
        driver.findElement(By.id("postal-code")).sendKeys("420014");
        Thread.sleep(2000);
        takeScreenshot("checkout_info");
        driver.findElement(By.id("continue")).click();
    }}

//    @Test
    public void finish()throws InterruptedException{
        if(driver.findElement(By.xpath("//span[text()='Checkout: Overview']")).isDisplayed()){
            takeScreenshot("Page_finish_Screenshot");
            Thread.sleep(2000);
        }
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        takeScreenshot("Page_finish_Screenshot");
        Thread.sleep(2000);
        takeScreenshot("back_To_product");
        driver.findElement(By.id("back-to-products")).click();
    }
}
