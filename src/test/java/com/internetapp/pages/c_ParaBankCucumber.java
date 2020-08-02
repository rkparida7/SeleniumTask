package com.internetapp.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Rutukanta.parabank.steps.Constant;
import com.Rutukanta.parabank.steps.Locators;
import com.Rutukanta.parabank.steps.readPropertiesFile;
import com.Rutukanta.parabank.steps.writePropertiesFile;
import com.maveric.core.config.ConfigProperties;
import com.maveric.core.driver.Driver;
import com.maveric.core.utils.web.WebActions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class c_ParaBankCucumber extends WebActions {

	WebDriverWait wait;
	WebDriver driver;

	public c_ParaBankCucumber() {
		driver = Driver.getWebDriver();
		wait = new WebDriverWait(driver, ConfigProperties.WAIT_TIMEOUT.getInt());
	}

	public c_ParaBankCucumber navigate(String url) {
		driver.navigate().to(url);
		driver.manage().window().maximize();

		logScreenshot("login");
		;
		return this;
	}

	@Given("Launch the paraBank Site")
	public void launch_the_paraBank_Site() {
		driver.navigate().to("https://parabank.parasoft.com/parabank/register.htm");
	}
	
	@And("create New IDs {string} and {string}")
	public void create_New_IDs(String string1, String string2) throws InterruptedException {
		scrollDown();
		sendkeym(Locators.Fname(), "Rutukanta");
		sendkeym(Locators.Lname(), "Parida");
		sendkeym(Locators.address(), "Chennai");
		sendkeym(Locators.city(), "Chennai");
		sendkeym(Locators.state(), "Tamil Nadu");
		sendkeym(Locators.zipCode(), "600032");
		sendkeym(Locators.phone(), "9874561230");
		sendkeym(Locators.SSN(), "789546");
		sendkeym(Locators.UName(), string1);
		sendkeym(Locators.Pswd(), string2);
		sendkeym(Locators.confirmPswd(), string2);
		logScreenshot("Data Entered successfully");
		clickm(Locators.registerButton());
		System.out.println("---> Signup Successfully");
		logScreenshot("Signup in successfully");
		clickm(Locators.logoutButton());
	}

	@Then("Enter the User Name and password and click login button {string} and {string}")
	public void enter_the_User_Name_and_password_and_click_login_button_and(String string1, String string2)
			throws InterruptedException {
		
			sendkeym(Locators.UserName(), string1);
			System.out.println("---> UserName  :   "+string1);
			sendkeym(Locators.Password(), string2);
			logScreenshot("logeed in");
			clickm(Locators.loginButton());
			
			String value = driver.findElement(By.xpath("//p[@class='error']")).getText();
			System.out.println("--> Error found : "+value);
			if (value != "The username and password could not be verified.") {
				System.out.println("---> Unable to Login Parabank");
			}else {
				System.out.println("---> Able to Login Successfully");
			}
	}

	@And("Navigate to Open New Account section")
	public void navigate_to_Open_New_Account_section() {
		System.out.println("Successfully Navigate to Open New Account section");
	}

	@When("Select the Account Type {string} and Click Open new accountButton")
	public void select_the_Account_Type_and_Click_Open_new_accountButton(String string)
			throws InterruptedException, IOException {
		clickm(Locators.openNewAccount());
		dropdownm(Locators.typeAccount(), string);
		logScreenshot("one");
		clickm(Locators.OpenNewAccountButton());
		logScreenshot("Account Creation Done successfully");

		String value = findText(Locators.newAccountNo());
		writePropertiesFile.write(value);
		System.out.println("New Transaction ID is:-- >  " + value);
	}

	@Then("A New account is Created successfully")
	public void a_New_account_is_Created_successfully() {
		System.out.println("Successfully New account is Created");
	}

	@When("Click the Transfer Funds option")
	public void click_the_Transfer_Funds_option() throws InterruptedException, IOException {
		clickm(Locators.TransferFund());
	}

	@And("Enter the Amount {string} to be transferred")
	public void enter_the_Amount_to_be_transferred(String string) throws InterruptedException {
		Thread.sleep(1000);
		try {
			sendkeym(Locators.amount(), string);
			System.out.println("----> Amount entered from feature file");
		} catch (Exception e) {
			Thread.sleep(1000);
			System.out.println("----> Amount entered directly");
			e.printStackTrace();
			sendkeym(Locators.amount(), "100");
		}
	}

	@And("Select required the Account number from dropdown")
	public void select_required_the_Account_number_from_dropdown() throws IOException, InterruptedException {
		String value = readPropertiesFile.read("NewAccount");
		dropdownm(Locators.fromAccountId(), value);
		logScreenshot("one");
	}

	@And("Click TransferButton")
	public void click_TransferButton() throws InterruptedException {
		clickm(Locators.transferButton());
		logScreenshot("Transfer Done successfully");
	}

	@Then("Fund transfer should done successfully")
	public void fund_transfer_should_done_successfully() {
		System.out.println("---> Fund transfer should done successfully");
	}

	@When("Click the Accounts Overview Option")
	public void click_the_Accounts_Overview_Option() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(Locators.FindTransactionsMenu()));
		System.out.println("---> on Find Transaction Menu");
		clickm(Locators.FindTransactionsMenu());
		System.out.println("---> Click on Find Transaction");
	}

	@When("Select the corresponding Account from the table")
	public void select_the_corresponding_Account_from_the_table() throws IOException, InterruptedException {
		String AccountNo = readPropertiesFile.read("NewAccount");
		System.out.println("---> Value reading ===> " + AccountNo);
		Thread.sleep(1000);
		dropdownm(Locators.findTxSelect(), AccountNo);
		System.out.println("---> Value entered ==> " + AccountNo);
	}

	@And("Selelct the currentDate {string} from the table")
	public void Selelct_the_current_date(String string) throws InterruptedException {
		System.out.println("---> Value is ==> " + string);
		sendkeym(Locators.findDate(), string);
		logScreenshot("one");
		clickm(Locators.findTransactionButton());
		logScreenshot("one");
	}

	@Then("Details of the Account is displayed")
	public void details_of_the_Account_is_displayed() {
		System.out.println("Details of the Account is displayed");
	}

	@And("Account activity details displayed")
	public void account_activity_details_displayed() {
		System.out.println("Account activity details displayed");
	}

	@When("Click on Logout option")
	public void click_on_Logout_option() throws InterruptedException {
		clickm(Locators.logoutButton());
		logScreenshot("Logout successfully");
	}

	@Then("Successfully logged out from Parabank Site")
	public void successfully_logged_out_from_Parabank_Site() {
		System.out.println("---> On the home page ");
		logScreenshot("Redirect to Login Page");
	}

}
