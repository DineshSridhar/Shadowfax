
//**Use Eclipse 2910-87 JRE 1.8 Windows 7 64Bit 
//Chrome Browser 74.0
//Cucumber Frame work used
//Import project Via Maven Project


package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PurchaseItemFromFlipkart extends BaseClass{

	
	@Given("User sould be in Flipkart page to buy a Product")
	public void user_sould_be_in_Flipkart_page_to_buy_a_Product() throws InterruptedException {
		BaseClass b = new BaseClass();
		 driver = b.getDriver();
		b.loadUrl("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Given("User should navigate to Electronics and Mobile section to select Oppo A{int}S Mobile")
	public void user_should_navigate_to_Electronics_and_Mobile_section_to_select_Oppo_A_S_Mobile(Integer int1) throws InterruptedException {
		BaseClass b = new BaseClass();
		PurchaseItemFromFlipkart p = new PurchaseItemFromFlipkart();
		WebElement clsButton = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		b.btnClick(clsButton);
		WebElement clcElectronics = driver.findElement(By.xpath("//span[text()='Electronics']"));
		Actions acc = new Actions(driver);
		acc.moveToElement(clcElectronics).perform();
		Thread.sleep(3000);
		
		WebElement clkOppo = driver.findElement(By.xpath("//a[text()='OPPO']"));
		b.btnClick(clkOppo);
		Thread.sleep(3000);
	}

	@When("User should click on ADD cart")
	public void user_should_click_on_ADD_cart() throws InterruptedException {
		BaseClass b = new BaseClass();
	    WebElement clkView = driver.findElement(By.xpath("(//a[@class='_2AkmmA _1eFTEo'])[2]"));
		b.btnClick(clkView);
		Thread.sleep(3000);
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
		WebElement txtPincode = driver.findElement(By.xpath("//input[@class='_3X4tVa']"));
		b.type(txtPincode, "600042");
		
		String name = txtPincode.getAttribute("value");
		System.out.println(name);
		Thread.sleep(3000);
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
	}

	@When("User should Click on Flipkart main icon to go back to home screen")
	public void user_should_Click_on_Flipkart_main_icon_to_go_back_to_home_screen() {
		driver.navigate().to("https://www.flipkart.com/");
	}

	@When("User should navigate back by Click on Cart and verify if item exists in the page")
	public void user_should_navigate_back_by_Click_on_Cart_and_verify_if_item_exists_in_the_page() throws InterruptedException {
		BaseClass b = new BaseClass();
		WebElement homePageCart = driver.findElement(By.xpath("//span[text()='Cart']"));
		b.btnClick(homePageCart);
		Thread.sleep(3000);
		WebElement compareCart = driver.findElement(By.xpath("//div[@class='_3vIvU_']"));
		String print2 = compareCart.getText();
		System.out.println(print2);
		
		String print = null;
		if (!(print==print2)) {
			System.out.println("equal");
		}
		else {
			System.out.println("Not equal");
		}
	}

	@When("User Click on Place Order")
	public void user_Click_on_Place_Order() {
		BaseClass b = new BaseClass();
		WebElement clkOrder = driver.findElement(By.xpath("//span[text()='Place Order']"));
		b.btnClick(clkOrder);
	}

	@When("User Should Login using their account")
	public void user_Should_Login_using_their_account() throws InterruptedException {
		BaseClass b = new BaseClass();
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
	}

	@When("Add order confirmation email and press continue")
	public void add_order_confirmation_email_and_press_continue() throws InterruptedException {
		BaseClass b = new BaseClass();
		WebElement clkContinue = driver.findElement(By.xpath("//button[@class='_2AkmmA _2Q4i61 _7UHT_c']"));
		b.btnClick(clkContinue);
		Thread.sleep(3000);
	}

	@When("On payments options select net banking select Corporation Bank")
	public void on_payments_options_select_net_banking_select_Corporation_Bank() throws InterruptedException {
		BaseClass b = new BaseClass();
		WebElement clkPaym = driver.findElement(By.xpath("//div[text()='Net Banking']"));
		b.btnClick(clkPaym);
		Thread.sleep(3000);
		//select other banks and chosse coroperation
		WebElement ChooseBank = driver.findElement(By.xpath("//select[@class='_1CV081']"));
		Select s = new Select(ChooseBank);
		
		
			s.selectByIndex(18);
			Thread.sleep(2000);
	}

	@Then("Take screenshot of the Bank screen")
	public void take_screenshot_of_the_Bank_screen() throws IOException, InterruptedException {
		TakesScreenshot tk=(TakesScreenshot) driver;
		File s1 = tk.getScreenshotAs(OutputType.FILE);
		File d = new File("E:\\Ecllipse_Projects\\Shadowfox\\ItemPurchase\\Screenshot\\ScreenShot.png");
		FileUtils.copyFile(s1, d);
		Thread.sleep(2000);
		
		driver.quit();
	}


}
