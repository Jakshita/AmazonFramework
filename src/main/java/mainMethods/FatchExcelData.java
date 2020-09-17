package mainMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class FatchExcelData {
	
	//
	public static Object[][] excelData(String path,String Sheet) throws IOException, InvalidFormatException {
		FileInputStream fls=new FileInputStream(path);
		Workbook book=WorkbookFactory.create(fls);
		Sheet sheet=book.getSheet(Sheet);
		//System.out.println(sheet.getLastRowNum());
		//System.out.println(sheet.getRow(0).getLastCellNum());
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			Row r=sheet.getRow(i+1);
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
				Cell c=r.getCell(j);
				try {
					if(c.getCellType()== CellType.STRING) {
						data[i][j] = c.getStringCellValue();
					}else {
						data[i][j] = String.valueOf(c.getNumericCellValue());
					}
					
				}catch(Exception e) {
					
				}
			}
		}
		return data;
	}
	
}
