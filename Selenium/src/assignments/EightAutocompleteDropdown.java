package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class EightAutocompleteDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement textBox = driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']"));
		textBox.sendKeys("united");
		Thread.sleep(1000);
		textBox.sendKeys(Keys.DOWN);
		textBox.sendKeys(Keys.DOWN);
		textBox.sendKeys(Keys.DOWN);
//		get value from the text box
		
//		Method 1:- using getattribute method
		System.out.println(textBox.getAttribute("value"));
		
//		Method 2 :- using javascript executor
//		 Extracting the value attribute
//		This script retrieves the value attribute of an input field using JavaScript.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String value = (String) js.executeScript("return arguments[0].value;",textBox);
		System.out.println("Extracted Value using JavascriptExecutor: " + value);
		
		System.out.println("TEST PASS");
		driver.quit();
	}

}
