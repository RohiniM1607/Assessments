package Assessment18.AutomationTesting_Selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeApplicationTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();   //Full screen view of the chrome
		
		//1. Login to the Application
		driver.get("https://demoblaze.com/");   //Opening the demoblaze application
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("RohiniM");
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("Rohini_16");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		String greeting = "Welcome RohiniM";
		//System.out.println(driver.findElement(By.xpath("//a[text()='Welcome RohiniM']")).getText());
		if(greeting.equals(driver.findElement(By.xpath("//a[text()='Welcome RohiniM']")).getText()))
			System.out.println("Login Successful");
		
		
		
		//2. Category Navigation & Product Handling
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		List<String> allProducts = new ArrayList<>();

		// First page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tbodyid']//a[@class='hrefch']")));
		List<WebElement> firstPageProducts = driver.findElements(By.xpath("//div[@id='tbodyid']//a[@class='hrefch']"));

		for (WebElement p : firstPageProducts) {
		    allProducts.add(p.getText());
		}

		// Click next page
		wait.until(ExpectedConditions.elementToBeClickable(By.id("next2"))).click();
		wait.until(ExpectedConditions.stalenessOf(firstPageProducts.get(0)));   //Refered AI : Used ChatGPT
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tbodyid']//a[@class='hrefch']")));
		List<WebElement> secondPageProducts = driver.findElements(By.xpath("//div[@id='tbodyid']//a[@class='hrefch']"));

		for (WebElement p : secondPageProducts) {
		    allProducts.add(p.getText());
		}

		// Sort
		Collections.sort(allProducts);
		System.out.println("Sorted Products:");
		for (String product : allProducts) {
		    System.out.println(product);
		}
		
		
		
		//3. Add Product to Cart
		driver.findElement(By.xpath("//a[text()='MacBook Pro']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']"))).click();
		wait.until(ExpectedConditions.alertIsPresent());
		//5. Alert Handled
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[@id='cartur']")).click();
		String productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='MacBook Pro']"))).getText();
		String productPrice = driver.findElement(By.xpath("//td[text()='MacBook Pro']/following-sibling::td[1]")).getText();

		if (productTitle.equals("MacBook Pro") && productPrice.equals("1100")) {
		    System.out.println("Product added to cart");
		    System.out.println("MacBook Pro added to cart.");
		}
		
		System.out.println("Alert Handled Successful");
		driver.close();
	}

}
