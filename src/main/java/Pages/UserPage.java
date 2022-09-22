package Pages;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.UtilMethode;

public class UserPage {
	private WebDriver driver;
	private By searchbar = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-list-user[1]/div[1]/div[1]/div[2]/kendo-grid[1]/kendo-grid-toolbar[1]/div[1]/div[1]/div[1]/app-search-user[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	private By rolebutton = By.xpath("//a[@id='ROLE']");
	private By emptymsg = By.xpath("//body[1]/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-list-user[1]/div[1]/div[1]/div[2]/kendo-grid[1]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]");
	private By editbutton = By.xpath("//tbody/tr[1]/td[8]/i[1]");
	private By deletebutton = By.xpath("//tbody/tr[1]/td[8]/i[2]");
	private By hidebutton = By.xpath("//tbody/tr[1]/td[8]/i[3]");
	private By rolechamp = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-user[1]/div[1]/div[2]/form[1]/p-accordion[1]/div[1]/p-accordiontab[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/app-multiselect-dropdown[1]/form[1]/ng-multiselect-dropdown[1]/div[1]/div[1]/span[1]");
	private By rolelist = By.xpath("/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-user[1]/div[1]/div[2]/form[1]/p-accordion[1]/div[1]/p-accordiontab[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/app-multiselect-dropdown[1]/form[1]/ng-multiselect-dropdown[1]/div[1]/div[2]/ul[2]/li[*]/div[1]");
	private By delrole = By.xpath("//a[contains(text(),'x')]");
	private By enregistrer = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-user[1]/div[1]/div[3]/div[1]/footer[1]/div[1]/div[1]/button[1]");
	private By addbutton = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-list-user[1]/div[1]/div[1]/div[2]/kendo-grid[1]/kendo-grid-toolbar[1]/div[1]/div[1]/div[2]/app-btn-grid[1]/div[1]/div[1]/button[1]/i[1]");
	private By nomcase = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-user[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	private By prenomcase = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-user[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
	private By pwdcase = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-user[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[2]/input[1]");
	private By pwdconfcase = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-user[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[3]/input[1]");
	private By viderlangue = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-user[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/app-user-languages-dropdown[1]/div[1]/kendo-combobox[1]/span[1]/span[1]");
	private By languecase = By.xpath("/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-user[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/app-user-languages-dropdown[1]/div[1]/kendo-combobox[1]/span[1]/kendo-searchbar[1]/input[1]");
	private By langueshow = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-user[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/app-user-languages-dropdown[1]/div[1]/kendo-combobox[1]/span[1]/span[1]");
	private By langue = By.xpath("/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-list[1]/div[1]/ul[1]/li");
	private By mailcase = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-user[1]/div[1]/div[2]/form[1]/p-accordion[1]/div[1]/p-accordiontab[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	private By confirm =By.xpath("//button[contains(text(),'Oui')]");
	private By errorNotifuser =By.xpath("//div[contains(text(),'Utilisateur est supprimé(e) avec succès')] | //div[contains(text(),'Utilisateur a été bien ajouté(e)')]");
	private By errornotif = By.xpath("//div[contains(text(),'est déjà utilisé(e)')]|//div[contains(text(),'Requis')]  | //div[contains(text(),'utilisateur est désactivé avec succès')] | //div[contains(text(),'utilisateur est activé avec succès')]");
	private By hidebuttonconfr = By.xpath("//button[contains(text(),'Désactiver')]  | //button[contains(text(),'Réactiver')]");
	private By deconnecterbutton =By.xpath("//tbody/tr[14]/td[8]/i[4] | //tbody/tr[1]/td[8]/i[4]");
	private By activerbutton = By.xpath("//tbody/tr[1]/td[8]/i[3]");
	private By addrolebutton =By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-list-role[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-btn-grid[1]/div[1]/div[1]/button[1]");
	private By rolecode =By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-role[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	private By desigcode =By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-role[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
	private By searchrole = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-role[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]");
	private By enregistrernewrole = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-role[1]/div[1]/div[3]/div[1]/footer[1]/div[1]/div[1]/button[1]");
	private By ticrole = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-add-role[1]/div[1]/div[2]/form[1]/app-role-config-category-treeview[1]/div[1]/div[1]/div[1]/div[1]/div[1]/kendo-treeview[1]/ul[1]/li[1]/div[1]/span[2]/span[1]/button[1]");
	//private By delnewrole = By.xpath("//tbody/tr[1]/td[3]/button[1]/i[1]");
	//private By searchexistrole = By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-list-role[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-search-role-config[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	public UserPage(WebDriver driver) {
		this.driver =driver;	

	}


	public WebElement  getrolechamp() {
		return driver.findElement(rolechamp);
	}

	public WebElement  getmailcase() {
		return driver.findElement(mailcase);
	}

	public WebElement  gethidebutton() {
		return  driver.findElement (hidebutton);
	}
	public WebElement  gethidebuttonconfr() {
		return  driver.findElement (hidebuttonconfr);
	}

	public WebElement  getdeconecterbutton() {
		return  driver.findElement (deconnecterbutton);
	}

	public String getVerif() {
		return  driver.findElement(rolebutton).getText();

	}

	public void Search (String name) throws InterruptedException, IOException, ParseException {
		driver.findElement(searchbar).sendKeys(name+Keys.ENTER);
		Thread.sleep(1000);

	}

	public String getEmptySearche() {
		return driver.findElement(emptymsg).getText();

	}

	public void EditRoleUser(String DesiredRole) throws InterruptedException, FileNotFoundException, IOException, ParseException {
		Thread.sleep(1000);
		UtilMethode utilMethode = new UtilMethode(driver);
		utilMethode.scrollhoriz(gethidebutton());
		Thread.sleep(1000);
		ClickeditButton();
		Thread.sleep(1000);
		utilMethode.scrollVert(getrolechamp());

		Thread.sleep(1000);
		driver.findElement(delrole).click();
		driver.findElement(rolechamp).click();
		List <WebElement> roles = driver.findElements(rolelist);
		for (WebElement webElement : roles) {
			//System.out.println(webElement.getText());
			if(webElement.getText().equals(DesiredRole))
			{
				//System.out.println(webElement.getText());
				webElement.click();
			}

		}
		Thread.sleep(1000);
		driver.findElement(enregistrer).click();
		Thread.sleep(1000);


	}

	public void ClickeditButton() {
		driver.findElement (editbutton).click();

	}

	public void ClickAddButton()
	{
		driver.findElement (addbutton).click();

	}

	public void AddNewUser(String newfirstname,String newlastname,String newpwd ,String newpwdconf ,String desiredlangue,String newmail,String newroledesigner) throws InterruptedException
	{				UtilMethode utilMethode = new UtilMethode(driver);

	Thread.sleep(1000);
	ClickAddButton();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(nomcase));
	driver.findElement(nomcase).sendKeys(newfirstname);
	Thread.sleep(500);
	driver.findElement(prenomcase).sendKeys(newlastname);
	Thread.sleep(500);
	driver.findElement(pwdcase).sendKeys(newpwd);
	Thread.sleep(500);
	driver.findElement(pwdconfcase).sendKeys(newpwdconf);
	Thread.sleep(500);

	driver.findElement(languecase).click();
	Thread.sleep(500);
	driver.findElement(viderlangue).click();
	Thread.sleep(500);
	driver.findElement(langueshow).click();
	Thread.sleep(500);

	List <WebElement> roles = driver.findElements(langue);
	for (WebElement webElement : roles) {
		//System.out.println(webElement.getText());
		if(webElement.getText().equals(desiredlangue))
		{
			//System.out.println(webElement.getText());
			webElement.click();
		}

	}
	Thread.sleep(1000);




	utilMethode.scrollVert(getrolechamp());
	driver.findElement(rolechamp).click();
	List <WebElement> rolesnew = driver.findElements(rolelist);
	for (WebElement webElement : rolesnew) {
		//System.out.println(webElement.getText());
		if(webElement.getText().equals(newroledesigner))
		{
			//System.out.println(webElement.getText());
			webElement.click();
		}

	}
	driver.findElement(rolechamp).click();

	utilMethode.scrollVert(getmailcase());

	Thread.sleep(1000);
	driver.findElement(mailcase).sendKeys(newmail);
	Thread.sleep(1000);
	driver.findElement(enregistrer).click();
	driver.findElement(enregistrer).click();


	}

	public void delUser() throws InterruptedException {
		Thread.sleep(1000);

		UtilMethode utilMethode = new UtilMethode(driver);

		utilMethode.scrollVert(gethidebutton());
		driver.findElement(deletebutton).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
		driver.findElement(confirm).click();;

	}


	public String getErrorNotif() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorNotifuser)); 
		return driver.findElement(errorNotifuser).getText();

	}

	public void wronguser() {
		if (driver.findElement(errornotif) != null) {
			System.out.println("Verify your information and try again...");
		}

	}



	public void desactiveruser(String search) throws InterruptedException {
		Thread.sleep(1000);

		UtilMethode utilMethode = new UtilMethode(driver);
		utilMethode.scrollhoriz(gethidebutton());
		Thread.sleep(1000);
		driver.findElement(hidebutton).click();
		utilMethode.scrollhoriz(gethidebuttonconfr());
		driver.findElement(hidebuttonconfr).click();
		driver.findElement(confirm).click();
		if (driver.findElement(errornotif) != null) {
			System.out.println("Utilisateur est désactivé avec succès");
		}
		driver.findElement(searchbar).sendKeys(search);
		utilMethode.scrollhoriz(getdeconecterbutton());
		Thread.sleep(2000);



	}
	public void activeruser(String search) throws InterruptedException {
		UtilMethode utilMethode = new UtilMethode(driver);
		utilMethode.scrollhoriz(getdeconecterbutton());
		Thread.sleep(2000);
		driver.findElement(activerbutton).click();
		utilMethode.scrollhoriz(gethidebuttonconfr());
		driver.findElement(hidebuttonconfr).click();
		driver.findElement(confirm).click();

		if (driver.findElement(errornotif) != null) {
			System.out.println("Utilisateur est activé avec succès");
		}

		driver.findElement(searchbar).sendKeys(search);
		utilMethode.scrollhoriz(gethidebutton());
		Thread.sleep(2000);



	}


	public void addrole() throws InterruptedException {
		driver.findElement(rolebutton).click();
		driver.findElement(addrolebutton).click();
		driver.findElement(rolecode).sendKeys("aaaa");
		Thread.sleep(2000);

		driver.findElement(desigcode).sendKeys("aaaa");
		Thread.sleep(2000);

		driver.findElement(searchrole).sendKeys("B2b" +Keys.ENTER);	
		Thread.sleep(2000);
		driver.findElement(ticrole).click();
		Thread.sleep(2000);
		driver.findElement(enregistrernewrole).click();
		//driver.findElement(By.xpath("//body/app-root[1]/app-main[1]/div[1]/main[1]/div[1]/app-settings-layout[1]/div[2]/div[2]/div[1]/div[1]/app-list-role[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-search-role-config[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("aaaa"+ Keys.ENTER);

	}


	public void delNewRole() throws InterruptedException {
		driver.findElement(rolebutton).click();
		Thread.sleep(2000);

		//	driver.findElement(searchexistrole).sendKeys("aaaa" +Keys.ENTER);	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody/tr[5]/td[3]/button[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(confirm).click();

	}

	public void editNewRole() throws InterruptedException {
		driver.findElement(rolebutton).click();
		Thread.sleep(2000);

		//	driver.findElement(searchexistrole).sendKeys("aaaa" +Keys.ENTER);	
		driver.findElement(By.xpath("//tbody/tr[5]/td[3]/i[1]")).click();
		Thread.sleep(2000);

		driver.findElement(searchrole).sendKeys("commercial" +Keys.ENTER);	
		Thread.sleep(2000);
		driver.findElement(ticrole).click();
		Thread.sleep(2000);
		driver.findElement(enregistrernewrole).click();

		Thread.sleep(3000);

	}



}















