package step_definitions.support;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.lift.Matchers;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class SeleniumBase extends Matchers {

    public WebDriver driver = Hooks.driver;
    ObjectLib obj = new ObjectLib("C:/Workspace/Which_java/src/test/java/step_definitions/support/OR.properties");

    public void clickByXpath(String S) throws Exception {
        driver.findElement(obj.getLocator(S)).click();
    }

    public void clickbyClassName(String S) throws Exception {
        driver.findElement(obj.getLocator(S)).click();
    }

    public void clickbyId(String S) throws Exception {
        driver.findElement(obj.getLocator(S)).click();
    }

    public void clickbyCss(String S) throws Exception {
        driver.findElement(obj.getLocator(S)).click();
    }

    public void clickByLinkText(String S) throws Exception {
        driver.findElement(obj.getLocator(S)).click();
    }

    public void clickByPartLinkText(String S) throws Exception {
        driver.findElement(obj.getLocator(S)).click();
    }

    public void assertUrl(String S) throws Exception {

        try {
            assertEquals(driver.getCurrentUrl(), obj.readURLor(S));
            Report.pass(S + "Asserted");
        } catch (Exception e) {
            Report.fail(S + "Assertion failed");
        }

    }

    public void paginate(String a, String b)  throws Exception {
        {

            try {

                click(a);
                Thread.sleep(1000);
                assertUrl(b);
            } catch (Exception e) {

                Report.fail(b + "Assertion failed");
            }
        }
    }

    public void acceptAlertIfAvailable(long timeout)
    {
        long waitForAlert= System.currentTimeMillis() + timeout;
        boolean boolFound = false;
        do
        {
            try
            {
                Alert alert = this.driver.switchTo().alert();
                if (alert != null)
                {
                    alert.accept();
                    boolFound = true;
                }
            }
            catch (NoAlertPresentException ex) {}
        } while ((System.currentTimeMillis() < waitForAlert) && (!boolFound));
    }

    public void assertTitle(String TitleName) {
        try {
            assertEquals(driver.getTitle(), obj.readValue(TitleName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void WaitASecond() throws Exception {
        Thread.sleep(1000);
    }

    public void assertElePresentXpath(String Path) throws Exception {
        if (driver.findElement(obj.getLocator(Path)).isDisplayed()) {
            System.out.println("Element is present");
        }
    }

    public void textBoxInput(String path, String value) {
        try {
            driver.findElement(obj.getLocator(path)).clear();
            driver.findElement(obj.getLocator(path)).sendKeys(obj.readValue(value));
            Report.info("Sucessfully sent the" + value + " to textbox");
        } catch (Exception e) {
            Report.fail(e.getMessage());
            Assert.fail("Failed to send the" + value + " to textbox");
        }
    }


    public void click(String clicky) {
        try {
            driver.findElement(obj.getLocator(clicky)).click();
            Report.info("Sucessfully clicked on  " + clicky);
        } catch (Exception e) {
            Report.info(e.getMessage());
            Report.fail("failed to click on " + clicky);
        }
    }

    public void handleAlert() {

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

    }

    public String getaUrl() {
        String URL1 = driver.getCurrentUrl();
        return URL1;
    }

    public String getTittle() {
        String title = driver.getTitle();
        return title;
    }

    public String getTextee(String linkname) {
        String Text = null;
        try {
            Text = driver.findElement(obj.getLocator(linkname)).getText();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Text;
    }

    public void Selectdrpdown(String Object, String Value) {
        try {
            Select drp = new Select(driver.findElement(obj.getLocator(Object)));
            drp.selectByValue(Value);
            Report.info("Dropdown selection succesful");
        } catch (Exception e) {
            Report.fail(e.getMessage());
            Report.fail("dropdown selection not sucesful");
        }

    }

    public void mouseover(String moveFrom, String moveTo) throws Exception {

        Actions builder = new Actions(driver);
        WebElement we = driver.findElement(obj.getLocator(moveFrom));
        builder.moveToElement(we).perform();
        driver.findElement(obj.getLocator(moveTo)).click();

    }

    public void mouseoverIsElePresent(String moveFrom, String moveTo, String compare) throws Exception {

        Actions builder = new Actions(driver);
        WebElement we = driver.findElement(obj.getLocator(moveFrom));
        builder.moveToElement(we).perform();
        String ActualText = driver.findElement(obj.getLocator(moveTo)).getText();
        String ExpectedText = obj.readValue(compare);

        if (ExpectedText.equals(ActualText)) {
            Report.pass(compare + " String present in mouse over");
        }

    }


    public void radio(String Object) {
        try {
            driver.findElement(obj.getLocator(Object)).click();
            Report.info("Radio button action succesful");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Report.fail(e.getMessage());
            Assert.fail("Radio button action unsuccesful");
        }
    }

    public void EnablecheckBox(String path) throws Exception {
        try {

            //if (!driver.findElement(obj.getLocator(path)).isEnabled()) {
            driver.findElement(obj.getLocator(path)).click();
            Report.info("\nEnabled checkbox");
            //}

        } catch (Exception e) {
            // TODO Auto-generated catch block
            Report.fail(e.getMessage());
            Assert.fail("Look i Can't Enable the Checkbox");
        }

    }

    public void DisableCheckBox(String path) throws Exception {
        try {

            if (driver.findElement(obj.getLocator(path)).isEnabled()) {
                driver.findElement(obj.getLocator(path)).click();
                Report.info("\nDisabled checkbox");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            Report.fail(e.getMessage());
            Assert.fail("Checkbox still enabled");
        }

    }

    public boolean verifyElementPresent(String object) {
        try {
            driver.findElement(obj.getLocator(object));
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return false;
            //e.printStackTrace();
        }

    }

    public void verifyTextPresent(String object, String value) {
        try {
            String str = driver.findElement(obj.getLocator(object)).getText();
            if (str.contentEquals(value)) {
                Report.info("Sucessfully verified the text as equal");
            } else {
                Report.fail("Text mismatch found");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Report.fail("Element not found");
        }

    }


    protected boolean IsElementPresent(String objname) throws Exception {

        try {
            driver.findElement(obj.getLocator(objname));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    /**
     * getText method (objname = the object name from objectobj file)
     */
    public String GetText(String objname) throws Exception {
        return driver.findElement(obj.getLocator(objname)).getText();

    }

    /**
     * verifyTextPresent method (objname = the object name from objectobj file)
     */
    public void VerifyTextPresent(String string_to_compare, String objname) throws Exception {
        String actualText = "";
        try {
            actualText = GetText(objname);
            assertEquals(string_to_compare, actualText);
            Report.pass("The text '" + string_to_compare + "' is verified");
        } catch (Error e) {
            Report.fail("'" + objname + "' is not as expected and the acutal text is: " + actualText);

        }
    }

    /**
     * verifyTextContains method (objname = the object name from objectobj file)
     */
    public void VerifyTextContains(String string_to_compare, String objname) throws Exception {
        try {
            GetText(objname).contains(string_to_compare);
            Report.pass("The text '" + string_to_compare + "' is verified");
        } catch (Error e) {
            Report.fail("'" + objname + "' is not as expected");

        }
    }

    /**
     * waitForTitle method (time is in seconds)
     */

    public void WaitForElementPresent(String objname, int waitTimeinSec) throws Exception {
        for (int second = 0; ; second++) {
            if (second >= waitTimeinSec)
                Report.fail("timeout error: '" + objname + "' not present");
            try {
                if (driver.findElement(obj.getLocator(objname)).isDisplayed()) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
    }

    /**
     * selectTextFromDropdown method (objname = the object name from objectobj file)
     */
    public void SelectTextByVisibleText(String objname, String text) {
        try {
            Select droplist = new Select(driver.findElement(obj.getLocator(objname)));
            droplist.selectByVisibleText(text);


           /* WebElement select = driver.findElement(obj.getLocator(objname));
            Select dropDown = new Select(select);
            String selected = dropDown.getFirstSelectedOption().getText();
            if (selected.equals(text)) {//do stuff already selected}
                List<WebElement> Options = dropDown.getOptions();
                for (WebElement option : Options) {
                    if (option.getText().equals(text)) {
                        option.click();
                    }
                }
            }*/

                Report.info("text '" + text + "' is selected from the dropdown '" + objname + "'");
            }catch(Exception e){
                Report.info("'" + objname + "' is not present or text '" + text + "' is not selected");
                Assert.fail("'" + objname + "' is not present or text '" + text + "' is not selected");
            }

        }

        /**
         * SelectTextByIndex method (objname = the object name from objectobj file)
         **/

    public void SelectTextByIndex(String objname, int indexno) {
        try {

            Select select = new Select(driver.findElement(obj.getLocator(objname)));
            Report.info("dropdown '" + objname + "' is selected");
            select.selectByIndex(indexno);
            Report.info("text '" + indexno + "' is selected from the dropdown '" + objname + "'");
        } catch (Exception e) {
            Report.fail("'" + objname + "' is not present or text '" + indexno + "' is not selected");
            Assert.fail("'" + objname + "' is not present or text '" + indexno + "' is not selected");
        }

    }

    /**
     * SelectTextByValue method (objname = the object name from objectobj file)
     */
    public void SelectTextByIndex(String objname, String Value) {
        try {
            Select select = new Select(driver.findElement(obj.getLocator(objname)));
            Report.info("dropdown '" + objname + "' is selected");
            select.selectByValue(Value);
            Report.info("text '" + Value + "' is selected from the dropdown '" + objname + "'");
        } catch (Exception e) {
            Report.fail("'" + objname + "' is not present or text '" + Value + "' is not selected");
            Assert.fail("'" + objname + "' is not present or text '" + Value + "' is not selected");
        }

    }

    /**
     * Navigate method (objname = the url to navigate)
     */
    //URL navigation
    public void navigate(String URLname) {
        try {
            driver.navigate().to(obj.readURLor(URLname));
            Report.pass("Navigated to " + URLname);
        } catch (Exception e) {
            Report.fail("'" + URLname + "' is not present");
            Assert.fail("'" + URLname + "' is not present");
        }

    }



    public void addCookie(String name, String value) {
        Cookie ck = new Cookie("name", "value");
        driver.manage().addCookie(ck);


    }

    // I didnt create any profile manually in firefox browser. So waste to use this function
    /*
    public void myProfile()
    {

        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("SeleniumProfile");
        System.setProperty("webdriver.firefox.profile", "SeleniumProfile");
        WebDriver driver = new FirefoxDriver(myprofile);
    }*/

    public void openNewTab()

    {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
    }

    public void switchToTab() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
    }

    public void dynamicPageTitle(String partialTitle) throws Exception {
        Assert.assertTrue(driver.getTitle().contains(obj.readValue(partialTitle)));

    }

    public void isRadioChecked(String RadioLocation) throws Exception {
        boolean RadioBton = driver.findElement(obj.getLocator(RadioLocation)).isEnabled();

        if (RadioBton) {
            Report.info(" Radio button is enabled");
        } else
            Report.info(" Radio button is not enabled");


    }



}

