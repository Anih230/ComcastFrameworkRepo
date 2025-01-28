package com.comcast.crm.contacttest;


import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.com.genericwebdriverutility.JavaUtility;
import com.comcast.com.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

import POM.Repository.HomePage;
import POM.Repository.LoginPage;
import POM.Repository.createcontactspage;
import POM.Repository.createneworganizationPage;

public class CreateContactwithsupportdatetest {
	
	public static void main(String[] args) throws IOException {
		
		
	
				  
				  //Read test script data from Excel
				  String lastName = eLib.getdatafromexcel("Contact", 4, 2) +jLib.getrandomnumber();
				  String orgName = eLib.getdatafromexcel("Contact", 7, 2) + jLib.getrandomnumber();  
					
				  
				  //Step 2: Navigate to the Contacts module
				  HomePage hp=new 
					hp.getContactsLink().click();
				  //driver.findElement(By.xpath("//a[.='Contacts']")).click();
				  
				  //Step 3: Click on the Create Contacts button
					 createcontactspage cp = new createcontactspage(driver);
					  cp.getCreatecontactsbtn().click();
				  //driver.findElement(By.xpath("//img[@title='Create Contact...\']")).click();
				  
				  //Step 4: Enter the start, end date, and create new contact
		        createneworganizationPage cNCP = new createneworganizationPage(driver);
					  cNCP.createContactWithSupportDate(driver,orgName, 30);
					  
					/*
					 * String startDate = jLib.getSystemDateYYYYMMDD(); 
					 * String endDate = jLib.getRequiredDateYYYYMMDD(30);
					
					 * CreatingNewContactPage cNP=new CreatingNewContactPage(driver);
					 * cNP.getLastName().sendKeys(lastName);
					 * //driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName );
					 * driver.findElement(By.name("support_start_date")).clear();
					 * driver.findElement(By.name("support_start_date")).sendKeys(startDate);
					  
					 * driver.findElement(By.name("support_end_date")).clear();
					 * driver.findElement(By.name("support_end_date")).sendKeys(endDate);
					 * 
					 * cNP.getSaveBtn().click();
					 */
				  //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				  
				  //Verify start date and end date
				  String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
				  System.out.println(actStartDate);
				  if(actStartDate.equals(startDate)) {
					  System.out.println(startDate + " is verified. Test PASS");
				  }else
				  {
					  System.out.println(startDate + " is not verified. Test FAIL");
				  }
				  String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
				  System.out.println(actEndDate);
				  if(actEndDate.equals(endDate)) {
					  System.out.println(endDate + " is verified. Test PASS");
				  }else
				  {
					  System.out.println(endDate + " is not verified. Test FAIL");
				  }
				  
				  //Step 5: Log out
				  hp.logout(driver);
				  /*
					 * WebElement
					 * ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"
					 * )); wLib.mouseMoveOnElement(driver, ele);
					 * driver.findElement(By.linkText("Sign Out")).click();
					 */
				  //driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				
				  driver.quit();
}

}


	
	





