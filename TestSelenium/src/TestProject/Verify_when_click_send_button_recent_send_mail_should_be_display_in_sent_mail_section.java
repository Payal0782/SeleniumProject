package TestProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verify_when_click_send_button_recent_send_mail_should_be_display_in_sent_mail_section {
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

		//type in reciepients inputarea
		element =driver.findElement(By.xpath("//textarea[@rows='1']"));
		element.sendKeys("payal0782@gmail.com");
		String text =driver.findElement(By.xpath("//textarea[@rows='1']")).getAttribute("value");
		//print text enters in subject
		System.out.println("reciepient ="+text);
		//verify text entered 

		//type in in message body 
		element =driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
		element.sendKeys("test email body");
		String msg =driver.findElement(By.xpath("//div[@aria-label='Message Body']")).getText();
		//print text enters in subject
		System.out.println("msg ="+msg);

		//type in subject textbox
		element =driver.findElement(By.xpath("//input[@name='subjectbox']"));
		element.sendKeys("test subject");
		String subject =driver.findElement(By.xpath("//input[@name='subjectbox']")).getAttribute("value");
		//print text enters in subject
		System.out.println("subject ="+subject);

		//click close 
		element =driver.findElement(By.xpath("//img[@aria-label='Save & close']"));
		element.click();

		//click drafts from menu option
		element =driver.findElement(By.xpath("//a[contains(text(),'Drafts')]"));
		element.click();

		String text1 =driver.findElement(By.xpath("//span[contains(text(),'test email body')]")).getText();
		if(text1.equalsIgnoreCase("test email body"))

		{
			System.out.println("msg not send appears in draft");
		}
		else
		{
			System.out.println("msg does not appears in draft");
		}
		driver.close();

	}
}
