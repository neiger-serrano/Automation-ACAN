package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.utils.web.BasePage;

public class RegisterOwnerPage extends BasePage{
	
	public RegisterOwnerPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public boolean verifyLoads() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
