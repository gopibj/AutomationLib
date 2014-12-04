package org.zapto.ajad.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;



/*
 * class that extracts properties from the .properties file
 * 
 *  
 */
public class PropertyLoader {
	
	//Constant to hold the default properties file / debug properties file
	private static final String DebugProperties = "/debug.properties";
	
	//Method for loading capabilities
	public static Capabilities LoadCapabilities() throws IOException {
		
		//First extract the name of the Application Property name from the system property defined in pom.xml "application.properties"
		return LoadCapabilities(System.getProperty("application.properties", DebugProperties));
		
	}
	
	public static Capabilities LoadCapabilities(String StrFromResource) throws IOException{
		
		//Instantiate a properties object to read from the AppProperties file 
		Properties ObjProperties = new Properties();
		
		//Read all the properties in the FromResource file(AppProp)
		ObjProperties.load(PropertyLoader.class.getResourceAsStream(StrFromResource));


		
		//Get the File name of the Capabilities prop to read the capabilities
		String StrCapabilitiesFile = ObjProperties.getProperty("capabilities");
		
		//Instantiate new properties object for reading the Capability properties from the capability file
		Properties ObjPropertiesCapabs = new Properties();
		
		//Load all the Capability properties
		ObjPropertiesCapabs.load(PropertyLoader.class.getResourceAsStream(StrCapabilitiesFile));

		
		
		//Instantiate a DesiredCapabilities Object to set its properties to that read from file
		DesiredCapabilities ObjDesiredCapabilities = new DesiredCapabilities();
		
		//Loop through the properties read to extract the values specs of capabilities 
		//and set the Object properties for the capabilities Object
		//Returns a Key values in Set Data Struc 
		for (String StrKey :ObjPropertiesCapabs.stringPropertyNames()){
			//Get the value for each key
			String StrValue = ObjPropertiesCapabs.getProperty(StrKey);
			
			//and set the Object properties for the capabilities Object
			if (StrValue.toLowerCase().equals("true") || StrValue.toLowerCase().equals("false")){
				ObjDesiredCapabilities.setCapability(StrKey, Boolean.valueOf(StrValue));				
			}else if (StrValue.startsWith("file:")){
				ObjDesiredCapabilities.setCapability(StrKey, new File(".", StrValue.substring(5)).getCanonicalFile().getAbsolutePath());
			}else{
				ObjDesiredCapabilities.setCapability(StrKey, StrValue);
			}	
		}
		return ObjDesiredCapabilities;		
	}	
	
	//Method to load property for a particular string name supplied
	public static String LoadProperty(String StrKey) throws IOException {
		//Get the file name from which to read the properties
		//User overloaded method to read values
		return LoadProperty(StrKey, System.getProperty("application.properties", DebugProperties));
	}

	private static String LoadProperty(String StrKey, String StrPropertyFile) throws IOException {
		
		//Instantiate a property object
		Properties ObjPropertiesProps = new Properties();
		ObjPropertiesProps.load(PropertyLoader.class.getResourceAsStream(StrPropertyFile));
		return ObjPropertiesProps.getProperty(StrKey);
	}

//Test
public static void main(String args[]) throws IOException{
	//PropertyLoader ObjPropertyLoader = new PropertyLoader();
	//String StrPropertyValue = PropertyLoader.LoadProperty("login.url", "application.properties");
	String StrPropertyValue = PropertyLoader.LoadProperty("login.url");
	//Capabilities ObjCapabilities = PropertyLoader.LoadCapabilities("application.properties");
	Capabilities ObjCapabilities = PropertyLoader.LoadCapabilities();
	System.out.println("ObjCapabilityValue - " + ObjCapabilities.getBrowserName());
	System.out.println(StrPropertyValue);
	
	
}
}