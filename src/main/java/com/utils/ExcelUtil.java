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
	
	private String fileName;
	private String sheetName;
	private FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	private InputStream	fis = null;
	
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
