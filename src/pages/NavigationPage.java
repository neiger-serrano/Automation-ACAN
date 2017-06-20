package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic.utils.web.BasePage;
import tests.DogsTests;

public class NavigationPage extends BasePage{
	
	//**********WEB ELEMENTS*****************
	
	@FindBy(xpath = "//div//li//a[@class='menu-button']")
	private List<WebElement> menuOptions;
	
	@FindBy(xpath = "//input[@name='Cerrar Sesión'")
	private WebElement cerrarSesion;
	
	@FindBy(xpath = "//div[@class='current-user']//p[2]")
	private WebElement currentUser;
	
	@FindBy(xpath = "//a[contains(text(),'MODIFICAR')]")
	private WebElement modifyDogButton;
	
	@FindBy(xpath = "//div//a[@class='brand-logo']//i")	
	private WebElement sideMenuButton;
	
	private DogsTests dogstest;
	
	//**********CONSTRUCTOR*****************
	public NavigationPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public boolean verifyLoads() {
		boolean vlr = waitForListMatchSize(menuOptions, 5);
		
		if(vlr) {
			for (int i=0, lim = menuOptions.size(); i<lim && !vlr; i++){
				vlr = waitForElementsVisible(menuOptions.get(i));
				waitForTextOnElement(menuOptions.get(i), dogstest.tableTitles.get(i));// hacer una verificacion por texto de acuerdo a cada opcion
			}
		}
		return vlr && waitForElementsVisible(currentUser, sideMenuButton);
	}
	
	//**********METHODS*****************
	
	
	public WebDriver goToPage(String option) {
		findElement(By.xpath("//div[contains(@class,'side-options')]//a[text()='" + option + "']"));
		//findElement(By.xpath("//div[contains(@class,'side-options')]//a['" + option + "']"));
	    return driver;
	}
	
	public boolean verifyUser(String user){
		System.out.println(getTextFromElement(currentUser));
		return waitForTextOnElement(currentUser, user);
	}
	
	public DogsPage clickDogsPage(){
		waitForListMinimumSize(menuOptions, 1);
		waitAndClick(menuOptions.get(0));
		return new DogsPage(driver);
	}
	
	public OwnersPage clickOwnersPage(){
		waitAndClick(menuOptions.get(1));
		return new OwnersPage(driver);
	}
	
	public AdminsPage clickAdminsPage(){
		waitAndClick(menuOptions.get(2));
		return new AdminsPage(driver);
	}
	
	public ChangePwdPage clickChangePwdPage(){
		waitAndClick(menuOptions.get(3));
		wait(1);
		return new ChangePwdPage(driver);
	}
	
	public LoginPage logoutUser(){
		waitAndClick(menuOptions.get(4));
		return new LoginPage(driver);
	}
	
	public RegisterDogPage modifyDog(){
		waitAndClick(modifyDogButton);
		return new RegisterDogPage(driver);
	}
	
	public WebElement genericButton(String buttonName){
		return findElement(By.xpath("//a[contains(text(),'" + buttonName + "')]"));
	}
	
	public boolean clickMenuButton(){
		return waitAndClick(sideMenuButton);
	}
	
}