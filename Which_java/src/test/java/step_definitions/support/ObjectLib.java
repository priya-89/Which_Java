package step_definitions.support;


import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectLib {

    Properties properties;

    public ObjectLib(String mapFile) {
        properties = new Properties();
        try {
            FileInputStream in = new FileInputStream(mapFile);
            properties.load(in);
            in.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public By getLocator(String logicalElementName) throws Exception {
        // Read value using the logical name as Key
        String locator = properties.getProperty(logicalElementName);

        // Split the value which contains locator type and locator value
        String locatorType = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];

        // Return a instance of By class based on type of locator
        if (locatorType.toLowerCase().equals("id"))
            return By.id(locatorValue);
        else if (locatorType.toLowerCase().equals("name"))
            return By.name(locatorValue);
        else if ((locatorType.toLowerCase().equals("classname"))
                || (locatorType.toLowerCase().equals("class")))
            return By.className(locatorValue);
        else if ((locatorType.toLowerCase().equals("tagname"))
                || (locatorType.toLowerCase().equals("tag")))
            return By.tagName(locatorValue);
        else if ((locatorType.toLowerCase().equals("linktext"))
                || (locatorType.toLowerCase().equals("link")))
            return By.linkText(locatorValue);
        else if (locatorType.toLowerCase().equals("partiallinktext"))
            return By.partialLinkText(locatorValue);
        else if ((locatorType.toLowerCase().equals("cssselector"))
                || (locatorType.toLowerCase().equals("css")))
            return By.cssSelector(locatorValue);
        else if (locatorType.toLowerCase().equals("xpath"))
            return By.xpath(locatorValue);

        else
            throw new Exception("Locator type '" + locatorType + "'is not defined!!");
    }

    public String readURLor(String URLidentity) throws Exception {

        String locator = properties.getProperty(URLidentity);

        // Split the value which contains locator type and locator value
        String URLType = locator.split(">")[0];
        String URLvalue = locator.split(">")[1];

        if (URLType.toLowerCase().equals("url"))
            return URLvalue;
        else
            throw new Exception("URL Type '" + URLType + "'is not defined in OR file!!");
    }

    public String readValue(String valueIdentity) throws Exception{

        String locator = properties.getProperty(valueIdentity);

        // Split the value which contains value type and actual value
        String ValueType = locator.split(">")[0];
        String ActualValue = locator.split(">")[1];

        if (ValueType.toLowerCase().equals("value"))
            return ActualValue;
        else
            throw new Exception("Value Type '" + ValueType + "'is not defined in OR file!!");


    }

}

