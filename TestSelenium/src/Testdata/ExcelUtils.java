package Testdata;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
public class ExcelUtils {
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    public static  void main(String args[]) throws IOException {

  	
	  File file =    new File("C:\\Users\\payal.agarwal\\Desktop\\TestData.xlsx");
	  FileInputStream inputStream = new FileInputStream(file);
	  XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	  XSSFSheet sheet = workbook.getSheetAt(0);
	  
	  XSSFCell row = sheet.getRow(0).getCell(0);
	  System.out.println("row="+row);
	
	  System.out.println(sheet.getRow(0).getCell(0));
	
	  System.out.println(sheet.getRow(0).getCell(1));
	 
	  
	  System.out.println(sheet.getRow(1).getCell(0));
	  
	 
	  System.out.println(sheet.getRow(1).getCell(1));
	  int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
      
      //iterate over all the row to print the data present in each cell.
      for(int i=0;i<=rowCount;i++){
          
          //get cell count in a row
          int cellcount=sheet.getRow(i).getLastCellNum();
          
          //iterate over each cell to print its value
          System.out.println("Row"+ i+" data is :");
          for(int j=0;j<cellcount;j++){
              System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
          }
          System.out.println();

}
    }
}

  



