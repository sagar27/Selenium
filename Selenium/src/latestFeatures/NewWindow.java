package latestFeatures;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindowId = it.next();
		String childWindowID = it.next();
		
		driver.switchTo().window(childWindowID);
		driver.get("https://rahulshettyacademy.com");
		String courseName = driver.findElements(By.xpath("//div[@id='courses-block'] //h2/a[contains(@href,'https://courses.rahulshettyacademy.com')]")).get(0).getText();
		
		
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.name("name")).sendKeys(courseName);
		Thread.sleep(2000);
		
		driver.quit();
		System.out.println("Test pass");	

	}

}
