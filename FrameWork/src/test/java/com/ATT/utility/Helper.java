// Helper class can include Screenshots, Frames, alerts, windows, sync issue, javascriptexecutor

package com.ATT.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	static WebDriver driver;

	public static String captureScreenShot() {  // here i am not passing the WebDriver as argument
		// and adding it as global variable, will it make any difference when calling the helper class
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

			String screenpath = System.getProperty("user.dir") + "./ScreenShots/Login_ATT" + getCurrentDateTime() + ".png";
			File Destination = new File(screenpath);
			try {
			     FileHandler.copy(src, Destination);			
			// FileUtils.copyfile(src, Destination)
			// FileHandler.copy(src, new File(screenpath));
		} catch (IOException e) {
			System.out.println("We found excpetion here" + e.getMessage());
		}
			return screenpath;
	}

	public static String getCurrentDateTime() {
		DateFormat df = new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		Date currentdate = new Date();
		return df.format(currentdate);
	}

	// public void logCapture()
	// {
	// Logger log= Logger.getLogger("logCapture");
	// log.getName();

	// }
}
