package com.fa.clp.stepDefinitions;

import java.io.IOException;

import com.fa.clp.testcomponents.BaseTest;

import io.cucumber.java.en.Given;

public class StepDefinitionImp extends BaseTest {
	
	@Given("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException {
		
		initializeDriver();
	}
	
	
	@Given("^I want to write a step with (.+)$")
	public void I_want_to_write_a_step_with_name(String name) throws IOException {
		
		initializeDriver();
	}
	

}
