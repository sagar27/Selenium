package latestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeightAndWidth {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameField = driver.findElement(By.name("name"));
		
		// get height and width of the nameField webelement
		int height = nameField.getRect().getHeight();
		int width = nameField.getRect().getWidth();
		
		System.out.println("Height of webelement: "+height);
		System.out.println("Width of webelement :"+width);
		
		System.out.println("Test Pass");
		driver.quit();		
	}

}
