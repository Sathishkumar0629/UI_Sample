package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import glue.Shared;
import utilities.ConfigReader;

public class UI_SamplePage extends Shared{

	Shared sh;
	
	@FindBy (how=How.LINK_TEXT, using="Login or register")
	private WebElement registerLink;
	
	@FindBy (how=How.XPATH, using="//button[@title='Continue']")
	private WebElement continueButton;
	
	@FindBy (how=How.NAME, using="firstname")
	private WebElement firstName;
	
	@FindBy (how=How.ID, using="AccountFrm_lastname")
	private WebElement lastName;
	
	@FindBy (how=How.ID, using="AccountFrm_email")
	private WebElement emailID;
	
	@FindBy (how=How.ID, using="AccountFrm_address_1")
	private WebElement address;
	
	@FindBy (how=How.ID, using="AccountFrm_city")
	private WebElement city;
	
	@FindBy (how=How.ID, using="AccountFrm_zone_id")
	private WebElement regionDropdown;
	
	@FindBy (how=How.ID, using="AccountFrm_postcode")
	private WebElement zipCode;
	
	@FindBy (how=How.ID, using="AccountFrm_country_id")
	private WebElement countryDropdown;
	
	@FindBy (how=How.ID, using="AccountFrm_loginname")
	private WebElement loginName;
	
	@FindBy (how=How.ID, using="AccountFrm_password")
	private WebElement pWD;
	
	@FindBy (how=How.ID, using="AccountFrm_confirm")
	private WebElement cnfpwd;
	
	@FindBy (how=How.ID, using="AccountFrm_agree")
	private WebElement tcCheckBox;
	
	@FindBy (how=How.XPATH, using="//button[@title='Continue']")
	private WebElement buttonContinue;
	
	@FindBy (how=How.XPATH, using="//div[contains(text(),'Welcome back')]")
	private WebElement createdName;
	
	@FindBy (how=How.XPATH, using="(//span[text()='Cart'])[1]")
	private WebElement cart;
	
	@FindBy (how=How.LINK_TEXT, using="Continue")
	private WebElement continueShopping;
	
	@FindBy (how=How.LINK_TEXT, using="Skinsheen Bronzer Stick")
	private WebElement product;
	
	@FindBy (how=How.XPATH, using="(//a[contains(@title,'Add to Cart')])[1]")
	private WebElement addToCart;
	
	@FindBy (how=How.ID, using="cart_checkout1")
	private WebElement checkout;
	
	@FindBy (how=How.XPATH, using="//span[contains(text(),' Checkout Confirmation')]")
	private List<WebElement> checkOutPage;
	
	@FindBy (how=How.XPATH, using="//a[@class='checkout_heading']")
	private WebElement checkOutHeading;
	
	
	public UI_SamplePage(Shared sh)
	{
		PageFactory.initElements(Shared.driver, this);
		this.sh=sh;
	}
	
	public void clickOnRegisterLink() {
		registerLink.click();
	}
	
	public void clickOnContinue() {
		continueButton.click();
	}
	
	public void enterPersonalDetails(String name, String lname, String email) {
		firstName.sendKeys(name);
		lastName.sendKeys(lname);
		emailID.sendKeys(email);
	}
	
	public void enterAddress(String add, String city1) {
		address.sendKeys(add);
		city.sendKeys(city1);
	}
	
	public void zipCode(String zip) {
		zipCode.sendKeys(zip);
	}
	
	public void selectCountryRegion() {
		Select select = new Select(countryDropdown);
		select.selectByVisibleText("India");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select select1 = new Select(regionDropdown);
		select1.selectByVisibleText("Karnataka");
	}
	
	public void enterLoginDetails(String loginname, String pwd, String cpwd) {
		loginName.sendKeys(loginname);
		pWD.sendKeys(pwd);
		cnfpwd.sendKeys(cpwd);
	}
	
	public void selectCheckBox() {
		tcCheckBox.click();
	}
	
	public void clickContinue() {
		buttonContinue.click();
	}
	
	public void verifyLandingPage() {
		if(createdName.getText().contains(ConfigReader.getName())) {
			Assert.assertTrue("user name verified", true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	public void clickOnCart() {
		cart.click();
	}
	
	public void clickContinueForShopping() {
		continueShopping.click();
	}
	
	public String prodDetails() {
		return product.getText();
	}
	
	public void addProd() {
		addToCart.click();
	}
	
	public void clickCheckout() {
		cart.click();
		checkout.click();
	}
	
	public void verifyCheckoutConfirmation() {
		if(checkOutPage.size() > 0) {
			if(checkOutHeading.getText().contains(prodDetails()))
				Assert.assertTrue("product is verified", true);
			else
				Assert.assertTrue(false);		
		}
	}
	
}
