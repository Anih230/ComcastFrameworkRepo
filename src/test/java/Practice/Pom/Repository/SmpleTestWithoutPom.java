package Practice.Pom.Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmpleTestWithoutPom {
	
	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://49.249.28.218:8888/");
		WebElement ele1 = driver.findElement(By.name("user_name"));
		WebElement ele2 = driver.findElement(By.name("user_password"));
		WebElement ele3 = driver.findElement(By.id("submitButton"));
		ele1.sendKeys("admin");
		ele2.sendKeys("admin");
		driver.navigate().refresh();
		ele1.sendKeys("admin");
		ele2.sendKeys("admin");
		ele3.click();
			 
		
	}

}
