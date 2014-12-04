package org.zapto.ajad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.zapto.ajad.pages.HomePage;
import org.zapto.ajad.pages.LoginPage;
import org.zapto.ajad.pages.UserHomePage;


public class HomePage extends Page{

	  @FindBy(how = How.TAG_NAME, using = "h1")
	  @CacheLookup
	  public WebElement header;

	public HomePage(WebDriver ParObjWebDriver) {
		super(ParObjWebDriver);
		// TODO Auto-generated constructor stub
	}
	

}
