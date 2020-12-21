package TestProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verify_Usercantype_Subject_line_in_Subject_textbox {
	private static WebElement element = null;
	public static void main(String[] args) {

		String msg ="//h2//div[contains(text(),'New Message')]";
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
		//type in subject textbox
		element =driver.findElement(By.xpath("//input[@name='subjectbox']"));
		element.sendKeys("test subject");
		String text =driver.findElement(By.xpath("//input[@name='subjectbox']")).getAttribute("value");
		//print text enters in subject
		System.out.println("text ="+text);
		//verify text entered 
		if(text.equalsIgnoreCase("test subject"))

		{
			System.out.println("user is able to type in To section ");
		}
		else
		{
			System.out.println("user is not able to type in To section ");
		}
		driver.close();

	}
}

