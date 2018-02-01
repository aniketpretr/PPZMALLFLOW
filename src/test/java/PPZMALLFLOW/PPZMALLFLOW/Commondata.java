package PPZMALLFLOW.PPZMALLFLOW;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@SuppressWarnings("unused")
public class Commondata
{
	WebDriver driver;
  @BeforeTest
  public void beforeTest()
  {
	  //driver.manage().deleteAllCookies();
	  HashMap<String, Object> prefs=new HashMap<String, Object>();
	  prefs.put("credentials_enable_service", false);
	  prefs.put("profile.password_manager_enable", false);
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\sel\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(3500, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
  public void login(String Name, String Password) throws InterruptedException
  {
			WebDriverWait wait= new WebDriverWait(driver, 3000);
			driver.navigate().refresh();
			Thread.sleep(1500);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("mall_select")))).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("login_panel")))).click();
			Thread.sleep(3500);
			driver.findElement(By.className("abcRioButtonIcon")).click();
		 String mainwindow=driver.getWindowHandle();
		 for(String childwindow : driver.getWindowHandles())
		 {
			 driver.switchTo().window(childwindow);
		 }
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("identifierId")))).sendKeys(Name);
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("identifierNext")))).click();
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("password")))).sendKeys(Password);
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("passwordNext")))).click();
		 Thread.sleep(2500);
		 driver.switchTo().window(mainwindow);
  }
  @AfterMethod
  public void afterMethod(ITestResult result)
  {
      try
   {
      if(result.getStatus() == ITestResult.SUCCESS)
      {

          System.out.println("************************************************************************");          
          System.out.println("Passed All Scenario");
          System.out.println("************************************************************************");   
      }

      else if(result.getStatus() == ITestResult.FAILURE)
      {
          System.out.println("************************************************************************");          
          System.out.println("Failed Scenario");
          System.out.println("************************************************************************"); 
      }

       else if(result.getStatus() == ITestResult.SKIP )
       {
           System.out.println("************************************************************************");          
           System.out.println("Skipped Scenario");
           System.out.println("************************************************************************"); 
      }
  }
     catch(Exception e)
     {
       e.printStackTrace();
     }

  }
  @AfterTest
  public void afterTest() 
  {
	//driver.close();
  }
//to create worksheet to get data from workbook
		public String[][] getTableArray(String xlFilePath, String sheetName,String tableName1, String tableend1) throws Exception 
		{
			String[][] tabArray1 = null;
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int startRow, startCol, endRow, endCol, ci, cj;
			Cell tableStart1 = sheet.findCell(tableName1);
			startRow = tableStart1.getRow();
			startCol = tableStart1.getColumn();
			Cell tableEnd = sheet.findCell(tableend1);
			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();
			//System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", "	+ "startCol=" + startCol + ", endCol=" + endCol);
			tabArray1 = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;
			for (int i = startRow + 1; i < endRow; i++, ci++) 
			{
				cj = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) 
				{
					tabArray1[ci][cj] = sheet.getCell(j, i).getContents();
				}
		   }
		return (tabArray1);
	    }
}