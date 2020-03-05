package com.herokuapp.testleaf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Panamera1 {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.porsche.com/usa/modelstart/");


    }
    @Test
    public void Panamera2(){

        driver.findElement(By.xpath("//nobr[.='Panamera']")).click();
        Common.sleep(1);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.xpath("(//label//nobr[.='Turismo'])[2]")).click();
        Common.sleep(1);
        List<WebElement> listOfCars = driver.findElements(By.xpath("//div[@class='m-14-model-tile visible']"));
        Common.sleep(1);

        listOfCars.get(1).click();
//        driver.findElement(By.xpath("(//div[@class='m-14-model-tile visible'])[2]")).click();



    }
    @AfterTest
    public void tearDown () {

         driver.quit();
    }
}
