package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
		WebElement dropdown = driver.findElement(By.id("nav-link-accountList"));
		WebElement searchbox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
				
		Actions a = new Actions(driver);
		a.moveToElement(dropdown).build().perform();
		a.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		System.out.println("TEST PASS");
		driver.quit();
		
	}

}