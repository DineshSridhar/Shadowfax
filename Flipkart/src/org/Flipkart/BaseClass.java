package org.Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	 WebDriver driver;
	 
	 public WebDriver getDriver() {
		 
		 System.setProperty("webdriver.chrome.driver","E:\\Ecllipse_Projects\\Shadowfox\\Flipkart\\Driver\\chromedriver.exe");
		  driver = new ChromeDriver();
		return driver;
	}
	 public void loadUrl(String Url) {
		driver.get(Url);

	}
	 public void type(WebElement element,String name) {
		element.sendKeys(name);

	}
	 public void btnClick(WebElement element) {
		element.click();

	}
	 public void quitBrowser() {
		driver.quit();

	}
}
