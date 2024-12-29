package test;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.logging.LogEntry;
public class FirstTest {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		//	WebDriver driver = new FirefoxDriver();
		//	WebDriver driver = new InternetExplorerDriver();
		//	WebDriver driver = new SafariDriver();

		try {
			driver.get("https://trytestingthis.netlify.app/");

			// minimize and maximize window
			driver.manage().window().minimize();
			Thread.sleep(2000);
			System.out.println("minimize");	

			driver.manage().window().maximize();
			Thread.sleep(2000);
			System.out.println("maximize");	

			System.out.println("This is layout one");

			//alert box		
			WebElement alertBtn = driver.findElement(By.xpath("//button[contains(.,'Your Sample Alert Button!')]"));
			alertBtn.click();
			Thread.sleep(2000);	
			Alert alertBtn1 = driver.switchTo().alert();
			alertBtn1.accept();
			Thread.sleep(2000);
			WebElement alertBtn2 = driver.findElement(By.xpath("//button[contains(.,'Your Sample Alert Button!')]"));
			alertBtn2.click();
			Thread.sleep(2000);
			Alert alertBtn3 = driver.switchTo().alert();
			alertBtn3.dismiss();

			//tooltip
			WebElement tooltip1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]"));
			Actions act = new Actions(driver);
			act.moveToElement(tooltip1).perform();
			Thread.sleep(2000);
			System.out.println("tooltip executed");

			//double click
			Actions action = new Actions(driver);
			WebElement doubleClkBtn = driver.findElement(By.xpath("//button[contains(.,'Double-click me')]"));
			action.doubleClick(doubleClkBtn).perform();
			System.out.println("double clicked");
			Thread.sleep(2000);


			//drag and drop
			WebElement from = driver.findElement(By.id("drag1"));
			WebElement to= driver.findElement(By.id("div1"));
			Actions builder = new Actions(driver);	
			Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
			dragAndDrop.perform();		
			System.out.println("drag and dropped");
			Thread.sleep(2000);	

			//login page
			WebElement username = driver.findElement(By.id("uname"));
			username.sendKeys("test");

			WebElement password =driver.findElement(By.id("pwd"));
			password.sendKeys("test");
			Thread.sleep(2000);

			WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
			loginBtn.click();
			System.out.println("login successful!");
			Thread.sleep(2000);


			//navbar buttons
			WebElement contactPage = driver.findElement(By.xpath("//a[contains(@href, '/contact')]"));
			contactPage.click();
			System.out.println("contact Page");
			Thread.sleep(2000);

			WebElement homePage = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
			homePage.click();
			System.out.println("home page");
			Thread.sleep(2000);


			System.out.println("This is layout three");
			//table

			WebElement table1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/fieldset/table"));
			for(WebElement row : table1.findElements(By.tagName("tr"))) {
				//System.out.println(row.getText());
				System.out.println("**********");
				for(WebElement col : row.findElements(By.tagName("td"))) {
					System.out.println(col.getText());
				}


				System.out.println("This is layout two");
				// text boxes
				WebElement textBox1 = driver.findElement(By.id("fname"));
				textBox1.sendKeys("Soujanya");

				WebElement textBox2 = driver.findElement(By.id("lname"));
				textBox2.sendKeys("Kirni");
				System.out.println("text boxes");


				//radio buttons
				WebElement radioBtn1 = driver.findElement(By.id("male"));
				radioBtn1.click();
				Thread.sleep(500);
				System.out.println("button1 clicked!");	
				WebElement radioBtn2 = driver.findElement(By.id("female"));
				radioBtn2.click();
				Thread.sleep(500);
				System.out.println("button2 clicked!");	
				WebElement radioBtn3 = driver.findElement(By.id("other"));
				radioBtn3.click();
				System.out.println("button3 clicked!");	
				Thread.sleep(2000);


				//dropdown
				Select dropdown1 =new Select(driver.findElement(By.id("option")));
				dropdown1.selectByIndex(0);
				dropdown1.selectByIndex(1);
				dropdown1.selectByIndex(2);
				dropdown1.selectByIndex(3);
				Thread.sleep(2000);
				System.out.println("Dropdown selected!");


				//dropdown multiselect
				Select dropdown =new Select(driver.findElement(By.id("owc")));
				dropdown.selectByIndex(0);
				dropdown.selectByValue("option 1");
				dropdown.selectByIndex(2);
				dropdown.selectByVisibleText("Option 3");
				Thread.sleep(2000);
				System.out.println("Dropdown multiselect selected!");	


				//checkboxes
				driver.findElement(By.xpath("//input[@name='option1']")).click();
				driver.findElement(By.xpath("//input[@name='option2']")).click();
				driver.findElement(By.xpath("//input[@name='option3']")).click();
				System.out.println("checkboxes selected!");
				Thread.sleep(2000);


				//auto type
				WebElement inputField = driver.findElement(By.name("Options"));
				inputField.click();
				WebElement inputField1 = driver.findElement(By.name("Options"));
				inputField1.sendKeys("Straw");
				Thread.sleep(3000); 


				//favourite color
				WebElement color = driver.findElement(By.id("favcolor"));
				color.click();
				color.sendKeys("#C04C26");		
				System.out.println("favourite color choosen!");
				Thread.sleep(3000);


				//Calender
				WebElement calender = driver.findElement(By.id("day"));
				calender.click();
				Thread.sleep(2000);
				WebElement calender1 = driver.findElement(By.id("day"));
				calender1.sendKeys("000011-000012-001999");
				System.out.println("Calender");
				Thread.sleep(5000);

				driver.findElement(By.id("day")).click();
				driver.findElement(By.id("day")).sendKeys("0001-12-12");
				driver.findElement(By.id("day")).sendKeys("0019-12-12");
				driver.findElement(By.id("day")).sendKeys("0199-12-12");
				driver.findElement(By.id("day")).sendKeys("1999-12-12");
				Thread.sleep(5000);

				//range slider
				WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
				WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("a")));
				JavascriptExecutor js =(JavascriptExecutor) driver;
				js.executeScript("document.getElementById('a').value=99;");
				js.executeScript("document.getElementById('a').dispatchEvent(new Event('input'));");
				System.out.println("range slider successful!");
				Thread.sleep(2000);


				//file upload
				WebElement fupload = driver.findElement(By.id("myfile"));
				fupload.sendKeys("C:\\Users\\Soujanya\\Downloads\\i5.jpg");
				System.out.println("file upload");
				Thread.sleep(2000);


				//select input from drop down range
				WebElement range = driver.findElement(By.id("quantity"));
				range.click();
				//Thread.sleep(2000);
				WebElement range2 = driver.findElement(By.id("quantity"));
				range2.sendKeys("4");
				System.out.println("drop down range");
				Thread.sleep(2000);


				//long message
				WebElement longtext = driver.findElement(By.name("message"));
				longtext.clear();
				//Thread.sleep(2000);
				WebElement longtext1 = driver.findElement(By.name("message"));
				longtext1.sendKeys("Paragraphs are the building blocks of papers.");
				System.out.println("long message");
				Thread.sleep(2000);

				//submit button
				WebElement submitBtn = driver.findElement(By.xpath("//button[contains(.,'Submit')]"));
				submitBtn.click();
				System.out.println("Submitted");
			}
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("catch block executed");
		}
		finally {
			System.out.println("finally block executed");
			//driver.quit();
		}	
	}
}
