package com.mycompany.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ivan on 28.10.2017.
 */
public class AccountsPage extends BasePage {
    // Page Elements.
    @FindBy(id = "bAdd")
    public
    WebElement Create;

    @FindBy(id = "bEdit")
    public
    WebElement Edit;

    @FindBy(id = "bDelete")
    public
    WebElement Delete;

    private WebDriver driver;

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
