package PPZMALLFLOW.PPZMALLFLOW;

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
	public void ppzflow(String URL, String Filteronline, String firststore, String Buynow, String Name, String Password, String Wishlist, String Conituneshopping) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get(URL);
		login(Name, Password);
		store(Filteronline, firststore, Buynow);
	}
}
