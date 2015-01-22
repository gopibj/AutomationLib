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
import org.zapto.ajad.utils.FileOps;
import org.zapto.ajad.utils.StringOps;

public class LoginPageTests extends TestNgTestBase
	{

		protected LoginPageTests() throws IOException
			{
				super();
				// TODO Auto-generated constructor stub
			}

		private HomePage ObjHomePage;
		private LoginPage ObjLoginPage;
		private UserHomePage ObjUserHomePage;

		// Initialize Page WebElements using page factory
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

		// Navigational ops PageLoad
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

		// Data Ops
		@DataProvider
		public Object[][] DataProvider()
			{

				// An int array table data 1X1
				// int ArrInt[] = new int[]{1,
				// 2};

				// Defining the 2d "Array" of type object to hold 1X2 Table data
				Object ObjArrRow1[] = new Object[]
					{ "username", "password" };
				Object ObjArrRow2[] = new Object[]
					{ "ajay", "ajay" };
				Object ObjArrRow3[] = new Object[]
					{ "advith", "advith" };

				Object[][] ObjectArrCol1 = new Object[][]
					{ ObjArrRow1, ObjArrRow2, ObjArrRow3 };

				// Return 2d Arr
				return ObjectArrCol1;

			}

		@DataProvider
		public Object[][] DataProvider2()
			{
				return new Object[][]
					{

					new Object[]
						{ "username", "password" }, new Object[]
						{ "advith", "advith" }, new Object[]
						{ "ajay", "ajay" }, };
			}

		@DataProvider
		public Object[][] DpCsvData() throws IOException
			{
				/*
				 * Get the string from the csv file using FileOps method User
				 * String Ops method to format this to Arr2d
				 * 
				 * @param ParStrDataCsv
				 * 
				 * @return Arr2d[][]
				 */

				// At the end of the test, this is the expected return to
				// validate
				// String[][] Arr2dStrExpected={{"a","b"}, {"c","d"},
				// {"e","f"}};

				FileOps ObjFileOps = new FileOps();

				// Get the string from file
				StringBuilder ObjStringBuilder = ObjFileOps
						.ReadFile("datalogin.csv");

				// The String data
				String ParStrCsvData = ObjStringBuilder.toString();
				System.out.println("ParStrCsvData - " + ParStrCsvData);

				// Now to format this to 2dArr
				StringOps ObjStringOps = new StringOps();

				// Format the string in to 2d Array
				String[][] Arr2dStrActual = ObjStringOps.FormatCsvDataToArray(
						ParStrCsvData, ",", 2);

				// System.out.println("Executing - GetDataFromCsvAsArr2dTest ");
				// Assert.assertArrayEquals("GetDataFromCsvAsArr2dTest - ok",
				// Arr2dStrExpected, Arr2dStrActual);

				return Arr2dStrActual;
			}

		// Navigational ops Functional

		public void OpsLogin()
			{

				// LoadPage
				InitDriverLoginPage();

				// Login form ops
				ObjLoginPage.UserName.sendKeys("username");
				ObjLoginPage.PassWord.sendKeys("password");
				ObjLoginPage.Submit.click();
			}

		public void OpsLogin(String ParStrUserName, String ParUserPassword)
			{
				// Load Page
				InitDriverLoginPage();

				// Login form ops
				ObjLoginPage.UserName.sendKeys(ParStrUserName);
				ObjLoginPage.PassWord.sendKeys(ParUserPassword);
				ObjLoginPage.Submit.click();

			}

		// Validation and Verification Ops

		public void OpsValidateLogin()
			{
				// Go to UserHomePage to validate
				InitDriverUserHomeUrl();
				Assert.assertEquals("Welcome " + "username",
						ObjUserHomePage.header.getText().toString(), "Pass");
			}

		public void OpsValidateLogin(String ParStrUserName,
				String ParStrPassword)
			{
				// Go to UserHomePage to validate
				InitDriverUserHomeUrl();
				Assert.assertEquals("Welcome " + ParStrUserName,
						ObjUserHomePage.header.getText().toString(), "Pass");
			}

		// Test Ops
		@Test(enabled = false)
		public void TestLogin()
			{
				OpsLogin();
				OpsValidateLogin();

			}

		@Test(enabled = true, dataProvider = "DpCsvData")
		public void TestLoginData(String ParStrUserName, String ParStrPassword)
			{
				OpsLogin(ParStrUserName, ParStrPassword);
				OpsValidateLogin(ParStrUserName, ParStrPassword);
			}

	}
