package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utils.web.BasePage;

public class DogsPage extends BasePage{
	
	public NavigationPage nav;

	//**********WEB ELEMENTS*****************
	@FindBy(id = "autocomplete-input")
	private WebElement searchBar;
	
	@FindBy(xpath = "//a[contains(text(),'AGREGAR')]")
	private WebElement agregarButton;
	
	@FindBy(xpath = "//th")
	private List<WebElement> tableValues;
	
	@FindBy(xpath = "//td//i[@class='dropdown-button material-icons']")
	private WebElement dropdownEdit;
	
	@FindBy(id = "dog-info")
	private WebElement viewDog;
	
	@FindBy(id = "edit-dog")
	private WebElement editDog;

	
	//**********CONSTRUCTOR*****************
	public DogsPage(WebDriver driver) {
		super(driver);
		nav = new NavigationPage(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public boolean verifyLoads() {
		return waitForElementsVisible(searchBar, agregarButton, dropdownEdit) && waitForListMatchSize(tableValues, 5) && nav.verifyLoads();
	}
	
	
	//**********METHODS*****************
	
	public boolean searchDogs(String searchText){
		return waitAndTypeOnCleanElement(searchBar, searchText); //&& this.verifyLoads();
	}
	
	public RegisterDogPage registrarPerro(){
		waitAndClick(nav.genericButton("AGREGAR"));
		return new RegisterDogPage(driver);
	}
	
	public boolean checkTableTitles(List<String> tableTitles){
		boolean vlr = waitForListMatchSize(tableValues, 5);
		
		if(vlr) {
			for (int i=0, lim = tableValues.size(); i<lim && !vlr; i++){
				vlr = waitForElementsVisible(tableValues.get(i));
				waitForTextOnElement(tableValues.get(i), tableTitles.get(i));
			}
		}
		return vlr;
	}
	
	public NavigationPage clickViewDog(){
		waitAndClick(dropdownEdit);
		waitAndClick(viewDog);
		wait(1);
		return new NavigationPage(driver); 
	}
	
	public RegisterDogPage clickEditDog(){
		waitAndClick(dropdownEdit);
		waitAndClick(editDog);
		wait(1);
		return new RegisterDogPage(driver);
	}
}