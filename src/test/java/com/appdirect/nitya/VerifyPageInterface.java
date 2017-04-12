package com.appdirect.nitya;

import java.io.IOException;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyIOException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.ExceptionHandling.MyNullPointerException;

public interface VerifyPageInterface {
	public void openBrowser() throws IOException, MyNoSuchElementException, MyFileNotFoundException;
	public void HomePageTest() throws  MyNoSuchElementException, MyFileNotFoundException, MyNullPointerException;
	public void LoginPageTest() throws  MyNoSuchElementException, MyNullPointerException, MyFileNotFoundException;
	public void SignUpPageTest() throws MyNoSuchElementException, MyNullPointerException, MyFileNotFoundException, MyIOException;
	public void endTest();
}
