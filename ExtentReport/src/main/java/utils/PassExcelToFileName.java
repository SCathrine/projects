package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PassExcelToFileName {

	public static String[][] readData(String filename) throws IOException {
		
		XSSFWorkbook wb=new XSSFWorkbook("data/"+filename+".xlsx");
		XSSFSheet ws=wb.getSheetAt(0);
		int lastRowNum = ws.getLastRowNum();
		short lastCellNum = ws.getRow(0).getLastCellNum();
	   //XSSFCell cell = ws.getRow(0).getCell(0);
		String[][] data=new String[lastRowNum][lastCellNum]; //array size
		for(int i=1;i<=lastRowNum;i++) {
			for(int j=0;j<lastCellNum;j++) {
				
				XSSFRow row = ws.getRow(i); //1
				XSSFCell cell = row.getCell(j);//r->1 , cell->0
				String stringCellValue = cell.getStringCellValue();//data at cell 0
				
				data[i-1][j]=stringCellValue;//pass to array
				
				
				
			}
		}
		
		wb.close();
		return data;
		
	}
	}


