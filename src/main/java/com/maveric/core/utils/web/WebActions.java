package com.maveric.core.utils.web;

import java.io.File;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.maveric.core.driver.Driver;
import com.maveric.core.testng.listeners.ReportListener;
import com.maveric.core.utils.reporter.Report;

public class WebActions {
	private final static AtomicInteger counter = new AtomicInteger();
	private final static Logger logger = LogManager.getLogger();
	public WebDriver driver;

	public void logScreenshot(String name) {
		String path = captureScreenshot();
		String html = "<a target=_blank href=" + "screenshots" + path.replaceAll(" ", "%20") + ">" + name + "  </a>";
		Report.log(html);
	}

	public WebActions() {
		if (!Driver.isWebDriverEmpty()) {
			driver = Driver.getWebDriver();
		} else if (!Driver.isAppiumDriverEmpty()) {
			driver = Driver.getAppiumDriver();
		}
	}

	private String captureScreenshot() {
		String screenshotName = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			screenshotName = "/screenshot" + "_" + getId() + ".png";
			String screenshotPath = ReportListener.screenshotFolder + screenshotName;
			FileUtils.copyFile(file, new File(screenshotPath));

		} catch (Exception e) {
			logger.error("unable to capture screenshot" + e);
		}
		return screenshotName;
	}

	private int getId() {
		return counter.incrementAndGet();
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public void doubleClickAction(WebElement value) {
		Actions actions = new Actions(driver);
		WebElement elementLocator = value;
		actions.doubleClick(elementLocator).perform();
	}

	public void rightClickAction(WebElement value) {
		Actions action = new Actions(driver);
		WebElement link = value;
		action.contextClick(link).perform();
	}

	public void highLighterMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}

	public void dragAndDropMethod(WebElement sourceLocator, WebElement targetLocator) throws InterruptedException {
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceLocator, targetLocator).build().perform();
		Thread.sleep(1500);
	}

	public void ResizeMethod(WebElement sourceLocator, int x, int y) {
		Actions actionsResize = new Actions(driver);
		actionsResize.dragAndDropBy(sourceLocator, x, y).perform();
		;
	}

	public void windowhandlingMethod() {
		String parent = driver.getWindowHandle();
		System.out.println("Parent - " + parent);
		Set<String> allwindow = driver.getWindowHandles();
		int count = allwindow.size();
		System.out.println("Total windows: " + count);
		for (String child : allwindow) {

			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}

		String child = driver.getWindowHandle();
		System.out.println("child - " + child);
		
//		driver.switchTo().window(parent);
	}
	public void tableRead() {
		String row = "//div[@class='rt-tbody']/div/div";
		String col = "//div[@class='rt-tbody']/div[1]/div[1]/div";

		int rowData = driver.findElements(By.xpath(row)).size();
		System.out.println("Row  :" + rowData);
		int colData = driver.findElements(By.xpath(col)).size();
		System.out.println("Coloumn   :" + colData);
		//*[@id='example']/tbody/tr[8]/td[5]
		//div[@class='rt-tbody']/div[1]/div[1]/div[5]
		
		String first="//div[@class='rt-tbody']/div[";
//		String second="]/div[";
		String second="]/div/div[";
		String third="]";
		
//		for (int i = 1; i <= rowData; i++) {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 7; j++) {
					String finalp = first + i + second + j + third;
					String text = driver.findElement(By.xpath(finalp)).getText();
					System.out.print(" | " + text);
			}

			System.out.println();
			System.out.println(" ");
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
