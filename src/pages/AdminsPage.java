package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utils.web.BasePage;

public class AdminsPage extends BasePage{
	
	//**********WEB ELEMENTS*****************
	
	@FindBy(xpath = "//a[contains(text(),'AGREGAR USUARIO')]")
	private WebElement agregarButton;
	
	
	
	
	//**********CONSTRUCTOR*****************
	public AdminsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public boolean verifyLoads() {
		return waitForElementsVisible(agregarButton);
	}
	
	
	//**********METHODS*****************
	
	
	public RegisterAdminPage registrarAdmin(){
		waitAndClick(agregarButton);
		wait(3);
		return new RegisterAdminPage(driver);
	}
	


}
