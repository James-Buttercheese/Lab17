import java.util.Scanner;


public class CountriesApp {
	
	static FileHelper<Country> fileHelper = new FileHelper<>("countries.txt", (new CountryLineConverter()));
	
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		boolean contLooping = true;
		
		System.out.printf("Welcome to the country maintinence application!\n");
		
		while (contLooping == true) {
			
			CountriesMethods.menu();
			System.out.println("What would you like to do?");
			int response = Validator.getInt(scnr, 1, 7);
			System.out.println();
			contLooping = CountriesMethods.methodJumper(response);			
			
		} System.out.println("Goodbye");
		scnr.close();
			
	}
}
