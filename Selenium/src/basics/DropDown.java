package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement departure = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		Thread.sleep(1000);
//		Select fromD = new Select(departure);
//		
//		fromD.selectByValue("BLR");
//		System.out.println(fromD.getFirstSelectedOption().getText());
		
		departure.click();
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']  //a[@value='MAA']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".ui-datepicker-today")).click();

	}

}