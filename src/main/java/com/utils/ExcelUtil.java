package com.utils;

import java.io.File;
import java.io.FileInputStream;
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
	} 	

}
