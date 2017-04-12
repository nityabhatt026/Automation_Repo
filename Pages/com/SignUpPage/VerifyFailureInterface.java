package com.SignUpPage;

import org.openqa.selenium.WebDriver;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;

public interface VerifyFailureInterface {
	public WebDriver verifySignupFail() throws MyNoSuchElementException, MyFileNotFoundException;
}
