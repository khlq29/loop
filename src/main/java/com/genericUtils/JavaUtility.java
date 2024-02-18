package com.genericUtils;

import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;



public class JavaUtility {
	public int getRandomData()
	{
		Random random = new Random();
		int ran = random.nextInt(1000);
		return ran;
	}


/*author @khaliq
 * 
 *
 */
  //**  this method is used to generate currrentdat   @return currentdate **/

public static String getCurrentDate()
{
	Date date = new Date();

    // Define the date format
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

    // Format the date object to the desired format
    String currentDateTime = dateFormat.format(date);

    return currentDateTime;
}


public static String getSystemDate() {
	Date date = new Date();
	return date.toString().replaceAll(" ","_").replace(":", "_");
	
}}