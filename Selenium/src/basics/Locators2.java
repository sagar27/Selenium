package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String pwdString = getPwdText(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		String name = "sagar";
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);  
		driver.findElement(By.xpath("//div/div[2]/form/input[2]")).sendKeys(pwdString);  //xpath-parent-child
		driver.findElement(By.cssSelector("input[value*='rmbr']")).click();			//cssSelector-regular expression
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.quit();

	}
	
	public static String getPwdText(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String PwdString = driver.findElement(By.cssSelector("form p")).getText();
		String[] array1 = PwdString.split("'"); // array1 = [Please use temporary password ,rahulshettyacademy' to Login.]
		String[] array2 = array1[1].split("'"); // array2 = [rahulshettyacademy , to Login.]
		String pwd = array2[0];
		return pwd;
		
	}

}
