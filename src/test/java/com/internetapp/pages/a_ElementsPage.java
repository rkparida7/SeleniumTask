package com.internetapp.pages;

import static com.maveric.core.utils.reporter.Report.log;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maveric.core.config.ConfigProperties;
import com.maveric.core.driver.Driver;
import com.maveric.core.utils.web.WebActions;

public class a_ElementsPage extends WebActions {
	private final By elementHead = By.xpath("(//div[@class='card-up'])[1]");
	private final By elementText = By.xpath("(//div[@class='col-12 mt-4 col-md-6'])[1]");
	private final By submitText = By.xpath("//button[@id='submit']");
	private final By FirstName = By.xpath("//input[@placeholder='Full Name']");
	private final By email = By.xpath("//input[@type='email']");
	private final By address = By.xpath("//textarea[@placeholder='Current Address']");
	private final By cAddress = By.xpath("//textarea[@id='permanentAddress']");
	private final By testBox = By.xpath("//span[contains(text(),'Text Box')]");
	private final By  chkBox = By.xpath("//span[contains(text(),'Check Box')]");
	private final By homeChk  = By.xpath("//span[@class='rct-checkbox']");
	private final By chkText = By.xpath("//div[@id='result']");
	private final By radiobtn = By.xpath("//span[contains(text(),'Radio Button')]");
	private final By radiobtnPoint= By.xpath("//input[@type='radio']//following::label[contains(text(),'Impressive')]");
	private final By webTable = By.xpath("//span[contains(text(),'Web Tables')]");
	private final By alden = By.xpath("(//div[contains(text(),'Insurance')]//following::span[@class='mr-2'])[2]");
	private final By agew = By.xpath("//input[@placeholder='Age']");
	private final By table = By.xpath("//div[@class='web-tables-wrapper']");
	private final By ddbutton = By.xpath("//span[contains(text(),'Buttons')]");
	private final By doublebtn = By.xpath("//button[@id='doubleClickBtn']");
	private final By rightbtn = By.xpath("//button[@id='rightClickBtn']");
	private final By clickbtn  = By.xpath("(//button[@type='button'])[4]");
	private final By links  = By.xpath("//span[contains(text(),'Links')]");
	private final By homeLink = By.xpath("//a[contains(text(),'Home') and @id='simpleLink']");
	private final By uploadDownload = By.xpath("//span[contains(text(),'Upload and Download')]");
	private final By selectFile = By.xpath("//label[contains(text(),'Select a file')]");
	private final By download = By.xpath("//a[@id='downloadButton']");
	private final By upload = By.xpath("//input[@id='uploadFile']");
	private final By dyProperties = By.xpath("//span[contains(text(),'Dynamic Properties')]");
	private final By vsble5Sec = By.xpath("//button[@id='visibleAfter']");
	private final By webTableFName = By.xpath("//input[@placeholder='First Name']");
	private final By addButton = By.xpath("//button[@id='addNewRecordButton']");
	private final By webTableLName = By.xpath("//input[@placeholder='Last Name']");
	private final By webEmail = By.xpath("//input[@id='userEmail']");
	private final By webSalary = By.xpath("//input[@placeholder='Salary']");
	private final By webDepart = By.xpath("//input[@placeholder='Department']");
	private final By registrationForm = By.xpath("//div[contains(text(),'Registration Form')]");
//	private final By  = By.xpath("");
//	private final By  = By.xpath("");
//	private final By  = By.xpath("");
//	private final By  = By.xpath("");
	
	
	
	

    WebDriverWait wait;
    WebDriver driver;

    public a_ElementsPage() {
        driver = Driver.getWebDriver();
        wait = new WebDriverWait(driver, ConfigProperties.WAIT_TIMEOUT.getInt());
    }

    public a_ElementsPage navigate(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();

        logScreenshot("login");
        ;
        log("sample log");

        return this;

    }	

    public a_ElementsPage testBox(String Fname,String mail,String add,String cAdd) throws InterruptedException {
    	scrollDown();
    	wait.until(ExpectedConditions.presenceOfElementLocated(elementHead));Thread.sleep(2000);
    	driver.findElement(elementHead).click();Thread.sleep(2000);
    	wait.until(ExpectedConditions.presenceOfElementLocated(elementText));
    	driver.findElement(testBox).click();
    	Thread.sleep(2000);
    	driver.findElement(FirstName).sendKeys(Fname);
    	driver.findElement(email).sendKeys(mail);
    	driver.findElement(address).sendKeys(add);
    	driver.findElement(cAddress).sendKeys(cAdd);
    	logScreenshot("Texted successful");
    	scrollDown();
    	driver.findElement(submitText).click();
        logScreenshot("TextBox successful");
        Thread.sleep(2000);
        return this;
    }
  
    public a_ElementsPage checkBox() throws InterruptedException {
    	wait.until(ExpectedConditions.presenceOfElementLocated(chkBox));
    	driver.findElement(chkBox).click();Thread.sleep(1000);
    	driver.findElement(homeChk).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(chkText)).isDisplayed();
    	
