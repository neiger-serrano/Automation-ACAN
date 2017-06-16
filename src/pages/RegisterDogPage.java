package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utils.web.BasePage;

public class RegisterDogPage extends BasePage{

	
	//**********WEB ELEMENTS*****************
	
	@FindBy(xpath = "//a[contains(text(),'CANCELAR')]")
	private WebElement cancelmodifyDogButton;
	
	
	//**********CONSTRUCTOR*****************
	public RegisterDogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public boolean verifyLoads() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	//**********METHODS*****************
	
	public NavigationPage cancelarDog(){
		waitAndClick(cancelmodifyDogButton);
		return new NavigationPage(driver);
	}
	
	
}
