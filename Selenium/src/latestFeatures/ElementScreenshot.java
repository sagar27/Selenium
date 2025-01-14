package latestFeatures;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		WebElement nameField = driver.findElement(By.name("name"));
		nameField.sendKeys("Heisenberg");
		
		// take screenshot of the web element alone
		
		File screenshotFile = nameField.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("screenshot.png")); //The screenshot.png file will be saved in the project root directory
		
		driver.quit();
		System.out.println("TEST PASS");
		
	}

}
