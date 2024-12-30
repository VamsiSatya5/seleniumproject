package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Abhibus {

	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.abhibus.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).click();
		Actions act=new Actions(driver);
		
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		WebElement toPlace=driver.findElement(By.xpath("//input[@placeholder=‘To Station’]"));
		toPlace.click();
		toPlace.sendKeys("vijayawada");

		WebElement seach=driver.findElement(By.xpath("//button[text()='Search’])"));
		seach.click();

		
	}

}
