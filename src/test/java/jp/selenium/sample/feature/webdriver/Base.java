package jp.selenium.sample.feature.webdriver;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class Base
{
    protected Logger logger = Logger.getLogger(this.getClass().getName());;
    protected WebDriver driver;

    @Before
    public void setUp() throws Exception
    {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @Test
    public void testNavigatorWebDriver()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        Boolean navigatorWebDriver = (Boolean) javascriptExecutor.executeScript("return navigator.webdriver;");
        assertThat(navigatorWebDriver, is(true));
    }

    public void testScreenshot() throws Exception
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Files.write(bytes, new File("screenshot.png"));
    }
    
    public void testActionClick()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .click()
                .build();
        action.perform();
    }

    public void testActionClickWebElement()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .click(driver.findElement(By.id("reserve_year")))
                .build();
        action.perform();
    }

    public void testActionClickAndHold()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .clickAndHold()
                .build();
        action.perform();
    }

    public void testActionClickAndHoldWebElement()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .clickAndHold(driver.findElement(By.id("reserve_year")))
                .build();
        action.perform();
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }

    protected WebDriver getDriver() throws Exception
    {
        throw new Exception();
    }
}