package basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverScope {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println("Total count of links in the page: " +driver.findElements(By.tagName("a")).size());
		
		// Find no.of links present in the footer section.
		
		WebElement footer = driver.findElement(By.cssSelector("#gf-BIG"));
		int footerLinksCount = footer.findElements(By.tagName("a")).size();
		System.out.println("No.of links present in footer section: "+footerLinksCount);
		
		// Find no.of links present in the first column(Discount Coupons)
		
		WebElement columnOne = footer.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
		System.out.println("No.of links in 1st column: "+columnOne.findElements(By.tagName("a")).size());
		
		// Check if all the links in the first columns are opening up
		Actions a =new Actions(driver);
		for(int i=1; i<columnOne.findElements(By.tagName("a")).size();i++)
		{
//			WebElement eachLink = columnOne.findElements(By.tagName("a")).get(i);
//			a.moveToElement(eachLink).keyDown(Keys.CONTROL).click().build().perform();
			
//			This can also be achieved by :-
			
			String clickOnEachLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnOne.findElements(By.tagName("a")).get(i).sendKeys(clickOnEachLink);
		}
		
		Set<String> tabsOpened = driver.getWindowHandles();
		Iterator<String> iterateTabs = tabsOpened.iterator();
		
//		String parentTab = iterateTabs.next();
//		String childTab;
//		for(int i=1; i<tabsOpened.size();i++)
//		{
//			childTab = iterateTabs.next();
//			driver.switchTo().window(childTab);
//			System.out.println("Title of page: " +i +" is: " +driver.getTitle());
//			driver.switchTo().window(parentTab);
//		}
		
		// Another way of doing the same(but also includes printing of home page title):-
		
		while(iterateTabs.hasNext()) {
			driver.switchTo().window(iterateTabs.next());
			System.out.println(driver.getTitle());
		}
		
		
		driver.quit();
		System.out.println("TEST PASS");
	}

}