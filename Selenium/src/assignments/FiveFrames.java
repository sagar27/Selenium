package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FiveFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//li/a[text()='Nested Frames']")).click();
		
		WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(topFrame);
		WebElement middleFrame = driver.findElement(By.cssSelector("frame[name='frame-middle']"));
		driver.switchTo().frame(middleFrame);
		System.out.println(driver.findElement(By.id("content")).getText());
		
		System.out.println("Test pass");
		driver.quit();

	}

}
