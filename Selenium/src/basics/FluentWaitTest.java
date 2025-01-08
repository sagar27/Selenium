package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		WebElement startButton = driver.findElement(By.cssSelector("div[id='start'] button"));
		startButton.click();
		
//		WebElement text = driver.findElement(By.cssSelector("div[id='finish'] h4"));
		
		Wait<WebDriver> w = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).
				ignoring(NoSuchElementException.class);
		
//		Implemented fluentwait with built in method
//
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='finish'] h4")));
//		System.out.println(text.getText());
		
//		fluent wait implemented as per course
		
		WebElement text = w.until(new Function<WebDriver, WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {
				return driver.findElement(By.cssSelector("div[id='finish'] h4"));
			}
				else {
					return null;
				}
			}
			
			});
		System.out.println(text.getText());

	}

}