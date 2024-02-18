package com.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.genericUtils.BaseClass;

import objectRepositoryPages.Homepage;

import java.util.HashMap;
import java.util.Map;
public class TcPart1 extends BaseClass {

	@Test
	    public  void tc1() throws Throwable {
	        
		Logger log;
		log = LogManager.getLogger(this.getClass());
		log.debug("-------Opening Browser and Navigating to the Website------");
	    	
		driver.get(fLib.getPropertyKeyValue("url"));
	    	Homepage hmpg = new Homepage(driver);

	        
	    	log.debug("-------Clicking on Email and sending the values------");
	        hmpg.getEmailbtn().sendKeys(fLib.getPropertyKeyValue("username"));
	        log.debug("-------Clicking on Password and sending the values------");
	        hmpg.getPassBtn().sendKeys(fLib.getPropertyKeyValue("password"));
	        log.debug("-------Clicking on Login------");
	        hmpg.getLogin().click();
	        Thread.sleep(3000);
	        log.debug("-------Closing the popup------");
	        hmpg.getPopup().click();
	        Thread.sleep(3000);
	        log.debug("-------Clicking on Chargeback button------");
	        hmpg.getCharback().click();
	        Thread.sleep(2000);
	        log.debug("-------Clicking on History by store button------");
	        hmpg.getHistory().click();
	        Thread.sleep(30000);

	        Map<Integer, String> month = new HashMap<Integer, String>();
	        month.put(2, "Aug 2023");
	        month.put(3, "Sep 2023");
	        month.put(4, "Oct 2023");
	        month.put(5, "Nov 2023");
	        month.put(6, "Dec 2023");
	        month.put(7, "Jan 2023");
	        month.put(8, "Feb 2024");
	        double sum = 0;
	        
	        log.debug("-------Extracting and validating the table data------");
	        for(int i =2;i <= 8 ; i++) {
	        	System.out.println("Data for the month " + month.get(i)+ " :");
	        	for(int j = 2; j<=10;j++) {
	        		WebElement cell = driver.findElement(By.xpath("//table[@class='MuiTable-root css-l6sbfr-MuiTable-root']//tbody//tr["+j+"]//td["+i+"]"));
	        		String cellText =  cell.getText().replace("$", "").trim();
	        		cellText = cellText.replace(",", "");
	                double cellVal = Double.parseDouble(cellText);
	                sum = sum + cellVal;
	                System.out.print(cellVal);
	                if(j<10) {
	        		System.out.print(" + ");
	        		}
	        	}
	        	System.out.println(" = $"+sum);
	        	WebElement totalSum = driver.findElement(By.xpath("//table[@class='MuiTable-root css-l6sbfr-MuiTable-root']//tbody//tr[12]//td["+i+"]"));
	        	String sum1 =  totalSum.getText().replace("$", "").trim();
	        	System.out.println("Actual sum : $" + sum1);
	        	sum1 = sum1.replace(",", "");
	        	double actSum = Double.parseDouble(sum1);
                if(sum == actSum)
                	System.out.println("The sum matches the Grand Total");
                else
                	System.out.println("The sum does not match the Grand Total");
	        	sum = 0;
	        	actSum=0;
	        	System.out.println("\n");
	        }
	 }
	        
}


	        


	

