package org.zapto.ajad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserHomePage extends Page{
	
	@FindBy(how = How.XPATH, using = "//body/h2[2]")
	@CacheLookup
	public WebElement header;

	public UserHomePage(WebDriver webDriver) {
		  
	  super(webDriver);
	  
	}
	  

}
