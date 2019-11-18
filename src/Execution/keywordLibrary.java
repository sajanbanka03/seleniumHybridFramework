package Execution;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class keywordLibrary
{
	static WebDriver driver;
	public static void CallKeyword(String Keyword, String param1, String param2, String param3) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Method method = keywordLibrary.class.getMethod(Keyword, String.class, String.class, String.class );
		method.invoke(Keyword, param1, param2, param3);
	}
	
	public void openBrowser(String browsertype, String url)
	{
		if(browsertype.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\D\\Selenium\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browsertype.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\D\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement ele = driver .findElement(By.xpath("//i[@class='wewidgeticon we_close']"));
		if(ele.isDisplayed())
		{
			ele.click();
			System.out.println("Promotion images are available and we clicked image close");
		}
		else
			System.out.println("Promotions not available");
		
		driver.findElement(By.xpath("//a[@href ='//www.makemytrip.com/flights/']")).click();
	}
	
	public static WebElement elementSelector(String selector, String selectorValue)
	{
		WebElement ele = null;
		switch(selector){
		case "name":
		 ele = driver.findElement(By.name(selectorValue));
		 
		case "id":
			ele = driver.findElement(By.id(selectorValue));
			
		case "xpath":
			ele = driver.findElement(By.xpath(selectorValue));
			
		default:
			System.out.println("Unknown locator type: please select fro ID, Name & Xpath");
		}
		
		return ele;
	}
	
	public void selectRadio(String selector, String selectorValue, String param3)
	{
		WebElement wbelm = elementSelector(selector, selectorValue);
		if(wbelm.isEnabled())
		{
			wbelm.click();
			System.out.println("Element is enable & clicked");
		}
		else
			System.out.println("Element is not enabled");
	}
	public void clickElement(String selector, String selectorValue,String param)
	{
		WebElement wbelm = elementSelector(selector, selectorValue);
		wbelm.click();
		System.out.println("Clicked on "+selector+" element");
	}
	public void enterText(String selector, String selectorValue, String text)
	{
		WebElement wbelm = elementSelector(selector, selectorValue);
		wbelm.sendKeys(text);
		System.out.println("Entered text "+text);
	}
	
	public void selectCalendar(String selector, String selectorValue, String date)
	{
		Calendar now = Calendar.getInstance();
		String[] arr = date.split("/");
		WebElement ele;
		for(int i =0; i<arr.length; i++)
		{
			
		}
		
//		if(arr[2].equals(now.YEAR))
//		{
//			if(arr[1].equals(now.MONTH))
//			{
//				 ele = elementSelector(selector, selectorValue);
//				ele.click();
//			}
//			else if(arr[1] now.MONTH)
//			{
//				
//			}
//		}
	}
	public void storeListValue(String selector, String selectorValue)
	{
		
	}

}
