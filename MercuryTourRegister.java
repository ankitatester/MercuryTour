package SeleniumSessions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;

public class MercuryTourRegister {
	
	
	static WebDriver driver;
	
	public static int getRandomNumber(){
		Random rd = new Random();
		 
	        return rd.nextInt();
		
		}
	
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asarkar\\Drivers\\chromedriver_win32\\chromedriver.exe\\");
		
		driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.guru99.com/test/newtours/");
		
		
		// Test Case 1- Title of the Website matches Expected Title asper the Requirement
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Mercury Tours";
		
		if (ActualTitle.equalsIgnoreCase(ExpectedTitle) || ActualTitle.contains(ExpectedTitle)) {			
			System.out.println("Test Case : Title is Passed. Actual Title is: "+ ActualTitle);
		}
		else {
			
			System.out.println("Test Case : Title is Failed. Actual Title: "+ ActualTitle +" does not match Expected Title: "+ExpectedTitle);
		}
			
		// Test Case 2- Perform Registration
		driver.findElement(By.linkText("REGISTER")).click();
		String ActualRegisterTitle = driver.getTitle();
		String ExpectedRegisterTitle = "Register";
		
		if (ActualRegisterTitle.equalsIgnoreCase(ExpectedRegisterTitle) || ActualRegisterTitle.contains(ExpectedRegisterTitle)) {			
			System.out.println("Test Case : Title is Passed. Actual Title is: "+ ActualRegisterTitle);
		}
		else {
			
			System.out.println("Test Case : Title is Failed. Actual Title: "+ ActualRegisterTitle +" does not match Expected Title: "+ExpectedRegisterTitle);
		}
		
		String FNelement = "firstName"; //name Element
		String LNelement = "lastName";  //name Element
		String PhnElement = "phone";  //name Element
		String emailElement = "userName"; //name and id element both are same
		String addrssElement = "address1"; //name Element
		String cityElement = "city"; //name Element
		String stateElement = "state"; //name Element
		String postalcodeElement = "postalCode"; //name Element
		String countryElement = "country"; //name Element
		Select Country =new Select(driver.findElement(By.name(countryElement)));
		String UserNameElement = "email"; //name and id element both are same
		String PswdElement = "password"; //name Element
		String ConfrmPswdElement = "confirmPassword"; //name Element
		String SubmitBttnElement = "submit";
		
					
		 driver.findElement(By.name(FNelement)).sendKeys("FNTest"+getRandomNumber());
		 driver.findElement(By.name(LNelement)).sendKeys("LNTest"+getRandomNumber());
		 driver.findElement(By.name(PhnElement)).sendKeys("91234545"+getRandomNumber());
		 driver.findElement(By.name(emailElement)).sendKeys("FirstN"+getRandomNumber()+"@hotmil.com");
		 driver.findElement(By.name(addrssElement)).sendKeys(getRandomNumber()+"234 test1 test2 Test3");
		 driver.findElement(By.name(cityElement)).sendKeys("Bang");
		 driver.findElement(By.name(stateElement)).sendKeys("Karnataka");
		 driver.findElement(By.name(postalcodeElement)).sendKeys("5603"+getRandomNumber());
		 Country.selectByValue("INDIA");
		 driver.findElement(By.name(UserNameElement)).sendKeys("FirstN"+getRandomNumber()+"@hotmil.com");
		
		 WebElement Username = driver.findElement(By.name(UserNameElement));
		            Username.sendKeys("LNTest"+getRandomNumber());
		 String UsernameString = Username.getAttribute("value");
		 System.out.println(UsernameString);
		 WebElement Password = driver.findElement(By.name(PswdElement));
			        Password.sendKeys("LNTest"+getRandomNumber());
		 String passwordString = Password.getAttribute("value");
		 System.out.println(passwordString);
		 
		 driver.findElement(By.name(ConfrmPswdElement)).sendKeys(passwordString);
		 
		 driver.findElement(By.name(SubmitBttnElement)).click();
		 
		 String RegistrationMssgXpath ="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]";
		 
		 String RegistrationMessage= driver.findElement(By.xpath(RegistrationMssgXpath)).getText();
		 System.out.println(RegistrationMessage);
		 
		 Boolean result1 = RegistrationMessage.contains("Thank you for registering.");
		 System.out.println("Result is: "+result1);
		 System.out.println("Test Case 2- Registration is Passed");
		 
		//Test Case 3 - Sign IN
		 
		 String HomeElement = "Home";
		 
		 driver.findElement(By.linkText(HomeElement)).click();
		 driver.findElement(By.name(UserNameElement)).sendKeys(UsernameString);
		 driver.findElement(By.name(PswdElement)).sendKeys(passwordString);
		 driver.findElement(By.name(SubmitBttnElement)).click();
		 
		 String SignInMessageXpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b";
		 String SignInMessage = driver.findElement(By.xpath(SignInMessageXpath)).getText();
		 
		 String SignInHeaderXpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3";
		 String SignInHeaderMessage = driver.findElement(By.xpath(SignInHeaderXpath)).getText();
		 
		 if (SignInHeaderMessage.contains("Successfully")) {
		 System.out.println("Header is printed as expected");
		 }
		 else {
			 System.out.println("Test case - Sign In Header Message failed");
		 }
		 
		 Boolean result2 = SignInMessage.contains("Thank you");
		 System.out.println("Result for SignIn is: "+result2);		 
		 System.out.println("Test Case 3- Sign In is Passed");
		 

	}

}
