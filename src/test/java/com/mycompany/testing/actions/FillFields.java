package com.mycompany.testing.actions;

import com.mycompany.testing.pages.BasePage;
import org.openqa.selenium.WebElement;

/**
 * Created by Ivan on 01.11.2017.
 */
public class FillFields {

    public void fillField(WebElement element, String value)    {
        Waits waits = new Waits();
        waits.WaitElement(element);
        element.clear();
        waits.WaitElement(element);
        element.sendKeys(value);
    }
}
