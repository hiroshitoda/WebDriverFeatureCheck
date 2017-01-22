package jp.selenium.sample.feature.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class GhostDriverFeatureTest extends Base
{
    @Override
    protected WebDriver getDriver() throws Exception
    {
        return new PhantomJSDriver();
    }
}
