package com.porsche;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Panamera {
   private WebDriver driver;
   
   @BeforeTest
   public void setUp () {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   }

   @Test
   public void test1() {
	   driver.get("https://www.porsche.com/usa/modelstart/");
	   driver.findElement(By.xpath("//img[@alt='Porsche - Panamera']")).click();
	   
	   JavascriptExecutor jse=(JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,250)");
		 
	   
	WebElement waitForFilter=driver.findElement(By.xpath("//button[@class='m-14-filter-overlay-button gui-btn"));
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(waitForFilter));
	waitForFilter.click();
		
	  
	  
	   
	  WebElement panameraButton=driver.findElement(By.className("m-14-filter-checkbox checked"));
	  boolean isSelectedPanamera=panameraButton.isSelected();
	  System.out.println(isSelectedPanamera);
	   
	  WebElement sportTurismo=driver.findElement(By.xpath("//span[contains(text(),'Sport ')]"));
	  boolean isSelectedSportPanamera=sportTurismo.isSelected();
	  System.out.println(isSelectedSportPanamera);
	  
	  
	  
}
   
   
   @AfterTest
   public void tearDown () {
       driver.quit();
   }
}
   
   
