package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement studentCheckBox = driver.findElement(By.cssSelector("input[id*='StudentDiscount'"));
		//System.out.println(studentCheckBox.isSelected());
		Assert.assertFalse(studentCheckBox.isSelected());
		studentCheckBox.click();
		Assert.assertTrue(studentCheckBox.isSelected());
		//System.out.println(studentCheckBox.isSelected());
		
		System.out.println("Total no.of checkboxes present in the page: " +driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		System.out.println("isEnabled method: " +driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		
		System.out.println("Before click: " +driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println("After click: " +driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("Disabled");
		}
		else {
			System.out.println("Enabled");
		}
		
		WebElement dd = driver.findElement(By.id("divpaxinfo"));
		System.out.println(dd.getText());
		dd.click();
		
		Thread.sleep(1000);	
		
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(dd.getText(), "5 Adult");	
		//System.out.println(dd.getText());
		
		
//		driver.quit();

	}
	
}