package step_definitions.support;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Hooks {

    int BROWSER = 2;

    public static WebDriver driver;


    @Before

    public void identifyBrowser() throws Exception {
        if (BROWSER == 1) {

            try {
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                driver = new FirefoxDriver(dc);
              /* DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("version", "39");
                capabilities.setCapability("platform", Platform.WIN8);
                //Create the connection to Sauce Labs to run the tests
                driver = new RemoteWebDriver(
                        new URL("http://nagapriyanka:00173860-928a-4f70-acba-d7ffb3835437@ondemand.saucelabs.com:80/wd/hub"), capabilities);*/
                Report.pass("firefox driver successfully opened");

            } catch (Exception e) {

                Report.fail("chrome Browser failed to open");
            }

        } else {
            if (BROWSER == 2) {

                try {
                   System.setProperty("webdriver.chrome.driver", "C:/Workspace/Which_java/src/SeleniumDrivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    Report.pass("Chrome driver successfully opened");
                } catch (Exception e) {
                    Report.fail("Chrome browser failed to open");
                }


            } else if (BROWSER == 3) {

                try {
                    System.setProperty("webdriver.ie.driver", "C:/Periscopix_AcceptanceTests/Peris_GA_Java_Cucumber_Maven_Auto/src/SeleniumDrivers/IEDriverServer.exe");
                    DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                    caps.setCapability(InternetExplorerDriver.
                            INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    caps.setCapability("ignoreZoomSetting", true);
                    driver = new InternetExplorerDriver(caps);
                    Report.pass("InternetExplorer driver successfully opened");
                } catch (Exception e) {
                    Report.fail("Internet Explorer failed to open");
                }

            }
            else {

                driver = new HtmlUnitDriver();
                Report.pass("HTML driver successfully opened");
            }
        }
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        Report.pass("Driver closed succesfully");
        driver.quit();

    }

}