package com.qa.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot  {
	
/*	public static String currentDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Calendar cal = Calendar.getInstance();
	    String cal1 = dateFormat.format(cal.getTime());
	    return cal1;
	}
*/	

	public String Takescreenshot(WebDriver driver, String ScreenShotname) throws IOException {
        
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		ScreenShotname = ScreenShotname + formater.format(calendar.getTime()) + ".jpg";
		String directory = "C://Users//vkjai//eclipse-workspace//Seleniumnew//TestEvidence";
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SourceFile, new File(directory + "//" + ScreenShotname ));
		String destination = directory + "//" + ScreenShotname ;
		
		return destination;

	}

}


