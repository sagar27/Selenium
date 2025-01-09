package advanced;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {
	
	public static void main(String args[]) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// find the url which is broken - https://rahulshettyacademy.com/brokenlink
		String brokenUrl = driver.findElement(By.xpath("//a[contains(@href,'broken')]")).getAttribute("href");
		System.out.println("Broken URL in the page is: "+brokenUrl);
		
		URL url = new URL(brokenUrl);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//		connection.setRequestMethod("HEAD");
//		connection.connect();
		
		int responseCode = connection.getResponseCode();
		System.out.println("RESPONSE CODE :"+responseCode);
		
		driver.quit();
		
		
}

}
