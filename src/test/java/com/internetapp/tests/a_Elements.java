package com.internetapp.tests;

import com.internetapp.pages.a_ElementsPage;
import com.internetapp.pages.b_InteractionsPage;
import com.maveric.core.testng.BaseTest;

import java.io.IOException;

import org.testng.annotations.Test;

public class a_Elements extends BaseTest {

	@Test(groups = { "Force1" })
	public void Test1() throws InterruptedException, IOException {
// Sl no 1
		new a_ElementsPage()
				.navigate("https://demoqa.com/")
				.testBox("Rutukanta", "rutukantap@maveric-systems.com", "Chennai", "India")
				.checkBox()
				.radioButton("Impressive")
				.webTables("Sachin","Tendulkar","sachinT@gmail.com", "42","5000","Cricket")
				.Dbutton()
				.dynamicProp()
				.upDownload() //AutoIT fileuploader 
				.LinksOps();

		System.out.println("ElementsPage task Comleted");
	}
	
	@Test(groups = { "Force2" })
	public void Test4() throws InterruptedException, IOException {
// Sl no 4
		new b_InteractionsPage().navigate("https://demoqa.com/")
							.sorttablee()
							.selecttablee()
							.Resizablee()
							.Droppablee()
							.Dragabblee();

		System.out.println("Interactions task Comleted");
	}
	
}
