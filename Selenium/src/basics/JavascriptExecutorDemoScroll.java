package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExecutorDemoScroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000); //just to pause the script before scrolling element in next step
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		List<WebElement> amount = driver.findElements(By.xpath("//table[@id='product'] //tr/td[4]"));
		int sumCalculated = 0;
		for(int i=0;i<amount.size();i++)
		{
			sumCalculated = sumCalculated + Integer.parseInt(amount.get(i).getText());
		}
		System.out.println("Total sum calculated: " +sumCalculated);
		
		int sumDisplayed = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(": ")[1]);
		System.out.println("Sum dislayed in UI: " +sumDisplayed);
		
		Assert.assertEquals(sumCalculated, sumDisplayed);
		
		System.out.println("Test pass");
		driver.quit();

	}

}
