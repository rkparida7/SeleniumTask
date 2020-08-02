package com.internetapp.pages;

import static com.maveric.core.utils.reporter.Report.log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maveric.core.config.ConfigProperties;
import com.maveric.core.driver.Driver;
import com.maveric.core.utils.web.WebActions;

public class b_InteractionsPage extends WebActions {
	
	private final By interactionHead = By.xpath("(//div[@class='card-up'])[5]");
	private final By sortableEntry = By.xpath("//span[contains(text(),'Sortable')]");
	private final By pageValue = By.xpath("//div[contains(text(),'Please select an item from left to start practice.')]");
	private final By grid = By.xpath("//a[contains(text(),'Grid')]");
	private final By selecttableEntry = By.xpath("//span[contains(text(),'Selectable')]");
	private final By selectTableV1 = By.xpath("//li[contains(text(),'Cras justo odio')]");
	private final By selectTableV3 = By.xpath("//li[contains(text(),'Morbi leo risus')]");
	private final By oneV = By.xpath("//li[contains(text(),'One')]");
	private final By twoV = By.xpath("//li[contains(text(),'Two')]");
	private final By fourV = By.xpath("//li[contains(text(),'Four')]");
	private final By resizableEntry = By.xpath("//span[contains(text(),'Resizable')]");
	private final By droppableEntry = By.xpath("//span[contains(text(),'Droppable')]");
	private final By dragabbleEntry = By.xpath("//span[contains(text(),'Dragabble')]");
	private final By axis = By.xpath("//a[contains(text(),'Axis Restricted')]");
//	private final By  = By.xpath("");
	

	
	WebDriverWait wait;
    WebDriver driver;

    public b_InteractionsPage() {
        driver = Driver.getWebDriver();
        wait = new WebDriverWait(driver, ConfigProperties.WAIT_TIMEOUT.getInt());
    }

    public b_InteractionsPage navigate(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();

        logScreenshot("login");
        ;
        log("sample log");

        return this;

    }	
   
    public b_InteractionsPage sorttablee() throws InterruptedException {
    	scrollDown();
    	wait.until(ExpectedConditions.presenceOfElementLocated(interactionHead));Thread.sleep(4000);
	    	driver.findElement(interactionHead).click();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(pageValue));
	    	scrollDown();
	    	logScreenshot("scrollDown successful");
	    	wait.until(ExpectedConditions.presenceOfElementLocated(sortableEntry));
	    	driver.findElement(sortableEntry).click(); 
	    	logScreenshot("clicking successful"); Thread.sleep(2000);
	    	driver.findElement(grid).click();
	    	Thread.sleep(2000);
	    	
	    	WebElement oneD = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[contains(text(),'One')]"));
	    	WebElement twoD = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[contains(text(),'Two')]"));
	    	WebElement threeD = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[contains(text(),'Three')]"));
	    	WebElement fourD = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[contains(text(),'Four')]"));
	    	WebElement fiveD = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[contains(text(),'Five')]"));
	    	WebElement sixD = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[contains(text(),'Six')]"));
	    	WebElement sevenD = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[contains(text(),'Seven')]"));
	    	WebElement eightD =	driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[contains(text(),'Eight')]"));
	    	WebElement nineD = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[contains(text(),'Nine')]"));
	    	
	    	dragAndDropMethod(oneD, nineD);
	    	dragAndDropMethod(twoD, nineD);
	    	dragAndDropMethod(threeD, nineD);
	    	dragAndDropMethod(fourD, nineD);
	    	dragAndDropMethod(fiveD, nineD);
	    	dragAndDropMethod(sixD, nineD);
	    	dragAndDropMethod(sevenD, nineD);
	    	dragAndDropMethod(eightD, nineD);
	    	Thread.sleep(5000);
	    	
	    	logScreenshot("clicking successful");
	    	
