package com.qa.Utilities;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {

	WebDriver driver;

	public WebDriver browsersetup(String browsername, WebDriver driver) {
		if (browsername.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\vkjai\\eclipse-workspace\\Seleniumnew\\Drivers\\chromedriver.exe");
			//killinstance(browsername);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

		else if (browsername.equalsIgnoreCase("FF")) {

			System.setProperty("webdriver.firefox.driver",
					"C:\\Users\\vkjai\\eclipse-workspace\\Seleniumnew\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			Alert alert = driver.switchTo().alert();
			//alert.authenticateUsing(new UserAndPassword("username", "password"));
	       
	        

		} else {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\vkjai\\eclipse-workspace\\Seleniumnew\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		return driver;
	}

	public void killinstance(String browsername ) 
	{
		browsername = browsername.trim().toLowerCase();
		System.out.println("<<<<======================================================================================================>>>>");
		try {
		Process process = Runtime.getRuntime().exec("tasklist.exe");
		Scanner sc = new Scanner(process.getInputStream());
		while(sc.hasNext()) {
			
			String processName = sc.nextLine().trim().split(" ")[0].trim();
			try {
				
			if(processName.equals(browsername + "driver.exe")|| processName.equals(browsername + ".exe")) {
				
				System.out.println("Killing----:" + processName);
				WindowsUtils.killByName(processName);
				
				
			}	
			}catch (ExceptionInInitializerError e) {
				System.out.println("===============");
			}			
				
				
			}
			
			
		}
		catch (Exception e) {
			System.out.println("==> error while killing the process");
		}	System.out.println("<<<=======================================================================================================>>>>");
		}}
