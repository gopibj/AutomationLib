/**
 * 
 */
package org.zapto.ajad.common;

import java.io.IOException;
import java.nio.file.Path;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.zapto.ajad.utils.PropertyLoader;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

/**
 * @author Ajad
 *
 */
public class CommonParams
	{

		protected static String StrGridHubUrl;
		protected static String StrBaseUrl;
		protected static String StrHomeUrl;
		protected static String StrLoginUrl;
		protected static String StrUserHomeUrl;
		protected static String StrTestResources;
		protected static WebDriver ObjWebDriver;
		protected static Capabilities ObjCapabilities;
		protected static String StrTestProperty;

		protected static String StrDataLoginCsv;

		public void InitCommonParams() throws IOException
			{
				StrBaseUrl = PropertyLoader.LoadProperty("site.url");
				StrHomeUrl = PropertyLoader.LoadProperty("home.url");
				StrLoginUrl = PropertyLoader.LoadProperty("login.url");
				StrUserHomeUrl = PropertyLoader.LoadProperty("userhome.url");

				// Load the test data for various tests
				StrTestResources = PropertyLoader.LoadProperty("testResources");

				// Load the test data for various tests
				StrDataLoginCsv = PropertyLoader.LoadProperty("datalogin.csv");

				/*
				 * // //Process the file names to get the absolute path
				 * 
				 * 
				 * int IntBeginIndex = StrDataCsv.length() - 4; if
				 * (StrDataCsv.substring(IntBeginIndex).equals("csv")){
				 * 
				 * 
				 * 
				 * } //Current UserDirectory
				 * System.out.println(SystemProperty.);
				 */

				/*
				 * //The GridHubUrl StrGridHubUrl =
				 * PropertyLoader.LoadProperty("grid.url"); if
				 * ("".equals(StrGridHubUrl)){ StrGridHubUrl=null; }
				 * ObjWebDriver = WebDriverFactory.getDriver(StrGridHubUrl,
				 * ObjCapabilities); //Set the WebDriverFactory setting
				 * WebDriverFactory
				 * .setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
				 */
			}

		// TestDrive
		public static void main(String[] args) throws IOException
			{
				CommonParams ObjCommonParams = new CommonParams();
				ObjCommonParams.InitCommonParams();
				System.out.println(StrTestResources + StrTestProperty
						+ StrBaseUrl);

			}

	}
