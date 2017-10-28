package com.mycompany.testing.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

/**
 * Created by Ivan on 28.10.2017.
 */
public class BasePage {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public void startDriver() {
        String pathToApp = "A:\\revolut_project\\Revolut_qa_4.3.0.237.apk";
        File app = new File(pathToApp);
        if (app.exists() && !app.isDirectory()) {
            System.out.println("APK присутствует");
        } else {
            System.out.println(pathToApp);
            System.out.println("APK не найдено");        }
        String platformVersion = "4.3.1";
        String deviceName = "test_nexus";
        String appiumUrl = "http://127.0.0.1:4725/wd/hub";
        Boolean unicodeKeyboard = true;
        String browserName = "";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (unicodeKeyboard.equals(true)) {
            capabilities.setCapability("unicodeKeyboard", true);
            capabilities.setCapability("resetKeyboard", true);
        } else {
            capabilities.setCapability("unicodeKeyboard", false);       }
        capabilities.setCapability(MobileCapabilityType.APP, pathToApp);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability("appPackage", "com.revolut.revolut.test");
        try {
            driver = new AndroidDriver(new URL(appiumUrl), capabilities);
            // todo убрать потом
            Thread.sleep(8000);

        } catch (Exception ex) {
            System.out.println("не удалось запустить андроид");
            System.out.println(ex.fillInStackTrace().toString());
        }

    }
}
