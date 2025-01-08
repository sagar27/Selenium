package basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.xpath("//div[@class='float-right']/a[1]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate = windows.iterator();
		String parent = iterate.next();
		String child = iterate.next();
		
		driver.switchTo().window(child);
//		identified the email text without using any string methods
//		String email = driver.findElement(By.xpath("//strong[contains(a,'.com')]")).getText();
		
//		identifying email using string methods:-
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].split(" with")[0].trim();
		System.out.println(email);
		driver.switchTo().window(parent);
		driver.findElement(By.id("username")).sendKeys(email);
		Thread.sleep(2000);
		driver.quit();
		System.out.println("TEST PASS");
		
	}

}