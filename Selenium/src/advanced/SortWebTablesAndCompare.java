package advanced;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortWebTablesAndCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//pagination scenario using streams and do-while loop
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> tablewebelements = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> originalList = tablewebelements.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));
		
		// get price of beans and print in the output using streams
		
		tablewebelements.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s))
				.collect(Collectors.toList()).forEach(s->System.out.println("Price is : "+s));
		
		System.out.println("PASS");
		driver.quit();

	}
	public static String getPrice(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
