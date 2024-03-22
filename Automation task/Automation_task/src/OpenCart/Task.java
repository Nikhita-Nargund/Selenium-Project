package OpenCart;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task {
	
	//Web driver is the interface 
    WebDriver driver;
		
	 @BeforeClass
	 public void SetUp() throws InterruptedException {
		 
		 //Edge driver path
		 System.setProperty("webdriver.edge.driver", "C:\\Users\\nikhita.nargund\\Desktop\\Accelerate_tasks\\edgedriver_win64 (3)\\msedgedriver.exe");
		 driver = new EdgeDriver();
				
		 //Maximize the window
		 driver.manage().window().maximize();
						
		 //Open the browser
		 driver.get("https://demo.opencart.com/");
		 Thread.sleep(2000);
	 }
	 
	 @Test
	 public void test() throws InterruptedException, IOException{
		 
		//Click on Laptops and Notebooks
		driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[2]")).click();
		Thread.sleep(3000);
		
		//Click on show all laptops and Notebooks
		driver.findElement(By.xpath("(//a[@class='see-all'])[2]")).click();
		Thread.sleep(3000);
		
		//Scroll down till sort by is visible
        JavascriptExecutor js = ((JavascriptExecutor) driver);
	    WebElement Element = driver.findElement(By.id("input-sort"));		
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(3000);
        
        //Select sort by ----price(Low>High)---Dropdown
      	Select sort = new Select(driver.findElement(By.id("input-sort")));
      	sort.selectByIndex(3);
   		Thread.sleep(3000);
   		
   		//Scroll down till image is visible
        JavascriptExecutor js1 = ((JavascriptExecutor) driver);
	    WebElement Element1 = driver.findElement(By.xpath("(//img[@class='img-fluid'])[3]"));		
        js1.executeScript("arguments[0].scrollIntoView();", Element1);
        Thread.sleep(3000);
        
        //Click on 1st Product
        driver.findElement(By.xpath("(//img[@class='img-fluid'])[3]")).click();
        Thread.sleep(3000);
        
        //Scroll down till specification is visible
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
	    WebElement Element2 = driver.findElement(By.id("specification-tab"));		
        js2.executeScript("arguments[0].scrollIntoView();", Element2);
        Thread.sleep(3000);
        
        //Click on Specifications
        driver.findElement(By.id("specification-tab")).click();
        Thread.sleep(3000);
        
        //Print memory and process details
        String details = driver.findElement(By.id("tab-specification")).getText();
        System.out.println(details);
        System.out.println("-------------------------------------------------------");
		Thread.sleep(3000);
   		
   		//Click on Review
		driver.findElement(By.id("review-tab")).click();
		Thread.sleep(3000);
		
		//Enter your Name
		driver.findElement(By.name("name")).sendKeys("Nikhita Nargund");
		Thread.sleep(3000);
		
		//Enter your Review
		driver.findElement(By.id("input-text")).sendKeys("The product is very good worth buying");
		Thread.sleep(3000);
		
		//Scroll down till radio button is visible
        JavascriptExecutor js3 = ((JavascriptExecutor) driver);
	    WebElement Element3 = driver.findElement(By.xpath("(//input[@class='form-check-input'])[3]"));		
        js3.executeScript("arguments[0].scrollIntoView();", Element3);
        Thread.sleep(3000);
		
		//Select 3rd radio button---Rating
		driver.findElement(By.xpath("(//input[@class='form-check-input'])[3]")).click();
		Thread.sleep(3000);
		
		//Click on Continue
		driver.findElement(By.id("button-review")).click();
		Thread.sleep(3000);
		
		//Print the success pop up message
		String message = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
   		System.out.println(message);
   		System.out.println("---------------------------------------------------------");
   		
   		//Scroll up till date is visible
   		JavascriptExecutor js4 = ((JavascriptExecutor) driver);
	    WebElement Element4 = driver.findElement(By.xpath("//input[@class='form-control date']"));		
        js4.executeScript("arguments[0].scrollIntoView();", Element4);
        Thread.sleep(3000);
        
        //Click on today's date
        driver.findElement(By.xpath("//input[@class='form-control date']")).click();
        Thread.sleep(3000);
        
        //Select today's date
        driver.findElement(By.xpath("//td[@class='active start-date active end-date available']")).click();
        Thread.sleep(3000);
        
        //Change Quantity to 2
        driver.findElement(By.id("input-quantity")).click();
      	driver.findElement(By.id("input-quantity")).clear();
      	driver.findElement(By.id("input-quantity")).sendKeys("2");
      	Thread.sleep(3000);
      	
      	//Click on Add to cart
      	driver.findElement(By.id("button-cart")).click();
      	Thread.sleep(5000);
      	
      	//Print the message
      	String alert = driver.findElement(By.id("alert")).getText();
        System.out.println(alert);
        Thread.sleep(3000);    
	 }
	 
	 @AfterClass
		public void TearDown() {
			driver.quit();
		}	 
}
