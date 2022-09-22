package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage {
	private WebDriver driver;
	private By Users = By.xpath("//a[@id='USERS']");



	public SettingsPage(WebDriver driver) {
		this.driver =driver;
	}

	public UserPage clickUsersTab() {	
		driver.findElement(Users).click();	
		return new UserPage(driver);
	}








}