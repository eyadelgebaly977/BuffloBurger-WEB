package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page.Login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StepLogin {
    WebDriver driver;
    LoginPage login;
    SoftAssert soft;
    WebDriverWait wait;
    public StepLogin() {
        driver = Hooks.getDriver();
        login = new LoginPage(driver);
        soft = new SoftAssert();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("User Navigate to login pop-up")
    public void loginPop() {
        driver.findElement(login.homeLoginButton()).click();
    }

    @Then("User make sure that the current section is the login section")
    public void loginSection() {
        String expectedColor = "rgb(255, 95, 0)";
        String actualColor = login.loginSection().getCssValue("color");
        soft.assertEquals(actualColor, expectedColor, "Login section is not the current section");
    }

    @And("^user enter mobile number \"(.*)\" and password \"(.*)\"$")
    public void Data_mobileNo_pass(String mobileNumber, String password) {
        login.loginData(mobileNumber, password);
    }

    @When("user press login button")
    public void loginButton() {
        driver.findElement(login.loginButton()).click();
    }

    @Then("User is logged in and welcome message with the name appears in the top right of the screen")
    public void enter_the_system() {
        Hooks.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String expectedData = "Hello, Eyad Sherif Elgebaly";
        String actualData = login.welcomeMessage().getText();
        soft.assertEquals(actualData, expectedData, "User Not Logged In");
    }

    @Then("error message appears about the invalid password")
    public void invalid_password() {
        WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(login.passwordErrorMessage()));
        String actualMessage = passwordError.getText();
        String expectedMessage = "Mobile number not found";
        soft.assertTrue(actualMessage.contains(expectedMessage),"Wrong Password Error message appears");
    }

    @Then("error message appears about the invalid phone number")
    public void invalid_phoneNumber() {
        WebElement phoneNumberError = wait.until(ExpectedConditions.visibilityOfElementLocated(login.phoneNumberErrorMessage()));
        String actualMessage = phoneNumberError.getText();
        String expectedMessage = "Mobile number not found";
        soft.assertTrue(actualMessage.contains(expectedMessage), "Wrong Phone Number Error message appears");
    }

    @Then("error message appears about the invalid phone number first")
    public void invalid_email_and_password() {
        WebElement phoneNumberError = wait.until(ExpectedConditions.visibilityOfElementLocated(login.phoneNumberErrorMessage()));
        String actualMessage = phoneNumberError.getText();
        String expectedMessage = "Mobile number not found";
        soft.assertTrue(actualMessage.contains(expectedMessage), "Wrong Check first occurs");
    }

    @When("when user press eye icon")
    public void show_entered_password() {
        login.passwordField().click();
        login.eyeIcon().click();
    }

    @Then("the entered password should appears")
    public void show_password() {
        String expectedData = "Eyad123@";
        String actualData = login.passwordField().getText();
        soft.assertEquals(actualData, expectedData, "The Password didn't appear");
    }
}
