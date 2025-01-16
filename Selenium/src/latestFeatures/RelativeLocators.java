package latestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
//		above()
		
		WebElement nameTextBoxField =  driver.findElement(By.name("name"));
		String labelAboveNameTextBox = driver.findElement(with(By.tagName("label")).above(nameTextBoxField)).getText();
		System.out.println("The label displayed above the Name Text box field is: "+labelAboveNameTextBox);
		
//		below()
		WebElement nameText = driver.findElement(By.xpath("//label[text()='Name']"));
		driver.findElement(with(By.tagName("input")).below(nameText)).sendKeys("David Warner");
		
//		toLeftOf()
		WebElement checkBoxText = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxText)).click();
	
//		toRightOf()
		WebElement checkbox= driver.findElement(By.xpath("//input[@type='checkbox']"));
		String checkboxText = driver.findElement(with(By.tagName("label")).toRightOf(checkbox)).getText();
		System.out.println("The checkbox text displayed is: "+checkboxText);
		
		
		driver.quit();
		System.out.println("TEST PASS");
	}

}
