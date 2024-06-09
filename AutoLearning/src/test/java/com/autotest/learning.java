package com.autotest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class learning {
    WebDriver driver;

    @Test
    public void multiWindow() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://facebook.com");
        String facebookWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://google.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!facebookWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        searchBox.sendKeys("hihi");
        searchBox.sendKeys(Keys.ENTER);
    }
}