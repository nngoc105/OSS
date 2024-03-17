package com.autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginShop extends baseTest {
    WebDriver driver;
    @Test
    public void login() {
        driver.navigate().to("https://management.oss-staging-maclogi.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@oss-maclogi.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("8CJIGZy693");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'ユーザー管理')]")));
    }
    @Test
    public void openShop() throws InterruptedException {
        driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();
        driver.findElement(By.xpath("//div[@title='Voyager']")).click();
    }
}
