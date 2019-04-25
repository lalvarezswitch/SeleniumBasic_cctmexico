package org.testerselenium.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExceptions {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		try {					
			String baseURL = "http://live.guru99.com/index.php/checkout/cart/";
			String actualResult = "";
			String expectedResult = "$615.00";
			String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
			
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
			driver.get(baseURL);
			driver.manage().window().maximize();
			
			//click en el link TV
			WebElement lnkTV = driver.findElement(By.linkText("TV"));
			lnkTV.click();
			
			//click en el boton ADD TO CART
			WebElement btnAddtoCart = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span"));
			btnAddtoCart.click();
			
			//obtener el precio
			WebElement lblSubtotal = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-total > span > span"));
			actualResult = lblSubtotal.getText();
			
			if (actualResult.contentEquals(expectedResult)) {
				System.out.println("Prueba Pasada! el resultado actual es: " + actualResult + " es igual a " + expectedResult);
			} else {
				System.out.println("Prueba fallada! el resultado actual es: " + actualResult + " no es igual a " + expectedResult);
			}
			
		} catch (NoSuchElementException ne) {
			System.err.println("No se encontró el WebElement: " + ne.getMessage());			
		} catch (WebDriverException we) {
			System.err.println("WebDriver falló: " + we.getMessage());			
		} catch (Exception ex) {
			System.err.println(ex.getMessage());			
		} finally {
			driver.close();			
		}
		
		
		
	}
	

}
