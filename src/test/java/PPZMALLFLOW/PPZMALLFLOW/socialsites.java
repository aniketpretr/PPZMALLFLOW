package PPZMALLFLOW.PPZMALLFLOW;

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

@SuppressWarnings("unused")
public class socialsites extends Commondata
{
	@DataProvider(name = "commondata")
	public void ppzflow2(String URL, String Filteronline, String firststore, String Buynow, String Name, String Password, String Wishlist, String Conituneshopping) throws Exception
	{
		driver.get(URL);
		login(Name, Password);
		Thread.sleep(2500);
		WebElement fb= driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[4]/div/ul/li[1]/a"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", "fb");
	}
}
