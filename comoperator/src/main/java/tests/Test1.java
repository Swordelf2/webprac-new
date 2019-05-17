package tests;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Random;

public class Test1 {
    public String baseUrl = "http://localhost:8080/comoperator_war_exploded/";
    String driverPath = "/usr/bin/geckodriver";
    public WebDriver driver ;

    @BeforeTest
    public void launchBrowser()
    {
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
    }
    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }

    @Test
    public void test1()
    {
        driver.get(baseUrl + "/index");
        driver.findElement(By.linkText("Клиенты")).click();
        WebElement elem = driver.findElement(By.name("name"));
        elem.sendKeys("Горбунов");
        driver.findElement(By.cssSelector("input[type='submit'")).click();
        List<WebElement> elems = driver.findElements(By.tagName("td"));
        Assert.assertEquals(elems.get(0).getText(), "3");
        Assert.assertEquals(elems.get(2).getText(), "Горбунов Виталий Петрович");
    }

    @Test
    public void test2()
    {
        driver.get(baseUrl + "/client?id=1");
        driver.findElement(By.linkText("Счет")).click();
        List<WebElement> elems = driver.findElements(By.tagName("td"));
        Assert.assertEquals(elems.get(10).getText(), "2019-02-26 15:05:00.0");
        Assert.assertEquals(elems.get(11).getText(), "100.00");
    }

    @Test
    public void test3()
    {
        driver.get(baseUrl + "/client?id=2");
        driver.findElement(By.linkText("История услуг")).click();
        driver.findElement(By.linkText("Регистрация договора об оказании услуги")).click();
        List<WebElement> elems = driver.findElements(By.tagName("input"));
        elems.get(1).sendKeys("1");
        Random random = new Random();
        String number = new String();
        for (int i = 0; i < 10; ++i) {
            number += random.nextInt(10);
        }
        String timeStart = "2019-01-01 18:00:00";
        String timeEnd = "2019-01-01 19:00:00";
        elems.get(2).sendKeys(number);
        elems.get(3).sendKeys(timeStart);
        elems.get(4).sendKeys(timeEnd);
        driver.findElement(By.tagName("button")).click();

        driver.get(baseUrl + "/serviceHistory?id=2");

        elems = driver.findElements(By.tagName("input"));
        elems.get(1).sendKeys(timeStart);
        elems.get(2).sendKeys(timeEnd);
        elems.get(3).click();

        elems = driver.findElements(By.tagName("td"));
        Assert.assertEquals(elems.get(4).getText(), number);
    }

    @Test
    public void test4()
    {
        driver.get(baseUrl + "/index");
        driver.findElement(By.linkText("Регистрация поступления на счет")).click();
        List<WebElement> elems = driver.findElements(By.tagName("input"));
        elems.get(0).sendKeys("1");
        elems.get(1).sendKeys("150");
        elems.get(2).sendKeys("2019-02-02 15:00:00");
        driver.findElement(By.tagName("button")).click();
    }

    @Test
    public void test5()
    {
        driver.get(baseUrl + "/clientList");
        driver.findElement(By.linkText("Info")).click();
        List<WebElement> elems = driver.findElements(By.tagName("td"));
        Assert.assertEquals(elems.get(3).getText(), "I");

        driver.findElement(By.linkText("Редактировать")).click();
        WebElement elem = driver.findElement(By.cssSelector("input[name='name"));
        elem.clear();
        elem.sendKeys("Архипова Любовь Владимировна");
        driver.findElement(By.tagName("button")).click();

        driver.get(baseUrl + "/client?id=1");
        elems = driver.findElements(By.tagName("td"));
        Assert.assertEquals(elems.get(5).getText(), "Архипова Любовь Владимировна");
    }
}
