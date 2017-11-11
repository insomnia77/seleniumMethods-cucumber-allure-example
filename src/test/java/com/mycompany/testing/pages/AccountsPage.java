package com.mycompany.testing.pages;

import com.mycompany.testing.actions.FillFields;
import com.mycompany.testing.actions.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

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

   @FindBy(id = "employee-list")
   public
   WebElement employee_list;

 /*  @FindAll(@FindBy(xpath = "//*[@id='employee-list']/li"))
   List<WebElement> employees;*/



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

    public boolean IsEmployeePresent(String firstName, String lastName)
    {
        return employee_list.getText().contains(firstName + " " + lastName);
    }

    public void select(String firstName, String lastName) throws Exception
    {
        if(!IsEmployeePresent(firstName, lastName))
        {
            throw new Exception("There is not Employee");
        }

        List<WebElement> VisibleEmployees1 = driver.findElements(By.xpath("//*[@id='employee-list']/li"));
        List<WebElement> VisibleEmployees2 = null;

        while(VisibleEmployees1 != VisibleEmployees2) {
            VisibleEmployees1 = driver.findElements(By.xpath("//*[@id='employee-list']/li")).stream().filter(e -> e.isDisplayed()).collect(Collectors.toList());
            List<WebElement> EmployeeToSelect = VisibleEmployees1.stream().filter(e -> e.getText().equals(firstName + " " + lastName)).collect(Collectors.toList());
            if (EmployeeToSelect.size() > 0) {
                EmployeeToSelect.get(0).click();
                return;
            }
            else {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", VisibleEmployees1.get(VisibleEmployees1.size()));
            }
            VisibleEmployees2 = driver.findElements(By.xpath("//*[@id='employee-list']/li")).stream().filter(e -> e.isDisplayed()).collect(Collectors.toList());
        }
    }
}
