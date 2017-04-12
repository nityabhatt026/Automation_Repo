package com.appdirect.nitya.utils;

import org.openqa.selenium.WebDriver;

public interface WaitClassInterface {
	public void explicitWait(String path,WebDriver driver);
	public WebDriver Wait();
	public WebDriver pageLoadTimeout();
	public WebDriver waitVisibilityConditionByXpath(String Xpath,WebDriver driver);
	public WebDriver waitVisibilityConditionByCss(String css,WebDriver driver);
}
