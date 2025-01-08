package assignments;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThreeSynchronizationWithExplicitwait {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5000));
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		
		WebElement dropdown = driver.findElement(By.tagName("select"));
		Select dropdownlist = new Select(dropdown);
		dropdownlist.selectByValue("consult");
		driver.findElement(By.name("terms")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
		addItemsToCart(driver);
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-success']")));
		System.out.println("Checkout button is identified");
		
		System.out.println("Test pass");
		driver.quit();	
	}
	
	public static void addItemsToCart(WebDriver driver) {
		List<WebElement> items = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		
		for(int i=0; i<items.size();i++) {
			items.get(i).click();
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		System.out.println("Clicked Checkout button");
	}
}