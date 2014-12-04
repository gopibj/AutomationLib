package org.zapto.ajad.tests;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.zapto.ajad.pages.HomePage;
import org.zapto.ajad.pages.LoginPage;
import org.zapto.ajad.pages.UserHomePage;
public class LoginPageTests extends TestNgTestBase {
	
	private HomePage ObjHomePage;
	private LoginPage ObjLoginPage;
	private UserHomePage ObjUserHomePage;
	
	
	//Initialize Page WebElements using page factory
	@BeforeMethod
	public void InitPageObjects(){
		ObjHomePage = PageFactory.initElements(ObjWebDriver, HomePage.class);
		ObjLoginPage = PageFactory.initElements(ObjWebDriver, LoginPage.class);
		ObjUserHomePage = PageFactory.initElements(ObjWebDriver, UserHomePage.class);
		
	}

	//Navigational ops PageLoad
	public void InitDriverHomePage(){
		ObjWebDriver.get(StrHomeUrl);
	}
	
	public void InitDriverLoginPage(){
		ObjWebDriver.get(StrLoginUrl);	
	}
	
	public void InitDriverUserHomeUrl(){
		ObjWebDriver.get(StrUserHomeUrl);
	}
	
	//Data Ops
	@DataProvider
	public Object[][] DataProvider(){
		
		//An  int array table data 1X1 
		//int ArrInt[] =  new int[]{1,
		//							2};
		
		// Defining the 2d "Array" of type object to hold 1X2 Table data
		Object ObjArrRow1[]= new Object[]{"username",  "password" };
		Object ObjArrRow2[]= new Object[]{"ajay", "ajay"};
		Object ObjArrRow3[]= new Object[]{"advith", "advith"};
		
		Object[][] ObjectArrCol1 =  new Object[][]{ ObjArrRow1,
													ObjArrRow2,
													ObjArrRow3};
		

		//Return 2d Arr
		return ObjectArrCol1;
		
	}
	
	@DataProvider
	public Object[][] DataProvider2(){
		  return new Object[][]{
				  
				  
			  new Object[] {"username","password"},
			  new Object[] {"advith", "advith"},
			  new Object[] {"ajay", "ajay"},
		  };
		  }
	
	//Navigational ops Functional

	public void OpsLogin(){
		
		//LoadPage
		InitDriverLoginPage();
		
		//Login form ops
		ObjLoginPage.UserName.sendKeys("username");
		ObjLoginPage.PassWord.sendKeys("password");
		ObjLoginPage.Submit.click();
	}
	
	public void OpsLogin(String ParStrUserName, String ParUserPassword){
		//Load Page
		InitDriverLoginPage();
		
		//Login form ops
		ObjLoginPage.UserName.sendKeys(ParStrUserName);
		ObjLoginPage.PassWord.sendKeys(ParUserPassword);
		ObjLoginPage.Submit.click();
		
	}
		
	//Validation and Verification Ops	
	
	public void OpsValidateLogin(){
		//Go to UserHomePage to validate
		InitDriverUserHomeUrl();		
	    Assert.assertEquals("Welcome " + "username" , ObjUserHomePage.header.getText().toString(), "Pass");
	}
	
	public void OpsValidateLogin(String ParStrUserName, String ParStrPassword){
		//Go to UserHomePage to validate
		InitDriverUserHomeUrl();		
	    Assert.assertEquals("Welcome " + ParStrUserName, ObjUserHomePage.header.getText().toString(), "Pass");
	}
	
		
	//Test Ops
	@Test(enabled=false)
	public void TestLogin(){
		OpsLogin();
		OpsValidateLogin();
		
	}
	@Test(enabled=true, dataProvider="DataProvider")
	public void TestLoginData(String ParStrUserName, String ParStrPassword){
		OpsLogin(ParStrUserName, ParStrPassword);
		OpsValidateLogin(ParStrUserName, ParStrPassword);
	}
		
		
	}


