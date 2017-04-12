package com.SignUpPage;

import org.openqa.selenium.WebDriver;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;

public interface VerifySuccessInterface {
	public WebDriver WarningMessage() throws MyNoSuchElementException, MyFileNotFoundException;
}
