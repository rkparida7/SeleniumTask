package com.Rutukanta.parabank.steps;

import java.io.IOException;

public class aParaBankTestFunctions extends webActionsPara {
	
	public void urlLuncing() {
		urlLunchChrome(Constant.URLparabank);
	}
	
	public void signUp() throws InterruptedException {
		scrollDown();
		sendkeym(Locators.Fname(), "Rutukanta");
		sendkeym(Locators.Lname(), "Parida");
		sendkeym(Locators.address(), "Chennai");
		sendkeym(Locators.city(), "Chennai");
		sendkeym(Locators.state(), "Tamil Nadu");
		sendkeym(Locators.zipCode(), "600032");
		sendkeym(Locators.phone(), "9874561230");
		sendkeym(Locators.SSN(), "789546");
		sendkeym(Locators.UName(), Constant.UserName);
		sendkeym(Locators.Pswd(), Constant.PassWord);
		sendkeym(Locators.confirmPswd(), Constant.PassWord);
		logScreenshot("Data Entered successfully");
		clickm(Locators.registerButton());
		logScreenshot("Signup in successfully");
		clickm(Locators.logoutButton());
	}
	
	public void login() throws InterruptedException {
		logScreenshot("landed on LoginPage");
		sendkeym(Locators.UserName(), Constant.UserName);
		sendkeym(Locators.Password(), Constant.PassWord);logScreenshot("one");
		clickm(Locators.loginButton());
		logScreenshot("logged in successfully");
	}

	public void login2() throws InterruptedException {
		logScreenshot("landed on LoginPage");
		sendkeym(Locators.UserName(), Constant.UserName1);
		sendkeym(Locators.Password(), Constant.PassWord);logScreenshot("one");
		clickm(Locators.loginButton());
		logScreenshot("logged in successfully");
	}
	
	public void accountCreation() throws InterruptedException, IOException {
		clickm(Locators.openNewAccount());
		dropdownm(Locators.typeAccount(), "SAVINGS");logScreenshot("one");
		clickm(Locators.OpenNewAccountButton());
		logScreenshot("Account Creation Done successfully");
		
		String value= findText(Locators.newAccountNo());
		writePropertiesFile.write(value);
		System.out.println("New Transaction ID is:-- >  "+value);
	}
	
	public void FundTransfer() throws InterruptedException, IOException {
		String value = readPropertiesFile.read("NewAccount");
		clickm(Locators.TransferFund());
		sendkeym(Locators.amount(), Constant.Amount);
		dropdownm(Locators.fromAccountId(),value);
		logScreenshot("one");
		clickm(Locators.transferButton());
		logScreenshot("Transfer Done successfully");
	}
	
	public void entriesFundTransfer() throws InterruptedException, IOException {
		String value = readPropertiesFile.read("NewAccount");
		clickm(Locators.FindTransactionsMenu());
		dropdownm(Locators.findTxSelect(), value);
		sendkeym(Locators.findDate(), Constant.Date);logScreenshot("one");
		clickm(Locators.findTransactionButton());logScreenshot("one");
		logScreenshot("Account details Checked successfully "); 
	}
	
	public void logOut() throws InterruptedException {
		clickm(Locators.logoutButton());
		logScreenshot("Logout successfully");
		driver.close();
	}

}
