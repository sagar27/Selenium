package shoppingWebsite;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000)); //implicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3000));
		
		String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot","Almonds",""};
		
		addItemsToCart(driver, itemsNeeded);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));	//explicit wait
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		System.out.println("Entered promocode");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));  //explicit wait
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		
		
		System.out.println("Test pass");
		driver.quit();
		
	}
//		method 1

//		int noOfItemsNeeded = itemsNeeded.length;
//		
//		List<WebElement> products = driver.findElements(By.cssSelector(".product"));
//		System.out.println("No.of products: "+products.size());
//		
//		for(int j=0;j<noOfItemsNeeded;j++)
//		{
//		for (int i=0; i<products.size();i++)
//		{
//			String name = products.get(i).getText();
//			if(name.contains(itemsNeeded[j])) {
//				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
//				break;
//			}
//		}
//		}
		
//		method 2 - Convert Array of Strings to Array list
		
		
		public static void addItemsToCart( WebDriver driver,String[] itemsNeeded) {
		List itemsNeededList = Arrays.asList(itemsNeeded);
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']"));
		System.out.println("No.of products: "+products.size());
		
		int loopCounter = 0;
		for (int i=0; i<products.size();i++)
		{
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			if(itemsNeededList.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				loopCounter++;
				if(loopCounter == itemsNeededList.size()) {
					break;
				}
			}
		}

	}

}