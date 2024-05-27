package com.autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import java.time.Duration;

import java.util.List;

public class loginShop {
    private WebDriver driver;
    @Test
    public void login() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Login Shop
        driver.navigate().to("https://management.oss-staging-maclogi.com");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@oss-maclogi.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("8CJIGZy693");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'ユーザー管理')]")));

        //Navigate to Project page
        driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();

        //Search Shop
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='keyword']"));
        searchBox.sendKeys("Voyager");
        searchBox.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[@title='Voyager']")).click();
        WebDriverWait shopLoading = new WebDriverWait(driver, Duration.ofSeconds(5));
        shopLoading.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='nav-link nav-item not-link'])[1]")));

        //Create Job Group
        driver.findElement(By.xpath("//a[@class='btn btn-info btn-info-custom px-lg-3']")).click();

        //Input form

        driver.findElement(By.xpath("//input[@id='job_group_title']")).sendKeys("Auto JG 1");
        WebElement executeMonth = driver.findElement(By.xpath("//div[@class='col-4']//span[@role='combobox']"));
        Select selectMonth = new Select(executeMonth);
        selectMonth.selectByIndex(1);

        WebElement executeDay = driver.findElement(By.xpath("(//span[@aria-expanded='true'])[1]"));
        Select selectDay = new Select(executeDay);
        selectDay.selectByIndex(1);
        
        //Close Window
        driver.quit();
    }
}