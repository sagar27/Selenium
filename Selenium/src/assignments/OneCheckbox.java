package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OneCheckbox {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// check and uncheck first checkbox
		
		WebElement firstCheckBox = driver.findElement(By.xpath("//input[@name='checkBoxOption1']"));
		firstCheckBox.click();
		Assert.assertTrue(firstCheckBox.isSelected());
		firstCheckBox.click();
		Assert.assertFalse(firstCheckBox.isSelected());
		
		// count of number of checkboxes present in the page
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		driver.quit();
		
	}

}