package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utils.web.BasePage;

import pages.NavigationPage;

public class RegisterDogPage extends BasePage{

	
	//**********WEB ELEMENTS*****************
	
	@FindBy(xpath = "//a[contains(text(),'CANCELAR')]")
	private WebElement cancelmodifyDogButton;
	
	@FindBy(xpath = "//input[@name]")
	private List<WebElement> inputFields;
	
	@FindBy(xpath = "//input[@class='select-dropdown']")
	private List<WebElement> dropdownOptions;
	
	@FindBy(xpath = "//input[@name='currentOwner']")
	private WebElement currentOwner;
	
	private NavigationPage nav;
	
	
	//**********CONSTRUCTOR*****************
	public RegisterDogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public boolean verifyLoads() {
		return waitForElementsVisible(cancelmodifyDogButton) && waitForListMatchSize(inputFields, 10) && waitForListMatchSize(dropdownOptions, 3);
	}

	
	
	//**********METHODS*****************
	
	public NavigationPage cancelarDog(){
		waitAndClick(cancelmodifyDogButton);
		return new NavigationPage(driver);
	}
	
	public boolean fillFields(String name, String cod, String chip){
		return waitAndTypeOnCleanElement(inputFields.get(0), name) && waitAndTypeOnCleanElement(inputFields.get(1), cod) 
				&& waitAndTypeOnCleanElement(inputFields.get(2), chip) && waitAndClick(nav.genericButton("SIGUIENTE")) 
				&& wait(5) && waitAndTypeOnCleanElement(currentOwner, "12345-Neiger Serrano Mena") 
				&& waitAndClick(nav.genericButton("GUARDAR"));
	}
	
}
