package com.mycompany.testing.actions;
import com.mycompany.testing.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Date;


/**
 * Created by Ivan on 01.11.2017.
 */
public class Waits {


    public void  WaitElement(WebElement element, int timeout, double pollingTime) {
        long startTime = Now();
        while (((Now() - startTime) / 1000) < timeout) {
            if (element.isEnabled()) {
              break;
            }
            WaitPollingTime(pollingTime);
        }
    }

    public void  WaitElement(WebElement element) {
        BasePage basePage = new BasePage();
        int med_wait = Integer.valueOf(basePage.getSettingsProperties("medium_wait"));
        double pollingTime = Double.valueOf(basePage.getSettingsProperties("pollingTime"));
        WaitElement(element, med_wait, pollingTime);
    }

    public void WaitPollingTime(double pollingTime) {
        try {Thread.sleep((int)(pollingTime*1000));} catch(InterruptedException interrupt) { System.out.println("thread problem" + interrupt);}
    }

    public long Now() {
        return new Date().getTime();
    }

    public  void waitForPageToLoad(WebDriver driver) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        long startTime = Now();
        while (!((Now() - startTime) > 20000)) {
            WaitPollingTime(5);
            if (jsExec.executeScript("return document.readyState").equals("complete")) {
                break;
            }
        }
    }

}
