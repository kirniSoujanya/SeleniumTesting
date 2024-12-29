package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicElements {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://trytestingthis.netlify.app/");

			WebElement artOfTestingLogo = driver.findElement(By.cssSelector("div.navbar-header"));
			artOfTestingLogo.click();
			//Navigating back in browser 
			driver.navigate().back();
			//Used for demo purpose only, not required
			Thread.sleep(4000);
			//Navigating forward in browser 
			driver.navigate().forward();	
		}
		catch(Exception e) {}
		finally {
			System.out.println("finally block executed!");
		}

	}

}
