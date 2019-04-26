package org.testerselenium.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Forms {
	static WebDriver driver;	
	
	public static void main(String[] args) {
		String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
		String baseUrl = "http://newtours.demoaut.com/";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver =  new ChromeDriver();
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		
		try {
			driver.findElement(By.xpath("//td[@class='mouseOut']/a[text()='REGISTER']")).click();
			
			WebElement txtFirstName = driver.findElement(By.name("firstName"));
			txtFirstName.sendKeys("Gil");
			Thread.sleep(1500);
			txtFirstName.clear();
			Thread.sleep(1500);
			txtFirstName.sendKeys("Gilberto");
			
			driver.findElement(By.name("address1")).sendKeys("64 Avenue, Palm Beach");
			
			Select dropdownCountry = new Select(driver.findElement(By.name("country")));
			Thread.sleep(2000);
			dropdownCountry.selectByValue("48");
			
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("gilberto@mail.com");
			driver.findElement(By.name("password")).sendKeys("123");
			
			WebElement txtConfirmPass = driver.findElement(By.cssSelector("input[name=\"confirmPassword\"]"));
			txtConfirmPass.sendKeys("123");
			txtConfirmPass.submit(); //aca se hace uso del método submit de Selenium
			//otra forma de hace este último paso es inspeccionar el elemento, seleccionarlo y dar clic en el botón Submit
			//driver.findElement(By.name("register")).click();
			
			System.out.println("Prueba exitosa! " + driver.findElement(By.xpath("//*[contains(text(),'Note:')]")).getText());
			
		} catch (NoSuchElementException ne) {
			System.err.println("No se encontró el WebElement: " + ne.getMessage());			
		} catch (WebDriverException we) {
			System.err.println("WebDriver falló: " + we.getMessage());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			driver.quit();
		}		
		
	}
	

}
