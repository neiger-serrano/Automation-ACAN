package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utils.web.BasePage;

public class OwnersPage extends BasePage{

	//**********WEB ELEMENTS*****************
	@FindBy(id = "autocomplete-input")
	private WebElement searchBar;
	
	@FindBy(xpath = "//a[contains(text(),'AGREGAR')]")
	private WebElement agregarButton;
	
	
	
	//**********CONSTRUCTOR*****************
	public OwnersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public boolean verifyLoads() {
		return waitForElementsVisible(searchBar);
	}
	
	
	//**********METHODS*****************
	
	public boolean searchOwners(String searchText){
		wait(2);
		return waitAndTypeOnCleanElement(searchBar, searchText);
	}
	
	public RegisterOwnerPage registerOwner(){
		waitAndClick(agregarButton);
		return new RegisterOwnerPage(driver);
	}
	

}