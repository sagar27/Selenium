package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SixPracticeExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("input[id=checkBoxOption3]")).click();
		String optionString =driver.findElement(By.xpath("//label[@for='honda']")).getText();
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select staticDropdown = new Select(dropdown);	
		staticDropdown.selectByVisibleText(optionString);

		driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys(optionString);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		if(alertText.contains(optionString)) {
			System.out.println("Alert Text: "+alertText);
			System.out.println("TEST PASS");
		}		
		driver.quit();
	}
}