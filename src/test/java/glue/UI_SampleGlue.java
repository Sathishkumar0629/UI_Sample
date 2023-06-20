package glue;

import static glue.Shared.driver;

import glue.Shared;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UI_SamplePage;
import utilities.ConfigReader;


public class UI_SampleGlue {
	
	Shared sh;
	UI_SamplePage sample = new UI_SamplePage(sh);
	public UI_SampleGlue(Shared sh)
	{
		this.sh=sh;
	}
	
	@Given("launch automation store test site")
	public void launch_automation_store_test_site() {
		 driver.get(ConfigReader.getURL());
		 driver.manage().window().maximize();
	}
	
	@Given("click on login or register link")
	public void click_on_login_or_register_link() {
	    sample.clickOnRegisterLink();
	}

	@Given("click on continue button")
	public void click_on_continue_button() {
		sample.clickOnContinue();
	}
	
	@Given("enter given {string} {string} and {string} details")
	public void enter_given_and_details(String name, String lname, String email) {
		sample.enterPersonalDetails(name, lname, email);
	}
	
	@Given("enter given address details {string} {string}")
	public void enter_given_address_details(String add, String city1) {
	    sample.enterAddress(add, city1);
	}
	
	@Given("enter {string}")
	public void enter(String zip) {
		sample.zipCode(zip);
	}

	@Given("select country and select region")
	public void select_country_and_select_region() {
		sample.selectCountryRegion();
	}
	
	@Given("enter login details {string} {string} {string}")
	public void enter_login_details(String loginname, String pwd, String cpwd) {
	    sample.enterLoginDetails(loginname, pwd, cpwd);
	}
	
	@Given("select privacy policy checkbox")
	public void select_privacy_policy_checkbox() {
	    sample.selectCheckBox();
	}

	@When("click on continue button after filling all the required details")
	public void click_on_continue_button_after_filling_all_the_required_details() {
	    sample.clickContinue();
	}
	
	@Then("verifies account created page with name")
	public void verifies_account_created_page_with_name() {
	    sample.verifyLandingPage();
	}

	@Then("click on cart")
	public void click_on_cart() {
	    sample.clickOnCart();
	}

	@Then("click on continue button for shopping")
	public void click_on_continue_button_for_shopping() {
	    sample.clickContinueForShopping();
	}
	
	@Then("add product to the cart")
	public void add_product_to_the_cart() {
	    sample.addProd();
	}

	@Then("proceed to checkout page")
	public void proceed_to_checkout_page() {
	    sample.clickCheckout();
	}

	@Then("verifies confirmation page")
	public void verifies_confirmation_page() {
	    sample.verifyCheckoutConfirmation();
	}
	
	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}
	
}
