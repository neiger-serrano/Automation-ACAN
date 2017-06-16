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
	
	//$x("//table")
	//$x("//table//tbody") Content
	//$x("//table//thead") Títulos
	
	
	//**********CONSTRUCTOR*****************
	public DogsPage(WebDriver driver) {
		super(driver);
		nav = new NavigationPage(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public boolean verifyLoads() {
		return waitForElementsVisible(searchBar, agregarButton, dropdownEdit) && waitForListMatchSize(tableValues, 5) && nav.verifyLoads();
//		return waitForElementsVisible(searchBar, agregarButton, viewDog, editDog) && waitForListMatchSize(tableValues, 5) && nav.verifyLoads();
	}
	
	
	//**********METHODS*****************
	
	public boolean searchDogs(String searchText){
		return waitAndTypeOnCleanElement(searchBar, searchText); //&& this.verifyLoads();
	}
	
	
	// No se usa
	//public boolean clearSearchBar(){
	//	return waitAndTypeOnCleanElement(searchBar, "");
	//}
	
	public RegisterDogPage registrarPerro(){
		waitAndClick(agregarButton);
		wait(3);
		return new RegisterDogPage(driver);
	}
	
	public boolean checkTableTitles(List<String> tableTitles){
		for (int i=0; i<tableValues.size(); i++){
			isElementPresentOnList(tableValues, tableTitles.get(i));
			System.out.println(getTextFromElement(tableValues.get(i)));
		}
		return true;
	}
	
	public NavigationPage clickViewDog(){
		//wait(3);
		waitAndClick(dropdownEdit);
		//wait(1);
		waitAndClick(viewDog);
		wait(1);
		return new NavigationPage(driver); 
	}
	
	public RegisterDogPage clickEditDog(){
		//wait(3);
		waitAndClick(dropdownEdit);
		//wait(1);
		waitAndClick(editDog);
		wait(1);
		return new RegisterDogPage(driver);
	}
}