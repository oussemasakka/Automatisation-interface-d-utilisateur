package Pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	private By menuDown = By.xpath("//header/ul[2]/li[5]/app-user-actions-dropdown[1]/li[1]/a[1]/div[1]");
	private By settings = By.xpath("//header/ul[2]/li[5]/app-user-actions-dropdown[1]/li[1]/div[1]/button[3]");
	private By appName = By.xpath("//h4[contains(text(),'Total Ventes')]");
	private By RoleButtun = By.xpath("//a[@id='USERS']");

	public HomePage(WebDriver driver) {
		this.driver =driver;	
	}

	public void clickSettingsMenu() {	
		driver.findElement(menuDown).click();	
	}

	public SettingsPage clickSettingsButton() {

		driver.findElement(settings).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(RoleButtun)); 

		return new SettingsPage(driver);
	}

	public String getApplicationName() {
		return driver.findElement(appName).getText();



	}




}
