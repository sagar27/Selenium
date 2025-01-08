package assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FourWindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//li/a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate = windows.iterator();
		String parent = iterate.next();
		String child = iterate.next();
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.switchTo().window(parent);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		System.out.println("TEST PASS");
		driver.quit();

	}

}