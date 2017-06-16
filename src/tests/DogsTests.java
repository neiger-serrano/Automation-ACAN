package tests;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic.managers.WebDriverManager;
import pages.DogsPage;
import pages.LoginPage;
import pages.NavigationPage;
import pages.RegisterDogPage;

public class DogsTests extends WebDriverManager{
	
	LoginPage loginPage;
	NavigationPage navigationPage;
	DogsPage dogsPage;
	RegisterDogPage registerDogPage;
	List<String> tableTitles = Arrays.asList("","Cód. de Federación", "Nombre", "Raza", "Nombre del Propietario");
	
	
	@Parameters({"email", "pwd"})
	@BeforeMethod
	public void setUp(String email, String pwd){
		loginPage = new LoginPage(getDriver());
		dogsPage = loginPage.logInValidation(email,pwd);
		assertTrue(dogsPage.verifyLoads(), " [ERROR] Dogs page not displayed correctly after login");
	}
	
	
	@Parameters({"searchByCodFed", "searchByName", "searchByOwner", "noValidSearch"})
	@Test
	public void verifyTypeSearchBar_ACAN_51(String searchByCodFed, String searchByName, String searchByOwner, String noValidSearch){
		assertTrue(dogsPage.searchDogs(searchByCodFed), " [ERROR] Search was not made");
		System.out.println("Search by Código de Federación");
		assertTrue(dogsPage.searchDogs(searchByName), " [ERROR] Search was not made");
		System.out.println("Search by Nombre del Perro");
		assertTrue(dogsPage.searchDogs(searchByOwner), " [ERROR] Search was not made");
		System.out.println("Search by Nombre del Propietario");
		assertTrue(dogsPage.searchDogs(noValidSearch), " [ERROR] Search was not made"); //ACAN_52
		System.out.println("Search by No valid entries");
		assertAll();
		dogsPage.nav.logoutUser();
	}
	
	
	
	
	@Test
	public void agregarPerro_ACAN_37(){
		registerDogPage = dogsPage.registrarPerro();
	}
	
	@Test
	public void verifyDogsTable_ACAN_34(){
		assertTrue(dogsPage.checkTableTitles(tableTitles), null);
		assertAll();
	}
	
	@Parameters("searchByCodFed")
	@Test
	public void searchAndwatchDog_ACAN_55(String searchByCodFed){
		assertTrue(dogsPage.searchDogs(searchByCodFed), " [ERROR] Search was not made");
		navigationPage = dogsPage.clickViewDog();
		assertAll();
		navigationPage.logoutUser();
	}
	
	@Parameters("searchByCodFed")
	@Test
	public void searchAndeditDog_ACAN_59(String searchByCodFed){
		assertTrue(dogsPage.searchDogs(searchByCodFed), " [ERROR] Search was not made");
		registerDogPage = dogsPage.clickEditDog();
		assertAll();
		navigationPage = registerDogPage.cancelarDog();
		navigationPage.logoutUser();
	}
	
}
