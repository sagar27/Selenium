package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
WebElement staticdropdown = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		
		Select sd = new Select(staticdropdown);
		
		sd.selectByIndex(3);
		System.out.println(sd.getFirstSelectedOption().getText());
		
		sd.selectByValue("AED");
		System.out.println(sd.getFirstSelectedOption().getText());
		
		sd.selectByVisibleText("INR");
		System.out.println(sd.getFirstSelectedOption().getText());
		
		driver.quit();
	}

}
