package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Task {

	public static void main(String[] args) throws IOException {
		String filePath="./Excelutil/Fileforpractise.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		 Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("practise");
		int count = sheet.getPhysicalNumberOfRows();
		int num = sheet.getLastRowNum();
		for(int i=1;i<num;i++) {
			Row row = sheet.getRow(i);
			String firstcol = row.getCell(1).getStringCellValue();
			String secondcol = row.getCell(2).getStringCellValue();
			System.out.println(firstcol + " /t "   + secondcol);
		}
	}

}
