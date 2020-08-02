package com.Rutukanta.parabank.steps;

import org.openqa.selenium.By;

public class Locators {
	
	public static By loginPage() {
		return By.xpath("//h2[contains(text(),'Customer Login')]");
	}
	public static By UserName() {
		return By.xpath("//input[@name='username']");
	}
	public static By Password() {
		return By.xpath("//input[@name='password']");
	}
	public static By loginButton() {
		return By.xpath("//input[@value='Log In']");
	}
	public static By openNewAccount() {
		return By.xpath("//a[contains(text(),'Open New Account')]");
	}
	public static By TransferFund() {
		return By.xpath("//a[contains(text(),'Transfer Funds')]");
	}
	public static By FindTransactionsMenu() {
		return By.xpath("//a[contains(text(),'Find Transactions')]");
	}
	public static By logoutButton() {
		return By.xpath("//a[contains(text(),'Log Out')]");
	}
	public static By findDate() {
		return By.xpath("//input[@id='criteria.onDate']");
	}
	public static By findTransactionButton() {
		return By.xpath("(//button[@type='submit'])[2]");
	}
	public static By amount() {
		return By.xpath("//input[@id='amount']");
	}
	public static By transferButton() {
		return By.xpath("//input[@value='Transfer']");
	}
	public static By toAccountId() {
		return By.xpath("//select[@id='toAccountId']");
	}
	public static By fromAccountId() {
		return By.xpath("//select[@id='fromAccountId']");
	}
	public static By typeAccount() {
		return By.xpath("//select[@id='type']");
	}
	public static By OpenNewAccountButton() {
		return By.xpath("//input[@value='Open New Account']");
	}
	public static By AccountsOverview() {
		return By.xpath("//a[contains(text(),'Accounts Overview')]");
	}
	public static By findTxSelect() {
		return By.xpath("//select[@id='accountId']");
	}
	public static By FundsTransferSentQuery() {
		return By.xpath("//a[contains(text(),'Funds Transfer Sent')]");
	}
	public static By Fname() {
		return By.xpath("//input[@id='customer.firstName']");
	}
	public static By Lname() {
		return By.xpath("//input[@id='customer.lastName']");
	}
	public static By address() {
		return By.xpath("//input[@id='customer.address.street']");
	}
	public static By city() {
		return By.xpath("//input[@id='customer.address.city']");
	}
	public static By state() {
		return By.xpath("//input[@id='customer.address.state']");
	}
	public static By zipCode() {
		return By.xpath("//input[@id='customer.address.zipCode']");
	}
	public static By phone() {
		return By.xpath("//input[@id='customer.phoneNumber']");
	}
	public static By SSN() {
		return By.xpath("//input[@id='customer.ssn']");
	}
	public static By UName() {
		return By.xpath("//input[@id='customer.username']");
	}
	public static By Pswd() {
		return By.xpath("//input[@id='customer.password']");
	}
	public static By confirmPswd() {
		return By.xpath("//input[@id='repeatedPassword']");
	}
	public static By registerButton() {
		return By.xpath("//input[@value='Register']");
	}
	public static By newAccountNo() {
		return By.xpath("//a[@class='ng-binding']");
	}
	public static By errorMsg() {
		return By.xpath("//h1[contains(text(),'Error!')]");
	}
	public static By errorMsgFail() {
		return By.xpath("//p[@class='error']");
	}
	
	
}
