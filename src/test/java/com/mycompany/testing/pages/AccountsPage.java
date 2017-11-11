package com.mycompany.testing.pages;

import com.mycompany.testing.actions.FillFields;
import com.mycompany.testing.actions.Waits;
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

    @FindBy(xpath = "//*[@name='employeeForm']//button[contains(text(), Add) and not(contains(@class,'ng-hide'))] | //*[@name='employeeForm']//button[contains(text(), Update) and not(contains(@class,'ng-hide'))]")
    public
    WebElement Add_or_Update;



    private WebDriver driver;

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        Waits waits = new Waits();
        waits.waitForPageToLoad(driver);
        PageFactory.initElements(driver, this);
    }

    public void edit(String firstName, String lastName, String startDate, String Email) {
        FillFields fillFields = new FillFields();
        fillFields.fillField(First_name, firstName);
        fillFields.fillField(Last_name, lastName);
        fillFields.fillField(Start_date, startDate);
        fillFields.fillField(this.Email, Email);
        Waits waits = new Waits();
        waits.WaitElement(Add_or_Update);
        Add_or_Update.click();
    }

}
