package com.appdirect.nitya.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.LoginPage.LoginPage;
import com.PageChecker.LoginPageChecker;

public class WaitClass implements WaitClassInterface{
	
	private static final TimeUnit SECONDS = null;
	WebDriver driver;
	WebDriverWait wait;
	
	public WaitClass(WebDriver driver){
		this.driver = driver;
	}
	
public void explicitWait(String path,WebDriver driver){

	 WebDriverWait wait = new WebDriverWait(driver, 20);
	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
	
}
public WebDriver Wait(){
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 return driver;
}
public WebDriver pageLoadTimeout(){
driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
return driver;
}

public WebDriver waitVisibilityConditionByXpath(String Xpath,WebDriver driver) {
    wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
    return driver;
}


public WebDriver waitVisibilityConditionByCss(String css,WebDriver driver) {
    wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
    return driver;
}


}