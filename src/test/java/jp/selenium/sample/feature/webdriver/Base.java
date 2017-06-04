package jp.selenium.sample.feature.webdriver;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class Base
{
    protected Logger logger = Logger.getLogger(this.getClass().getName());;
    protected static WebDriver driver;

    protected By byReserveYear = By.id("reserve_year");
    protected By byReserveMonth = By.id("reserve_month");

    @BeforeClass
    public static void setUpBeforeClass()
    {
        driver = null;
    }

    @Before
    public void setUp() throws Exception
    {
        if (driver == null)
        {
            driver = getDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @Test
    public void testNavigatorWebDriver()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        Boolean navigatorWebDriver = (Boolean) javascriptExecutor.executeScript("return navigator.webdriver;");
        assertThat(navigatorWebDriver, is(true));
    }

    @Test
    public void testScreenshot() throws Exception
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Files.write(bytes, new File("screenshot.png"));
    }

    @Test
    public void testActionClick()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .click()
                .build();
        action.perform();
    }

    @Test
    public void testActionClickWebElement()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .click(driver.findElement(byReserveYear))
                .build();
        action.perform();
    }

    @Test
    public void testActionClickAndHold()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .clickAndHold()
                .build();
        action.perform();
    }

    @Test
    public void testActionClickAndHoldWebElement()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .clickAndHold(driver.findElement(byReserveYear))
                .build();
        action.perform();
    }

    @Test
    public void testContextClick()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .contextClick()
                .build();
        action.perform();
    }

    @Test
    public void testContextClickWebElement()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .contextClick(driver.findElement(byReserveYear))
                .build();
        action.perform();
    }

    @Test
    public void testDoubleClick()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .doubleClick()
                .build();
        action.perform();
    }

    @Test
    public void testDoubleClickWebElement()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .doubleClick(driver.findElement(byReserveYear))
                .build();
        action.perform();
    }

    @Test
    public void testDragAndDrop()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .dragAndDrop(driver.findElement(byReserveYear), driver.findElement(byReserveMonth))
                .build();
        action.perform();
    }

    @Test
    public void testDragAndDropBy()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .dragAndDropBy(driver.findElement(byReserveYear), 30, 15)
                .build();
        action.perform();
    }

    @Test
    public void testKeyDown()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .keyDown(Keys.ALT)
                .build();
        action.perform();
    }

    @Test
    public void testKeyDownWebElement()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .keyDown(driver.findElement(byReserveYear), Keys.ALT)
                .build();
        action.perform();
    }

    @Test
    public void testKeyUp()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .keyUp(Keys.ALT)
                .build();
        action.perform();
    }

    @Test
    public void testKeyUpWebElement()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .keyUp(driver.findElement(byReserveYear), Keys.ALT)
                .build();
        action.perform();
    }

    @Test
    public void testMoveByOffset()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .moveByOffset(200, 75)
                .build();
        action.perform();
    }

    @Test
    public void testMoveToElement()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .moveToElement(driver.findElement(byReserveYear))
                .build();
        action.perform();
    }

    @Test
    public void testMoveToElementOffset()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .moveToElement(driver.findElement(byReserveYear), 200, 75)
                .build();
        action.perform();
    }

    @Test
    public void testPause()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        java.time.Duration duration = java.time.Duration.ofMillis(1000);
        Action action = new Actions(driver)
                .pause(duration)
                .build();
        action.perform();
    }

    @Test
    public void testRelease()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .release()
                .build();
        action.perform();
    }

    @Test
    public void testReleaseWebElement()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .release(driver.findElement(byReserveYear))
                .build();
        action.perform();
    }

    @Test
    public void testSendKeys()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .sendKeys(Keys.ALT)
                .build();
        action.perform();
    }

    @Test
    public void testSendKeysWebElement()
    {
        driver.get("http://example.selenium.jp/reserveApp/");
        Action action = new Actions(driver)
                .sendKeys(driver.findElement(byReserveYear), Keys.ALT)
                .build();
        action.perform();
    }

    @Test
    public void testTick()
    {
        fail("no test.");
    }

    @Test
    public void testTickInteractions()
    {
        fail("no test.");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
        driver.quit();
    }

    protected WebDriver getDriver() throws Exception
    {
        throw new Exception();
    }
}