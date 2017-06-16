package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic.managers.WebDriverManager;
import pages.ChangePwdPage;
import pages.DogsPage;
import pages.LoginPage;


public class ChangePwdTests extends WebDriverManager{
	
	private LoginPage loginPage;
	private DogsPage dogsPage;
	private ChangePwdPage changePwdPage;
	
	@Parameters({"email", "pwd"})
	@Test
	public void changePwd_ACAN_20(String email, String pwd){
		loginPage = new LoginPage(getDriver());
		dogsPage = loginPage.logInValidation(email,pwd);
		assertTrue(dogsPage.verifyLoads(), " [ERROR] Dogs page not displayed correctly after login");
		dogsPage.nav.goToPage("Cambiar Contraseña");
		changePwdPage.verifyLoads();
	}
}
