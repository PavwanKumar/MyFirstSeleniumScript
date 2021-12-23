package com.test;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.google.common.io.Files;

public class FirstTest 
{
	
	WebDriver driver=null;
	
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pavwan\\eclipse-workspace1\\SampleTestProject\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in");
	}

	@Test
	public void methodOne() throws IOException
	{
		openBrowser();
		driver.findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
		captureScreenshot();
		quitDriver();
	}
	
	public void captureScreenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("./Screenshots/Screen.png"));
	}
	
	public void quitDriver()
	{
		driver.quit();
	}
}
