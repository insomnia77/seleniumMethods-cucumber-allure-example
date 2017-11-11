package com.mycompany.testing.actions;

import com.mycompany.testing.pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ivan on 11.11.2017.
 */
public class Alerts {

    public void acceptAlert(WebDriver driver) throws Exception
    {
        Alert alert;
        Waits waits = new Waits();
        BasePage basePage = new BasePage();
        int huge_wait = Integer.valueOf(basePage.getSettingsProperties("huge_wait"));
        long startTime = waits.Now();
        while (!(((waits.Now() - startTime) / 1000) > huge_wait)) {
            try {
                alert = driver.switchTo().alert();
                alert.accept();
            } catch (NoAlertPresentException noAlert) {
                System.out.println("Alert accepted");
                break;
            } catch (Exception e) {
               throw new Exception("Alert not accepted");
            }
            double pollingTime = Double.valueOf(basePage.getSettingsProperties("pollingTime"));
            waits.WaitPollingTime(pollingTime);
        }
        waits.waitForPageToLoad(driver);
    }

}
