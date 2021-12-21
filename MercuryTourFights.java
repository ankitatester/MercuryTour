package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MercuryTourFights {
	
	static WebDriver driver;

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver","C:\\Users\\asarkar\\Drivers\\chromedriver_win32\\chromedriver.exe\\");
		
		driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.findElement(By.linkText("Flights")).click();
		WebElement element = driver.findElement(By.id("google_adStringiframe_/24132379/INTERSTITIAL_DemoGuru99_0__container__"));
        driver.switchTo().activeElement();
        
		WebElement flightdetailsRadioType = driver.findElement(By.xpath("//input[@name='tripType' and @value='oneway']"));
		
		Select PassNum =  new Select(driver.findElement(By.name("passCount")));
		Select DepartingFromDD = new Select(driver.findElement(By.name("fromPort")));
		Select departingDateMonthDD = new Select(driver.findElement(By.name("fromMonth")));
		Select departingDateDD = new Select(driver.findElement(By.name("fromDay")));
		Select arrivingInDD= new Select(driver.findElement(By.name("toPort")));
		Select returningDateMonthDD = new Select(driver.findElement(By.name("toMonth")));
		Select returningDateDD = new Select(driver.findElement(By.name("toDay")));
		List <WebElement> serviceClassRadio = driver.findElements(By.name("servClass"));
		Select airlineDD = new Select(driver.findElement(By.name("airline")));
		WebElement continueButton= driver.findElement(By.name("findFlights"));

		String passcount = "2";
		String departingFrom = "London";
	//	String returningDate = "5";  // representing May as value of May is 5 in html
		String departingDate = "7";
		String arrivingIn= "Portland";
		String returningMonth = "10"; // representing October as value of October is 10 in html
		String returningDate = "10";
		String serviceClass = "First";
		String airline = "Unified Airlines";
		
		PassNum.selectByValue(passcount);
		DepartingFromDD.selectByValue(departingFrom);
		returningDateDD.selectByValue(returningDate);
		departingDateDD.selectByValue(departingDate);
		arrivingInDD.selectByValue(arrivingIn);
		returningDateMonthDD.selectByValue(returningMonth);
		returningDateDD.selectByValue(returningDate);
		airlineDD.selectByVisibleText(airline);
        
	}

}
