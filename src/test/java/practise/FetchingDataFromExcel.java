package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcel {

	public static void main(String[] args) throws IOException {
		String filePath="./Excelutil/Fileforpractise.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		 Workbook workbook = WorkbookFactory.create(fis);
		String cellValue = workbook.getSheet("practise").getRow(1).getCell(1).toString();
		String cellValue1 = workbook.getSheet("practise").getRow(1).getCell(2).toString();
		String cellValue2 = workbook.getSheet("practise").getRow(1).getCell(3).toString();
	    String cellValue3 = workbook.getSheet("practise").getRow(1).getCell(4).toString();
		System.out.println(cellValue);
		System.out.println(cellValue1);
		System.out.println(cellValue2);
		System.out.println(cellValue3);
		Sheet getsheet = workbook.getSheet("practise");
		Row getrow = getsheet.getRow(1);
	       Cell cell = getrow.createCell(5);
	        cell.setCellValue("karate");
	        FileOutputStream fos=new FileOutputStream(filePath);
	        workbook.write(fos);
		workbook.close();

	}

}
