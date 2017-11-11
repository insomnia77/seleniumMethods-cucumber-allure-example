package com.mycompany.testing.pages;

import com.mycompany.testing.actions.Waits;
import com.mycompany.testing.pages.BasePage;
import gherkin.lexer.Th;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Ivan on 28.10.2017.
 */
public class LoginPage extends BasePage {
    // Page Elements.
    @FindBy(xpath = "//*[@id='login-form']//span[text()='Username*']/following-sibling::input")
    public
    WebElement Username;

    @FindBy(xpath = "//*[@id='login-form']//span[text()='Password*']/following-sibling::input")
    public
    WebElement Password;

    @FindBy(xpath = "//*[@id='login-form']//button[text()='Login']")
    public
    WebElement loginButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver) throws Exception{
        this.driver = driver;
       Waits waits = new Waits();
        waits.waitForPageToLoad(driver);
        PageFactory.initElements(driver, this);
    }
}
