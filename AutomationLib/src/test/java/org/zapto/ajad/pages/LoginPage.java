package org.zapto.ajad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Page
	{

		public LoginPage(WebDriver ParObjWebDriver)
			{
				super(ParObjWebDriver);

			}

		@FindBy(how = How.NAME, using = "UserName")
		@CacheLookup
		public WebElement UserName;

		@FindBy(how = How.NAME, using = "UserPassWord")
		@CacheLookup
		public WebElement PassWord;

		@FindBy(how = How.NAME, using = "Submit")
		@CacheLookup
		public WebElement Submit;

	}
