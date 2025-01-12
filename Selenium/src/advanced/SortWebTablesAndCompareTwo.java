package advanced;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SortWebTablesAndCompareTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		// find out the Price of Wheat which is present in the 4th page of the table
		
		List<String> priceOfElement;
		
		do {
		List<WebElement> tablerows = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		priceOfElement = tablerows.stream().filter(s->s.getText().contains("Wheat")).map(s->getPrice(s)).collect(Collectors.toList());
		priceOfElement.forEach(S->System.out.println("Price of wheat: " +S));
		if(priceOfElement.size()==0) {
		WebElement nextButton = driver.findElement(By.xpath("//a[@aria-label='Next']"));
		nextButton.click();
		}
		}while(priceOfElement.size()==0);
		
		driver.quit();
		System.out.println("TEST PASS");
	}
	public static String getPrice(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
