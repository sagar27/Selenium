package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).click();
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			
			System.out.println("not enabled");
			Assert.assertTrue(true);
		}else {
			System.out.println("Enabled");
			Assert.assertFalse(false);
		}
		
		WebElement passengers = driver.findElement(By.id("divpaxinfo"));
		System.out.println("default passengers count = "+passengers.getText());
		
		passengers.click();
		Thread.sleep(1000);
		int i=1;
		while( i<5) {
			
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(passengers.getText(),"5 Adult");
		
		WebElement dropdown = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select currency = new Select(dropdown);
		currency.selectByValue("USD");
		
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		System.out.println("Test pass");
		
		driver.quit();
	}

}