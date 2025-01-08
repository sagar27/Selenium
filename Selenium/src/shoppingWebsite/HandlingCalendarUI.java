package shoppingWebsite;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingCalendarUI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate = windows.iterator();
		String parent = iterate.next();
		String child = iterate.next();
		driver.switchTo().window(child);
		
		String monthNumber = "6";
		String day = "15";
		String year = "2027";
		String[] expectedDate = {monthNumber,day,year};
		
		WebElement yearField = driver.findElement(By.xpath("//input[@name='year']"));
		yearField.click();
		WebElement yearLabel = driver.findElement(By.className("react-calendar__navigation__label"));
		yearLabel.click();
		yearLabel.click();
		
		driver.findElement(By.xpath("//button[text()='"+year +"']")).click();
		List<WebElement> months= driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"));
		months.get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text()='" +day +"']")).click();
		
		List<WebElement> actualDate = driver.findElements(By.xpath("//input[contains(@class,'react-date-picker__inputGroup__input')]"));
		for(int i=0; i<actualDate.size(); i++) {
			Assert.assertEquals(actualDate.get(i).getAttribute("value"), expectedDate[i]); 
		}
		
		System.out.println("TEST PASS");
		driver.quit();
		
	}

}