	    	 return this;
	    }

	public b_InteractionsPage selecttablee() throws InterruptedException {
//	    	Thread.sleep(1000);
//	    	driver.findElement(interactionHead).click();
//	    	wait.until(ExpectedConditions.presenceOfElementLocated(pageValue));
	    	scrollDown();
	    	logScreenshot("scrollDown successful");
	    	wait.until(ExpectedConditions.presenceOfElementLocated(selecttableEntry));
	    	driver.findElement(selecttableEntry).click(); 
	    	logScreenshot("clicking successful"); Thread.sleep(1000);
	    	driver.findElement(selectTableV1).click();
	    	driver.findElement(selectTableV3).click();
	    	logScreenshot("clicking successful");
	    	Thread.sleep(2000);
	    	driver.findElement(grid).click();
	    	driver.findElement(oneV).click();
	    	driver.findElement(twoV).click();
	    	driver.findElement(fourV).click();
	    	Thread.sleep(2000);
	    	driver.findElement(oneV).click();
	    	Thread.sleep(2000);
	    	logScreenshot("clicking successful");
	    	
	    	return this;
	    }

	public b_InteractionsPage Resizablee() throws InterruptedException {
    	Thread.sleep(1000);
//    	driver.findElement(interactionHead).click();
//    	wait.until(ExpectedConditions.presenceOfElementLocated(pageValue));
    	scrollDown();
    	wait.until(ExpectedConditions.presenceOfElementLocated(resizableEntry));
    	driver.findElement(resizableEntry).click(); 	Thread.sleep(4000);
    	logScreenshot("clicking successful");
    	WebElement point = driver.findElement(By.xpath("(//span[@class='react-resizable-handle react-resizable-handle-se'])[1]"));
    	ResizeMethod(point, 90, 70);
    	scrollDown();Thread.sleep(3000);
    	WebElement point2 = driver.findElement(By.xpath("(//span[@class='react-resizable-handle react-resizable-handle-se'])[2]"));
    	ResizeMethod(point2, 100, 80);
    	Thread.sleep(3000);
    	logScreenshot("clicking successful");
    	return this;
    }
	
	public b_InteractionsPage Droppablee() throws InterruptedException {
		
//    	Thread.sleep(2000);
//    	driver.findElement(interactionHead).click();
//    	wait.until(ExpectedConditions.presenceOfElementLocated(pageValue));
    	scrollDown();Thread.sleep(2000);
    	scrollDown();
    	wait.until(ExpectedConditions.presenceOfElementLocated(droppableEntry));
    	driver.findElement(droppableEntry).click(); 	Thread.sleep(2000);
    	logScreenshot("clicking successful");
    	WebElement dragme = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropme = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
    	WebElement revertDrag = driver.findElement(By.xpath("//a[@id='droppableExample-tab-revertable']"));
    	WebElement dropped = driver.findElement(By.xpath("(//p[contains(text(),'Drop here')])[3]"));
    	WebElement revertD = driver.findElement(By.xpath("//div[contains(text(),'Will Revert')]"));
    	WebElement notRevertD = driver.findElement(By.xpath("//div[contains(text(),'Not Revert')]"));

    	dragAndDropMethod(dragme, dropme);Thread.sleep(2000);
    	
    	revertDrag.click();Thread.sleep(2000);
    	logScreenshot("clicking successful");
    	dragAndDropMethod(revertD, dropped);
    	dragAndDropMethod(notRevertD, dropped);
    	dragAndDropMethod(notRevertD, revertD);
    	
    	
    	
    	Thread.sleep(2000);
    	logScreenshot("clicking successful");
    	
    	return this;
    }
	
	public b_InteractionsPage Dragabblee() throws InterruptedException {
//    	Thread.sleep(1000);
//    	driver.findElement(interactionHead).click();
//    	wait.until(ExpectedConditions.presenceOfElementLocated(pageValue));
    	scrollDown();Thread.sleep(1000);
    	scrollDown();
    	wait.until(ExpectedConditions.presenceOfElementLocated(dragabbleEntry));
    	driver.findElement(dragabbleEntry).click(); 	Thread.sleep(2000);
    	logScreenshot("clicking successful");
    	
    	WebElement dragbox = driver.findElement(By.xpath("//div[@id='dragBox']"));
    	WebElement dragcursorStyle = driver.findElement(By.xpath("//a[@id='draggableExample-tab-cursorStyle']"));
    	WebElement xAxis = driver.findElement(By.xpath("//div[contains(text(),'Only X')]"));
    	WebElement yAxis = driver.findElement(By.xpath("//div[contains(text(),'Only Y')]"));
    	
    	
    	dragAndDropMethod(dragbox, dragcursorStyle);
    	Thread.sleep(2000);
    	
    	driver.findElement(axis).click();Thread.sleep(2000);
    	new Actions(driver).dragAndDropBy(xAxis, 150, 0).build().perform();
    	Thread.sleep(2000);
    	
    	new Actions(driver).dragAndDropBy(yAxis, 0, 150).build().perform();
    	Thread.sleep(2000);
    	logScreenshot("clicking successful");
    	
    	return this;
    }
	
	

}
