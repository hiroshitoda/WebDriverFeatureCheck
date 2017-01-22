package jp.selenium.sample.feature.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverFeatureTest extends Base
{
    @Override
    protected WebDriver getDriver() throws Exception
    {
        return new SafariDriver();
    }
}
