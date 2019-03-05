package com.utils;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.bo.User;
import com.google.gson.Gson;

/** 
 * @author 105284
 */

public class DataproviderForTest{
	
	/**
	 * Read the data from the excel for a particular userRole
	 * Reads all the rows and coloums from the excel sheet and stores it in map as key being the userRole and values being username and password  
	 *   
	 * @author 105284
	 *
	 */
	
	public static User readdata(String userRole) {
		
		Map<String, User> mapOfUsers = new HashMap<String, User>();
		
		User user = new User();

		ExcelUtil abaCredential = new ExcelUtil(Constants.TESTDATA_ABACREDENTIALS);
		
		int rowCount = abaCredential.sheet.getLastRowNum()+1;
		int colCount = abaCredential.sheet.getRow(0).getLastCellNum();
		
				
		for(int i=1;i<rowCount;i++){
			 
			abaCredential.row =abaCredential.sheet.getRow(i);
			
			  for(int j = 0;j<colCount;j++){
				  abaCredential.cell =  abaCredential.row.getCell(j);
				  
				  if (abaCredential.cell.getColumnIndex()== 0) {
					  user.userRole = abaCredential.cell.getStringCellValue();
				  }
				  
				  if (abaCredential.cell.getColumnIndex()== 1) {
					  
					  user.userName = abaCredential.cell.getStringCellValue();
				  }
				  
				  if (abaCredential.cell.getColumnIndex()== 2) {
					  
					  user.passWord = abaCredential.cell.getStringCellValue();
				  } 
				  if (abaCredential.cell.getColumnIndex()== 3) {
					  
					  user.firstName = abaCredential.cell.getStringCellValue();
				  } 				  
				  if (abaCredential.cell.getColumnIndex()== 4) {
	  
					  user.lastName = abaCredential.cell.getStringCellValue();
				  } 				  

				  
				
			}
			  
			  mapOfUsers.put(user.userRole, user);
			  user = new User();
		
		}
		
		 
		return mapOfUsers.get(userRole); 	
		
	} 	
	
	/**
	 * DataProvider for Admin Credentials
	 * @return
	 * @throws Exception
	 */
	
	  @DataProvider(name="adminData")
	  public static Object[][] adminData() throws Exception { 
		  User user = readdata("Admin");
		  Object[][] data = new Object[1][1];
		  data[0][0] = user;
		
		  return data;
	  }
	 
	
	  /**
		 * DataProvider for Staff Credentials
		 * @return
		 * @throws Exception
		 */
	  
	  @DataProvider(name="staffData")
	  public static Object[][] staffData() throws Exception { 
		  User user = readdata("Staff");
		  Object[][] data = new Object[1][1];
		  data[0][0] = user;
		
		  return data;
	  }
	  
	  /**
		 * DataProvider for Dean Credentials
		 * @return
		 * @throws Exception
		 */
	
	  @DataProvider(name="deanData")
	  public static Object[][] deanData() throws Exception { 
		  User user = readdata("Dean");
		  Object[][] data = new Object[1][1];
		  data[0][0] = user;
		
		  return data;
	  }
	  
	  /**
		 * DataProvider for Executive Credentials
		 * @return
		 * @throws Exception
		 */
	  
	  @DataProvider(name="abaExecutiveData")
	  public static Object[][] abaExecutiveData() throws Exception { 
		  User user = readdata("ABA Executive");
		  Object[][] data = new Object[1][1];
		  data[0][0] = user;
		
		  return data;
	  }
	  
	  /**
		 * DataProvider for Paralegal Credentials
		 * @return
		 * @throws Exception
		 */
	  
	  @DataProvider(name="paralegalData")
	  public static Object[][] paralegalData() throws Exception { 
		  User user = readdata("Paralegal Member");
		  Object[][] data = new Object[1][1];
		  data[0][0] = user;
		
		  return data;
	  }
	  
	  /**
		 * DataProvider for IR Credentials
		 * @return
		 * @throws Exception
		 */
	  
	  @DataProvider(name="irData")
	  public static Object[][] irData() throws Exception { 
		  User user = readdata("Internal Reviewer");
		  Object[][] data = new Object[1][1];
		  data[0][0] = user;
		
		  return data;
	  }
	  
	  /**
		 * DataProvider for Council Credentials
		 * @return
		 * @throws Exception
		 */
	  
	  @DataProvider(name="councilData")
	  public static Object[][] councilData() throws Exception { 
		  User user = readdata("Council");
		  Object[][] data = new Object[1][1];
		  data[0][0] = user;
		
		  return data;
	  }
}
