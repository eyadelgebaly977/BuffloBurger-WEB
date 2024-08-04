package org.example.page.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public By homeLoginButton() {
        return By.xpath("//*[@id=\"__next\"]/div/div[1]/nav/div[4]/div[2]");
    }

    public WebElement loginSection() {
        return driver.findElement(By.id("full-width-tab-0"));
    }

    public WebElement mobileNumberField() {
        return driver.findElement(By.name("mobile_number"));
    }

    public WebElement passwordField() {
        return driver.findElement(By.name("password"));
    }

    public void loginData(String mobileNumber, String password) {
        mobileNumberField().clear();
        mobileNumberField().sendKeys(mobileNumber);
        passwordField().clear();
        passwordField().sendKeys(password);
    }

    public By loginButton() {
        return By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/button");
    }

    public WebElement welcomeMessage() {
        return driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/nav/div[4]/div/div/div/span"));
    }

    public By passwordErrorMessage() {
        return By.xpath("/html/body/div[1]/div/div[7]/div/div/div[1]/div");
    }

    public By phoneNumberErrorMessage() {
        return By.xpath("/html/body/div[1]/div/div[7]/div/div/div[1]");
    }

    public WebElement eyeIcon() {
        return driver.findElement(By.cssSelector("body > div.MuiModal-root.css-8ndowl > div.flex.justify-center.items-center.m-0.mx-auto.my-auto.relative.top-1\\/2.-translate-y-1\\/2.w-100\\%.min-w-\\[320px\\].h-\\[80\\%\\].max-h-\\[80\\%\\].bg-transparent.rounded-\\[20px\\].scroll-with-no-display.outline-none > div > div > div > div.w-full.rounded-b-\\[20px\\].bg-white > form > div.relative > div > svg > path"));
    }
}
