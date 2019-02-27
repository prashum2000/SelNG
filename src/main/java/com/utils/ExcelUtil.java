package com.utils;

import java.io.FileOutputStream;
import java.io.InputStream;

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
	
	public ExcelUtil (String fileName, String sheetName){
		
		this.sheetName = sheetName;
		this.fileName = fileName;
		try	{
			InputStream	fis=this.getClass().getResourceAsStream(fileName);				
			this.workbook = new XSSFWorkbook(fis);
			this.sheet = workbook.getSheet(sheetName);
			fis.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public ExcelUtil (String fileName){
		
		this.fileName = fileName;
		try{
			InputStream	fis=this.getClass().getResourceAsStream(fileName);			
			this.workbook = new XSSFWorkbook(fis);
			this.sheet = workbook.getSheetAt(0);
			fis.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
