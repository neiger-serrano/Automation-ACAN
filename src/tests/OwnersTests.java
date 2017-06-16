package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic.managers.WebDriverManager;
import pages.DogsPage;
import pages.LoginPage;
import pages.NavigationPage;
import pages.OwnersPage;
import pages.RegisterOwnerPage;

public class OwnersTests extends WebDriverManager{
	
	
	LoginPage loginPage;
	NavigationPage navigationPage;
	OwnersPage ownersPage;
	RegisterOwnerPage registerOwnerPage;
	DogsPage dogsPage;
	
	
	@Parameters({"email", "pwd"})
	@BeforeMethod
	public void setUp(String email, String pwd){
		loginPage = new LoginPage(getDriver());
		dogsPage = loginPage.logInValidation(email,pwd);
		assertTrue(dogsPage.verifyLoads(), " [ERROR] Dogs page not displayed correctly after login");
		ownersPage = dogsPage.nav.clickOwnersPage();
	}
	
	
	@Parameters({"searchOwnerByCodFed", "searchByOwner", "noValidSearch"})
	@Test
	public void verifyTypeSearchBar_ACAN_94(String searchByCodFed, String searchByName, String noValidSearch){
		
		ownersPage.searchOwners(searchByCodFed);
		System.out.println("Search by Código de Federación");
		ownersPage.searchOwners(searchByName);
		System.out.println("Search by Nombre");
		assertTrue(dogsPage.searchDogs(noValidSearch), " [ERROR] Search was not made"); //ACAN_95
		System.out.println("Search by No valid entries");
	}
	
	@Test
	public void addOwner_ACAN_42(){
		registerOwnerPage = ownersPage.registerOwner();
	}
}
