package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j2
import org.apache.logging.log4j.Logger; //log4j2
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
//import org.apache.logging.log4j.core.Logger;

public class Baseclass {
	
public WebDriver driver;
public Logger logger; //log4j2
public Properties p;
	
	
	@BeforeClass(groups= {"Sanity","Regression"})
	@Parameters({"browser","platform"})
	public void setUp(String br,String os) throws IOException  {
		
		//Loading config.properties files
		FileInputStream file=new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
		p.load(file);
	
		
		logger=LogManager.getLogger(this.getClass());
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
				
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{

		
		switch(br.toLowerCase()) {
		case "chrome" :driver=new ChromeDriver(); break;
		case "firefox" :driver=new FirefoxDriver(); break;
		case "edge" :driver=new EdgeDriver(); break;
		default : System.out.println("Invalid");return;
		
		}
		}
		
		
		//driver=new ChromeDriver();
		//driver=new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(p.getProperty("https://tutorialsninja.com/demo/"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Sanity","Regression"})
	public void tearDown() {
		driver.quit();
		
	}
	
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		}

	
	//For randomnumber generation
	
	public String randomNumber() 
	{
		String generateNumber=RandomStringUtils.randomNumeric(10);
		return generateNumber;
			
	}
	
	//To generate random password which combination of numeric and alphabetic
	public String alphaNumeric() {
		String generatedString=RandomStringUtils.randomAlphabetic(4);
		String generateNumber=RandomStringUtils.randomNumeric(4);
		return (generatedString+generateNumber);
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	

}
