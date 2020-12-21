package TestProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verify_usercantype_email_in_emailbodysection {
	private static WebElement element = null;
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:/Users/payal.agarwal/Desktop/chromedriver_win32 (3)/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://mail.google.com/mail/u/0/#inbox");
	driver.manage().window().maximize();
	//click email textbox 
	element =driver.findElement(By.xpath("//input[@type='email']"));
	element.click();
	element.sendKeys("pa516086@gmail.com");
	//click next textbox 
	element =driver.findElement(By.xpath("//button[@jsname='LgbsSe']"));
	element.click();	
	//click password textbox
	element =driver.findElement(By.xpath("//input[@name='password']"));
	element.click();
	element.sendKeys("Payal@1234");
	//click next textbox
	element =driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
	element.click();
	//click compose icon 
	element =driver.findElement(By.xpath("//div[contains(text(),'Compose')]"));
	element.click();
	//verify new message msg appears after click compose 
	element =driver.findElement(By.xpath("//h2//div[contains(text(),'New Message')]"));
	boolean b1 = element.isDisplayed();
	if(b1)
	{
		System.out.println("New Message title gets dispaly when click compose ");
	}
	else
	{
		System.out.println("No New Message title gets dispaly when click compose ");
	}
	driver.close();
}
}