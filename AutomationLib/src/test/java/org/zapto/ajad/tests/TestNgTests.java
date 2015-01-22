package org.zapto.ajad.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.asserts.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.*;
import org.testng.annotations.*;
import org.zapto.ajad.pages.*;

public class TestNgTests extends TestNgTestBase
	{
		protected TestNgTests() throws IOException
			{
				super();
				// TODO Auto-generated constructor stub
			}

		private HomePage homepage;
		private LoginPage loginpage;
		private UserHomePage userhomepage;

		@BeforeMethod
		public void initPageObjects()
			{
				homepage = PageFactory.initElements(ObjWebDriver,
						HomePage.class);
				loginpage = PageFactory.initElements(ObjWebDriver,
						LoginPage.class);
				userhomepage = PageFactory.initElements(ObjWebDriver,
						UserHomePage.class);

			}

		@Test(enabled = false)
		public void testHomePageHasAHeader()
			{
				ObjWebDriver.get(StrBaseUrl);
				Assert.assertFalse("".equals(homepage.header.getText()));
			}

		@Test(enabled = false)
		public void testLoginPage()
			{
				ObjWebDriver.get(StrLoginUrl);
				// Assert.assertFalse("".equals(loginpage.input.getText()));
				loginpage.UserName.sendKeys("username");
				loginpage.PassWord.sendKeys("password");
				loginpage.Submit.click();

			}

		@Test(enabled = false, dataProvider = "DataProvider")
		public void testLoginPageValidate(String UserName, String PassWord)
			{
				// Navigate to Login page and Login
				ObjWebDriver.get(StrLoginUrl);
				// loginpage.UserName.sendKeys("username");
				loginpage.UserName.sendKeys(UserName);
				loginpage.PassWord.sendKeys(PassWord);
				loginpage.Submit.click();

				// Go to UserHome page to Validate
				ObjWebDriver.get(StrUserHomeUrl);
				Assert.assertFalse("".equals(userhomepage.header.getText()));
				Assert.assertEquals("Welcome " + UserName, userhomepage.header
						.getText().toString(), "Pass");
			}

		@DataProvider
		public Object[][] DataProvider()
			{
				return new Object[][]
					{

					new Object[]
						{ "username", "password" }, new Object[]
						{ "advith", "advith" }, new Object[]
						{ "ajay", "ajay" }, };
			}

	}
