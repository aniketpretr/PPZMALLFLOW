package PPZMALLFLOW.PPZMALLFLOW;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PPZMALLFLOW.PPZMALLFLOW.Commondata;

@SuppressWarnings("unused")
public class Onlinestoreselection extends Commondata
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
	public void ppzflow(String URL, String Filteronline, String firststore, String Buynow, String Name, String Password, String Wishlist, String Conituneshopping, String fb, String twitter, String insta, String apple, String android  ) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get(URL);
		login(Name, Password);
		Thread.sleep(2000);
		  {
			  	WebElement directory=driver.findElement(By.className("menu_panel"));
			  	List<WebElement> storelist=directory.findElements(By.tagName("li"));
			  	int length=storelist.size();
			  	for(int i=0; i<=length; i++)
			  	{
			  		if(i==0)
			  		{
			  			storelist.get(i).click();
			  		}
			  	}
				Thread.sleep(1500);
				driver.findElement(By.xpath(Filteronline)).click();
				Thread.sleep(1500);
				driver.findElement(By.xpath(firststore)).click();
				Thread.sleep(1500);
				driver.findElement(By.xpath(Buynow)).click();
		  }
	}
}
