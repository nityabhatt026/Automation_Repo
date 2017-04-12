package com.PageChecker;

import org.testng.Reporter;

public class BrowserChecker implements BrowserCheckerInterface{
public void browserCheck(String browser){
	if(browser==null){
		Reporter.log("Browser not Found",true);
		throw new NullPointerException("Null Pointer Exception");	
	}
	else{
		Reporter.log("Browser Found",true);
	}
}
}
