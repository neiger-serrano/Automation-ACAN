package tests;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import generic.managers.WebDriverManager;
import pages.DogsPage;
import pages.LoginPage;


public class LoginTests extends WebDriverManager{
	
	private LoginPage loginPage;
	private List<String> sideMenu = Arrays.asList("Perros","Propietarios", "Administradores", "Cambiar Contraseña", "Cerrar Sesión");

	@BeforeMethod
	public void setUp(){
		loginPage = new LoginPage(getDriver());
		assertTrue(loginPage.verifyLoads(), null);
	}

	@Parameters({"email", "pwd"})
	@Test
	public void validSignIn_ACAN_2_(String email, String pwd) {
		assertTrue(loginPage.verifyLoads(), " [ERROR] Login not displayed correctly");
		DogsPage dogs = loginPage.logInValidation(email,pwd);
		assertTrue(dogs.verifyLoads(), " [ERROR] Dogs page not displayed correctly after login"); // ACAN 121
		assertTrue(dogs.nav.verifyLoads(), " [ERROR] User's email and Menu options are not displayed"); // verificar el usrname ACAN_115_
		assertTrue(dogs.nav.logoutUser().verifyLoads(), " [ERROR] Unable to logout");
		assertAll();
	}

	@Parameters({"emailNotRegistered", "pwd"})
	@Test
	public void noValidSignIn_ACAN_4_(String email, String pwd){
		loginPage.logInValidation(email, pwd);
		assertTrue(loginPage.verifyLoads(), " [ERROR] ");
		// Implementar el verifyErrorMsg 
		assertTrue(loginPage.verifyErrorMsg("Por favor revise sus credenciales o intentelo más tarde."), " [ERROR] ");
		assertAll();
	}

	@Parameters("email")
	@Test
	public void forgotPasswordRegisteredEmail_ACAN_27(String email){
		assertTrue(loginPage.forgotPwdEmail(email),  " [ERROR] ");
		assertTrue(loginPage.verifyErrorMsg("Su contraseña ha sido enviada"), " [ERROR] ");
		assertAll();
	}
	
	@Parameters("emailNotRegistered")
	@Test
	public void forgotPasswordNotRegisteredEmail_ACAN_198(String email){
		assertTrue(loginPage.forgotPwdEmail(email),   " [ERROR] ");
		assertTrue(loginPage.verifyErrorMsg("Su correo electrónico no está asociado a ningún usuario. Contacte al administrador del sistema para solucionar el problema."), " [ERROR] ");
		assertAll();
	}
	
}