package com.mycompany.testing.pages;


import com.mycompany.testing.actions.Waits;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by Ivan on 28.10.2017.
 */
public class BasePage {
    private static WebDriver driver;
    private static Properties prop = null;

    @FindBy(xpath = "//header//p[text()='Logout']")
    public
    WebElement Logout;

    public static WebDriver getDriver() {
        return driver;
    }

    public void startDriver() {
        if(driver != null)
        {
            driver.close();
        }
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        }
        ChromeDriverService service = ChromeDriverService.createDefaultService();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("multiple-automatic-downloads", 1);
        chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.default_directory", getSettingsProperties("PathToDownLoad"));
        chromePrefs.put("perfLoggingPrefs", true);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(service, options);
    }

    public static String getSettingsProperties(String Variable) {
        if (prop != null) {
            return prop.getProperty(Variable,"");
        }
        prop = new Properties();
        String propFile = "AutoTest.properties";
        try {
            FileInputStream fis = new FileInputStream(propFile);
            InputStreamReader reader = new InputStreamReader(fis,"UTF8");
            prop.load(reader);
        } catch (IOException e) {
            System.err.println("TestSetPath.properties not found!");

            e.printStackTrace();
        }
        String res = null;
        res = prop.getProperty(Variable,"");
        return res;
    }

  public void logout()
  {
      PageFactory.initElements(driver, this);
      Waits waits = new Waits();
      waits.WaitElement(Logout);
      Logout.click();
      driver.close();
      driver = null;
  }



}
