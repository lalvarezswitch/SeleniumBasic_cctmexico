package org.testerselenium.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Class33 {
	static WebDriver driver =  new ChromeDriver();
	static String baseUrl = "http://newtours.demoaut.com/";
	static String chromePath = System.getProperty("user.dir")+"/drivers/chromedriver.exe";
	
	public static void testRegistrar() {
		driver.navigate().to(baseUrl);
		WebElement lnkRegister = driver.findElement(By.xpath("//td[@class='mouseOut']/a[text()='REGISTER']"));
		lnkRegister.click();
		Select dropdownCountry = new Select(driver.findElement(By.name("country")));
		dropdownCountry.selectByIndex(3);
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromePath);
		testRegistrar();
		
		
	}
	

}
