package com.mycompany.testing.actions;
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

    public void WaitPollingTime(double pollingTime) {
        try {Thread.sleep((int)(pollingTime*1000));} catch(InterruptedException interrupt) { System.out.println("thread problem" + interrupt);}
    }

    public long Now() {
        return new Date().getTime();
    }

}
