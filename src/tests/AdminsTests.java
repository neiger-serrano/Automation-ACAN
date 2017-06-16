package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic.managers.WebDriverManager;
import pages.AdminsPage;
import pages.DogsPage;
import pages.LoginPage;
import pages.RegisterAdminPage;

public class AdminsTests extends WebDriverManager{
	
	LoginPage loginPage;
	DogsPage dogsPage;
	AdminsPage adminsPage;
	RegisterAdminPage registerAdminsPage;
	
	@Parameters({"email", "pwd"})
	@BeforeMethod
	public void setUp(String email, String pwd){
		loginPage = new LoginPage(getDriver());
		dogsPage = loginPage.logInValidation(email,pwd);
		assertTrue(dogsPage.verifyLoads(), " [ERROR] Dogs page not displayed correctly after login");
		adminsPage = dogsPage.nav.clickAdminsPage();
	}
	
	
	@Test
	public void agregarAdmin_ACAN_14(){
		registerAdminsPage = adminsPage.registrarAdmin();
	}
}
