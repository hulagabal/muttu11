package dataDriver;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetData {

	public String[][] getdata() {
		String[][] arrayExcelData = null;

		XSSFWorkbook book = null;
		try {
			book = new XSSFWorkbook(new File("C:\\Users\\Mutturaj\\muttu11\\muttu11\\XLS files\\data.xlsx"));
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		XSSFSheet sheet = book.getSheetAt(0);

		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		Cell ceelValue = null;
		DataFormatter df = null;
		arrayExcelData = new String[rowcount+1][2];
		for (int i = 0; i < rowcount + 1; i++) {

			Row row = sheet.getRow(i);

			int lastCellNumber = row.getLastCellNum();
			
			for (int j = 0; j < lastCellNumber; j++) {

				ceelValue = row.getCell(j);

				df = new DataFormatter();
				System.out.println(df.formatCellValue(ceelValue));
				arrayExcelData[i][j] = df.formatCellValue(ceelValue);
				
			}

		}
		return arrayExcelData;
	}

	@DataProvider(name = "data")
	public Object[][] loginData() {
		Object[][] arrayObject = getdata();

		return arrayObject;
	}

	

}
