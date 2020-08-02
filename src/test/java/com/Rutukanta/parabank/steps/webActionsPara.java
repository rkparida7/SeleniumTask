package com.Rutukanta.parabank.steps;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class webActionsPara {
	private final static AtomicInteger counter = new AtomicInteger();
	public WebDriver driver;
	public WebDriverWait wait;

	public void urlLunchChrome(String value) {
		System.setProperty("webdriver.chrome.driver", "Resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(value);
	}

	public void doubleClickAction(WebElement value) {
		Actions actions = new Actions(driver);
		WebElement elementLocator = value;
		actions.doubleClick(elementLocator).perform();
	}

	public void sendkeym(By value1, String value2) {
		driver.findElement(value1).sendKeys(value2);
	}

	public void clickm(By value1) throws InterruptedException {
		driver.findElement(value1).click();
		Thread.sleep(3500);
	}

	public void dropdownm(By by, String value2) {
		Select sel = new Select(driver.findElement(by));
//		sel.selectByValue(value2);
		sel.selectByVisibleText(value2);
	}
	
	public String findText(By by) {
		return driver.findElement(by).getText();
	}

	public void highlightElement(By element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
	}
	
	public void scrollDown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(1000);
	}

//-----------------------------------------------------------------------------------------------------------
	public void logScreenshot(String name) {
		String path = captureScreenshot();
		String html = "<a target=_blank href=" + "screenshots" + path.replaceAll(" ", "%20") + ">" + name + "  </a>";
//		Report.log(html);
	}

	private String captureScreenshot() {
		String screenshotName = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			screenshotName = "/screenshot" + "_" + getId() + ".png";
			String screenshotPath = "Screenshots"
					+ screenshotName;
			Files.copy(file, new File(screenshotPath));

		} catch (Exception e) {
			e.getMessage();
		}
		return screenshotName;
	}

	private int getId() {
		return counter.incrementAndGet();
	}
//-----------------------------------------------------------------------------------
}
