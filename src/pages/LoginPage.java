package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic.utils.web.BasePage;


public class LoginPage extends BasePage{
	
	
	//**********WEB ELEMENTS*****************
	
	@FindBy(xpath =  "//input[@name='user']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//a[contains(text(),'Iniciar Sesión')]")
	//@FindBy(xpath = "//div//a[@class='waves-effect waves-light btn']")
	private WebElement signInBth;
	
	@FindBy(xpath = "//div//a[@href='#forgot-password']")
	private WebElement forgotPassButton;
	
	@FindBy(id= "email")
	private WebElement typeEmail;
	
	@FindBy(xpath = "//a[contains(text(),'Cancelar')]")
	private WebElement cancelarButton;
	
	@FindBy(xpath = "//a[contains(text(),'Enviar')]")
	private WebElement enviarButton;
	
	@FindBy(id = "notification-title")
	private WebElement titleMessage;
	
	@FindBy(xpath = "//a[contains(text(),'OK!')]")
	private WebElement okButton;
	
	@FindBy(xpath = "//div[contains(@class,'modal open')]//p")
	private WebElement popupText;
	
	//**********CONSTRUCTOR*****************
	public LoginPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public boolean verifyLoads() {
		return waitForElementsVisible(emailTextField, passwordTextField,signInBth);
	}
	
	
	//**********METHODS*****************

	public DogsPage logInValidation(String usr, String pwd){
			waitAndTypeOnCleanElement(emailTextField, usr);
			waitAndTypeOnCleanElement(passwordTextField, pwd);
			waitAndClick(signInBth);
			return new DogsPage(driver);
	}

	
	public boolean forgotPwdEmail(String email){
			return waitAndClick(forgotPassButton) && waitAndTypeOnCleanElement(typeEmail, email) && waitAndClick(enviarButton);
	}

	
	public boolean verifyErrorMsg(String txt) {
		return waitForTextOnElement(popupText, txt);
	}
}