package com.Rutukanta.parabank.steps;

import java.io.IOException;

import org.testng.annotations.Test;

public class aParaBankTest extends webActionsPara {

	aParaBankTestFunctions steps = new aParaBankTestFunctions();

//	@Test(groups = { "paraBankTest" })
	@Test
	public void TestingOne() throws InterruptedException, IOException {

		steps.urlLuncing();
		steps.signUp();
		steps.login();
		steps.accountCreation();
		steps.FundTransfer();
		steps.entriesFundTransfer();
		steps.logOut();
		
		System.out.println("--------Test One Completed----------");
	}

}
