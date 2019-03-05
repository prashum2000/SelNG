package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public String fileName;
	public String sheetName;
	public FileOutputStream fileOut = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public InputStream	fis = null;
	
	public ExcelUtil (String fileToReadFrom, String SheetToReadFrom){
		
		this.sheetName = SheetToReadFrom;
		this.fileName = fileToReadFrom;
		
		try	{
			this.fis = new FileInputStream(new File(fileName));				
			this.workbook = new XSSFWorkbook(fis);
			this.sheet = workbook.getSheet(sheetName);
			fis.close();
		}catch (Exception e){
			Log.info(ExceptionUtils.getStackTrace(e));
		}
	}
	
	public ExcelUtil (String fileToReadFrom){
		
		this.fileName = fileToReadFrom;
		try{
			fis	= new FileInputStream(new File(fileName));			
			this.workbook = new XSSFWorkbook(fis);
			this.sheet = workbook.getSheetAt(0);
			fis.close();
		}catch (Exception e){
			Log.info(ExceptionUtils.getStackTrace(e));
		}
	}
	
	/**
	 * Given any excel file, reads the 1st column values into a List<String>
	 * @return
	 */
	public List<String> readStringValuesFromFirstColumn (){
		
		String cellValue = null; 		
		List<String> stringList = new ArrayList<String>();	  		
		Iterator<Row> rowIterator = sheet.rowIterator();
		
		while (rowIterator.hasNext()){
			
			row = (XSSFRow) rowIterator.next();
			int rowNum = row.getRowNum(); 			
			if (rowNum == 0) continue;			
			Iterator<Cell> cellIterator = row.cellIterator(); 
			
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int cellColumnNum = cell.getColumnIndex();
				
				if (cellColumnNum > 0) break;
				
				if (cell.getCellType() == Cell.CELL_TYPE_STRING){
					cellValue = cell.getStringCellValue().trim();
				} 				
				
			} 			
			
			stringList.add(cellValue);
			
		} 			
		
		return stringList;
	}

}
