package org.Flipkart;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ItemPurchase {

	public static void main(String[] args) throws InterruptedException, IOException {
		BaseClass b = new BaseClass();
		WebDriver driver = b.getDriver();
		b.loadUrl("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//close POP
		WebElement clsButton = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		b.btnClick(clsButton);
		WebElement clcElectronics = driver.findElement(By.xpath("//span[text()='Electronics']"));
		
		Actions acc = new Actions(driver);
		acc.moveToElement(clcElectronics).perform();
		Thread.sleep(3000);
		
		WebElement clkOppo = driver.findElement(By.xpath("//a[text()='OPPO']"));
		b.btnClick(clkOppo);
		Thread.sleep(3000);
		
		//click view all

		WebElement clkView = driver.findElement(By.xpath("(//a[@class='_2AkmmA _1eFTEo'])[2]"));
		b.btnClick(clkView);
		Thread.sleep(3000);
		
		//Choosing OPPO A3s(purple 16GB)
		WebElement seleOppo = driver.findElement(By.xpath("//div[text()='OPPO A3s (Purple, 16 GB)']"));
		b.btnClick(seleOppo);
		Thread.sleep(3000);
		
		String par=driver.getWindowHandle();
		System.out.println(par);
		Set<String> chi=driver.getWindowHandles();
		System.out.println(chi);
		for (String x : chi) {
			if (!x.equalsIgnoreCase(par)) {
				driver.switchTo().window(x);
			}
		}
		Thread.sleep(3000);

		//Pincode
		WebElement txtPincode = driver.findElement(By.xpath("//input[@class='_3X4tVa']"));
		b.type(txtPincode, "600042");
		
		String name = txtPincode.getAttribute("value");
		System.out.println(name);
		Thread.sleep(3000);
		
		//clk check 
		WebElement clkCheck = driver.findElement(By.xpath("//span[text()='Check']"));
		b.btnClick(clkCheck);
		Thread.sleep(3000);
		
		
		//Add to cart
		WebElement clkCart = driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']"));
		b.btnClick(clkCart);
		Thread.sleep(3000);
		//print product avaulabe in cart to verify
		WebElement printProduct = driver.findElement(By.xpath("//div[@class='_3vIvU_']"));
		String print = printProduct.getText();
		System.out.println(print);
		
		//Navigating to home page
	driver.navigate().to("https://www.flipkart.com/");
	
	// Click on cart in home page to check the item exist on page
	WebElement homePageCart = driver.findElement(By.xpath("//span[text()='Cart']"));
	b.btnClick(homePageCart);
	Thread.sleep(3000);
	WebElement compareCart = driver.findElement(By.xpath("//div[@class='_3vIvU_']"));
	String print2 = compareCart.getText();
	System.out.println(print2);
	
	if (!(print==print2)) {
		System.out.println("equal");
	}
	else {
		System.out.println("Not equal");
	}
	
	//place order
	WebElement clkOrder = driver.findElement(By.xpath("//span[text()='Place Order']"));
	b.btnClick(clkOrder);
	
	//login
	WebElement txtLogin = driver.findElement(By.xpath("//input[@type='text']"));
	b.type(txtLogin, "8124244143");
	
	WebElement clkBtn = driver.findElement(By.xpath("//button[@class='_2AkmmA _1poQZq _7UHT_c']"));
	b.btnClick(clkBtn);
	Thread.sleep(3000);
	//password
	WebElement txtPass = driver.findElement(By.xpath("//input[@type='password']"));
	b.type(txtPass, "Welcome2");
	Thread.sleep(3000);
	
	WebElement clkLogin = driver.findElement(By.xpath("//button[@class='_2AkmmA _1poQZq _7UHT_c']"));
	b.btnClick(clkLogin);
	Thread.sleep(3000);
	
	//conformation mail in order summary
	WebElement clkContinue = driver.findElement(By.xpath("//button[@class='_2AkmmA _2Q4i61 _7UHT_c']"));
	b.btnClick(clkContinue);
	Thread.sleep(3000);
	//payment page
	
	WebElement clkPaym = driver.findElement(By.xpath("//div[text()='Net Banking']"));
	b.btnClick(clkPaym);
	Thread.sleep(3000);
	//select other banks and chosse coroperation
	WebElement ChooseBank = driver.findElement(By.xpath("//select[@class='_1CV081']"));
	Select s = new Select(ChooseBank);
	
	//List<WebElement> emp = s.getOptions();
	//for (int i = 0; i <emp.size(); i++) {
		s.selectByIndex(18);
		Thread.sleep(2000);
		//Screen of bank
		TakesScreenshot tk=(TakesScreenshot) driver;
		File s1 = tk.getScreenshotAs(OutputType.FILE);
		File d = new File("E:\\Ecllipse_Projects\\Shadowfox\\Flipkart\\Screenshot\\ScreenShot.png");
		FileUtils.copyFile(s1, d);
		Thread.sleep(2000);
		
		driver.quit();
	}
	}

