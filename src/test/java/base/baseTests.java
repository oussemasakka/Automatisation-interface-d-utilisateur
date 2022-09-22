package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class baseTests{
	public WebDriver driver;
	@BeforeMethod
	public void setUp() {
		String projectlocation = System.getProperty("user.dir");
		//System.out.println(projectlocation);
		System.setProperty("webdriver.chrome.driver", projectlocation +"/Resources/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("http://192.168.1.203:9002/login");
		driver.manage().window().maximize();

	}
	@AfterMethod
	public void tearDown() {

		driver.quit();

	}


}
