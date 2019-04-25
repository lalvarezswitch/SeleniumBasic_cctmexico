package org.testerselenium.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseQuit {
	static WebDriver driver;
	static String baseUrl = "http://www.popuptest.com/popuptest2.html";
	static String chromePath = System.getProperty("user.dir")+"/drivers/chromedriver.exe";
	
	public static void cerrar() {
		driver = new ChromeDriver();
		driver.navigate().to(baseUrl);
		driver.close();		
	} 
	
	public static void cerrarTodo() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromePath);
		cerrarTodo();
	}

}
