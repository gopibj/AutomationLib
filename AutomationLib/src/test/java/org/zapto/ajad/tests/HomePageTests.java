package org.zapto.ajad.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.zapto.ajad.pages.HomePage;
import org.zapto.ajad.pages.LoginPage;
import org.zapto.ajad.pages.UserHomePage;

public class HomePageTests extends TestNgTestBase
	{
		protected HomePageTests() throws IOException
			{
				super();
				// TODO Auto-generated constructor stub
			}

		private HomePage ObjHomePage;
		private LoginPage ObjLoginPage;
		private UserHomePage ObjUserHomePage;

		@BeforeMethod
		public void InitPageObjects()
			{
				ObjHomePage = PageFactory.initElements(ObjWebDriver,
						HomePage.class);
				ObjLoginPage = PageFactory.initElements(ObjWebDriver,
						LoginPage.class);
				ObjUserHomePage = PageFactory.initElements(ObjWebDriver,
						UserHomePage.class);

			}

		// Navigational ops
		public void InitDriverHomePage()
			{
				ObjWebDriver.get(StrHomeUrl);
			}

		public void InitDriverLoginPage()
			{
				ObjWebDriver.get(StrLoginUrl);
			}

		public void InitDriverUserHomeUrl()
			{
				ObjWebDriver.get(StrUserHomeUrl);
			}

		// Asserts
		public void AssertFalseHomePageHasHeader()
			{
				Assert.assertFalse("".equals(ObjHomePage.header.getText()));

			}

		// Tests
		@Test
		public void TestHomePageHasHeader()
			{
				this.InitDriverHomePage();
				this.AssertFalseHomePageHasHeader();

			}
	}
