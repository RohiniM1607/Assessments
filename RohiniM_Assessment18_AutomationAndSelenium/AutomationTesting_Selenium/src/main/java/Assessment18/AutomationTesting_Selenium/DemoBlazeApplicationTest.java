package Assessment18.AutomationTesting_Selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeApplicationTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//1.Login to the Application
		driver.get("https://demoblaze.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@id='login2']")).click();
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='loginusername']")));
		username.sendKeys("RohiniM");
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("Rohini_16");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		try {
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			if (alert != null) {
				alert.accept();
				System.out.println("Login Failed");
			}
		}  // When no alert appears within the wait time, alert line throws a TimeOutException(Wait condition was not satisfied)
		catch (Exception e) {
			WebElement home = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Welcome RohiniM']")));

			if (home.getText().equals("Welcome RohiniM")) {
				System.out.println("Login Successful");
			}
		}
		
		
		//2.Category Navigation & Product Handling
		driver.findElement(By.xpath("//a[text()='Laptops']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='MacBook air']")));
		List<String> allLaptops = new ArrayList<>();

		// First page laptops
		List<WebElement> firstPage = driver.findElements(By.xpath("//div[@id='tbodyid']//h4/a"));
		for (WebElement laptop : firstPage) {
		    allLaptops.add(laptop.getText());
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.id("next2"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Apple monitor 24']")));

		// Second page laptops
		List<WebElement> secondPage = driver.findElements(By.xpath("//div[@class='row']//child::a[@class='hrefch']"));
		for (WebElement laptop : secondPage) {
		    allLaptops.add(laptop.getText());
		}

		Collections.sort(allLaptops);  //Sorting the laptops
		Set<String> laptopSet = new LinkedHashSet<>(allLaptops);
		for (String productTitle : laptopSet) {
		    System.out.println("Found Laptop: " + productTitle);
		}

		// MacBook Pro locator
		By macBookPro = By.xpath("//a[text()='MacBook Pro']");
		WebElement macbook = wait.until(ExpectedConditions.visibilityOfElementLocated(macBookPro));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", macbook);

		Actions action = new Actions(driver);
		action.moveToElement(macbook).perform();
		String laptopTitle = macbook.getText();

		if (laptopTitle.equals("MacBook Pro")) {
		    System.out.println("Found Laptop for purchase: " + laptopTitle);
		}

		


		//3.Add Product to Cart
		wait.until(ExpectedConditions.elementToBeClickable(macBookPro)).click();
		String expectedTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='name']"))).getText();
		String expectedPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='price-container']"))).getText().replaceAll("[^0-9]", "");

		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		System.out.println("Alert Handled Successfully");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();

		String actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[2]"))).getText();
		String actualPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[3]"))).getText();

		if (expectedTitle.equals(actualTitle) && expectedPrice.equals(actualPrice)) {
		    System.out.println("Product added to cart");
		    System.out.println("MacBook Pro added to cart.");
		} 
		else {
		    System.out.println("Product not added correctly");
		}
		
		//4. Place Order
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Rohini");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("city")).sendKeys("Chennai");
		driver.findElement(By.id("card")).sendKeys("1234567890123456");
		driver.findElement(By.id("month")).sendKeys("04");
		driver.findElement(By.id("year")).sendKeys("2026");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Purchase']"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Thank you for your purchase!']")));

		String purchase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']//p"))).getText();

		if (purchase.contains("Id")) {
		    System.out.println("Order is placed successfully");
		    String[] details = purchase.split("\n");
		    for (String detail : details) {
		        if (detail.startsWith("Id")) {
		            System.out.println("Order ID: " + detail.replace("Id: ", ""));
		        }
		        if (detail.startsWith("Amount")) {
		            System.out.println(detail);
		        }
		        if (detail.startsWith("Date")) {
		            System.out.println(detail);
		        }
		    }

		} 
		else {
		    System.out.println("Order is Unsuccessful");
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']"))).click();
		driver.close();
	}

}
