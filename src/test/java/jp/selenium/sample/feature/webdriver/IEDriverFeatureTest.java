package jp.selenium.sample.feature.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverFeatureTest extends Base
{
    @Override
    protected WebDriver getDriver() throws Exception
    {
        return new InternetExplorerDriver();
    }
}
