import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CountriesMethods {

	static Scanner scnr = new Scanner(System.in);

	public static void menu() {

		
		System.out.printf("1) See list of countries.\n");
		System.out.printf("2) Add a country.\n");
		System.out.printf("3) Delete a country. \n");
		System.out.printf("4) Modify population. \n");
		System.out.printf("5) Sort alphabetically. \n");
		System.out.printf("6) Sort by population.\n");
		System.out.printf("7) Exit\n");
		System.out.println();
	}

	public static void list() {

		List<Country> countries = CountriesApp.fileHelper.readAll();
		for (Country c : countries) {
			System.out.println(c);
		}
		System.out.println();
	}

	public static void add() {

		System.out.println("What country would you like to add?");
		String newC = scnr.nextLine();
		System.out.println("How many people live in " + newC + "?");
		int newP = Validator.getInt(scnr);
		scnr.nextLine();
		System.out.println("What language is primarily spoken in " + newC + "?");
		String newL = scnr.nextLine();

		CountriesApp.fileHelper.append(new Country(newC, newP, newL));

	}

	public static void remove() {

		Country holder = new Country();

		List<Country> countries = CountriesApp.fileHelper.readAll();
		for (Country c : countries) {
			System.out.println(c);
		}
		System.out.println("Which country would you like to remove?");
		String remover = Validator.isCountry(scnr);
		for (Country c : countries) {
			if (c.toString().startsWith(remover)) {
				holder = c;
			}
		}
		countries.remove(holder);
		CountriesApp.fileHelper.rewrite(countries);

	}

	public static void modifyPop() {

		List<Country> countries = CountriesApp.fileHelper.readAll();
		for (Country c : countries) {
			System.out.println(c);
		}
		System.out.println("Which countries population would you like to change?");
		String remover =  Validator.isCountry(scnr);
		for (Country c : countries) {
			if (c.toString().startsWith(remover)) {
				System.out.println("What is the new population?");
				int newPop = Validator.getInt(scnr);
				scnr.nextLine();
				c.setPopulation(newPop);
			}
		}
		CountriesApp.fileHelper.rewrite(countries);
	}

	public static void sortByName() {

		List<Country> countries = CountriesApp.fileHelper.readAll();

		Comparator<Country> compareByName = (Country o1, Country o2) -> o1.getName().compareTo(o2.getName());

		Collections.sort(countries, compareByName);

		CountriesApp.fileHelper.rewrite(countries);

	}

	public static void sortByPop() {

		List<Country> countries = CountriesApp.fileHelper.readAll();
		
	
		Comparator<Country> compareByPop = Comparator.comparingInt(c -> c.getPopulation());

		Collections.sort(countries, compareByPop);

		CountriesApp.fileHelper.rewrite(countries);

	}
	
	public static boolean quit() {
		String response = "";

		System.out.println("Are you sure you want to quit?");
		System.out.println("(Y/N)");
		response = scnr.nextLine();
		response = response.toUpperCase();
		if (response.startsWith("Y")) {
			return false;
		}
		return true;
	}
	
	public static boolean methodJumper(int response) {
		boolean continueTasking = true;

		switch (response) {
		case 1:
			list();
			break;
		case 2:
			add();
			break;
		case 3:
			remove();
			break;
		case 4:
			modifyPop();
			break;
		case 5:
			sortByName();
			break;
		case 6:
			sortByPop();
			break;
		case 7:
			continueTasking = quit();
			break;

		}
		return continueTasking;
	}

}
