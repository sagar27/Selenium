package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TwoUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("Sagar");
		driver.findElement(By.name("email")).sendKeys("sagar27@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password");
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement genderdropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender = new Select(genderdropdown);
		gender.selectByIndex(0);
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("04/27/1999");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String successmsg = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText();
		System.out.println(successmsg);		
	}
}