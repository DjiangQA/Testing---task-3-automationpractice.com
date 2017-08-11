package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Signin {
	
	final String createAnAccount = "//*[@id=\"SubmitCreate\"]/span";
	
	final String titleMr = "//*[@id=\"id_gender1\"]";
	final String titleMrs = "//*[@id=\"id_gender2\"]";
	
	final String firstName = "//*[@id=\"customer_firstname\"]";
	
	final String lastName = "//*[@id=\"customer_lastname\"]";
	
	final String passWord = "//*[@id=\"passwd\"]";
	
	final String DOB_d = "//*[@id=\"days\"]";
	final String DOB_m = "//*[@id=\"months\"]";
	final String DOB_y = "//*[@id=\"years\"]";
	
	final String firstNameAddress = "//*[@id=\"firstname\"]";
	
	final String lastNameAddress = "//*[@id=\"lastname\"]";
	
	final String address = "//*[@id=\"address1\"]";
	
	final String email = "//*[@id=\"email_create\"]";
	
	final String city = "//*[@id=\"city\"]";
	
	final String state = "//*[@id=\"id_state\"]";
	
	final String postCode = "//*[@id=\"postcode\"]";
	
	final String country = "//*[@id=\"id_country\"]";
	
	final String mobile = "//*[@id=\"phone_mobile\"]";
	
	final String alias = "//*[@id=\"alias\"]";
	
	final String submitButton = "//*[@id=\"submitAccount\"]/span";
	
	
	
	@FindBy (xpath = createAnAccount)
	public WebElement CreateAnAccount;
	
	
	@FindBy (xpath = titleMr)
	public WebElement TitleMr;
	
	@FindBy (xpath = titleMrs)
	public WebElement TitleMrs;
	
	@FindBy (xpath = firstName)
	public WebElement FirstName;
	
	@FindBy (xpath = lastName)
	public WebElement LastName;
	
	@FindBy (xpath = passWord)
	public WebElement PassWord;
	
	@FindBy (xpath = DOB_d)
	public WebElement DOB_D;
	
	@FindBy (xpath = DOB_m)
	public WebElement DOB_M;
	
	@FindBy (xpath = DOB_y)
	public WebElement DOB_Y;
	
	@FindBy (xpath = firstNameAddress)
	public WebElement FirstNameAddress;
	
	@FindBy (xpath = lastNameAddress)
	public WebElement LastNameAddress;
	
	@FindBy (xpath = address)
	public WebElement Address;
	
	@FindBy (xpath = email)
	public WebElement Email;
	
	@FindBy (xpath = city)
	public WebElement City;
	
	@FindBy (xpath = state)
	public WebElement State;
	
	@FindBy (xpath = postCode)
	public WebElement PostCode;
	
	@FindBy (xpath = country)
	public WebElement Country;
	
	@FindBy (xpath = mobile)
	public WebElement Mobile;
	
	@FindBy (xpath = alias)
	public WebElement Alias;
	
	@FindBy (xpath = submitButton)
	public WebElement SubmitButton;

}
