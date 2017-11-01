package com.mycompany.testing.actions;

import com.mycompany.testing.pages.BasePage;
import org.openqa.selenium.WebElement;

/**
 * Created by Ivan on 01.11.2017.
 */
public class FillFields {

    public void fillField(WebElement element, String value)    {
        BasePage basePage = new BasePage();
        int med_wait = Integer.valueOf(basePage.getSettingsProperties("medium_wait"));
        int pollingTime = Integer.valueOf(basePage.getSettingsProperties("pollingTime"));
        Waits waits = new Waits();
        waits.WaitElement(element, med_wait, pollingTime);
        element.clear();
        waits.WaitElement(element, med_wait, pollingTime);
        element.sendKeys(value);
    }
}
