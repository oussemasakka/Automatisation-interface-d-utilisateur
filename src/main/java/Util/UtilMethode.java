package Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilMethode {
	private WebDriver driver;

	public UtilMethode (WebDriver driver) {this.driver= driver;}


	public void scrollhoriz(WebElement element) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
	}

	public void scrollVert(WebElement wb) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", wb);
		Thread.sleep(500); 
	}





}
