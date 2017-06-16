package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utils.web.BasePage;

public class ViewDog extends BasePage{
	
	//**********WEB ELEMENTS*****************
	@FindBy(xpath = "//a[contains(text(),'MODIFICAR')]")
	private WebElement modifyDogButton;
	
	
	//**********CONSTRUCTOR*****************
	public ViewDog(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public boolean verifyLoads() {
		return waitForElementVisible(modifyDogButton);
	}
	
	
	
	//**********METHODS*****************
	
	
}