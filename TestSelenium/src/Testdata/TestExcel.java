package Testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Constant;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestExcel {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/payal.agarwal/Desktop/chromedriver_win32 (5)/chromedriver.exe");
		  File file =    new File("C:\\Users\\payal.agarwal\\Desktop\\TestData.xlsx");
		  FileInputStream inputStream = new FileInputStream(file);
		  XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		  XSSFSheet sheet = workbook.getSheetAt(1);
		  int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	        
	       //Creating an object of ChromeDriver
	        WebDriver driver = new ChromeDriver();
	        
	        //Navigate to the URL
	        driver.get("https://demoqa.com/automation-practice-form");
	 
	 
	        //Identify the WebElements for the student registration form
	        WebElement firstName=driver.findElement(By.id("firstName"));
	        WebElement lastName=driver.findElement(By.id("lastName"));
	        WebElement email=driver.findElement(By.id("userEmail"));
	        WebElement genderMale= driver.findElement(By.id("gender-radio-2"));
	        WebElement mobile=driver.findElement(By.id("userNumber"));
	        WebElement address=driver.findElement(By.id("currentAddress"));
	        WebElement submitBtn=driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
	 
	        
            
	 
	        //iterate over all the rows in Excel and put data in the form.
	        for(int i=1;i<=rowCount;i++) {
	            //Enter the values read from Excel in firstname,lastname,mobile,email,address
	            firstName.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
	            lastName.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
	            email.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
	            //Cell cell1 = sheet.getRow(i).getCell(0);   
	            //mobile.sendKeys(cell1.getNumericCellValue());
	            address.sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());
	            
	            //Click on the gender radio button using javascript
	            //JavascriptExecutor js = (JavascriptExecutor) driver;
	            //js.executeScript("arguments[0].click();", genderMale);
	            JavascriptExecutor jse = (JavascriptExecutor)driver;
	    		jse.executeScript("scroll(0, 250);");
	            Thread.sleep(3);
	            //Click on submit button
	            submitBtn.click();
	            
	            //Verify the confirmation message
	            WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));
	            
	            //create a new cell in the row at index 6
	            XSSFCell cell = sheet.getRow(i).createCell(6);
	            
	            //check if confirmation message is displayed
	            if (confirmationMessage.isDisplayed()) {
	                // if the message is displayed , write PASS in the excel sheet
	                cell.setCellValue("PASS");
	                
	            } else {
	                //if the message is not displayed , write FAIL in the excel sheet
	                cell.setCellValue("FAIL");
	            }
	            
	            // Write the data back in the Excel file
	            FileOutputStream outputStream = new FileOutputStream("E:\\TestData\\TestData.xls");
	            workbook.write(outputStream);
	 
	            //close the confirmation popup
	            WebElement closebtn = driver.findElement(By.id("closeLargeModal"));
	            closebtn.click();
	            
	            //wait for page to come back to registration page after close button is clicked
	            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	        }
	        
	        //Close the workbook
	        workbook.close();
	        
	        //Quit the driver
	        driver.close();
	        }
	}


