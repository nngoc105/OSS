package com.autotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class baseTest {
        @BeforeMethod
        public void setupBrowser () {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

}