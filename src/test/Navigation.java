package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigation {
	
	final String signin = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a";
	
	@FindBy (xpath = signin)
	public WebElement Signin;

}
