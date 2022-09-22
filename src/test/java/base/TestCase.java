package base;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Pages.HomePage;
import Pages.LoginPage ;
import Pages.SettingsPage;
import Pages.UserPage;





public class TestCase extends baseTests{

	//ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter("./a.html");

	//xtentReports extentReports = new ExtentReports();
	static Logger logger = LogManager.getLogger(TestCase.class);

	String loc = ".\\Resources\\Json\\test.json";  

	@Test (priority = 4)


	void successfulLogin() throws IOException  {
		//	extentReports.attachReporter(extentHtmlReporter);
		//	ExtentTest test = extentReports.createTest("SuccessfulLogin");

		String result = new String(Files.readAllBytes(Paths.get(loc)));   
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());  

		String name =  (String) data.get("name");
		String pwd = (String) data.get("pwd");
		String expectedTitle = (String) data.get("expectedTitle");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUserMail(name);
		loginpage.setUserPassword(pwd);
		HomePage homepage =	loginpage.clickLoginButton();
		assertEquals(homepage.getApplicationName(), expectedTitle);
		/*	if (homepage.getApplicationName().equalsIgnoreCase(expectedTitle)) {
			test.pass("login with successfully");
			test.warning(expectedTitle);
		}
		else {
			test.fail("login no successfully");

		}
	extentReports.flush();*/
	}


	@Test( priority=5)
	public void testUserInterface() throws IOException, ParseException, InterruptedException{



		String result = new String(Files.readAllBytes(Paths.get(loc)));   
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());  

		String role =  (String) data.get("role");

		successfulLogin();
		HomePage home = new HomePage(driver);
		home.clickSettingsMenu();
		SettingsPage settingspage =	home.clickSettingsButton();
		UserPage userpage = settingspage.clickUsersTab();
		Thread.sleep(3000);
		//System.out.println(userpage.getVerif()); 
		assertEquals(userpage.getVerif(), role);

	}


	@Test (priority=1)
	void wrongLogin() throws InterruptedException, IOException {
		String result = new String(Files.readAllBytes(Paths.get(loc)));   
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());  

		String wrongmail =  (String) data.get("wrongmail");
		String pwd =  (String) data.get("pwd");
		String mailerrone =  (String) data.get("mailerrone");
		String notcorrect =  (String) data.get("notcorrect");

		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(2000);
		loginpage.setUserMail(wrongmail);
		loginpage.setUserPassword(pwd);

		loginpage.clickLoginButton();
		System.out.println(loginpage.getErrorNotifLogin());
		assertEquals(loginpage.getErrorNotifLogin(), mailerrone ,notcorrect);

	}


	@Test (priority=2)
	void wrongMdp() throws InterruptedException, IOException {

		String result = new String(Files.readAllBytes(Paths.get(loc)));   
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());

		String name =  (String) data.get("name");
		String searchname =  (String) data.get("Searchname");
		String notcorrect =  (String) data.get("notcorrect");
		String motdepasseerroné =  (String) data.get("Motdepasseerroné");

		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(2000);
		loginpage.setUserMail(name);

		loginpage.setUserPassword(searchname);

		loginpage.clickLoginButton();
		System.out.println(loginpage.getErrorNotifLogin());
		assertEquals(loginpage.getErrorNotifLogin(),motdepasseerroné,notcorrect);

	}


	@Test (priority=3)
	void empty() throws InterruptedException, IOException {
		String result = new String(Files.readAllBytes(Paths.get(loc)));   
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());

		String mailetmotdepasserequis =  (String) data.get("mailetmotdepasserequis");

		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(2000);
		loginpage.setUserMail(" ");
		loginpage.setUserPassword(" ");

		loginpage.clickLoginButton();
		System.out.println(loginpage.getErrorNotifLogin());
		assertEquals(loginpage.getErrorNotifLogin(), mailetmotdepasserequis);

	}


	@Test (priority=8)
	void successfullSearch() throws InterruptedException, IOException, ParseException {
		String result = new String(Files.readAllBytes(Paths.get(loc)));   
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());

		String searchname =  (String) data.get("Searchname");

		testUserInterface();
		UserPage userpage = new UserPage(driver);
		userpage.Search(searchname);

	}


	@Test(priority=6)
	void noSuchElement() throws InterruptedException, IOException, ParseException {
		String result = new String(Files.readAllBytes(Paths.get(loc)));   
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());

		String searchnamenotfound =  (String) data.get("Searchnamenotfound");

		testUserInterface();
		UserPage userpage = new UserPage(driver);
		userpage.Search(searchnamenotfound);
		System.out.println(userpage.getEmptySearche());
		Thread.sleep(2000);

	}


	@Test(priority=10)
	void editRoleUser() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		String result = new String(Files.readAllBytes(Paths.get(loc)));   
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());
		String roledesigner =  (String) data.get("roledesigner");

		successfullSearch();
		UserPage userPage = new UserPage(driver);
		//UtilMethode utilmethode =new UtilMethode(driver);
		//utilmethode.scrollhoriz(userPage.gethidebutton());
		//userPage.ClickeditButton();
		//utilmethode.scrollVert(userPage.getrolechamp());
		userPage.EditRoleUser(roledesigner);

	}


	@Test (priority=7)
	void addUser() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		String result = new String(Files.readAllBytes(Paths.get(loc)));   
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());
		String newname =  (String) data.get("newname");
		String newlastname =  (String) data.get("newlastname");
		String newpwd =  (String) data.get("newpwd");
		String desiredlangue =  (String) data.get("desiredlangue");
		String newmail =  (String) data.get("newmail");
		String newroledesigner =  (String) data.get("newroledesigner");
		String utilisateuraétébienajouté = (String) data.get("Utilisateuraétébienajouté");

		testUserInterface();
		UserPage userPage = new UserPage(driver);
		userPage.AddNewUser(newname,newlastname,newpwd,newpwd,desiredlangue,newmail,newroledesigner);
		System.out.println(userPage.getErrorNotif());
		assertEquals(userPage.getErrorNotif(), utilisateuraétébienajouté);

	}


	@Test(priority=13)
	void delUser() throws InterruptedException, IOException, ParseException {
		String result = new String(Files.readAllBytes(Paths.get(loc)));   
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());

		String utilisateurestsupprime = (String) data.get("Utilisateurestsupprime");

		successfullSearch();
		Thread.sleep(2000);
		UserPage userPage = new UserPage(driver);
		userPage.delUser();
		System.out.println(userPage.getErrorNotif());
		assertEquals(userPage.getErrorNotif(), utilisateurestsupprime);

	}


	@Test (priority=9)
	void missingAddUser() throws IOException, ParseException, InterruptedException {
		String result = new String(Files.readAllBytes(Paths.get(loc)));  
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());  

		String newname =  (String) data.get("newname");
		String newlastname =  (String) data.get("newlastname");
		String newpwd =  (String) data.get("newpwd");
		String desiredlangue =  (String) data.get("desiredlangue");
		String newmail =  (String) data.get("newmail");
		String newroledesigner =  (String) data.get("newroledesigner");

		testUserInterface();
		UserPage userPage = new UserPage(driver);
		userPage.AddNewUser(newname,newlastname,newpwd,newpwd,desiredlangue,newmail, newroledesigner);
		userPage.wronguser();
		Thread.sleep(2000);

	}


	@Test (priority=11)
	void desactiverUser() throws IOException, ParseException, InterruptedException {
		String result = new String(Files.readAllBytes(Paths.get(loc)));  
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());  

		String newname =  (String) data.get("newname");

		successfullSearch();
		UserPage userPage = new UserPage(driver);
		userPage.desactiveruser(newname);
		Thread.sleep(2000);

	}


	@Test (priority=12)
	void activerUser() throws InterruptedException, IOException, ParseException {
		String result = new String(Files.readAllBytes(Paths.get(loc)));  
		Map<String, Object> data = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {  }.getType());  

		String newname =  (String) data.get("newname");

		successfullSearch();
		UserPage userPage = new UserPage(driver);
		userPage.activeruser(newname);
		Thread.sleep(2000);

	}


	@Test (priority=14)
	void addNewRole() throws InterruptedException, IOException, ParseException {
		testUserInterface();
		UserPage userPage = new UserPage(driver);
		userPage.addrole();

	}



	@Test (priority=15)
	void editNewRole() throws InterruptedException, IOException, ParseException {
		testUserInterface();
		UserPage userPage = new UserPage(driver);
		userPage.editNewRole();
		Thread.sleep(2000);

	}

	@Test (priority=16)
	void delNewRole() throws InterruptedException, IOException, ParseException {
		testUserInterface();
		UserPage userPage = new UserPage(driver);
		userPage.delNewRole();
		Thread.sleep(2000);

	}

	@Test
	void test() throws InterruptedException, IOException, ParseException {
		WebElement element = driver.findElement(By.cssSelector("app-root:nth-child(1) app-login:nth-child(3) div.limiter div.container-login100 > div.wrap-login100.animate__animated.animate__bounceIn"));
		String	s = element.getCssValue("color");
		java.awt.Color c = Color.fromString(s).getColor();
		System.out.println(c);
		logger.trace("trace");
		logger.info("info");
		logger.error("error");
		logger.warn("warn");
		logger.fatal("fatal");

		System.out.println("\nfini....");
		//System.out.println(element.getCssValue("color"));


		//testUserInterface();
		//driver.findElement(By.xpath("//i[@id='dropdownMenu']")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Export Excel')]")).click();
		//File directory = new File("\\C:\\Users\\ASUS\\Download");
		//boolean downloadinFilePresence = false;
		//File[] filesList =null;
		File file = new File("C:\\Users\\ASUS\\Downloads\\logo.png");

		if (file.exists()) {
			System.out.println("aaaa" + " is present");
		}

		else 			System.out.println("bbbbbbbbb" + " is not present");
		

	

	}
	



}
