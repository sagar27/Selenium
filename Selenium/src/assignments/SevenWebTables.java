package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SevenWebTables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)");
		
		WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));
		List<WebElement> column = table.findElements(By.tagName("th"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("No.of rows = "+rows.size());
		System.out.println("No.of columns = "+column.size());
		
		List<WebElement> secondRow = driver.findElements(By.xpath("//table[@name='courses'] //tr[3]/td"));
		for(int i=0;i<secondRow.size();i++)
		{
			System.out.println(secondRow.get(i).getText());
		}
		
		System.out.println("TEST PASS");
		driver.quit();
	}

}