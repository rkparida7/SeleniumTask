package com.Rutukanta.parabank;


import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		tags="@parabank",
		features="./src/test/resources/features/parabankTest", 
		glue="com.Rutukanta.parabank.steps",
		dryRun = false
		)

/*
@RunWith(Cucumber.class) 
@CucumberOptions( 
	    features ="Path of the feature file", 
	    glue = {"path of step definition class or package "},
	    format={"pretty","json:target/"},
	    dryRun = true, 
	    strict = true,      
	    monochrome = true )
*/

public class paraBankRunner {//extends CucumberBaseTest{
	

}
