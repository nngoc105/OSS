package com.autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class job_creation {
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
        WebElement executeYear = driver.findElement(By.xpath("//*[@id=\"execute_month_year\"]"));
        Select selectYear = new Select(executeYear);
        selectYear.selectByIndex(1);

        WebElement executeMonth = driver.findElement(By.xpath("//*[@id=\"execute_month_month\"]"));
        Select selectMonth = new Select(executeMonth);
        selectMonth.selectByIndex(1);
        
        WebElement groupManager = driver.findElement(By.xpath("//*[@id=\"assignees\"]"));
        Select selectManager = new Select(groupManager);
        selectManager.selectByVisibleText("Tester Voy");

        //Add job
        driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[1]/div/div[10]/div[1]/a")).click();
        WebElement jobTemplate = driver.findElement(By.xpath("//*[@id=\"template_selection\"]"));
        Select selectTemplate = new Select(jobTemplate);
        selectTemplate.selectByIndex(9);
        driver.findElement(By.xpath("//*[@id=\"single-job-title\"]")).sendKeys("AJ - T9");
        //Set reflect time
        driver.findElement(By.xpath("//*[@id=\"single-job-basic-info\"]/div[2]/div[2]/div[3]/div/button")).click();
        //Set Product
        driver.findElement(By.xpath("//*[@id=\"single-job-basic-info\"]/div[4]/div[2]/div/div[2]/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"single-job-item-urls\"]")).sendKeys("mac200000");


        //Autocreate Task
        driver.findElement(By.xpath("//*[@id=\"single-job-basic-info\"]/div[7]/div[2]/div[3]/label/span")).click();

        //Create job
        driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[2]/div/div/button")).click();




    }
}