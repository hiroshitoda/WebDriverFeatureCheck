package jp.selenium.sample.feature.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFeatureTest extends Base
{
    @Override
    protected WebDriver getDriver() throws Exception
    {
        return new ChromeDriver();
    }
}
