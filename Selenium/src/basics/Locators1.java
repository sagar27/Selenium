package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		System.out.println(driver.getTitle());
		
	driver.findElement(By.cssSelector("input[id='inputUsername']")).sendKeys("sagar");
	driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("22");
	
	driver.findElement(By.cssSelector("button.submit")).click();
	
	
	System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
	
	driver.findElement(By.linkText("Forgot your password?")).click();
	driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("sagar");
	
	driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("sagar@gmail.com");
	System.out.println("entered sagar email");
	//driver.findElement(By.cssSelector("input[type='text']:nth-child(2)")).clear();
	
	driver.findElement(By.xpath("//form/input[3]")).sendKeys("2211221122");
	driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	
	System.out.println(driver.findElement(By.cssSelector("form p")).getText());
	
	driver.findElement(By.xpath("//div[contains(@class,'pwd')]/button[1]")).click();
	driver.findElement(By.cssSelector("#inputUsername")).sendKeys("sagar");
	driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
	Thread.sleep(1000);
	driver.findElement(By.id("chkboxOne")).click();
	driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	
	//driver.quit();
	}


}