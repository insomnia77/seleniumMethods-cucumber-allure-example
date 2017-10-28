package com.mycompany.testing.pages;

import com.mycompany.testing.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ivan on 28.10.2017.
 */
public class WelcomePage extends BasePage {
    // Page Elements.
    @FindBy(xpath = "//*[@resource-id='com.revolut.revolut.test:id/splash_logo']")
    public
    WebElement logo;

    @FindBy(xpath = "//*[@resource-id='com.revolut.revolut.test:id/next_button']")
    public
    WebElement nextButton;

    @FindBy(xpath = "//*[@resource-id='com.revolut.revolut.test:id/header_next']")
    public
    WebElement skipButton;

    @FindBy(xpath = "//*[@resource-id='com.revolut.revolut.test:id/uic_edit_phone_number']")
    WebElement phoneNumber;

    @FindBy(xpath = "//*[@resource-id='com.revolut.revolut.test:id/signup_next']")
    WebElement signupNextButton;

    private WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
