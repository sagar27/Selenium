package advanced;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class FindAllBrokenLinks {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		SoftAssert a = new SoftAssert();
		
		// find all the broken elements in the footer section
		
		List<WebElement> urls= driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for( WebElement eachURL: urls)
		{
			String currentURL = eachURL.getAttribute("href");
			URL url = new URL(currentURL);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			int responseCode = connection.getResponseCode();
			a.assertTrue(responseCode<400,"The link text: '"+eachURL.getText() +"' is broken and the response code is: "+responseCode );
		
		}
		a.assertAll();
	}

}
