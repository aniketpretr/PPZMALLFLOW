package PPZMALLFLOW.PPZMALLFLOW;

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
import PPZMALLFLOW.PPZMALLFLOW.Commondata;
//import PPZMALLFLOW.PPZMALLFLOW.Productfilterandselection;

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
	public void ppzflow3(String URL, String Filteronline, String firststore, String Buynow, String Name, String Password, String Wishlist, String Conituneshopping) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get(URL);
		login(Name, Password);
		Thread.sleep(1500);
		WebElement fb= driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[4]/div/ul/li[1]/a"));
		WebElement twitter= driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[4]/div/ul/li[2]/a"));
		WebElement insta= driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[4]/div/ul/li[3]/a"));
		WebElement apple=driver.findElement(By.xpath("/html/body/div[1]/footer/div[1]/div[1]/a[1]"));
		WebElement android=driver.findElement(By.xpath("/html/body/div[1]/footer/div[1]/div[1]/a[2]"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", fb);
		Thread.sleep(1500); 
		fb.click();
		Thread.sleep(1500);
		twitter.click();
		Thread.sleep(1500);
		insta.click();
		Thread.sleep(1500);
		apple.click();
		Thread.sleep(1500);
		android.click();
	}
}
