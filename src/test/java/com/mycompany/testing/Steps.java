package com.mycompany.testing;


import com.mycompany.testing.actions.FillFields;
import com.mycompany.testing.actions.Waits;
import com.mycompany.testing.pages.BasePage;
import com.mycompany.testing.pages.LoginPage;
import cucumber.api.java.en.When;


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
        loginPage.loginButton.click();
    }

    @Attachment()
    private byte[] createAttachment(String att) {
        String content = att;
        return content.getBytes();
    }


}
