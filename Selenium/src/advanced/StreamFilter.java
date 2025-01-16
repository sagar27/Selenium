package advanced;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String itemToSearch	= "Banana";
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(itemToSearch);
		
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]")); // this list will have all the web elements that comes up on entering the text in previous step
		List<WebElement> filteredUsingStream = rows.stream().filter(s->s.getText().contains("Banana")).collect(Collectors.toList()); 
		// in the above step we are just filtering the the table using filter method in streams to make sure that the filter functionality in the application is working as expected
		
		Assert.assertEquals(rows.size(), filteredUsingStream.size()); //compare the size of both the list
		
		driver.quit();
		System.out.println("TEST PASS");

	}

}
