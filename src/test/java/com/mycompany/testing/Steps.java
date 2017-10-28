package com.mycompany.testing;


import com.mycompany.testing.pages.BasePage;
import com.mycompany.testing.pages.WelcomePage;
import cucumber.api.java.ru.Когда;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * Created by Ivan on 28.10.2017.
 */
public class Steps {
    @Когда("^авторизован пользователь с телефонным номером \"([^\"]*)\" и пинкодом \"([^\"]*)\"$")
    public void login(String telNum, String pincode) throws Throwable {
        BasePage basePage = new BasePage();
        basePage.startDriver();
        WebDriver driver = basePage.getDriver();
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.logo.click();
        welcomePage.nextButton.click();
        welcomePage.skipButton.click();
    }

    @Attachment()
    private byte[] createAttachment(String att) {
        String content = att;
        return content.getBytes();
    }


}
