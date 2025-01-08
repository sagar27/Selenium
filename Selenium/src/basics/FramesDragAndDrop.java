package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
//		driver.switchTo().frame(0); //frame index
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame"))); // frame webElement
		
		WebElement source = driver.findElement(By.cssSelector("#draggable"));
		WebElement target = driver.findElement(By.cssSelector("#droppable"));
		
		System.out.println(source.getText());
		System.out.println("text before drop: " +target.getText());
		
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		
		System.out.println("text after drop: " +target.getText());
		
		driver.quit();
		System.out.println("TEST PASS");

	}

}