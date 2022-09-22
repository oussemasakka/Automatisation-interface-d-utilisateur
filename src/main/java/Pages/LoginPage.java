package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	public LoginPage(WebDriver driver ) {this.driver=driver;}

	private WebDriver driver;

	private By email = By.xpath("//input[@name='Email']");
	private By password = By.xpath("//input[@name='Password']");
	private By login = By.xpath("//button[contains(text(),'Login')]");
	//private By settings = By.xpath("//header/ul[2]/li[5]/app-user-actions-dropdown[1]/li[1]/a[1]/div[1]");
	private By errorNotiflogin = By.xpath("//div[contains(text(),'E-mail erroné')] | //div[contains(text(),'Mot de passe erroné')] |//header/ul[2]/li[5]/app-user-actions-dropdown[1]/li[1]/a[1]/div[1] | //div[contains(text(),'REQUIRED_EMAIL_AND_PASSWORD')] | //div[contains(text(),'E-mail et mot de passe requis')]");



	public void setUserMail(String mail) {
		System.out.println("..................");
		driver.findElement(email).sendKeys(mail);
	}

	public void setUserPassword(String mdp) {

		driver.findElement(password).sendKeys(mdp);
	}

	public HomePage clickLoginButton() {

		driver.findElement(login).click();	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorNotiflogin)); 
		return new HomePage(driver);
	} 

	public String getErrorNotifLogin() {
		return driver.findElement(errorNotiflogin).getText();
	}


}


