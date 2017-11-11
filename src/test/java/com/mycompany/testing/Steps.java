package com.mycompany.testing;


import com.mycompany.testing.actions.Alerts;
import com.mycompany.testing.actions.FillFields;
import com.mycompany.testing.actions.Waits;
import com.mycompany.testing.pages.AccountsPage;
import com.mycompany.testing.pages.BasePage;
import com.mycompany.testing.pages.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * Created by Ivan on 28.10.2017.
 */
public class Steps {
    @When("^log in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void login(String username, String password) throws Throwable {
        BasePage basePage = new BasePage();
        basePage.startDriver();
        WebDriver driver = basePage.getDriver();
        driver.navigate().to(basePage.getSettingsProperties("LoginURL"));
        LoginPage loginPage = new LoginPage(driver);
        FillFields fillFields = new FillFields();
        fillFields.fillField(loginPage.Username, username);
        fillFields.fillField(loginPage.Password, password);
        Waits waits = new Waits();
        waits.WaitElement(loginPage.loginButton);
        loginPage.loginButton.click();
    }

    @When("^add employee with first name \"([^\"]*)\" and last name \"([^\"]*)\" and start date \"([^\"]*)\" and email \"([^\"]*)\"$")
    public void addEmployee(String firstName, String lastName, String startDate, String Email) throws Throwable {
        BasePage basePage = new BasePage();
        AccountsPage accountsPage = new AccountsPage(basePage.getDriver());
        Waits waits = new Waits();
        waits.WaitElement(accountsPage.Create);
        accountsPage.Create.click();
        waits.waitForPageToLoad(basePage.getDriver());
        accountsPage.edit(firstName, lastName, startDate, Email);
    }

    @When("^select employee with first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
    public void selectEmployee(String firstName, String lastName) throws Throwable {
        BasePage basePage = new BasePage();
        AccountsPage accountsPage = new AccountsPage(basePage.getDriver());
        accountsPage.select(firstName, lastName);
    }

    @When("^edit selected employee and set first name \"([^\"]*)\" and set last name \"([^\"]*)\" and set start date \"([^\"]*)\" and set email \"([^\"]*)\"$")
    public void editSelectedEmployee(String firstName, String lastName, String startDate, String Email) throws Throwable {
        BasePage basePage = new BasePage();
        AccountsPage accountsPage = new AccountsPage(basePage.getDriver());
        Waits waits = new Waits();
        waits.WaitElement(accountsPage.Edit);
        accountsPage.Edit.click();
        waits.waitForPageToLoad(basePage.getDriver());
        accountsPage.edit(firstName, lastName, startDate, Email);
    }

    @Then("^employee with first name \"([^\"]*)\" and last name \"([^\"]*)\" is present$")
    public void checkEmployeePresent(String firstName, String lastName) throws Throwable {
        BasePage basePage = new BasePage();
        AccountsPage accountsPage = new AccountsPage(basePage.getDriver());
        Assert.assertTrue(accountsPage.IsEmployeePresent(firstName, lastName));
    }


    @Then("^delete selected employee$")
    public void deleteSelectedEmployee() throws Throwable {
        BasePage basePage = new BasePage();
        AccountsPage accountsPage = new AccountsPage(basePage.getDriver());
        Waits waits = new Waits();
        waits.WaitElement(accountsPage.Delete);
        accountsPage.Delete.click();
        Alerts alerts = new Alerts();
        alerts.acceptAlert(basePage.getDriver());
    }

    @Then("^logout$")
    public void stepLogout() throws Throwable {
        BasePage basePage = new BasePage();
        basePage.logout();
    }

    @Attachment()
    private byte[] createAttachment(String att) {
        String content = att;
        return content.getBytes();
    }


}
