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

    @FindBy(xpath = "//*[@name='employeeForm']//span[text()='Delete'] | //*[@id='bDelete']")
    public
    WebElement Delete;

    @FindBy(xpath = "//*[@name='employeeForm']//span[text()='First name:']/following-sibling::input")
    public
    WebElement First_name;

    @FindBy(xpath = "//*[@name='employeeForm']//span[text()='Last name:']/following-sibling::input")
    public
    WebElement Last_name;


    @FindBy(xpath = "//*[@name='employeeForm']//span[text()='Start date:']/following-sibling::input")
    public
    WebElement Start_date;

    @FindBy(xpath = "//*[@name='employeeForm']//span[text()='Email:']/following-sibling::input")
    public
    WebElement Email;

    @FindBy(xpath = "//*[@name='employeeForm']//span[text()='Add']")
    public
    WebElement Add;

    @FindBy(xpath = "//*[@name='employeeForm']//span[text()='Update']")
    public
    WebElement Update;



    private WebDriver driver;

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
