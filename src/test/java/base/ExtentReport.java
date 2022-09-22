package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	static WebDriver driver ;
	
	public static void main (String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);  
        ExtentTest test1 = extent.createTest("test one","aaa");
        String projectlocation = System.getProperty("user.dir");
		//System.out.println(projectlocation);
		System.setProperty("webdriver.chrome.driver", projectlocation +"/Resources/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		test1.log(Status.INFO, "Start");

		driver = new ChromeDriver();
		
		driver.get("http://192.168.1.203:9002/login");
		driver.close();
		test1.pass("close") ;
		extent.flush();
		
	}


}
