package InputLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class InputLayer_ExcelRead 
{
	HSSFRow row;
	HSSFCell cell;
	public List<List<String>> ReadExcel(String filename, String sheetName) throws IOException
	{
		File file = new File(filename);
		FileInputStream inputstream =  new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(inputstream);
		HSSFSheet sheet = workbook.getSheet(sheetName);
		List<List<String>> completeTest = new ArrayList<>();
		for(int i=0; i<sheet.getPhysicalNumberOfRows();i++)
		{
			row = sheet.getRow(i);
			List<String> testcaseData = new ArrayList<>();
			for(int j =0; j<row.getPhysicalNumberOfCells();j++)
			{
				cell = row.getCell(j);
				testcaseData.add(cell.getStringCellValue());
			}
			
			completeTest.add(testcaseData);
		}
		
			return completeTest;
	}

}
