package org.zapto.ajad.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.zapto.ajad.common.CommonParams;
import org.zapto.ajad.utils.PropertyLoader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

public class TestNgTestBase extends CommonParams
	{

		/*
		 * 
		 * //The vars to get from the application.properties -> pom.xml
		 * 
		 * protected static String StrGridHubUrl; protected static String
		 * StrBaseUrl; protected static String StrHomeUrl; protected static
		 * String StrLoginUrl; protected static String StrUserHomeUrl; protected
		 * static String StrDataCsv; protected static Capabilities
		 * ObjCapabilities;
		 * 
		 * protected WebDriver ObjWebDriver;
		 */
		/*
		 * @BeforeSuite protected void InitTestNgTestBase() throws IOException {
		 * CommonParams.InitCommonParams();
		 * 
		 * // TODO Auto-generated constructor stub }
		 */

		@BeforeSuite
		public void beforeSuite() throws IOException
			{

				// Init the vars by fetching them from the
				// application.properties -> pom.xml

				// Urls for different pages for navigation
				StrBaseUrl = PropertyLoader.LoadProperty("site.url");
				StrHomeUrl = PropertyLoader.LoadProperty("home.url");
				StrLoginUrl = PropertyLoader.LoadProperty("login.url");
				StrUserHomeUrl = PropertyLoader.LoadProperty("userhome.url");

				StrTestResources = PropertyLoader.LoadProperty("testResources");

				// Load the test data for various tests
				StrDataLoginCsv = PropertyLoader.LoadProperty("datalogin.csv");

				// The GridHubUrl
				StrGridHubUrl = PropertyLoader.LoadProperty("grid.url");
				if ("".equals(StrGridHubUrl))
					{
						StrGridHubUrl = null;
					}

				// Loading the Browser capabilities
				ObjCapabilities = PropertyLoader.LoadCapabilities();

				// Set the WebDriverFactory setting
				WebDriverFactory
						.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
			}

		@BeforeMethod
		public void InitWebDriver()
			{
				ObjWebDriver = WebDriverFactory.getDriver(StrGridHubUrl,
						ObjCapabilities);
			}

		@AfterSuite(alwaysRun = true)
		public void TearDown()
			{
				WebDriverFactory.dismissAll();

			}

	}