        logScreenshot("CheckBox successful");
        return this;
    }

    public a_ElementsPage radioButton(String option) throws InterruptedException {
    	wait.until(ExpectedConditions.presenceOfElementLocated(radiobtn));
    	driver.findElement(radiobtn).click(); Thread.sleep(1000);
    	driver.findElement(radiobtnPoint).click();
        logScreenshot("RadioButton successful");
        return this;
    }

    public a_ElementsPage webTables(String FisrtName,String LastName,String Email, String ageGiven, String salary,String Department ) throws InterruptedException {
//    	driver.findElement(elementHead).click();
//    	wait.until(ExpectedConditions.presenceOfElementLocated(elementText));
    	scrollDown();
    	wait.until(ExpectedConditions.presenceOfElementLocated(webTable));
    	driver.findElement(webTable).click(); 
    	logScreenshot("webTables successful");
    	driver.findElement(addButton).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(registrationForm));Thread.sleep(3000);
    	logScreenshot("webTables amned successful");
    	driver.findElement(webTableFName).sendKeys(FisrtName);
    	driver.findElement(webTableLName).sendKeys(LastName);
    	driver.findElement(webEmail).sendKeys(Email);
    	driver.findElement(agew).sendKeys(ageGiven);
    	driver.findElement(webSalary).sendKeys(salary);
    	driver.findElement(webDepart).sendKeys(Department);
    	driver.findElement(submitText).click();Thread.sleep(3000);
    	tableRead();
    	
    	logScreenshot("webTables amned successful");
    	
        return this;
    }
  
    public a_ElementsPage Dbutton() throws InterruptedException {
//    	driver.findElement(elementHead).click();
//    	wait.until(ExpectedConditions.presenceOfElementLocated(elementText));
    	scrollDown();
    	wait.until(ExpectedConditions.presenceOfElementLocated(ddbutton));logScreenshot("visible");
    	driver.findElement(ddbutton).click(); 
    	logScreenshot("webTables successful");
    	doubleClickAction(driver.findElement(doublebtn));
    	rightClickAction(driver.findElement(rightbtn));
    	driver.findElement(clickbtn).click();
    	Thread.sleep(3000);
    	logScreenshot("clicking successful");
        return this;
    }

    public a_ElementsPage LinksOps() throws InterruptedException {
//    	driver.findElement(elementHead).click();
//    	wait.until(ExpectedConditions.presenceOfElementLocated(elementText));
    	scrollDown();
    	wait.until(ExpectedConditions.presenceOfElementLocated(links));
//    	highLighterMethod(driver, (WebElement) links);
    	logScreenshot("visible");
    	driver.findElement(links).click();
    	logScreenshot("clicking successful");
    	wait.until(ExpectedConditions.presenceOfElementLocated(homeLink));
//    	highLighterMethod(driver, (WebElement) homeLink);Thread.sleep(2000);logScreenshot("visible");
    	driver.findElement(homeLink).click();Thread.sleep(1000);
    	windowhandlingMethod();Thread.sleep(2000);
    	new a_ElementsPage()
						.testBox("Rutukanta", "rutukantap@maveric-systems.com", "Chennai", "India");
    	logScreenshot("visible");
    	return this;
    }
    
    public a_ElementsPage upDownload() throws IOException, InterruptedException {
//    	scrollDown();
//    	wait.until(ExpectedConditions.presenceOfElementLocated(elementHead));
//    	driver.findElement(elementHead).click();
//    	wait.until(ExpectedConditions.presenceOfElementLocated(elementText));
    	scrollDown();
//    	logScreenshot("clicking successful");
    	driver.findElement(uploadDownload).click();
//    	logScreenshot("clicking successful");
    	driver.findElement(download).click();
    	Thread.sleep(3000);
    	wait.until(ExpectedConditions.presenceOfElementLocated(selectFile));
//    	driver.findElement(upload).click();
//    	try {
//			WebElement point = driver.findElement(By.xpath("//input[@id='uploadFile']"));
//			point.click();
//			Runtime.getRuntime().exec("C:\\Users\\Rkparida\\Desktop\\SCUBA\\AutoIT\\Fileuploader.exe");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	Thread.sleep(4000);
    	driver.findElement(download).click();Thread.sleep(4000);
    	return this;
    }

    public a_ElementsPage dynamicProp() throws InterruptedException {
//    	driver.findElement(elementHead).click();
//    	wait.until(ExpectedConditions.presenceOfElementLocated(elementText));
    	scrollDown();
    	logScreenshot("clicking successful");
    	wait.until(ExpectedConditions.presenceOfElementLocated(dyProperties));
    	driver.findElement(dyProperties).click(); 
    	logScreenshot("clicking successful"); Thread.sleep(5500);
    	driver.findElement(vsble5Sec).isDisplayed();
    	String value = driver.findElement(vsble5Sec).getText();
    	System.out.println("Dynamic value is: "+value);
    	logScreenshot("clicking successful");
    	
    	 return this;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
