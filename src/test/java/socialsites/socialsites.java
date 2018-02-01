package socialsites;

import org.testng.annotations.Test;

import PPZMALLFLOW.PPZMALLFLOW.Commondata;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class socialsites extends Commondata
{
	@DataProvider(name = "commondata")
	public Object[][] createData1() throws InterruptedException 
{
	Object[][] retObjArr;
		try {
				retObjArr = getTableArray("C:\\Users\\ambab\\Desktop\\testing.xls","testing", "TestDataStart", "TestDataEnd");
			} 
		catch (Exception e) 
			{
				System.out.println("Exception occured while reading the excel");
				e.printStackTrace();
				return null;
			}
return (retObjArr);
}

@Test(dataProvider = "commondata")
	public void ppzflow3(String URL, String Filteronline, String firststore, String Buynow, String Name, String Password, String Wishlist, String Conituneshopping, String fb, String twitter, String insta, String apple, String android  ) throws Exception
	{
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get(URL);
		login(Name, Password);
		Thread.sleep(1500);
		WebElement fb1= driver.findElement(By.xpath(fb));
		WebElement twitter1= driver.findElement(By.xpath(twitter));
		WebElement insta1= driver.findElement(By.xpath(insta));
		WebElement apple1=driver.findElement(By.xpath(apple));
		WebElement android1=driver.findElement(By.xpath(android));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", fb1);
		Thread.sleep(1500); 
		fb1.click();
		Thread.sleep(1500);
		twitter1.click();
		Thread.sleep(1500);
		insta1.click();
		Thread.sleep(1500);
		apple1.click();
		Thread.sleep(1500);
		android1.click();
	}
}
