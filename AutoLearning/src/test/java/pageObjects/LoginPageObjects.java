package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.cssSelector;

public class LoginPageObjects {
    @FindBy(xpath = "//input[@id='email']")
    WebElement txt_email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement txt_password;

    @FindBy(xpath = "/html/body/div/div/div[2]/form/div[3]/button")
    WebElement btn_login;

    public LoginPageObjects(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void login(){
        txt_email.sendKeys("admin@oss-maclogi.com");
        txt_password.sendKeys("8CJIGZy693");
        btn_login.click();
    }
}
