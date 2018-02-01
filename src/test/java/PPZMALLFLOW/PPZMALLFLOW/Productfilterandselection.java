package PPZMALLFLOW.PPZMALLFLOW;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import PPZMALLFLOW.PPZMALLFLOW.Onlinestoreselection;
import PPZMALLFLOW.PPZMALLFLOW.Commondata;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class Productfilterandselection extends Onlinestoreselection
{
	@Test(dataProvider = "commondata")
	public void ppzflow1(String URL, String Filteronline, String firststore, String Buynow, String Name, String Password, String Wishlist, String Conituneshopping) throws Exception
	{
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.id("men")).click();
		Thread.sleep(1500);
		
			driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div[4]/div[1]")).click();
			Thread.sleep(1500);
			List <WebElement> filter=driver.findElements(By.className("filter_value"));
			int len=filter.size();
			for(int i=0; i<=len; i++)
			{
				if(i==len-2)
				{
					filter.get(i).click();
				}
				break;
			}
		WebElement sort=driver.findElement(By.className("select"));
		Select sel=new Select(sort);
		sel.selectByIndex(1);
		Thread.sleep(2500);
		driver.findElement(By.xpath(Wishlist)).click();
		Thread.sleep(2500);
		driver.findElement(By.id("user_name")).click();
		WebElement wishlist=driver.findElement(By.className("logout_links_panel"));
		List <WebElement>options=wishlist.findElements(By.tagName("li"));
		int opt=options.size();
		for(int i=1; i<opt; i++)
		{
			if(i==3)
			{
				WebElement text=driver.findElement(By.xpath("//*[@id=\"logout\"]/ul/li[4]/a"));
				text.click();
			}
		}
		driver.findElement(By.className("proimages")).click();
		WebElement size=driver.findElement(By.id("size_drop_down"));
		Select seo=new Select (size);
		seo.selectByIndex(1);
		driver.findElement(By.id("addToBag")).click();
		List <WebElement> dlt=driver.findElements(By.className("delete_icon"));
		int dlen=dlt.size();
		for (int i=1; i<dlen; i++)
		{
				dlt.get(i).click();
		
		}
		driver.findElement(By.xpath(Conituneshopping)).click();
		driver.findElement(By.className("cart_chkout_btn")).click();
	}
}