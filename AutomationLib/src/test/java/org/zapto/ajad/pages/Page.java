package org.zapto.ajad.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
	
	protected WebDriver ObjWebDriver;
	
	/*
	 * Constructor 
	 * 
	 * @param ObjWebDriver
	 * 
	 */
	public Page(WebDriver ParObjWebDriver){
		this.ObjWebDriver = ParObjWebDriver;
				
	}
	
	public String GetPageTitle(){
		return ObjWebDriver.getTitle();
	}

}
